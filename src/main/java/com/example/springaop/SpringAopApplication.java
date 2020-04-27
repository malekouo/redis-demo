package com.example.springaop;


import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
@Slf4j
public class SpringAopApplication {
    public static ApplicationContext applicationContext;

    public static void main(String[] args) {
        //启动类中返回  applicationContext，用于获取bean
        SpringAopApplication.applicationContext = SpringApplication.run(SpringAopApplication.class, args);
    }

}
