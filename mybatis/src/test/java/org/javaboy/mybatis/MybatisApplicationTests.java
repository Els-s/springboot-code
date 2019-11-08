package org.javaboy.mybatis;

import org.javaboy.mybatis.mapper.UserMapper;
import org.javaboy.mybatis.mapper2.UserMapper2;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class MybatisApplicationTests {

    @Autowired
    UserMapper userMapper;
    @Autowired
    UserMapper2 userMapper2;
    @Test
    void contextLoads() {
        System.out.println(userMapper.getAllUsers());
        System.out.println(userMapper2.getAllUsers());
    }

}
