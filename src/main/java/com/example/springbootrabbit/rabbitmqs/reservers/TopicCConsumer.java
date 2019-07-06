package com.example.springbootrabbit.rabbitmqs.reservers;

import com.aliyuncs.exceptions.ClientException;
import com.example.springbootrabbit.rabbitmqs.duanxin.AliyunSmsUtils;
import com.example.springbootrabbit.rabbitmqs.mail.TestMail;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import static java.lang.Thread.sleep;

@Component
@RabbitListener(queues = "topic.c")
public class TopicCConsumer {

    @Autowired
    private TestMail testmail;
    @Autowired
    private AmqpTemplate rabbitmqTemplate;

    /**
     * 消息消费
     * @RabbitHandler 代表此方法为接受到消息后的处理方法
     */
    @RabbitHandler
    public void recieved(String msg) throws ClientException {
        System.out.println("topicb+++++发短信中+++++");
        AliyunSmsUtils.sendSms("18580369113","hello");

        System.out.println("[topic.C] recieved message:接受信息 = " + msg);
    }
}