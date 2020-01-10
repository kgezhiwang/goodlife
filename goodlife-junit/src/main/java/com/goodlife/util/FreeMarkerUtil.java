package com.goodlife.util;

import freemarker.template.Configuration;
import freemarker.template.Template;
import lombok.extern.slf4j.Slf4j;

import java.io.File;
import java.io.FileWriter;
import java.io.Writer;
import java.util.Map;
import java.util.Random;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Slf4j
public class FreeMarkerUtil {


    /**
     * 默认模板在/src/main/resources/ 目录下
     * 默认生成的新文件在/target/static 目录下
     * fltFile flt文件名 , templatePath flt文件路径 ,fileNameOrSuffix 后缀名(前缀随机)/全名称 , datas 数据集合
     *
     * @param fltFile
     * @param templatePath
     * @param fileNameOrSuffix
     * @param datas
     * @return 生成文件路径
     */
    public static String geneFile(String fltFile, String templatePath, String fileNameOrSuffix, Map<String, Object> datas) {
        return geneFile(fltFile,templatePath,"/target/static",fileNameOrSuffix, datas);
    }

    /**
     * 默认模板在/src/main/resources/ 目录下
     * 默认生成的新文件在/target/static 目录下
     * fltFile flt文件名 , templatePath flt文件路径 ,fileNameOrSuffix 后缀名(前缀随机)/全名称 , datas 数据集合
     *
     * @param fltFile
     * @param templatePath
     * @param fileNameOrSuffix
     * @param datas
     * @return 生成文件路径
     */
    public static String geneFile(String fltFile, String templatePath,String packageName, String fileNameOrSuffix, Map<String, Object> datas) {

        Configuration configuration = new Configuration();
        String result = null;
        try {
            String resourcePath = "E:\\changcheng\\gwm-app-store-service\\src\\main\\resources\\template";
            configuration.setDirectoryForTemplateLoading(new File(resourcePath));
            Template temp = configuration.getTemplate(fltFile + ".ftl");

            StringBuffer pathBuffer = new StringBuffer(resourcePath);

            //create file home
            File fileIsExists = new File(pathBuffer.append("/target").append("/static/").toString());
            if (!fileIsExists.exists()) {
                fileIsExists.mkdirs();
            }

            //检查元素
            int count = 0;
            Pattern element = Pattern.compile("\\.");
            Matcher subject = element.matcher(fileNameOrSuffix);
            while (subject.find()) {
                count++;
            }

            Random rand = new Random();
            if (count < 1)//断言名称类型
                pathBuffer.append(rand.nextInt(10)).append(".").append(fileNameOrSuffix);//避免文件过多
            else
                pathBuffer.append(fileNameOrSuffix);

            String path = pathBuffer.toString();
            result = path;
            log.info("CREATE NEW FILE PATH : {}", path);

            Writer file = new FileWriter(new File(result));

            temp.process(datas, file);
            file.flush();
            file.close();
        } catch (Exception e) {
            log.error(e.getMessage(),e);
        }
        return result;
    }
}