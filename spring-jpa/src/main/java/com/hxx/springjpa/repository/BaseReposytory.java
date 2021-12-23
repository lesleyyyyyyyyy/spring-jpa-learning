package com.hxx.springjpa.repository;

import org.springframework.data.repository.NoRepositoryBean;

import java.io.Serializable;

/**
 * 自定义基类
 *
 * @Author xin.hao
 * @create 2020/12/31 15:24
 */
@NoRepositoryBean
public interface BaseReposytory<T, ID extends Serializable> {
    void sharedCusttomMethod(ID id);
}
