package org.codancer.bean.impl;

import org.codancer.annotation.Bean;
import org.codancer.annotation.DI;
import org.codancer.bean.ApplicaitionContext;

import java.io.File;
import java.io.IOException;
import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.net.URL;
import java.net.URLDecoder;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class AnnotationApplicationContext implements ApplicaitionContext {

    private static Map<Class, Object> beanFactory = new HashMap<>();
    private static String rootPath;

    @Override
    public Object getBean(Class clazz) {
        return beanFactory.get(clazz);
    }

    //设置包的扫描规则，查找Bean
    public AnnotationApplicationContext(String basePackage) throws IOException, ClassNotFoundException, InstantiationException, IllegalAccessException {
        String packagePath = basePackage.replaceAll("\\.", "\\\\");
        Enumeration<URL> urls = Thread.currentThread().getContextClassLoader().getResources(packagePath);
        while (urls.hasMoreElements()) {
            URL url = urls.nextElement();
            String filePath = URLDecoder.decode(url.getFile(), "utf-8");
            rootPath = filePath.substring(0, filePath.length() - packagePath.length());
            loadBean(new File(filePath));
        }
        loadDi();
    }


    private static void loadBean(File file) throws ClassNotFoundException, InstantiationException, IllegalAccessException {
        if (file.isDirectory()) {
            File[] childFiles = file.listFiles();
            if (childFiles == null || childFiles.length == 0) {
                return ;
            }

            for (File cfile: childFiles) {
                loadBean(cfile);
            }
        }
        // is file
        String pathwithClass  = file.getAbsolutePath().substring(rootPath.length() - 1);

        if (pathwithClass.contains(".class")) {
            String allName = pathwithClass.replaceAll("\\\\", ".").replace(".class", "");

            Class clazz = Class.forName(allName);
            if (!clazz.isInterface()) {
                Annotation annotation = clazz.getAnnotation(Bean.class);
                if (annotation != null) {
                    //实例化
                    Object instance = clazz.newInstance();
                    if (clazz.getInterfaces().length > 0) {
                        beanFactory.put(clazz.getInterfaces()[0], instance);
                    } else {
                        beanFactory.put(clazz, instance);
                    }
                }
            }
        }
    }

    //属性注入
    private void loadDi() throws IllegalAccessException {
        Set<Map.Entry<Class, Object>> entries = beanFactory.entrySet();
        for(Map.Entry<Class, Object> entry: entries) {
            Object value = entry.getValue();

            Class clazz = value.getClass();

            for (Field field: clazz.getDeclaredFields()) {
                if (field.getAnnotation(DI.class) != null) {
                    field.setAccessible(true);
                    field.set(value, beanFactory.get(field.getType()));
                }
            }
//            Field[] declaredFields = clazz.getDeclaredFields();
        }
    }
}
