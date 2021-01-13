package com.hxx.springjpa.service;

import com.hxx.springjpa.entity.User;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

/**
 * @Author xin.hao
 * @create 2020/12/28 9:13
 */
public interface UserService {

    public Optional<User> findById(Integer id);

}
