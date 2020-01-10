package com.goodlife.ljq.model;

import com.alibaba.fastjson.JSONObject;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.lang.annotation.Annotation;
import java.lang.reflect.Method;

/**
 * @Auther: zcx
 * @Date: 2019/11/18 09:52
 * @Description:
 */
public abstract class AbstractResult implements Result {

    private HttpServletRequest request;


    public AbstractResult(){
        this.request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
    }

    @Override
    public String getUrl() {
        return request.getRequestURL().toString();
    }

    public String getFullUrl() {
        HttpServletRequest httpRequest=(HttpServletRequest)request;

        String strBackUrl = "http://" + request.getServerName() //服务器地址
                + ":"
                + request.getServerPort()           //端口号
                + httpRequest.getContextPath()      //项目名称
                + httpRequest.getServletPath()      //请求页面或其他地址
                + "?" + (httpRequest.getQueryString()); //参数

        return strBackUrl;
    }

    @Override
    public String getIpAddr() {
        return  getRemoteHost(request);
    }

    @Override
    public String getContentType() {
        return request.getContentType();
    }

    @Override
    public String getRequestMethod() {
        return request.getMethod();
    }

    /**
     * 获取目标主机的ip
     * @param request
     * @return
     */
    private String getRemoteHost(HttpServletRequest request) {
        String ip = request.getHeader("x-forwarded-for");
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getHeader("Proxy-Client-IP");
        }
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getHeader("WL-Proxy-Client-IP");
        }
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getRemoteAddr();
        }
        return "0:0:0:0:0:0:0:1".equals(ip) ? "127.0.0.1" : ip;
    }

    @Override
    public String getJsonStr() {
        String stringObj = "";
        if (this.getContentType()!= null && "application/json".equals(this.getContentType())){

            Object[] objs = getParams();
            stringObj = JSONObject.toJSONString(objs[objs.length-1]);
//            for (Object obj: objs) {
//                if (obj.toString().contains("=")) {
//                    String s = obj.toString();
//
//                    //Testa(id=aef , name=fdf, age=adf)
//                    int a = s.indexOf("(");
//                    int b = s.indexOf(")");
//                    String x = s.substring(a+1,b);
//
//                    String newstr = x.replace("=",":\"");
//                    stringObj= "{" +newstr.replace(",","\",") + "\"}";
//                    break;
//                }
//            }
            return stringObj;

        }
        return null;
    }

}
