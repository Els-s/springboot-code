package org.javaboy.commandlinerunner;

import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;
import java.util.Set;

/**
 * @作者 江南一点雨
 * @公众号 江南一点雨
 * @微信号 a_java_boy
 * @GitHub https://github.com/lenve
 * @博客 http://wangsong.blog.csdn.net
 * @网站 http://www.javaboy.org
 * @时间 2019-10-26 14:14
 */
@Component
@Order(98)
public class MyApplicationRunner1 implements ApplicationRunner {
    @Override
    public void run(ApplicationArguments args) throws Exception {
        String[] sourceArgs = args.getSourceArgs();//获取命令行中所有的参数
        System.out.println("命令行中所有参数：" + Arrays.toString(sourceArgs));
        List<String> nonOptionArgs = args.getNonOptionArgs();//获取和 CommandLineRunner 中相同的参数，即那些没有 key 的参数
        System.out.println("所有的无 key 参数：" + nonOptionArgs);
        Set<String> optionNames = args.getOptionNames();//获取所有有 key 参数的 key
        for (String optionName : optionNames) {
            System.out.println("key:" + optionName + ";value:" + args.getOptionValues(optionName));
        }
    }
}
