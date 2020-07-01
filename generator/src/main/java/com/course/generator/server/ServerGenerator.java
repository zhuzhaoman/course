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
    static String toControllerPath = "business/src/main/java/com/course/business/controller/admin/";

    public static void main(String[] args) throws IOException, TemplateException {
        String Pojo = "Section";
        String pojo = "section";
        Map<String, Object> map = new HashMap<>();
        map.put("Pojo", Pojo);
        map.put("pojo", pojo);

        // 生成service
        // FreemarkerUtil.initConfig("service.ftl");
        // FreemarkerUtil.generator(toServicePath + Pojo + "Service.java", map);

        // 生成controller
        FreemarkerUtil.initConfig("controller.ftl");
        FreemarkerUtil.generator(toControllerPath + Pojo + "Controller.java", map);
    }
}
