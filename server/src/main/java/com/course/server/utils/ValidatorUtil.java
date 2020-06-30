package com.course.server.utils;

import com.course.server.exception.ValidatorException;
import org.springframework.util.StringUtils;

/**
 * @author zhuzhaoman
 * @date 2020/6/30 0030 23:04
 * @description 描述
 */
public class ValidatorUtil {

    /**
     * 控制校验（null or "")
     * @param str
     * @param fieldName
     */
    public static void require(String str, String fieldName) {
        if (StringUtils.isEmpty(str)) {
            throw new ValidatorException(fieldName + "不能为空");
        }
    }

    /**
     * 长度校验
     * @param str
     * @param fieldName
     * @param min
     * @param max
     */
    public static void length(String str, String fieldName, Integer min, Integer max) {
        Integer length = 0;
        if (!StringUtils.isEmpty(str)) {
            length = str.length();
        }
        if (length < min || length > max) {
            throw new ValidatorException(fieldName + "长度" + min + "~" + max + "位");
        }
    }
}
