package com.goodlife.simple;

import com.goodlife.annotation.EnableAopJunitTest;
import com.goodlife.annotation.EnableInterceptorJunitTest;
import com.goodlife.compile.annotation.EnableCompile;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * @Auther: zcx
 * @Date: 2019/10/28 17:37
 * @Description:
 */
@EnableSwagger2
@SpringBootApplication
//@EnableCompile
//@EnableAopJunitTest
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

}
