package com.hxx.springjpa.config;

import com.hxx.springjpa.entity.User;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.domain.AuditorAware;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

import java.util.Optional;

/**
 * @Author xin.hao
 * @create 2021/1/13 14:32
 */
@Configuration
@EnableJpaAuditing
public class JPAConfiguration {
    @Bean
    public AuditorAware<User> getCurrentUser() {
        User currentUser = new User();
        currentUser.setName("Bob");
        currentUser.setAge(20);
        return () -> Optional.of(currentUser);
    }
}
