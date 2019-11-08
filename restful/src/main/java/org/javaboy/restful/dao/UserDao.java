package org.javaboy.restful.dao;

import org.javaboy.restful.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.annotation.RestResource;

import java.util.List;

/**
 * @作者 江南一点雨
 * @公众号 江南一点雨
 * @微信号 a_java_boy
 * @GitHub https://github.com/lenve
 * @博客 http://wangsong.blog.csdn.net
 * @网站 http://www.javaboy.org
 * @时间 2019-10-25 9:13
 */
@RepositoryRestResource(path = "people",collectionResourceRel = "people",itemResourceRel = "u")
public interface UserDao extends JpaRepository<User, Integer> {
    @RestResource(path = "byname",rel = "byname")
    List<User> findUserByUsernameStartingWith(@Param("username") String username);
}