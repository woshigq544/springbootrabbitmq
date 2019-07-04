package com.example.springbootrabbit.mypackages.reservers;

import com.example.springbootrabbit.mypackages.mail.TestMail;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.retry.backoff.Sleeper;
import org.springframework.stereotype.Component;

/**
 * @author yukong
 * @date 2018/8/22
 * @description rabbitmq消费者 @RabbitListener(queues = "simpleMsg") 监听名simpleMsg的队列
 */
@Component
@RabbitListener(queues = "string")
public class HelloReceiver {

    @Autowired private AmqpTemplate rabbitmqTemplate;

    @Autowired
    private TestMail tm;
    /**
     * 消息消费
     * @RabbitHandler 代表此方法为接受到消息后的处理方法
     */
    @RabbitHandler
    public void recieved(String msg) {
        for(int i = 0 ; i < 20  ; i++){
            System.out.println(i);
            tm.reportCurrentTime();
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

}