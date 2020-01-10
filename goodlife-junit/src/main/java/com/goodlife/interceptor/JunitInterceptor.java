package com.goodlife.interceptor;

import com.goodlife.ljq.model.MethodInterceptorResult;
import com.goodlife.ljq.model.Result;
import com.goodlife.util.AutoCreateJunitUtils;
import lombok.extern.slf4j.Slf4j;
import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

/**
 * @Auther: zcx
 * @Date: 2019/3/20 14:28
 * @Description:传入参数为json，且为post请求
 */
@Slf4j
@Component
public class JunitInterceptor implements MethodInterceptor {



    @Override
    public Object invoke(MethodInvocation invocation) throws Throwable {

        Result result = new MethodInterceptorResult(invocation);
        AutoCreateJunitUtils autoCreateJunitUtils = new AutoCreateJunitUtils();
        autoCreateJunitUtils.generator(result);
        return invocation.proceed();
    }

}
