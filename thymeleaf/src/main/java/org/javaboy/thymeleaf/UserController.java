package org.javaboy.thymeleaf;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.ArrayList;
import java.util.List;

/**
 * @作者 江南一点雨
 * @公众号 江南一点雨
 * @微信号 a_java_boy
 * @GitHub https://github.com/lenve
 * @博客 http://wangsong.blog.csdn.net
 * @网站 http://www.javaboy.org
 * @时间 2019-10-22 16:53
 */
@Controller
public class UserController {
    @GetMapping("/hello")
    public String hello(Model model) {
        List<User> users = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            User e = new User();
            e.setId(i);
            e.setUsername("张三：" + i);
            e.setAddress("sehnz:" + i);
            users.add(e);
        }
        model.addAttribute("users", users);
        return "user";
    }
}
