package com.goodlife.simple.test;

import com.goodlife.freemarker.FreeMarkerUtil;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * @Auther: zcx
 * @Date: 2019/11/12 09:26
 * @Description:
 */
public class Test {

    public static void freemarkerTests ()throws IOException {

        Map<String,Object> dataMap=new HashMap<String,Object>();
        dataMap.put("type", 2);
        dataMap.put("list", new ArrayList<>());
        dataMap.put("size", 0);
        String result = FreeMarkerUtil.geneFile("feedback", "template", "xls", dataMap);
        System.out.println(result);

    }

    public static void main(String[] args) throws Exception{
        freemarkerTests();
    }
}
