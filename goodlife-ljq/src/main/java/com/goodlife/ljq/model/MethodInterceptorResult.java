package com.goodlife.ljq.model;

import org.aopalliance.intercept.MethodInvocation;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.reflect.MethodSignature;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;

/**
 * @Auther: zcx
 * @Date: 2019/11/18 09:48
 * @Description:
 */
public class MethodInterceptorResult extends AbstractResult {

    private MethodInvocation invocation;

    public MethodInterceptorResult(MethodInvocation invocation) {
        this.invocation = invocation;
    }

    @Override
    public String getPackageName() {
        return getClazz().getPackage().getName();
    }

    @Override
    public String getClassName() {
        System.out.println(getClazz().getSimpleName());
        return getClazz().getSimpleName();
    }

    @Override
    public Method getMethod() {
        return invocation.getMethod();
    }

    @Override
    public Annotation[] getAnnotations() {
        return getMethod().getAnnotations();
    }

    @Override
    public Class getClazz() {
        return invocation.getMethod().getDeclaringClass();
    }


    @Override
    public String getMethodName() {
        return getMethod().getName();
    }


    @Override
    public Object[] getParams() {

        // reqParam = JSON.toJSONString(request.getParameterMap());
        return invocation.getArguments();
    }

}
