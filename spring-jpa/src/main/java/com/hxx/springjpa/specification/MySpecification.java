package com.hxx.springjpa.specification;

import com.hxx.springjpa.entity.Cnd;
import com.hxx.springjpa.entity.Order;
import org.apache.commons.lang3.StringUtils;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.util.CollectionUtils;

import javax.persistence.criteria.*;
import java.util.ArrayList;
import java.util.List;

/**
 * @Author xin.hao
 * @create 2020/12/30 15:58
 */
public class MySpecification<T> implements Specification<T> {

    /**
     * 属性分隔符
     */
    private static final String PROPERTY_SEPARATOR = ".";

    /**
     * and条件组
     */
    List<Cnd> andConditions = new ArrayList<>();

    /**
     * or条件组
     */
    List<Cnd> orConditions = new ArrayList<>();

    /**
     * 排序条件组
     */
    List<Order> orders = new ArrayList<>();

    @Override
    public Predicate toPredicate(Root<T> root, CriteriaQuery<?> criteriaQuery, CriteriaBuilder criteriaBuilder) {
        Predicate restrictions = criteriaBuilder.and(getAndPredicates(root, criteriaBuilder));
        //restrictions = criteriaQuery.orderBy(getOrders(root,criteriaBuilder));
        return restrictions;
    }


    private Predicate getAndPredicates(Root<T> root, CriteriaBuilder cb) {
        Predicate restrictions = cb.conjunction();
        for (Cnd condition : andConditions) {
            if (condition == null) {
                continue;
            }
            Path<?> path = this.getPath(root, condition.getProperty());
            if (path == null) {
                continue;
            }
            switch (condition.getOperator()) {
                case eq:
                    if (condition.getValue() != null) {
                        if (String.class.isAssignableFrom(path.getJavaType()) && condition.getValue() instanceof String) {
                            if (!(condition.getValue()).toString().isEmpty()) {
                                restrictions = cb.and(restrictions, cb.equal(path, condition.getValue()));
                            }
                        } else {
                            restrictions = cb.and(restrictions, cb.equal(path, condition.getValue()));
                        }
                    }
                    break;
                case ge:
                    if (Number.class.isAssignableFrom(path.getJavaType()) && condition.getValue() instanceof Number) {
                        restrictions = cb.and(restrictions, cb.ge((Path<Number>) path, (Number) condition.getValue()));
                    }
                    break;
                case gt:
                    if (Number.class.isAssignableFrom(path.getJavaType()) && condition.getValue() instanceof Number) {
                        restrictions = cb.and(restrictions, cb.gt((Path<Number>) path, (Number) condition.getValue()));
                    }
                    break;
                case lt:
                    if (Number.class.isAssignableFrom(path.getJavaType()) && condition.getValue() instanceof Number) {
                        restrictions = cb.and(restrictions, cb.lt((Path<Number>) path, (Number) condition.getValue()));
                    }
                    break;
                case ne:
                    if (condition.getValue() != null) {
                        if (String.class.isAssignableFrom(path.getJavaType()) && condition.getValue() instanceof String && !((String) condition.getValue()).isEmpty()) {
                            restrictions = cb.and(restrictions, cb.notEqual(path, condition.getValue()));
                        } else {
                            restrictions = cb.and(restrictions, cb.notEqual(path, condition.getValue()));
                        }
                    }
                    break;
                case isNotNull:
                    restrictions = cb.and(restrictions, path.isNotNull());
                    break;
            }
        }
        return restrictions;
    }

    private Predicate getOrPredicates(Root<T> root, CriteriaBuilder cb) {
        // 相同的逻辑 Need TODO
        return null;
    }

    private List<javax.persistence.criteria.Order> getOrders(Root<T> root, CriteriaBuilder cb) {
        List<javax.persistence.criteria.Order> orderList = new ArrayList<>();
        if (root == null || CollectionUtils.isEmpty(orders)) {
            return orderList;
        }
        for (Order order : orders) {
            if (order == null) {
                continue;
            }
            String property = order.getProperty();
            Sort.Direction direction = order.getDirection();
            Path<?> path = this.getPath(root, property);
            if (path == null || direction == null) {
                continue;
            }
            switch (direction) {
                case ASC:
                    orderList.add(cb.asc(path));
                    break;
                case DESC:
                    orderList.add(cb.desc(path));
                    break;
            }
        }
        return orderList;
    }

    private Path<?> getPath(Root<T> root, String property) {
        return null;
    }

    @Override
    public Specification and(Specification other) {
        return null;
    }

    @Override
    public Specification or(Specification other) {
        return null;
    }

    /**
     * 获取Path
     *
     * @param path         Path
     * @param propertyPath 属性路径
     * @return Path
     */
    private <X> Path<X> getPath(Path<?> path, String propertyPath) {
        if (path == null || StringUtils.isEmpty(propertyPath)) {
            return (Path<X>) path;
        }
        String property = StringUtils.substringBefore(propertyPath, PROPERTY_SEPARATOR);
        return getPath(path.get(property), StringUtils.substringAfter(propertyPath, PROPERTY_SEPARATOR));
    }

}
