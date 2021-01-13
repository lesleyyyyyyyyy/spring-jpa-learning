package com.hxx.springjpa.entity;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

/**
 * @Author xin.hao
 * @create 2021/1/4 16:28
 */
@Entity
@Table(name = "user_receiving_address", schema = "test")
public class UserReceivingAddressEntity implements Serializable {

    @Id
    @Column(name = "id", nullable = false)
    private Integer id;

    @Column(name = "user_id", nullable = false)
    private Integer userId;

    @Column(name = "address_city", nullable = false, length = 500)
    private String addressCity;
}
