package org.javaboy.quartz;

import org.springframework.stereotype.Component;

import java.util.Date;

/**
 * @作者 江南一点雨
 * @公众号 江南一点雨
 * @微信号 a_java_boy
 * @GitHub https://github.com/lenve
 * @博客 http://wangsong.blog.csdn.net
 * @网站 http://www.javaboy.org
 * @时间 2019-10-26 11:12
 */
@Component
public class MyJob1 {
    public void hello() {
        System.out.println("hello myjob1>"+new Date());
    }
}
