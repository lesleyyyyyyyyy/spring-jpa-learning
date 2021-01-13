package com.hxx.springjpa.specification;

import org.springframework.data.jpa.domain.Specification;

import java.math.BigDecimal;
import java.util.Collection;
import java.util.Date;

/**
 * @Author xin.hao
 * @create 2020/12/28 15:45
 */
public class SpecificationFactory {
    /**
     * 模糊查询
     * @param attribute 表中实体字段
     * @param value 查询条件
     * @return
     */
    public static Specification containsLike(String attribute, String value) {
        return (root, query, cb) -> cb.like(root.get(attribute), "%"+value+"%");
    }

    /**
     *  某字段的值等于value
     * @param attribute 字段名
     * @param value
     * @return
     */
    public static Specification equal(String attribute, Object value) {
        return (root, query, cb) -> cb.equal(root.get(attribute), value);
    }

    /**
     * 获取对应属性的值 所在区间
     * @param attribute 字段名
     * @param min
     * @param max
     * @return
     */
    public static Specification isBetween(String attribute, int min, int max) {
        return (root, query, cb) -> cb.between(root.get(attribute), min, max);
    }

    public static Specification isBetween(String attribute, double min, double max) {
        return (root, query, cb) -> cb.between(root.get(attribute), min, max);
    }

    public static Specification isBetween(String attribute, Date min, Date max) {
        return (root, query, cb) -> cb.between(root.get(attribute), min, max);
    }

    /**
     * 通过属性名和集合实现in查询
     * @param attribute 属性名（字段名）
     * @param collection 集合
     * @return
     */
    public static Specification in(String attribute, Collection collection) {
        return (root, query, cb) -> root.get(attribute).in(collection);
    }

    /**
     * 通过属性名构建 大于等于value 的查询条件
     * @param attribute 属性名（字段名）
     * @param value
     * @return
     */
    public static Specification greaterThan(String attribute, BigDecimal value) {
        return (root, query, cb) -> cb.greaterThan(root.get(attribute), value);
    }

    public static Specification greaterThan(String attribute, Long value) {
        return (root, query, cb) -> cb.greaterThan(root.get(attribute), value);
    }

    public static Specification greaterThan(String attribute, Integer value) {
        return (root, query, cb) -> cb.greaterThan(root.get(attribute), value);
    }
}
