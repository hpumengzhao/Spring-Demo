package org.codancer.annoaop;


import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

import java.util.Arrays;

//切面类
@Aspect
@Component
public class LogAspect {
    //设置切入点和通知类型
    //通知类型：前置 返回 异常 后置和环绕
//    @Before()
//    @AfterReturning
//    @AfterThrowing
//    @After()
//    @Around()
//    @Pointcut() 重用切入点表达式

    //切入点表达式: execution(public int org.codancer.annoaop.target.Calculator.add(int, int))
    @Before(value = "execution(public int org.codancer.annoaop.Calculator.*(..))")
    public void beforeMethod(JoinPoint joinPoint) {
        String method = joinPoint.getSignature().getName();
        System.out.println(method + " 前置通知");
    }

    //重用切入点表达式
    @After(value = "pointCut()")
    public void afterMethod(JoinPoint joinPoint) {
        String method = joinPoint.getSignature().getName();
        System.out.println(method + " 后置通知");
    }

    @AfterReturning(value = "execution(public int org.codancer.annoaop.Calculator.*(..))",returning = "result")
    public void afterReturningMethod(JoinPoint joinPoint, Object result) {
        String method = joinPoint.getSignature().getName();
        System.out.println(method + " 返回后通知, 返回结果为 " + result);
    }

    @AfterThrowing(value = "execution(public int org.codancer.annoaop.Calculator.div(int, int))", throwing = "ex")
    public void afterThrowing(JoinPoint joinPoint, Throwable ex) {
        String method = joinPoint.getSignature().getName();
        System.out.println(method + " 返回后通知, 异常信息为 " + ex);
    }

    @Around(value = "execution(public int org.codancer.annoaop.Calculator.*(..))")
    public Object around(ProceedingJoinPoint joinPoint) {
        String method = joinPoint.getSignature().getName();
        Object[] args = joinPoint.getArgs();
        String argString = Arrays.toString(args);
        System.out.println(method + " ");
        Object result = null;
        try {
            System.out.println("环绕通知==目标方法之前");
            result = joinPoint.proceed();
            System.out.println("环绕通知==目标方法返回值之后");
        } catch (Throwable throwable) {
            System.out.println("环绕通知==目标方法出现异常");
        }finally {
            System.out.println("环绕通知==目标方法完成");
        }
        return result;
    }

    //重用切入表达式
    @Pointcut(value = "execution(public int org.codancer.annoaop.Calculator.*(..))")
    public void pointCut() {

    }

}
