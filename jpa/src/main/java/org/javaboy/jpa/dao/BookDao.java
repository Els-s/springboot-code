package org.javaboy.jpa.dao;

import org.javaboy.jpa.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @作者 江南一点雨
 * @公众号 江南一点雨
 * @微信号 a_java_boy
 * @GitHub https://github.com/lenve
 * @博客 http://wangsong.blog.csdn.net
 * @网站 http://www.javaboy.org
 * @时间 2019-10-24 14:28
 */
public interface BookDao extends JpaRepository<Book,Integer> {
}
