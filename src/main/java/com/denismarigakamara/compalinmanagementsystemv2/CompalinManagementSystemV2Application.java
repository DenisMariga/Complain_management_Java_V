package com.denismarigakamara.compalinmanagementsystemv2;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.domain.AuditorAware;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing(auditorAwareRef = "auditorAware")
public class CompalinManagementSystemV2Application {
@Bean
public AuditorAware<String>auditorAware(){
    return new SpringAuditorAware();
    }
    public static void main(String[] args) {
        SpringApplication.run(CompalinManagementSystemV2Application.class, args);
    }

}
