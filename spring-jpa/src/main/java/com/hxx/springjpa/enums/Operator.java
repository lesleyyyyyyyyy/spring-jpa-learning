package com.hxx.springjpa.enums;

import lombok.Getter;

/**
 * 运算符
 * @Author xin.hao
 * @create 2021/1/6 16:35
 */

@Getter
//@Setter
public enum Operator {
    /**
     * 等于
     */
    eq(" = "),
    /**
     * 不等于
     */
    ne(" != "),
    /**
     * 大于
     */
    gt(" > "),
    /**
     * 小于
     */
    lt(" < "),
    /**
     * 大于等于
     */
    ge(" >= "),
    /**
     * 不为Null
     */
    isNotNull(" is not NULL ");

    Operator(String operator) {
        this.operator = operator;
    }

    private String operator;

}
