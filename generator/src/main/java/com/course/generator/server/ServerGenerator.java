package com.course.generator.server;

import com.course.generator.utils.DbUtil;
import com.course.generator.utils.Field;
import com.course.generator.utils.FreemarkerUtil;
import freemarker.template.TemplateException;
import java.io.IOException;
import java.util.*;

/**
 * @author zhuzhaoman
 * @date 2020/7/1 0001 13:13
 * @description 描述
 */
public class ServerGenerator {

    static String MODULE = "business";
    static String toServicePath = "server/src/main/java/com/course/server/service/";
    static String toDtoPath = "server/src/main/java/com/course/server/dto/";
    static String toControllerPath = MODULE + "/src/main/java/com/course/" + MODULE + "/controller/admin/";

    public static void main(String[] args) throws Exception {
        String Pojo = "Section";
        String pojo = "section";
        String tableNameCn = "小节";
        String module = MODULE;
        List<Field> fieldList = DbUtil.getColumnByTableName(pojo);
        Set<String> typeSet = getJavaType(fieldList);
        Map<String, Object> map = new HashMap<>();
        map.put("Pojo", Pojo);
        map.put("pojo", pojo);
        map.put("tableNameCn", tableNameCn);
        map.put("module", module);
        map.put("fieldList", fieldList);
        map.put("typeSet", typeSet);

        // 生成dto
         FreemarkerUtil.initConfig("dto.ftl");
         FreemarkerUtil.generator(toDtoPath + Pojo + "Dto.java", map);

        // 生成service
        // FreemarkerUtil.initConfig("service.ftl");
        // FreemarkerUtil.generator(toServicePath + Pojo + "Service.java", map);

        // 生成controller
        // FreemarkerUtil.initConfig("controller.ftl");
        // FreemarkerUtil.generator(toControllerPath + Pojo + "Controller.java", map);
    }

    private static Set<String> getJavaType(List<Field> fieldList) {
        Set<String> set = new HashSet<>();
        for (int i = 0; i < fieldList.size(); i++) {
            Field field = fieldList.get(i);
            set.add(field.getJavaType());
        }

        return set;
    }
}
