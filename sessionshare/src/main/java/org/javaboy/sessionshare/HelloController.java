package org.javaboy.sessionshare;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;

/**
 * @作者 江南一点雨
 * @公众号 江南一点雨
 * @微信号 a_java_boy
 * @GitHub https://github.com/lenve
 * @博客 http://wangsong.blog.csdn.net
 * @网站 http://www.javaboy.org
 * @时间 2019-10-25 16:50
 *
 * yum -y install pcre-devel
 * yum -y install openssl openssl-devel
 *
 * 1. 下载 nginx wget http://nginx.org/download/nginx-1.17.5.tar.gz
 * 2. 解压下载文件，并进入到解压目录中
 * 3. 配置 ./configure
 * 4. 编译：make
 * 5. 编译安装 make install
 */
@RestController
public class HelloController {
    @Value("${server.port}")
    Integer port;
    @GetMapping("/set")
    public String set(HttpSession session) {
        session.setAttribute("username", "javaboy");
        return String.valueOf(port);
    }

    @GetMapping("/get")
    public String get(HttpSession session) {
        return session.getAttribute("username") + ":" + port;
    }
}
