package com.hxx.springjpa.audit;

import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.util.Date;

/**
 * @Author xin.hao
 * @create 2021/1/8 11:09
 *
 * 引入 @MappedSuperclass 注解，
 * 我们将 @Id、@CreatedBy、 @CreatedDate、 @LastModifiedBy、 @LastModifiedDate 抽象到一个公用的基类里面，
 * 方便公用和形成每个表的字段约束。可以将其放到我们公司的框架代码上，对表设计形成统一的强约束。
 */
@MappedSuperclass
@EntityListeners(AuditingEntityListener.class)
public abstract class AbstractAuditable {

    @Id
    @Column(name = "id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @CreatedDate
    @Column(name = "create_time", nullable = true)
    private Date createTime;

    @CreatedBy
    @Column(name = "create_user_id", nullable = true)
    private Integer createUserId;

    @LastModifiedBy
    @Column(name = "last_modified_user_id", nullable = true)
    private Integer lastModifiedUserId;

    @LastModifiedDate
    @Column(name = "last_modified_time", nullable = true)
    private Date lastModifiedTime;

}
