package org.javaboy.mybatis.config;

import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.annotation.Resource;
import javax.sql.DataSource;

/**
 * @作者 江南一点雨
 * @公众号 江南一点雨
 * @微信号 a_java_boy
 * @GitHub https://github.com/lenve
 * @博客 http://wangsong.blog.csdn.net
 * @网站 http://www.javaboy.org
 * @时间 2019-10-24 10:58
 */
@Configuration
@MapperScan(basePackages = "org.javaboy.mybatis.mapper2",sqlSessionFactoryRef = "sqlSessionFactoryTwo",sqlSessionTemplateRef = "sqlSessionTemplateTwo")
public class MyBatisConfigTwo {
    @Resource(name = "dsTwo")
    DataSource dsOne;

    @Bean
    SqlSessionFactoryBean sqlSessionFactoryTwo() {
        SqlSessionFactoryBean bean = new SqlSessionFactoryBean();
        try {
            bean.setDataSource(dsOne);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return bean;
    }

    @Bean
    SqlSessionTemplate sqlSessionTemplateTwo() {
        try {
            return new SqlSessionTemplate(sqlSessionFactoryTwo().getObject());
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
