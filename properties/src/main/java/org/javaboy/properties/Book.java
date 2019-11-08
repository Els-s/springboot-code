package org.javaboy.properties;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

/**
 * @作者 江南一点雨
 * @公众号 江南一点雨
 * @微信号 a_java_boy
 * @GitHub https://github.com/lenve
 * @博客 http://wangsong.blog.csdn.net
 * @网站 http://www.javaboy.org
 * @时间 2019-10-22 10:33
 *
 * 内省
 */
@Component
@PropertySource("classpath:book.properties")//这就相当于 XML  配置中的 place-holder 引入配置文件
@ConfigurationProperties(prefix = "book")
public class Book {
    private String aaa;
    private String author;

    @Override
    public String toString() {
        return "Book{" +
                "name='" + aaa + '\'' +
                ", author='" + author + '\'' +
                '}';
    }

    public String getName() {
        return aaa;
    }

    public void setName(String name) {
        this.aaa = name;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }
}
