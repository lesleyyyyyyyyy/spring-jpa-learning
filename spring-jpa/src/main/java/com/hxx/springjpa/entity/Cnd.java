package com.hxx.springjpa.entity;

import com.hxx.springjpa.enums.Operator;
import lombok.Data;

/**
 * 条件
 * @Author xin.hao
 * @create 2021/1/4 13:54
 */
@Data
public class Cnd {
    private String property;
    private Operator operator;
    private Object  value;

    public Cnd(String property, Operator operator, Object value) {
        this.operator = operator;
        this.property = property;
        this.value = value;
    }

    /**
     * 相等
     *
     * @param property
     * @param value
     * @return
     */
    public static Cnd eq(String property, Object value) {
        return new Cnd(property, Operator.eq, value);
    }

    /**
     * 不相等
     *
     * @param property
     * @param value
     * @return
     */
    public static Cnd ne(String property, Object value) {
        return new Cnd(property, Operator.ne, value);
    }

}
