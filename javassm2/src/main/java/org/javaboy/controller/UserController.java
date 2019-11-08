package org.javaboy.controller;

import org.javaboy.model.User;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

/**
 * @作者 江南一点雨
 * @公众号 江南一点雨
 * @微信号 a_java_boy
 * @GitHub https://github.com/lenve
 * @博客 http://wangsong.blog.csdn.net
 * @网站 http://www.javaboy.org
 * @时间 2019-10-21 14:07
 */
@RestController
public class UserController {
    @GetMapping("/user")
    public User getUserById() {
        User user = new User();
        user.setId(99);
        user.setUsername("javaboy");
        user.setBirthday(new Date());
        return user;
    }
}
