package com.goodlife.simple.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

import java.util.Map;

/**
 * @Auther: zcx
 * @Date: 2019/12/5 16:58
 * @Description:
 */

@Data
@ConfigurationProperties(prefix = "aaa")
public class TestProperties {

    private Map<String,Map<String, String>> test;
}
