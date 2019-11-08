package org.javaboy.security.config;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.javaboy.security.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.LockedException;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter {
    @Autowired
    UserService userService;

    @Bean
    MyFilter myFilter() throws Exception {
        MyFilter myFilter = new MyFilter();
        myFilter.setAuthenticationManager(authenticationManagerBean());
        return myFilter;
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                .antMatchers("/admin/**")
                .hasRole("admin")
                .antMatchers("/user/**")
                .hasAnyRole("admin", "user")
                .anyRequest().authenticated()
                .and()
                .addFilterBefore(myFilter(),UsernamePasswordAuthenticationFilter.class)
//                .formLogin()
//                .passwordParameter("password")//自定义登录时密码的key
//                .usernameParameter("username")//自定义登录时用户名的key
//                .loginProcessingUrl("/doLogin")//处理登录的接口
//                .loginPage("/login")
//                .successHandler(new AuthenticationSuccessHandler() {
//                    @Override
//                    public void onAuthenticationSuccess(HttpServletRequest req, HttpServletResponse resp, Authentication authentication) throws IOException, ServletException {
//                        resp.setContentType("application/json;charset=utf-8");
//                        Map<String, Object> map = new HashMap<>();
//                        map.put("status", 200);
//                        map.put("msg", "登录成功");
//                        map.put("obj", authentication.getPrincipal());
//                        PrintWriter out = resp.getWriter();
//                        out.write(new ObjectMapper().writeValueAsString(map));
//                        out.flush();
//                        out.close();
//                    }
//                })
//                .failureHandler(new AuthenticationFailureHandler() {
//                    @Override
//                    public void onAuthenticationFailure(HttpServletRequest req, HttpServletResponse resp, AuthenticationException e) throws IOException, ServletException {
//                        resp.setContentType("application/json;charset=utf-8");
//                        Map<String, Object> map = new HashMap<>();
//                        map.put("status", 500);
//                        map.put("msg", "登录失败");
//                        if (e instanceof BadCredentialsException) {
//                            map.put("msg", "用户名或密码写错");
//                        } else if (e instanceof DisabledException) {
//                            map.put("msg", "账户被禁用，登录失败");
//                        } else if (e instanceof LockedException) {
//                            map.put("msg", "账户被锁定，登录失败");
//                        }
//                        PrintWriter out = resp.getWriter();
//                        out.write(new ObjectMapper().writeValueAsString(map));
//                        out.flush();
//                        out.close();
//                    }
//                })
//                .permitAll()
//                .and()
                .csrf().disable();
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userService);
//        auth.inMemoryAuthentication()
//                .withUser("javaboy")
//                .password("$2a$10$GtdrF2nLLJlkhKbwowr32erVvbBncTvzgBBYYs7WSS3VHnK8sEPzK")
//                .roles("admin")
//                .and()
//                .withUser("zhangsan")
//                .password("$2a$10$OG7vOvR8fkWmDmVtbHUevOL8dYcUmhQ5rIVQ1wPshY9qNc6n99Zjq")
//                .roles("user");
    }

    @Bean
    PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}
