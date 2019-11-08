package org.javaboy.ehcache;

import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

/**
 * @作者 江南一点雨
 * @公众号 江南一点雨
 * @微信号 a_java_boy
 * @GitHub https://github.com/lenve
 * @博客 http://wangsong.blog.csdn.net
 * @网站 http://www.javaboy.org
 * @时间 2019-10-25 15:57
 */
@Service
public class UserService {
    @Cacheable(cacheNames = "user")
    public User getUserById(Integer id) {
        System.out.println(id);
        User user = new User();
        user.setId(id);
        return user;
    }
}
