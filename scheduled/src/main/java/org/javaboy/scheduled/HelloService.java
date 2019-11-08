package org.javaboy.scheduled;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.util.Date;

/**
 * @作者 江南一点雨
 * @公众号 江南一点雨
 * @微信号 a_java_boy
 * @GitHub https://github.com/lenve
 * @博客 http://wangsong.blog.csdn.net
 * @网站 http://www.javaboy.org
 * @时间 2019-10-26 10:53
 */
@Service
public class HelloService {
    /**
     * fixedRate 表示定时任务开启的频率，即两个定时任务开启时间之间的间隔
     * fixedDelay 表示定时任务的延迟时间间隔，即前一个定时任务结束时间和后一个定时任务开始时间之间的间隔
     * cron 表达式
     */
    @Scheduled(cron = "0/5 10-12 11-12 * * ?")
    public void hello() {
        System.out.println("hello>" + new Date());
    }
}