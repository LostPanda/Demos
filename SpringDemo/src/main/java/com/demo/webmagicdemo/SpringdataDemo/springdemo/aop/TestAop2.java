package com.demo.webmagicdemo.SpringdataDemo.springdemo.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

/**
 * @Author wb-hx347246
 * @Date 2018/6/22 14:52
 */
@Aspect
@Component
@Order(4)
public class TestAop2 {

    @Pointcut("execution(* com.demo.springdemo.aop.*.*(..))")
    public void pointCut(){}

    @Around("pointCut()")
    public Object aroundCut(ProceedingJoinPoint jp){
        Object proceed=null;
        try {
            Object[] args1 = jp.getArgs();
            Object[] newArg=new Object[args1.length];
            int i=0;
            for (Object o : args1) {
                if(o instanceof Integer){
                    o=(Integer)o+20;
                }
                newArg[i]=o;
                i++;
            }
            proceed = jp.proceed(newArg);
            Object[] args = jp.getArgs();
            int temp=0;
            for (Object arg : args) {
                if(arg instanceof Integer)
                    temp=(Integer)arg;
            }
            proceed=(String)proceed+(temp+10);
        } catch (Throwable throwable) {
            throwable.printStackTrace();
        }
        return proceed;
    }
}
