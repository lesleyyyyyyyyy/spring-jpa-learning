package com.hxx.springjpa.audit;

import com.hxx.springjpa.entity.User;
import org.apache.tomcat.util.net.openssl.ciphers.Authentication;
import org.springframework.data.domain.AuditorAware;

import java.util.Optional;

/**
 * @Author xin.hao
 * @create 2021/1/13 15:07
 */
public class SpringSecurityAuditorAware implements AuditorAware<User> {
    public Optional<User> getCurrentAuditor() {

        return Optional.ofNullable(SecurityContextHolder.getContext())
                .map(SecurityContext::getAuthentication)
                .filter(Authentication::isAuthenticated)
                .map(Authentication::getPrincipal)
                .map(User.class::cast);
    }
}
