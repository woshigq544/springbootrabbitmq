package com.example.springbootrabbit.rabbitmqs.mail;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;
import java.util.Date;

@Component
public class TestMail {
    private static final SimpleDateFormat dateFormat = new SimpleDateFormat("HH:mm:ss");

    @Autowired
    private JavaMailSender mailSender;
    // 发件人邮箱地址
    @Value("${spring.mail.username}")
    private String from ;
    /*
     * @Scheduled(fixedRate = 6000) 上一次开始执行时间点之后6秒再执行
     * @Scheduled(fixedDelay = 6000) 上一次执行完毕时间之后6秒再执行
     * @Scheduled(initialDelay=1000, fixedRate=6000) 第一次延迟1秒后执行，之后按fixedRate的规则执行
     * */
   // @Scheduled(fixedRate = 6000)/*每隔六秒钟执行一次*/
    public void reportCurrentTime() {
        System.out.println("FROM = "+from);
        System.out.println("现在时间：" + dateFormat.format(new Date()));
        SimpleMailMessage message = new SimpleMailMessage();
        message.setFrom(from);
        //目标邮箱
        message.setTo("544279513@qq.com");
        message.setSubject("主题：emmmmmmmmmmm");
        message.setText("测试邮件内容1");
        mailSender.send(message);
    }
}