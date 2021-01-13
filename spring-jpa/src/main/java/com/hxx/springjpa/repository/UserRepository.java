package com.hxx.springjpa.repository;

import com.hxx.springjpa.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

/**
 * @Author xin.hao
 * @create 2020/11/4 15:34
 */
public interface UserRepository extends JpaRepository<User,Integer>, JpaSpecificationExecutor<User>{
}
