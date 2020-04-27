package com.example.springaop.aop;


import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;


@Aspect //定义这是一个切面类
@Component //加入IOC容器
@Slf4j
public class RedisAspect {

    //定义web请求日志切点
    @Pointcut("execution(com.example.springaop.controller.UserController.*(..))")
    private void webLog() {
    }

    //定义jedis切点（相当于每个JedisUtil下方法都会算一个切点）
    @Pointcut("execution(com.example.springaop.util.JedisUtil.*(..))")
    private void jedisPoint() {
    }

    /**
     * webLog() 切点在执行前，会执行这个方法
     *
     * @param joinPoint
     */
    @Before(value = "webLog()")
    public void before(JoinPoint joinPoint) {
        ServletRequestAttributes requestAttributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = requestAttributes.getRequest();
        //打印请求内容
        log.info("请求内容:方式{}--url{}--method{}--payload{}", request.getMethod(), request.getRequestURI(), joinPoint.getSignature(), joinPoint.getArgs());
    }


    @After(value = "jedisPoint()")
    public void after(JoinPoint joinPoint) {
        ServletRequestAttributes requestAttributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = requestAttributes.getRequest();
        //获取类
        Class<? extends JoinPoint> jedisUtil = joinPoint.getClass();
        ClassLoader classLoader = jedisUtil.getClassLoader();
        //todo 关闭jedis实例连接
       /* //打印请求内容
        log.info("请求内容:方式{}--url{}--method{}--payload{}", request.getMethod(), request.getRequestURI(), joinPoint.getSignature(), joinPoint.getArgs());*/
    }


}
