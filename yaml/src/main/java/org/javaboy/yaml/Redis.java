package org.javaboy.yaml;

/**
 * @作者 江南一点雨
 * @公众号 江南一点雨
 * @微信号 a_java_boy
 * @GitHub https://github.com/lenve
 * @博客 http://wangsong.blog.csdn.net
 * @网站 http://www.javaboy.org
 * @时间 2019-10-22 14:21
 */
public class Redis {
    private String ip;
    private Integer port;

    public String getIp() {
        return ip;
    }

    @Override
    public String toString() {
        return "Redis{" +
                "ip='" + ip + '\'' +
                ", port=" + port +
                '}';
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public Integer getPort() {
        return port;
    }

    public void setPort(Integer port) {
        this.port = port;
    }
}
