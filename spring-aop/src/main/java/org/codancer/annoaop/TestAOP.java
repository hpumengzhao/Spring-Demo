package org.codancer.annoaop;

import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestAOP {

    @Test
    public void testAdd() {
        ApplicationContext context = new ClassPathXmlApplicationContext("bean.xml");

        LogAspect logAspect = context.getBean(LogAspect.class);
        System.out.println(logAspect);
        Calculator calculator =  context.getBean(Calculator.class);
        calculator.add(1, 2);

        calculator.div(1, 0);
    }
}
