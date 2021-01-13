package com.hxx.springjpa.repository;

import com.hxx.springjpa.entity.User;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 * @Author xin.hao
 * @create 2020/12/31 11:25
 */
public class UserRepositoryImpl implements UserRepositoryCustom {

    @PersistenceContext //获得
    EntityManager entityManager;

    @Override
    public User findById(Integer id) {
        return entityManager.find(User.class, id);
    }
}
