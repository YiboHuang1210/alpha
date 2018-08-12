package com.hyb.alpha.aspect;


import com.hyb.alpha.exception.AlphaException;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

/**
 * 日志切面
 *
 * 通知分类：
 *　  @Before: 前置通知, 在方法执行之前执行
 *    @After: 后置通知, 在方法执行之后执行
 *    @AfterRunning: 返回通知, 在方法返回结果之后执行
 *    @AfterThrowing: 异常通知, 在方法抛出异常之后
 *    @Around: 环绕通知, 围绕着方法执行
 * @author Yibo
 * @version 1.0
 * @since 2018/8/8 13:58
 **/

@Component
@Aspect
public class LoggingAspect {

    private static final Logger logger = LoggerFactory.getLogger(LoggingAspect.class);

    @Pointcut("execution(public * com.hyb.alpha.controller.SwaggerController.*(..))")
    public void http(){}

    /**
     * 声明该方法是一个前置通知：在目标方法开始之前执行 哪些类，哪些方法
     * 作用：@before 当调用目标方法，而目标方法与注解声明的方法相匹配的时候，aop框架会自动的为那个方法所在的类生成一个代理对象，在目标方法执行之前，执行注解的方法
     * 支持通配符
     * @param joinPoint
     */
    @Before("http()")
    public void doBefore(JoinPoint joinPoint){

        //记录http请求,从request中获取http请求的url/请求的方法类型／响应该http请求的类方法／IP地址／请求中的参数
        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = attributes.getRequest();

        String methodName = joinPoint.getSignature().getDeclaringTypeName()+ "."+joinPoint.getSignature().getName();
        logger.info("[doBefore] url={}, method={}, ip={}, class_method={}, args={}",request.getRequestURI(),request.getMethod(),request.getRemoteAddr(),methodName,joinPoint.getArgs());
    }

    /**
     * 在方法执行后执行的代码，无论该方法是否出现异常
     * @param joinPoint
     */
    @After("http()")
    public void doAfter(JoinPoint joinPoint){
        String methodName = joinPoint.getSignature().getDeclaringTypeName()+ "."+joinPoint.getSignature().getName();
        logger.info("[doAfter] method={}",methodName);
    }

    /**
     * 在方法正常结束后执行代码，放回通知是可以访问到方法的返回值
     * @param joinPoint
     * @param object
     */
    @AfterReturning(returning = "object",pointcut = "http()")
    public void doAfterReturning(JoinPoint joinPoint,Map<String, Object> object){
        String methodName = joinPoint.getSignature().getDeclaringTypeName()+ "."+joinPoint.getSignature().getName();
        logger.info("[doReturn] response={},method={}",object,methodName);
    }

    /**
     * 在目标方法出现异常时会执行代码，可以访问到异常对象，且，可以指定出现特定异常时执行通知代码
     * @param joinPoint
     * @param ex
     */
    @AfterThrowing(throwing="ex", pointcut = "http()")
    public void afterThrowing(JoinPoint joinPoint, AlphaException ex){
        String methodName = joinPoint.getSignature().getDeclaringTypeName()+ "."+joinPoint.getSignature().getName();
        logger.warn("[afterThrowing] Method={}, Msg={}",methodName,ex.getMessage());
    }

    /**
     * 环绕通知需要携带 ProceedingJoinPoint 类型的参数
     * 环绕通知 类似于  动态代理的全过程
     * ProceedingJoinPoint：可以决定是否执行目标方法
     * 环绕通知必须有返回值，返回值即为目标方法的返回值
     *
     * @param proceedingJoinPoint
     */
//    @Around("execution(* com.hyb.aop.service.impl.*.*(..))")
//    public Object around(ProceedingJoinPoint proceedingJoinPoint){
//
//        Object result = null;
//        String methodName = proceedingJoinPoint.getSignature().getName();
//
//        //执行目标方法
//        try {
//            //前置通知
//            logger.info("The method " + methodName + " begin with " + Arrays.asList(proceedingJoinPoint.getArgs()));
//            result = proceedingJoinPoint.proceed();
//        } catch (Throwable e) {
//            //异常通知
//            logger.error("The method " + methodName + " occurs exceptions " + e);
//            throw new RuntimeException();
//        }
//        //后置通知
//        logger.info("The method " + methodName + " end with " + result);
//        return result;
//    }
}
