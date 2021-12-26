package com.liu.bootmq;

import com.liu.bootmq.service.SendService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class RabbitmqBootSendApplication {

    public static void main(String[] args) {
        ConfigurableApplicationContext run = SpringApplication.run(RabbitmqBootSendApplication.class, args);
        SendService sendService = run.getBean(SendService.class);
        System.out.println("sendService.getClass() = " + sendService.getClass());
        sendService.sendMessage("这是springboot实现的mq队列!");
    }
}
