<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Title</title>
</head>
<body>
<!--
 @作者 江南一点雨
 @公众号 江南一点雨
 @微信号 a_java_boy
 @GitHub https://github.com/lenve
 @博客 http://wangsong.blog.csdn.net
 @网站 http://www.javaboy.org 
 @时间 2019-10-22 16:55
-->
<table border="1">
    <tr>
        <td>用户编号</td>
        <td>用户名</td>
        <td>用户地址</td>
    </tr>
    <#list users as user>
        <tr>
            <td>${user.id}</td>
            <td>${user.username}</td>
            <td>${user.address}</td>
        </tr>
    </#list>
</table>
</body>
</html>