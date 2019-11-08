package org.javaboy.rediscache;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication
@EnableCaching
public class RediscacheApplication {

    public static void main(String[] args) {
        SpringApplication.run(RediscacheApplication.class, args);
    }

}
