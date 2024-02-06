package org.codancer;

import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestUser {

    private Logger logger = LoggerFactory.getLogger(TestUser.class);

    @Test
    public void testUser() {
        ApplicationContext context = new ClassPathXmlApplicationContext("bean.xml");
        User user = (User)context.getBean("user");
        System.out.println(user);
        user.add();
        logger.info("执行调用成功！");
    }

    @Test
    public void testUserObject() throws ClassNotFoundException, InstantiationException, IllegalAccessException {
        // 反射创建对象
        Class clazz = Class.forName("org.codancer.User");
        Object obj = clazz.newInstance();
        User user = (User) obj;
        user.add();
    }
}
