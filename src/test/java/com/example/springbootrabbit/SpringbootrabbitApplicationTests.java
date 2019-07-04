package com.example.springbootrabbit;

import com.example.springbootrabbit.mypackages.reservers.HelloReceiver;
import com.example.springbootrabbit.mypackages.sender.HelloSender;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringbootrabbitApplicationTests {
    @Autowired
    private HelloSender producer;
    @Autowired
    private HelloReceiver r;

    @Test
    public void testStringSend() {
        producer.topicTopic1Send();
        producer.topicTopic2Send();
        producer.topicTopic3Send();
    }
}
