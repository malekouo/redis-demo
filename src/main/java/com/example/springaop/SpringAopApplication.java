package com.example.springaop;


import com.example.springaop.util.RedisUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@Slf4j
public class SpringAopApplication {

    public static void main(String[] args) {

        SpringApplication.run(SpringAopApplication.class, args);
        boolean a = RedisUtil.set("张三", "aa");
        log.info("a{}",a);
        boolean b = RedisUtil.set("李四","bb");
        log.info("b{}",b);
    }

}
