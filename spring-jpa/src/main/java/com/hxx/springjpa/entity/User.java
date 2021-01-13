package com.hxx.springjpa.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;

/**
 * @Author xin.hao
 * @create 2020/11/4 15:17
 */
@Entity
@Table(name = "tbl_user")
@Data
public class User {

    @Id //主键
    @GeneratedValue(strategy = GenerationType.IDENTITY) //自增主键
    private Integer id;

    @Column(name = "name",length = 50)
    private String name;

    @Column
    private Integer age;

    @Column
    private String email;

    @Column(name = "first_name", nullable = true, length = 100)
    private String firstName;

    @Column(name = "last_name", nullable = true, length = 100)
    private String lastName;

    @Column(name = "telephone", nullable = true, length = 100)
    private String telephone;

    @Column(name = "create_time", nullable = true)
    private Date createTime;

    @Column(name = "version", nullable = true)
    private String version;

//    @OneToOne(optional = false,fetch = FetchType.EAGER)
//    @JoinColumn(referencedColumnName = "id",name = "address_id",nullable = false)
//    @Fetch(FetchMode.JOIN)
//    private UserReceivingAddressEntity addressEntity;

}
