package org.javaboy.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;
import org.springframework.stereotype.Controller;

/**
 * @作者 江南一点雨
 * @公众号 江南一点雨
 * @微信号 a_java_boy
 * @GitHub https://github.com/lenve
 * @博客 http://wangsong.blog.csdn.net
 * @网站 http://www.javaboy.org
 * @时间 2019-10-21 10:18
 * <p>
 * 这是 Spring 的配置文件，作用类似于 applicationContext.xml，这里的属性和 XML 配置中都是一一对应的
 */
@Configuration
@ComponentScan(basePackages = "org.javaboy", useDefaultFilters = true, excludeFilters = @ComponentScan.Filter(type = FilterType.ANNOTATION, classes = Controller.class))
public class SpringConfig {
}
