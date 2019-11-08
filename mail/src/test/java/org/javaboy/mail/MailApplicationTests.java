package org.javaboy.mail;

import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.core.io.FileSystemResource;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;
import org.thymeleaf.context.IContext;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import java.io.File;
import java.io.IOException;
import java.io.StringWriter;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@SpringBootTest
class MailApplicationTests {

    @Autowired
    JavaMailSender mailSender;

    @Test
    void contextLoads() {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setSubject("这是一封测试邮件");
        message.setText("这是测试邮件的正文");
        message.setSentDate(new Date());
        message.setFrom("1510161612@qq.com");
        message.setTo("775969742@qq.com");
        message.setCc("2451651145@qq.com");
        message.setBcc("2578293757@qq.com");
        mailSender.send(message);
    }

    @Autowired
    TemplateEngine templateEngine;

    @Test
    void test1() throws MessagingException {
        MimeMessage mimeMessage = mailSender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(mimeMessage, true);
        helper.setSubject("这是一封测试邮件");
        Context context = new Context();
        context.setVariable("username", "javaboy");
        context.setVariable("position", "Java 工程师");
        context.setVariable("salary", 99999);
        String mail = templateEngine.process("mail", context);
        System.out.println(mail);
        helper.setText(mail, true);
        helper.setSentDate(new Date());
        helper.setFrom("1510161612@qq.com");
        helper.setTo("775969742@qq.com");
        helper.setCc("2451651145@qq.com");
        helper.setBcc("2578293757@qq.com");
        helper.addAttachment("1560496899.png", new File("C:\\Users\\sang\\Downloads\\1560496899.png"));
        mailSender.send(mimeMessage);
    }


    @Test
    void test3() throws MessagingException, IOException, TemplateException {
        MimeMessage mimeMessage = mailSender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(mimeMessage, true);
        helper.setSubject("这是一封测试邮件");
        Configuration configuration = new Configuration(Configuration.VERSION_2_3_29);
        configuration.setClassLoaderForTemplateLoading(this.getClass().getClassLoader(), "templates");
        Template template = configuration.getTemplate("mail.ftlh");
        StringWriter out = new StringWriter();
        Map<String, Object> map = new HashMap<>();
        map.put("username", "javaboy");
        map.put("salary", 999999);
        map.put("position", "Java高工");
        template.process(map, out);
        helper.setText(out.toString(), true);
        helper.setSentDate(new Date());
        helper.setFrom("1510161612@qq.com");
        helper.setTo("775969742@qq.com");
        helper.setCc("2451651145@qq.com");
        helper.setBcc("2578293757@qq.com");
        helper.addAttachment("1560496899.png", new File("C:\\Users\\sang\\Downloads\\1560496899.png"));
        mailSender.send(mimeMessage);
    }


    @Test
    void test2() throws MessagingException {
        MimeMessage mimeMessage = mailSender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(mimeMessage, true);
        helper.setSubject("这是一封测试邮件");
        helper.setText("<p>这是一封带图片的测试邮件</p><img src='cid:p01'/>", true);
        helper.setSentDate(new Date());
        helper.setFrom("1510161612@qq.com");
        helper.setTo("775969742@qq.com");
        helper.setCc("2451651145@qq.com");
        helper.setBcc("2578293757@qq.com");
        helper.addInline("p01", new FileSystemResource(new File("C:\\Users\\sang\\Downloads\\1560496899.png")));
        mailSender.send(mimeMessage);
    }


}
