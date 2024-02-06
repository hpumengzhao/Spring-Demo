package org.codancer;

import org.codancer.bean.ApplicaitionContext;
import org.codancer.bean.impl.AnnotationApplicationContext;
import org.codancer.service.UserService;

import java.io.IOException;

public class TestIoc {
    public static void main(String[] args) throws IOException, ClassNotFoundException, InstantiationException, IllegalAccessException {
        ApplicaitionContext applicaitionContext = new AnnotationApplicationContext("org.codancer");
        UserService userService = (UserService) applicaitionContext.getBean(UserService.class);
        System.out.println(userService);
        userService.add();
    }
}
