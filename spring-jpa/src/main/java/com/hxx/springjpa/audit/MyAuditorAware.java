package com.hxx.springjpa.audit;

import org.springframework.data.domain.AuditorAware;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import java.util.Optional;

/**
 * @Author xin.hao
 * @create 2021/1/7 14:55
 */
public class MyAuditorAware implements AuditorAware<Integer> {


    @Override
    public Optional<Integer> getCurrentAuditor() {
        //第二种方式通过request里面取或者session里面取
        ServletRequestAttributes servletRequestAttributes =
                (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        return Optional.of(Integer.parseInt(servletRequestAttributes.getRequest().getSession().getAttribute("userId").toString()));
    }
}
