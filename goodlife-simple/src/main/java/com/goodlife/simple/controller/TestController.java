package com.goodlife.simple.controller;

import com.alibaba.fastjson.JSONObject;
import com.goodlife.simple.config.TestProperties;
import com.goodlife.simple.model.Testa;
import com.goodlife.simple.model.Testb;
import com.goodlife.simple.service.TestService;
import com.goodlife.simple.service.TestServiceImpl;
import com.goodlife.simple.util.HuManager;
import org.apache.http.HttpRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.web.bind.annotation.*;

import java.io.UnsupportedEncodingException;

/**
 * @Auther: zcx
 * @Date: 2019/10/28 17:27
 * @Description:
 */
@RestController
@RequestMapping("/test")
public class TestController {

    @Autowired
    private ApplicationContext applicationContext;

    @Autowired
    private TestService testService;

    @Autowired
    private TestProperties testProperties;


    @RequestMapping(value = "/test1" ,method= RequestMethod.POST)
    public void test(String a, String b){
        System.out.println(testProperties.getTest().get(a).get(b));
    }

    @RequestMapping(value = "/test2" ,method= RequestMethod.POST)
    public void test2(@ModelAttribute Testa test,String a,String b){
        System.out.println("a:"+a+"b:"+b);
        Testb testb = new Testb();
        testb.setAge(a);
        testb.setName(b);
        testb.setId("123");

        testService.adfa(testb);
    }

    @RequestMapping(value = "/aa",method= RequestMethod.GET)
    @ResponseBody
    public JSONObject aa(String a,String b){
        String sbUrl = "https://wecloudapi.autoai.com/radio/p3/obtain/category?apiKey=b83a217b94c247baa51e851fa9d1c892&os=other&openid=px91042019092310004911&deviceId=1005219031600178";
        JSONObject data;
        JSONObject resBody = new JSONObject();
        resBody.put("code", 200);
        resBody.put("msg", "success");
        // 发送请求
        String result = HuManager.send(sbUrl.toString());

        try {
            result = new String(result.getBytes("utf-8"),"GBK");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }

        resBody.put("data",result);
        return resBody;
    }

}
