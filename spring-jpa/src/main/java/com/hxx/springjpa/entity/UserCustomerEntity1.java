package com.hxx.springjpa.entity;

import com.hxx.springjpa.audit.AbstractAuditable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * @Author xin.hao
 * @create 2021/1/11 11:19
 * <p>
 * 每个需要 Auditing 的实体 需要继承 AbstractAuditable.
 */
@Entity
@Table(name = "user_customer", schema = "test", catalog = "")
public class UserCustomerEntity1 extends AbstractAuditable {

    @Column(name = "customer_name", nullable = true, length = 50)
    private String customerName;

    @Column(name = "customer_email", nullable = true, length = 50)
    private String customerEmail;
}
