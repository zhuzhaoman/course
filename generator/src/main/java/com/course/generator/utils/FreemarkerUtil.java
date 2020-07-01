package com.course.generator.utils;

import freemarker.template.Configuration;
import freemarker.template.DefaultObjectWrapper;
import freemarker.template.Template;
import freemarker.template.TemplateException;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Map;

/**
 * @author zhuzhaoman
 * @date 2020/7/1 0001 13:06
 * @description 描述
 */
public class FreemarkerUtil {

    static String ftlPath = "generator/src/main/java/com/course/generator/ftl/";
    static Template temp;

    /**
     * 读模板
     * @param ftlName
     * @throws IOException
     */
    public static void initConfig(String ftlName) throws IOException {

        Configuration cfg = new Configuration(Configuration.VERSION_2_3_30);
        cfg.setDirectoryForTemplateLoading(new File(ftlPath));
        cfg.setObjectWrapper(new DefaultObjectWrapper(Configuration.VERSION_2_3_30));
        temp = cfg.getTemplate(ftlName);
    }

    /**
     * 生成模板
     */
    public static void generator(String toPath, Map<String, Object> map) throws IOException, TemplateException {
        FileWriter fw = new FileWriter(toPath);
        BufferedWriter bw = new BufferedWriter(fw);
        temp.process(map, bw);
        bw.flush();
        fw.close();
    }


}
