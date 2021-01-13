package com.hxx.springjpa.repository;

import com.hxx.springjpa.entity.User;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 * @Author xin.hao
 * @create 2021/1/12 15:14
 */
public class UserCustomerRepositoryImpl implements UserRepositoryCustom {

    @PersistenceContext //获得
    EntityManager entityManager;

    @Override
    public User findById(Integer id) {
        return entityManager.find(User.class, id);
    }
}
