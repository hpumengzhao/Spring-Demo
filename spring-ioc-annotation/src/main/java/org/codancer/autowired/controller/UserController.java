package org.codancer.autowired.controller;

import org.codancer.autowired.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;


@Controller
public class UserController {

    //属性注入
    @Autowired //根据类型找到对应的对象并注入
    private UserService userService;

    public void add() {
        userService.add();
    }
}
