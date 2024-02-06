package org.codancer.autowired.dao;


import org.springframework.stereotype.Repository;

@Repository
public class UserRedisDaoImpl implements UserDao{

    @Override
    public void add() {
        System.out.println("Redis dao add...");
    }
}
