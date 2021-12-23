package com.hxx.springjpa.entity;

import lombok.Data;
import org.springframework.data.domain.Sort;

/**
 * @Author xin.hao
 * @create 2021/1/6 16:55
 */
@Data
public class Order {

    private String property;
    private Sort.Direction direction = Sort.Direction.ASC;

    /**
     * 构造方法
     *
     * @param property  属性
     * @param direction 方向
     */
    public Order(String property, Sort.Direction direction) {
        this.property = property;
        this.direction = direction;
    }

    /**
     * 返回递增排序
     *
     * @param property 属性
     * @return 递增排序
     */
    public static Order asc(String property) {
        return new Order(property, Sort.Direction.ASC);
    }

    /**
     * 返回递减排序
     *
     * @param property 属性
     * @return 递减排序
     */
    public static Order desc(String property) {
        return new Order(property, Sort.Direction.DESC);
    }

}
