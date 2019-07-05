package com.example.springbootrabbit.rabbitmqs.reservers;

import com.example.springbootrabbit.rabbitmqs.mail.TestMail;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import static java.lang.Thread.sleep;

@Component
@RabbitListener(queues = "topic.a")
public class TopicAConsumer {

    @Autowired
    private AmqpTemplate rabbitmqTemplate;

    @Autowired
    private TestMail testmail;

    /**
     * 消息消费
     * @RabbitHandler 代表此方法为接受到消息后的处理方法
     */
    @RabbitHandler
    public void recieved(String msg) {
        System.out.println("发邮件中+++++++++");
        testmail.reportCurrentTime();
        System.out.println("[topic.a] recieved message:接受信息 = " + msg);
    }
}