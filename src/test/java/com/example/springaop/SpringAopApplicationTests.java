package com.example.springaop;

import com.alibaba.fastjson.JSON;
import com.example.springaop.aop.annotation.WebLog;
import com.example.springaop.service.StockService;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;

@SpringBootTest
@Slf4j
class SpringAopApplicationTests {

    @Autowired
    private StockService stockService;

    @Autowired
    private ApplicationContext applicationContext;

    @Test
    void contextLoads() {
    }

    /**
     * 测试不加锁
     */
    @Test
    void testOptimisticLock() {
        for (int i = 0; i < 1000; i++) {
            new AddThread().start();
            new SubtractThread().start();
        }
        log.info("库存总数{}", StockService.stockAmount);
    }


    class AddThread extends java.lang.Thread {
        public void run() {
            StockService stockService = StockService.getInstance();
            stockService.addStock();
        }

    }

    class SubtractThread extends java.lang.Thread {
        public void run() {
            StockService stockService = StockService.getInstance();
            stockService.subtractStock();
        }

    }

    //System.identityHashCode(Object) 返回对象地址
    @Test
    public void testString() {
        String a = "a";
        System.out.println("第一次内存地址：" + System.identityHashCode(a));
        a = "a";
        System.out.println("赋值以后内存地址：" + System.identityHashCode(a));
        a = "d";
    }

    @Test
    @WebLog
    public void testString2() {
        String[] beanDefinitionNames = applicationContext.getBeanDefinitionNames();
        log.info("beanNames{}", JSON.toJSONString(beanDefinitionNames));
        //ApplicationContext ac = new ClassPathXmlApplicationContext("app").getBean();
    }


}
