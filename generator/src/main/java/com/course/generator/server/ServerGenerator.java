package com.course.generator.server;

import com.course.generator.utils.FreemarkerUtil;
import freemarker.template.TemplateException;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * @author zhuzhaoman
 * @date 2020/7/1 0001 13:13
 * @description 描述
 */
public class ServerGenerator {

    static String toServicePath = "server/src/main/java/com/course/server/service/";

    public static void main(String[] args) throws IOException, TemplateException {
        String Pojo = "Section";
        String pojo = "section";
        Map<String, Object> map = new HashMap<>();
        map.put("Pojo", Pojo);
        map.put("pojo", pojo);

        FreemarkerUtil.initConfig("service.ftl");
        FreemarkerUtil.generator(toServicePath + Pojo + "Service.java", map);
    }
}
