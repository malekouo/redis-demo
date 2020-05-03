package com.example.springaop.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

/**
 * 模拟库存
 */
@Slf4j
@Service
public class StockService {
    //定义库存总数为 100 （static修饰）
    public static int stockAmount = 1000;

    private static StockService stockService = new StockService();

    public void addStock() {
        stockAmount++;
        log.info("加库存成功,线程名称{}，库存数是{}", Thread.currentThread().getName(), stockAmount);
    }

    public void subtractStock() {
        stockAmount--;
        log.info("减库存成功,线程名称{}--操作成功，库存数是{}", Thread.currentThread().getName(), stockAmount);
    }

    //单例模式，恶汉模式，线程安全，不会重复创建
    public static StockService getInstance() {
        return stockService;
    }

}
