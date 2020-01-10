package com.goodlife.simple.test;

import com.baidu.aip.imageclassify.AipImageClassify;
import org.apache.commons.io.FileUtils;
import org.json.JSONObject;

import java.io.File;
import java.util.HashMap;

/**
 * @Auther: zcx
 * @Date: 2019/11/15 17:02
 * @Description:
 */
public class Sample {
    //设置APPID/AK/SK
    public static final String APP_ID = "17780377";
    public static final String API_KEY = "NzcYHlwLSnbCKYIaUpDsBeGS";
    public static final String SECRET_KEY = "OAE9L45c7zGzHMvhnpYR9sxny0EwE4pH";

    public static void main(String[] args) throws Exception{
        // 初始化一个AipImageClassify
        AipImageClassify client = new AipImageClassify(APP_ID, API_KEY, SECRET_KEY);

        // 可选：设置网络连接参数
        client.setConnectionTimeoutInMillis(2000);
        client.setSocketTimeoutInMillis(60000);

        // 可选：设置代理服务器地址, http和socket二选一，或者均不设置
//        client.setHttpProxy("proxy_host", proxy_port);  // 设置http代理
//        client.setSocketProxy("proxy_host", proxy_port);  // 设置socket代理

        // 传入可选参数调用接口
        HashMap<String, String> options = new HashMap<String, String>();
        options.put("top_num", "3");
        options.put("filter_threshold", "0.7");
        options.put("baike_num", "5");


        // 参数为本地路径
        File files = new File("E:\\download\\python-win32-quickstart6\\food1.jpg");

        // 参数为二进制数组
        byte[] file = FileUtils.readFileToByteArray(files);
        JSONObject  res = client.dishDetect(file, options);
        System.out.println(res.toString(2));

    }

}
