package org.javaboy.yaml;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @作者 江南一点雨
 * @公众号 江南一点雨
 * @微信号 a_java_boy
 * @GitHub https://github.com/lenve
 * @博客 http://wangsong.blog.csdn.net
 * @网站 http://www.javaboy.org
 * @时间 2019-10-22 14:17
 */
@Component
@ConfigurationProperties(prefix = "redis2")
public class RedisCluster2 {
    private List<Redis> redisList;

    public List<Redis> getRedisList() {
        return redisList;
    }

    @Override
    public String toString() {
        return "RedisCluster2{" +
                "redisList=" + redisList +
                '}';
    }

    public void setRedisList(List<Redis> redisList) {
        this.redisList = redisList;
    }
}
