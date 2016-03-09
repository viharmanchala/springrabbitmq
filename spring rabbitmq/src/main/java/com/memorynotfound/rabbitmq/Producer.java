package com.memorynotfound.rabbitmq;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Producer {

    public static void main(String[] args) {
        @SuppressWarnings("resource")
		ApplicationContext ctx = new AnnotationConfigApplicationContext(RabbitMqConfig.class);
        RabbitTemplate rabbitTemplate = ctx.getBean(RabbitTemplate.class);

        for (int i = 0; i < 5; i++){
            System.out.println("sending new custom message..");
            rabbitTemplate.convertAndSend(new CustomMessage(i, "RabbitMQ Spring JSON Example"));
        }
    }

}
