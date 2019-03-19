package com.example.book.config;

import com.example.book.filter.JWTLoginFilter;
import com.example.book.filter.JwtAuthenticationFilter;
import com.example.book.service.impl.UserDetailsServiceImpl;
import com.example.book.utils.Utils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.security.SecurityProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
@Order(SecurityProperties.BASIC_AUTH_ORDER)
public class MyWebSecurityConfig extends WebSecurityConfigurerAdapter {
//    private UserDetailsService userDetailsService;
//    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @Autowired
    UserDetailsServiceImpl userDetailsService;

//    public MyWebSecurityConfig(UserDetailsService userDetailsService, BCryptPasswordEncoder bCryptPasswordEncoder) {
//        this.userDetailsService = userDetailsService;
//        this.bCryptPasswordEncoder = bCryptPasswordEncoder;
//    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.cors().and().csrf().disable().authorizeRequests()
                .antMatchers(HttpMethod.POST, "/users/signup").permitAll()
                .antMatchers(
                        "/v2/api-docs/**",
                        "/swagger-resources/**",
                        "/webjars/springfox-swagger-ui/**",
                        "/swagger-ui.html**").permitAll()
//                .antMatchers("/api/v1/book").permitAll()
                .anyRequest().authenticated()
                .and()
                .addFilter(new JWTLoginFilter(authenticationManager()))
                .addFilter(new JwtAuthenticationFilter(authenticationManager()));
    }

    @Override
    public void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userDetailsService).passwordEncoder(Utils.bCryptPasswordEncoder());
    }


}
