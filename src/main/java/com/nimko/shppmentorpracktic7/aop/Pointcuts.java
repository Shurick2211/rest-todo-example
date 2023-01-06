package com.nimko.shppmentorpracktic7.aop;

import org.aspectj.lang.annotation.Pointcut;

public class Pointcuts {
    @Pointcut("execution(* com.nimko.shppmentorpracktic7.controllers.ToDoController.*(..))")
    public void allControllerMethods(){}

}
