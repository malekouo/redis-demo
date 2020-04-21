package com.example.springaop;

import com.example.springaop.service.StockService;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
@Slf4j
class SpringAopApplicationTests {

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
            new  SubtractThread().start();
        }
        log.info("库存总数{}",StockService.stockAmount);
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

}
