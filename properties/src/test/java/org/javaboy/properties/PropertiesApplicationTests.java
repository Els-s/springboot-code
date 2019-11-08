package org.javaboy.properties;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class PropertiesApplicationTests {

    @Autowired
    Book book;

    @Test
    void contextLoads() {
        System.out.println(book);
    }

}
