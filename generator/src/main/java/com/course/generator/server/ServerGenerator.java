package com.course.generator.server;

import com.course.generator.utils.FreemarkerUtil;
import freemarker.template.TemplateException;

import java.io.IOException;

/**
 * @author zhuzhaoman
 * @date 2020/7/1 0001 13:13
 * @description 描述
 */
public class ServerGenerator {

    static String toPath = "generator/src/main/java/com/course/generator/test/";

    public static void main(String[] args) throws IOException, TemplateException {
        FreemarkerUtil.initConfig("test.ftl");
        FreemarkerUtil.generator(toPath + "Test.java");
    }
}
