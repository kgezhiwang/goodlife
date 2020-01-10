package com.goodlife.annotation;

import com.goodlife.interceptor.InterceptorAspect;
import org.springframework.context.annotation.Import;

import java.lang.annotation.*;

/**
 * @Auther: zcx
 * @Date: 2019/3/20 14:26
 * @Description:
 */

@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Import(InterceptorAspect.class)
public @interface EnableInterceptorJunitTest {

    String value() default "";
}
