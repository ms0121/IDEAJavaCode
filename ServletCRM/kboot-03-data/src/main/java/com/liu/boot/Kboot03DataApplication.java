package com.liu.boot;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.sql.DataSource;

@SpringBootApplication
public class Kboot03DataApplication {

    public static void main(String[] args) {
        SpringApplication.run(Kboot03DataApplication.class, args);

    }

}
