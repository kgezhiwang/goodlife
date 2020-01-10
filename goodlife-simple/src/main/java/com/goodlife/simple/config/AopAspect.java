package com.goodlife.simple.config;

import com.goodlife.ljq.model.AopResult;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;

/**
 * @Auther: zcx
 * @Date: 2019/10/30 10:19
 * @Description:
 */
@Slf4j
//@Aspect
//@Component
public class AopAspect {

    @Pointcut("execution(public * com.goodlife.simple.controller..*(..))")
    public void pointCut(){}

    @Before("pointCut()")
    public void doBefore(JoinPoint joinPoint) throws Throwable {
        // 接收到请求，记录请求内容
        AopResult aopResult = new AopResult(joinPoint);
        System.out.println(aopResult.getMethod());
        System.out.println(aopResult.getClazz());
        System.out.println(aopResult.getAnnotations());
        System.out.println(aopResult.getClassName());
        System.out.println(aopResult.getClass());
        System.out.println(aopResult.getMethod());
        System.out.println(aopResult.getMethodName());
        System.out.println(aopResult.getPackageName());
        System.out.println(aopResult.getParams());
        System.out.println(aopResult.getContentType());
        System.out.println(aopResult.getIpAddr());
        System.out.println(aopResult.getRequestMethod());
        System.out.println(aopResult.getUrl());
        System.out.println(aopResult.getFullUrl());
        System.out.println(aopResult.getJsonStr());

        Object[] params = aopResult.getParams();
        for (Object obj : params) {
            System.out.println(obj);
        }

    }

    @AfterReturning(returning = "ret", pointcut = "pointCut()")
    public Object doAfterReturning(Object ret) throws Throwable {
        // 处理完请求，返回内容
        log.info("RESPONSE : " + ret);
        return ret;
    }
}
