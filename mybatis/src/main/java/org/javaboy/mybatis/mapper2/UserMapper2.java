package org.javaboy.mybatis.mapper2;

import org.javaboy.mybatis.model.User;

import java.util.List;

/**
 * @作者 江南一点雨
 * @公众号 江南一点雨
 * @微信号 a_java_boy
 * @GitHub https://github.com/lenve
 * @博客 http://wangsong.blog.csdn.net
 * @网站 http://www.javaboy.org
 * @时间 2019-10-24 10:40
 */
//@Mapper//每个Mapper 上添加 @Mapper 注解，表示这是一个 Mapper，弊端是每个 Mapper 都要添加注解
public interface UserMapper2 {
//    @Select("select * from t_user")
    List<User> getAllUsers();
}
