package com.nimko.shppmentorpracktic7.aop;

import com.nimko.shppmentorpracktic7.models.ToDoEntity;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Component
@Aspect
@Slf4j
public class MyAspect {

    @Around("Pointcuts.allControllerMethods()")
    public Object logging(ProceedingJoinPoint joinPoint) throws Throwable {
       MethodSignature signature = (MethodSignature) joinPoint.getSignature();
       String methodName = signature.getName();
       log.info("{} was call", methodName);
       if (methodName.startsWith("create") || methodName.startsWith("put")) {
           log.info("{} try to add on DB", Arrays.stream(joinPoint.getArgs()).sequential()
                   .filter(ToDoEntity.class::isInstance).findFirst().orElse(""));
       }
       Object o = joinPoint.proceed();
       log.info("Success for {}", methodName);
       return o;
    }

}
