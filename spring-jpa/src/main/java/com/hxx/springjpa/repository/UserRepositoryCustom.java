package com.hxx.springjpa.repository;

import com.hxx.springjpa.entity.User;

/**
 * @Author xin.hao
 * @create 2020/12/31 11:24
 */
public interface UserRepositoryCustom {

    public User findById(Integer id);
}
