package com.goodlife.annotation;

import com.goodlife.config.InterceptorConfig;
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
@Import(InterceptorConfig.class)
public @interface EnableAopJunitTest {

    String value() default "";
}
