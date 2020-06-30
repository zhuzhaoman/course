package com.course.business.handler;

import com.course.server.utils.JSONResult;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import com.course.server.exception.ValidatorException;

/**
 * @author zhuzhaoman
 * @date 2020/6/30 0030 23:22
 * @description 描述
 */
@ControllerAdvice
public class ControllerExceptionHandler {

    private static final Logger LOGGER = LoggerFactory.getLogger(ControllerExceptionHandler.class);

    @ExceptionHandler(value = ValidatorException.class)
    @ResponseBody
    public JSONResult validatorExceptionHandler(ValidatorException e) {
        LOGGER.warn(e.getMessage());
        return JSONResult.errorMsg(e.getMessage());
    }
}
