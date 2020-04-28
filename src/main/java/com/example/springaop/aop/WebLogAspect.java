package com.example.springaop.aop;


import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
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
public class WebLogAspect {

    //todo 这个切点是可以改成 注解一起使用的
    //定义web请求日志切点 controller包下面的类的所有方法 或者方法上面 配置注解 @WebLog 的
    @Pointcut("execution(* com.example.springaop.controller.*.*(..))|| @annotation(com.example.springaop.aop.annotation.WebLog)")
    private void webLog() {
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
        log.info("请求内容:方式{{}}--url{{}}--method{{}}--payload{{}}", request.getMethod(), request.getRequestURI(), joinPoint.getSignature(), joinPoint.getArgs());
    }


}
