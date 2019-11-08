package org.javaboy.jdbctemplate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @作者 江南一点雨
 * @公众号 江南一点雨
 * @微信号 a_java_boy
 * @GitHub https://github.com/lenve
 * @博客 http://wangsong.blog.csdn.net
 * @网站 http://www.javaboy.org
 * @时间 2019-10-24 9:26
 */
@Service
public class UserService {
    @Autowired
    @Qualifier("jdbcTemplateOne")
    JdbcTemplate jdbcTemplateOne;
    @Resource(name = "jdbcTemplateTwo")
    JdbcTemplate jdbcTemplateTwo;

    public void getAllUsers() {
        List<User> list = jdbcTemplateOne.query("select * from t_user", new BeanPropertyRowMapper<>(User.class));
        System.out.println(list);
        list = jdbcTemplateTwo.query("select * from t_user", new BeanPropertyRowMapper<>(User.class));
        System.out.println(list);
    }
}