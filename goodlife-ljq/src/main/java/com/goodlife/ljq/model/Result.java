package com.goodlife.ljq.model;

import lombok.Data;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;

/**
 * @Auther: zcx
 * @Date: 2019/11/18 09:39
 * @Description:
 */

public interface Result {

    String url = null;

    String fullUrl = null;

    String packageName = null;

    Class clazz = null;

    String className = null;

    String methodName = null;

    Method method = null;

    Object[] params = null;

    String contentType = null;

    String requestMethod = null;

    String ipAddr = null;

    Annotation[] annotations = null;

    String jsonStr = null;

    public String getUrl();

    public String getFullUrl();

    public String getPackageName();

    public String getClassName();

    public String getMethodName();

    public String getContentType();

    public Object[] getParams();

    public String getRequestMethod();

    public String getIpAddr();

    public Method getMethod();

    public Annotation[] getAnnotations();

    public Class getClazz();

    public String getJsonStr();

}
