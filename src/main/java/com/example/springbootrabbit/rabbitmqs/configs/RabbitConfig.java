package com.example.springbootrabbit.rabbitmqs.configs;


import org.springframework.amqp.core.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 *
 * 普通队列
 * 这里注入一个AmqpTemplate来发布消息
 * 接下来我们需要在rabbit-consumer工程配置一下消费者。
 * 创建StringConsumer
 */

/**
 * fanout模式
 * fanout属于广播模式，只要跟它绑定的队列都会通知并且接受到消息。
 * 我们同理在RabbitConfig中配置一下fanout模式的队列跟交换机。
 * 在代码中我们配置了三个队列名、一个fanout交换机，并且将这三个队列绑定到了fanout交换器上。只要我们往这个交换机生产新的消息，那么这三个队列都会收到。
 * 接下来，我们在RabbitProducer 中添加fanout的生产方法。
 *
 */

/**
 *
 * topic模式，
 * 同样，配置topic队列跟交换器，注意的是这里需要多配置一个bindingKey
 * topicA的key为topic.msg 那么他只会接收包含topic.msg的消息
 * topicB的key为topic.#那么他只会接收topic开头的消息
 * topicC的key为topic.*.Z那么他只会接收topic.B.z这样格式的消息
 * 同理在RabbitProducer完成topic生产方法
 *
 */
@Configuration
public class RabbitConfig {
    /**
     * 定义队列名
     */
    private final static String STRING = "string";


    /**
     * 普通队列
     * 定义string队列
     * @return
     */
    @Bean
    public Queue string() {
        return new Queue(STRING);

    }

    //=================== fanout 模式  ====================
//在代码中我们配置了三个队列名、一个fanout交换机，并且将这三个队列绑定到了fanout交换器上。只要我们往这个交换机生产新的消息，那么这三个队列都会收到。
   // 接下来，我们在RabbitProducer 中添加fanout的生产方法。
   @Bean
    public Queue fanoutA() {
        return new Queue("fanout.a");
    }

    @Bean
    public Queue fanoutB() {
        return new Queue("fanout.b");
    }

    @Bean
    public Queue fanoutC() {
        return new Queue("fanout.c");
    }

    /**
     * 定义个fanout交换器
     * @return
     */
    @Bean
    FanoutExchange fanoutExchange() {
        // 定义一个名为fanoutExchange的fanout交换器
        return new FanoutExchange("fanoutExchange");
    }

    /**
     * 将定义的fanoutA队列与fanoutExchange交换机绑定
     * @return
     */
    @Bean
    public Binding bindingExchangeWithA() {
        return BindingBuilder.bind(fanoutA()).to(fanoutExchange());
    }

    /**
     * 将定义的fanoutB队列与fanoutExchange交换机绑定
     * @return
     */
    @Bean
    public Binding bindingExchangeWithB() {
        return BindingBuilder.bind(fanoutB()).to(fanoutExchange());
    }

/**
     * 将定义的fanoutC队列与fanoutExchange交换机绑定
     * @return
     */
    @Bean
    public Binding bindingExchangeWithC() {
        return BindingBuilder.bind(fanoutC()).to(fanoutExchange());
    }



    //#################topic模式########################

    @Bean
    public Queue topiocA() {
        return new Queue("topic.a");
    }

    @Bean
    public Queue topicB() {
        return new Queue("topic.b");
    }

    @Bean
    public Queue topicC() {
        return new Queue("topic.c");
    }

    /**
     * 定义个topic交换器
     * @return
     */
    @Bean
    TopicExchange topicExchange() {
        // 定义一个名为fanoutExchange的fanout交换器
        return new TopicExchange("topicExchange");
    }

    /**
     * 将定义的topicA队列与topicExchange交换机绑定
     * @return
     */
    @Bean
    public Binding bindingTopicExchangeWithA() {
        return BindingBuilder.bind(topiocA()).to(topicExchange()).with("topic.msg");
    }

    /**
     * 将定义的topicB队列与topicExchange交换机绑定
     * @return
     */
    @Bean
    public Binding bindingTopicExchangeWithB() {
        return BindingBuilder.bind(topicB()).to(topicExchange()).with("topic.#");
    }

    /**
     * 将定义的topicC队列与topicExchange交换机绑定
     * @return
     */
    @Bean
    public Binding bindingTopicExchangeWithC() {
        return BindingBuilder.bind(topicC()).to(topicExchange()).with("topic.*.z");
    }
}