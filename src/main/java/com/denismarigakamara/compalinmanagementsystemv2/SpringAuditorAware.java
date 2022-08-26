package com.denismarigakamara.compalinmanagementsystemv2;

import org.springframework.data.domain.AuditorAware;

import java.util.Optional;

public class SpringAuditorAware implements AuditorAware<String> {
    @Override
    public Optional<String> getCurrentAuditor() {
//        return Optional.empty();

        // Just return a string representing the username
        return Optional.ofNullable("Denis").filter(s -> !s.isEmpty());
    }

}
