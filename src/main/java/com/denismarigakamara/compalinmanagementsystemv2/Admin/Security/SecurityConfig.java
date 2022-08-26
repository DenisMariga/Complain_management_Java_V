//package com.denismarigakamara.compalinmanagementsystemv2.Admin.Security;
//
//import org.springframework.context.annotation.Configuration;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
//import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
//
//@Configuration
//@EnableWebSecurity
//public class SecurityConfig extends WebSecurityConfigurerAdapter {
//    @Override
//    protected void configure(HttpSecurity http) throws Exception {
//        http
//                .csrf().disable()
//                .authorizeRequests()
//                .antMatchers("/register", "/adminLogin", "/", "/Admin/**", "/css/**", "/Admin/addNew", "/js/**").permitAll()
//                .anyRequest().authenticated();
//        http.formLogin()
//                .loginPage("/adminLogin").permitAll();
//        http.formLogin()
//                .defaultSuccessUrl("/Admin/", true);
//    }
//}
