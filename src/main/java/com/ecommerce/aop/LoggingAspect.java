package com.ecommerce.aop;

import org.aspectj.lang.*;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LoggingAspect {

    // 1️⃣ Join Point → كل methods داخل service
    @Pointcut("execution(* com.ecommerce.service.*.*(..))")
    public void serviceLayer(){}

    // 2️⃣ Before Advice
    @Before("serviceLayer()")
    public void logBefore(JoinPoint joinPoint){

        System.out.println("🔹 Method Started: "
                + joinPoint.getSignature().getName());
    }

    // 3️⃣ After Returning Advice
    @AfterReturning(pointcut = "serviceLayer()", returning = "result")
    public void logAfter(JoinPoint joinPoint, Object result){

        System.out.println("✅ Method Finished: "
                + joinPoint.getSignature().getName());

        System.out.println("➡ Result: " + result);
    }

    // 4️⃣ After Throwing Advice
    @AfterThrowing(pointcut = "serviceLayer()", throwing = "ex")
    public void logError(JoinPoint joinPoint, Exception ex){

        System.out.println("❌ Error in: "
                + joinPoint.getSignature().getName());

        System.out.println("⚠ Exception: " + ex.getMessage());
    }

    @Around("serviceLayer()")
    public Object logExecutionTime(ProceedingJoinPoint joinPoint) throws Throwable {

        long start = System.currentTimeMillis();

        Object result = joinPoint.proceed();

        long end = System.currentTimeMillis();

        System.out.println("⏱ Execution time: "
                + (end - start) + "ms");

        return result;
    }
}