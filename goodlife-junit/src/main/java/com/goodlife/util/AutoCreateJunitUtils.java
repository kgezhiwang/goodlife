package com.goodlife.util;

import com.goodlife.ljq.model.Result;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;

import java.io.File;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @Auther: zcx
 * @Date: 2019/3/20 14:03
 * @Description:
 */
@Slf4j
public class AutoCreateJunitUtils {

    private String resourcePath = "E:/changcheng/gwm-app-store-service/src/test/java/com/mapbar/appStore/controller";




    public void generator(Result result) throws Exception {
        /**
         * 1、判断需要生成的文件是否已经存在
         * 2、如果不存在则生成header，生成method，拼装成新的file保存在具体路径下，并保存计数
         * 3、如果存在则生成method，获取文件后拼装生成新的文件
         * 4、把旧文件删除
         */

        File fileDir =  new File(resourcePath);
        File fileIsExists = new File(new StringBuffer(resourcePath).append("/").append(result.getClassName()).append("Test.java").toString());
        String file = "";

        if (!fileDir.exists()) {
            fileDir.mkdirs();
        }
        if (!fileIsExists.exists()) {
            fileIsExists.createNewFile();
            file = createHeader(result.getPackageName(),result.getClazz());
        } else {
            file = FileUtils.readFileToString(fileIsExists);
        }
        String method = createMethod(result);
        if (file.contains(method)) {
            return;
        }
        String str =  file.substring(0,file.length()-1) + method + file.substring(file.length()-1);

        FileUtils.writeStringToFile(fileIsExists,str);



    }



    public  String createHeader(String packageName,Class clazz) throws Exception {
        Map<String,Object> dataMap = new HashMap<>();
        dataMap.put("package",packageName);
        dataMap.put("className",clazz.getSimpleName());
        String path = FreeMarkerUtil.geneFile("header","template","java",dataMap);
        String str = FileUtils.readFileToString(new File(path));
        FileUtils.forceDelete(new File(path));
        return str;

    }

    public  String createMethod(Result result) throws Exception {
        String path = "";
        Map<String,Object> dataMap = new HashMap<>();
        dataMap.put("method",result.getMethodName());
        dataMap.put("url",result.getUrl());
        dataMap.put("type",result.getContentType());
        if (StringUtils.isNotEmpty(result.getJsonStr()) &&  (result.getContentType()!= null && "application/json".equals(result.getContentType()) )){

            dataMap.put("json",result.getJsonStr().replace("\"","\\\""));
            path = FreeMarkerUtil.geneFile("methodPost","template","java",dataMap);
        } else {
            path = FreeMarkerUtil.geneFile("method","template","java",dataMap);
        }

        String str = FileUtils.readFileToString(new File(path));
        FileUtils.forceDelete(new File(path));
        return str;

    }
}
