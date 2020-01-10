package com.goodlife.config;

import com.goodlife.interceptor.JunitInterceptor;
import com.goodlife.util.AutoCreateJunitUtils;
import org.springframework.aop.aspectj.AspectJExpressionPointcut;
import org.springframework.aop.support.DefaultPointcutAdvisor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

/**
 * @Auther: zcx
 * @Date: 2019/11/11 16:46
 * @Description:
 */
@EnableAspectJAutoProxy
@Configuration
public class InterceptorConfig {

    @Value("${junit.execution}")
    private String execution;

    @Value("${junit.resourcePath}")
    private String resourcePath;

    @Bean
    public DefaultPointcutAdvisor defaultPointcutAdvisor() {
        JunitInterceptor interceptor = new JunitInterceptor();
        AspectJExpressionPointcut pointcut = new AspectJExpressionPointcut();
        pointcut.setExpression(execution);

        // 配置增强类advisor
        DefaultPointcutAdvisor advisor = new DefaultPointcutAdvisor();
        advisor.setPointcut(pointcut);
        advisor.setAdvice(interceptor);
        return advisor;
    }


}
