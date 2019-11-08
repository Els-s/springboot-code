package org.javaboy.rediscache;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class RediscacheApplicationTests {

    @Autowired
    UserService userService;
    @Test
    void contextLoads() {
        System.out.println(">>>>>>>>>>>>>>>>>>>"+userService.getUserById(99));
//        userService.updateUserById("javaboy", 99);
        userService.deleteUserById(99);
        System.out.println(">>>>>>>>>>>>>>>>>>>"+userService.getUserById(99));
    }

}
