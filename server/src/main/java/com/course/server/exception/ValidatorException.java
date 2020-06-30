package com.course.server.exception;

/**
 * @author zhuzhaoman
 * @date 2020/6/30 0030 23:11
 * @description 自定义参数校验异常类
 */
public class ValidatorException extends RuntimeException {
    public ValidatorException(String message) {
        super(message);
    }
}
