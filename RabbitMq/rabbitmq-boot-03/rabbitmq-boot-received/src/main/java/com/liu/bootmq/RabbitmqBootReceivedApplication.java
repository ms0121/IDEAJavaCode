package com.liu.bootmq;

import com.liu.bootmq.service.ReceivedService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class RabbitmqBootReceivedApplication {

    public static void main(String[] args) {

        ConfigurableApplicationContext run =
                SpringApplication.run(RabbitmqBootReceivedApplication.class, args);
        ReceivedService receivedService = run.getBean(ReceivedService.class);
        receivedService.receivedMessage();
    }

}
