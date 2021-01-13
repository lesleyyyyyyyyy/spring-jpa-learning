package com.hxx.springjpa.entity;

import com.hxx.springjpa.audit.AbstractAuditable;
import lombok.Data;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.util.Date;

/**
 * @Author xin.hao
 * @create 2021/1/7 9:17
 */
@Data
@Entity
@Table(name = "user_customer", schema = "test", catalog = "")
@EntityListeners(AuditingEntityListener.class)
public class UserCustomerEntity extends AbstractAuditable {

    @Version
    @Column(name = "version")
    private Long version;

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

    @Column(name = "customer_name", nullable = true, length = 50)
    private String customerName;

    @Column(name = "customer_email", nullable = true, length = 50)
    private String customerEmail;

    public UserCustomerEntity() {
    }
}
