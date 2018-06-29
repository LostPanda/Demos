package com.demo.springdemo.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.core.annotation.Order;

/**
 * @Author wb-hx347246
 * @Date 2018/6/22 10:44
 */
@Aspect
@Order(3)
public class TestAop {

    @AfterThrowing(pointcut = "execution(* *.*(..))", throwing = "ex")
    public void handleException(JoinPoint jp,Throwable ex) {
        System.out.println(jp.getSignature().getName()+"发生异常:"+ex.getMessage());
    }

    @AfterReturning("execution(* com.demo.springdemo.aop.*.*(..))")
    public Object doAfter(JoinPoint jp){
        Object[] args = jp.getArgs();
        System.out.println(args);
        return "11";
    }


}
