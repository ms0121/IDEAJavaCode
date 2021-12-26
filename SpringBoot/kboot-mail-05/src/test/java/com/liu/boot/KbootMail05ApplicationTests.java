package com.liu.boot;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.AutoConfigureOrder;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.mock.http.MockHttpInputMessage;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import java.io.File;

@SpringBootTest
class KbootMail05ApplicationTests {

    @Autowired
    JavaMailSenderImpl mailSender;

    // 简单的邮件发送的方式
    @Test
    void contextLoads() {
        SimpleMailMessage simpleMailMessage = new SimpleMailMessage();
        simpleMailMessage.setSubject("这是主题：比赛通知");
        simpleMailMessage.setText("今天晚上7:30开始");

        simpleMailMessage.setTo("1132601565@qq.com");
        simpleMailMessage.setFrom("1132601565@qq.com");

        mailSender.send(simpleMailMessage);
    }


    //复杂的邮箱发送信息的设置
    @Test
    public void context2() throws MessagingException {
        MimeMessage mimeMessage = mailSender.createMimeMessage();
        // 用于拼接邮件需要发送的复杂的信息
        MimeMessageHelper helper = new MimeMessageHelper(mimeMessage, true);

        // 主题和内容
        helper.setSubject("通知：明晚比赛");
        helper.setText("比赛时间是7-10点");

        // 添加附件
        helper.addAttachment("text1.pdf", new File("C:\\Users\\Administrator\\Desktop\\text1.pdf"));
        helper.setTo("1132601565@qq.com");
        helper.setFrom("1132601565@qq.com");

        mailSender.send(mimeMessage);
    }

}
