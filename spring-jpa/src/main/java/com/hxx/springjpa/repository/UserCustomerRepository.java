package com.hxx.springjpa.repository;

import com.hxx.springjpa.entity.UserCustomerEntity;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @Author xin.hao
 * @create 2021/1/12 15:13
 */
public interface UserCustomerRepository extends JpaRepository<UserCustomerEntity, Integer> {
}
