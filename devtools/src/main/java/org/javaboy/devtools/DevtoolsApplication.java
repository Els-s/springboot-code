package org.javaboy.devtools;

import org.springframework.boot.Banner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.annotation.ImportResource;

@SpringBootApplication
public class DevtoolsApplication {

    public static void main(String[] args) {
        SpringApplicationBuilder builder = new SpringApplicationBuilder(DevtoolsApplication.class);
        builder.bannerMode(Banner.Mode.OFF);
        builder.run(args);
//        SpringApplication.run(DevtoolsApplication.class, args);
    }

}
