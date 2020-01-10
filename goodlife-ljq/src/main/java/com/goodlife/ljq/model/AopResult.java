package com.goodlife.ljq.model;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.reflect.MethodSignature;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;

/**
 * @Auther: zcx
 * @Date: 2019/11/18 09:48
 * @Description:
 */
public class AopResult extends AbstractResult {

    private JoinPoint joinPoint;

    public AopResult(JoinPoint joinPoint) {
        this.joinPoint = joinPoint;
    }

    @Override
    public String getPackageName() {
        return getClazz().getPackage().getName();
    }

    @Override
    public String getClassName() {
        return joinPoint.getTarget().getClass().getSimpleName();
    }

    @Override
    public Method getMethod() {
        return ((MethodSignature)joinPoint.getSignature()).getMethod();
    }

    @Override
    public Annotation[] getAnnotations() {
        return getMethod().getAnnotations();
    }

    @Override
    public Class getClazz() {
        return joinPoint.getTarget().getClass();
    }

    @Override
    public String getJsonStr() {
        String stringObj = "";
        if (this.getContentType()!= null && "application/json".equals(this.getContentType())){

            Object[] objs = getParams();
            for (Object obj: objs) {
                if (obj.toString().contains("=")) {
                    String s = obj.toString();

                    //Testa(id=aef , name=fdf, age=adf)
                    int a = s.indexOf("(");
                    int b = s.indexOf(")");
                    String x = s.substring(a+1,b);

                    String newstr = x.replace("=",":\"");
                    stringObj= "{" +newstr.replace(",","\",") + "\"}";
                    break;
                }
            }
            return stringObj;

        }
        return null;
    }

    @Override
    public String getMethodName() {
        return getMethod().getName();
    }


    @Override
    public Object[] getParams() {

        // reqParam = JSON.toJSONString(request.getParameterMap());
        return joinPoint.getArgs();
    }

}
