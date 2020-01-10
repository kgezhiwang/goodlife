package com.goodlife.redis.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.HashOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Auther: zcx
 * @Date: 2019/10/31 10:27
 * @Description:
 */
@RestController
public class TestController {

    @Autowired
    private RedisTemplate redisTemplate;

    @GetMapping("/test")
    public void test() {
        System.out.println(redisTemplate.hasKey("name"));
        redisTemplate.opsForValue().set("name", "123214");
        String name = (String) redisTemplate.opsForValue().get("name");
        System.out.println(name);
        redisTemplate.opsForValue().set("name2", "123214");
        String name2 = (String) redisTemplate.opsForValue().get("name");
        System.out.println(name2);
        redisTemplate.opsForValue().set("name3", "123214");
        String name3 = (String) redisTemplate.opsForValue().get("name");
        System.out.println(name3);
        redisTemplate.opsForValue().set("name4", "123214");
        String name4 = (String) redisTemplate.opsForValue().get("name");
        System.out.println(name4);
        HashOperations<String, String, String> hashOperations = redisTemplate.opsForHash();
        hashOperations.put("user", "test", "测试");
        System.out.println(hashOperations.get("user", "test"));
    }

}