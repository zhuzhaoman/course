package com.course.system.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author zhuzhaoman
 * @date 2020/6/23 0023 23:21
 * @description 测试Controller
 */

@RestController
public class TestController {

    @GetMapping("/test")
    public String test() {
        return "success";
    }
}
