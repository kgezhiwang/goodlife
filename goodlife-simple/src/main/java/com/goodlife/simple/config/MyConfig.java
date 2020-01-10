package com.goodlife.simple.config;

import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Configuration;

/**
 * @Auther: zcx
 * @Date: 2019/12/5 16:57
 * @Description:
 */

@Configuration
@EnableConfigurationProperties({TestProperties.class})
public class MyConfig {
}
