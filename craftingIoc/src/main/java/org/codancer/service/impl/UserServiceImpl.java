package org.codancer.service.impl;

import org.codancer.annotation.Bean;
import org.codancer.annotation.DI;
import org.codancer.dao.UserDao;
import org.codancer.service.UserService;


@Bean
public class UserServiceImpl implements UserService {
    @DI
    private UserDao userDao;

    @Override
    public void add() {
        System.out.println("service add..");
        userDao.add();
    }
}
