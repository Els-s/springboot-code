package org.javaboy.rediscache;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

/**
 * @作者 江南一点雨
 * @公众号 江南一点雨
 * @微信号 a_java_boy
 * @GitHub https://github.com/lenve
 * @博客 http://wangsong.blog.csdn.net
 * @网站 http://www.javaboy.org
 * @时间 2019-10-25 14:12
 */
@Service
@CacheConfig(cacheNames = "c1")
public class UserService {
    /**
     * @Cacheable 表示该方法开启缓存，方法的参数作为缓存的 key，方法的返回值作为缓存的 value
     * @param id
     * @return
     */
    @Cacheable
    public User getUserById(Integer id) {
        System.out.println("getUserById:"+id);
        User user = new User();
        user.setId(id);
        return user;
    }

    /**
     * @CachePut 这个注解一般用在更新方法上。
     * 更新时，以方法的参数为 key，方法返回值为 value ，更新redis上的数据
     * @param username
     * @param id
     * @return
     */
    @CachePut(key = "#id")
    public User updateUserById(String username, Integer id) {
        User user = new User();
        user.setId(id);
        user.setUsername(username);
        return user;
    }

    @CacheEvict
    public void deleteUserById(Integer id) {
        System.out.println("deleteUserById");
    }
}
