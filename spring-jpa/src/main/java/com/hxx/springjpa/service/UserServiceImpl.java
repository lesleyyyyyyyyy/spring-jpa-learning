package com.hxx.springjpa.service;

import com.hxx.springjpa.entity.User;
import com.hxx.springjpa.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

/**
 * @Author xin.hao
 * @create 2020/12/30 16:44
 */
@Service
@AllArgsConstructor
public class UserServiceImpl implements UserService {

    @Autowired
    UserRepository userRepository;

    @Override
    @Transactional
    public Optional<User> findById(Integer id) {
        return userRepository.findById(id);
    }
}
