package com.hxx.springjpa.repository;


import com.hxx.springjpa.entity.User;
import org.springframework.data.jpa.repository.support.JpaEntityInformation;
import org.springframework.data.jpa.repository.support.SimpleJpaRepository;

import javax.persistence.EntityManager;
import java.io.Serializable;

/**
 * @Author xin.hao
 * @create 2020/12/31 15:30
 * <p>
 * 注意：
 * 该类需要具有专门的存储库工厂实现使用超级类的构造函数，如果存储库基类有多个构造函数，
 * 则覆盖一个 EntityInformation 加上特定于存储的基础架构对象（例如，一个 EntityManager 或一个模板类），
 * 也可以重写 SimpleJpaRepository 的任何逻辑。如逻辑删除放在这里面实现，就不要所有的 Repository 去关心实现哪个接口了。
 */
public class BaseReposytoryImpl<T, ID extends Serializable> extends SimpleJpaRepository<T, ID> implements BaseReposytory<T, ID> {

    private final EntityManager entityManager;

    public BaseReposytoryImpl(JpaEntityInformation entityInformation, EntityManager entityManager) {
        super(entityInformation, entityManager);
        this.entityManager = entityManager;
    }


    @Override
    public void sharedCusttomMethod(ID id) {

    }
}


