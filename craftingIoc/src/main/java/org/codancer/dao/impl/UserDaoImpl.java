package org.codancer.dao.impl;

import org.codancer.annotation.Bean;
import org.codancer.dao.UserDao;


@Bean
public class UserDaoImpl implements UserDao {
    @Override
    public void add() {
        System.out.println("dao add...");
    }
}
