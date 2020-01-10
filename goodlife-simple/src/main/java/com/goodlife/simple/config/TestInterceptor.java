package com.goodlife.simple.config;

import com.goodlife.ljq.model.MethodInterceptorResult;
import com.goodlife.ljq.model.Result;
import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;
import org.springframework.stereotype.Component;

/**
 * @Auther: zcx
 * @Date: 2019/11/18 11:18
 * @Description:
 */

//@Component
public class TestInterceptor implements MethodInterceptor  {
    @Override
    public Object invoke(MethodInvocation invocation) throws Throwable {

        Result aopResult = new MethodInterceptorResult(invocation);
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

        return null;
    }
}
