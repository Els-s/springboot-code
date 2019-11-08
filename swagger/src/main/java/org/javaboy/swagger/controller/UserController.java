package org.javaboy.swagger.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.javaboy.swagger.model.User;
import org.springframework.web.bind.annotation.*;

/**
 * @作者 江南一点雨
 * @公众号 江南一点雨
 * @微信号 a_java_boy
 * @GitHub https://github.com/lenve
 * @博客 http://wangsong.blog.csdn.net
 * @网站 http://www.javaboy.org
 * @时间 2019-10-26 9:27
 */
@RestController
@Api(tags = "用户相关的接口")
public class UserController {
    @GetMapping("/hello")
    public String hello() {
        return "hello swagger";
    }

    @GetMapping("/user")
    @ApiOperation("根据用户 id 查询用户")
    @ApiImplicitParam(name = "id", value = "用户id", defaultValue = "99")
    public User getUserById(Integer id) {
        User user = new User();
        user.setId(id);
        return user;
    }

    @PutMapping("/user")
    @ApiOperation("根据用户 id 更新用户名")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "id", value = "用户id", defaultValue = "99"),
            @ApiImplicitParam(name = "username", value = "用户名", defaultValue = "javaboy")
    })
    public User updateUsernameById(String username, Integer id) {
        User user = new User();
        user.setId(id);
        user.setUsername(username);
        return user;
    }

    @DeleteMapping("/user/{id}")
    @ApiOperation("根据用户 id 删除用户")
    @ApiImplicitParam(name = "id", value = "用户id", defaultValue = "99")
    public void deleteUserById(@PathVariable Integer id) {
        System.out.println(id);
    }

    @PostMapping("/user")
    @ApiOperation("添加用户")
    public User addUser(@RequestBody User user) {
        return user;
    }
}
