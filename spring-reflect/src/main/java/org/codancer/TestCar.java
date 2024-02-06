package org.codancer;

import org.junit.jupiter.api.Test;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class TestCar {

    //reflect创建实例
    @Test
    public void test01() throws ClassNotFoundException, InstantiationException, IllegalAccessException {
        //获取class
        Class clazz1 = Car.class;

        Class clazz2 = new Car().getClass();

        Class clazz3 = Class.forName("org.codancer.Car");

        //实例化
        Car car3 = (Car)clazz3.newInstance();
        System.out.println(car3);
    }

    //reflect获取构造函数并创建实例
    @Test
    public void test02() throws NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {
        Class clazz = Car.class;
        Constructor[] constructors = clazz.getDeclaredConstructors();

        for (Constructor constructor: constructors) {
            System.out.println(constructor.getName() + " " + constructor.getParameterCount());
        }

        //指定有参数构造创建对象
        Constructor c1 = clazz.getConstructor(String.class, int.class, String.class);
        Car car = (Car)c1.newInstance("sa", 1, "sasa");
        System.out.println(car);
    }

    //reflect获取属性
    @Test
    public void test03() throws InstantiationException, IllegalAccessException {
        Class clazz = Car.class;
        Car car = (Car)clazz.newInstance();

        //获取public属性
        clazz.getFields();

        //获取所有属性
        Field[] fields = clazz.getDeclaredFields();
        for (Field field: fields) {
            if (field.getName().equals("name")) {
                field.setAccessible(true);
                field.set(car, "五菱宏光");
            }
            System.out.println(field.getName());
        }

        System.out.println(car.getName());
    }

    //reflect操作方法
    @Test
    public void testo4() throws InvocationTargetException, IllegalAccessException {
        Car car = new Car("奔驰", 10, "白色");
        Class clazz = car.getClass();

        //public methods
        for (Method method: clazz.getMethods()) {
            if (method.getName().equals("toString")) {
                System.out.println(method.invoke(car));
            }
        }

        //all methods including private methods
        for (Method method: clazz.getDeclaredMethods()) {
            if (method.getName().equals("run")) {
                method.setAccessible(true);
                method.invoke(car);
            }
        }
    }

}
