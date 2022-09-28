package com.example.security.config;

import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityCustomizer;
import org.springframework.security.web.SecurityFilterChain;

/**
 * <p>
 *     推荐阅读：<a href="https://mp.weixin.qq.com/s?__biz=MzI1NDY0MTkzNQ==&mid=2247488113&idx=1&sn=01168c492e22fa287043eb746950da73&chksm=e9c34011deb4c90711456b13c2b7063c6a3f6aa0c1a80942c84e22665cd2497a6be735500ca4&scene=178&cur_album_id=1319828555819286528#rd">...</a>
 * </p>
 * @author zhaojiejun
 * @date 2022/9/28 5:41 PM
 **/
public class SecurityConfig {


    /**
     * Ignore all requests to the /js/**, /css/**, and /images/** directories.
     *
     * @return A WebSecurityCustomizer
     */
    @Bean
    public WebSecurityCustomizer webSecurityCustomizer() {
        return web -> {
            web.ignoring().antMatchers("/js/**", "/css/**","/images/**");
        };
    }


    /**
     * If the user is authenticated, then allow them to access any page. If they are not authenticated, then redirect them
     * to the login page.
     *
     * @param http The HttpSecurity object that is used to configure the security filter chain.
     * @return A SecurityFilterChain
     */
    @Bean
    SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                .anyRequest().authenticated()
                .and()
                .formLogin()
                .loginPage("/login.html")
                .permitAll()
                .and()
                .csrf().disable();
        return http.build();
    }
}
