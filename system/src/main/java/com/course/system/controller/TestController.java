package com.course.system.controller;

import com.course.server.pojo.Test;
import com.course.server.service.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author zhuzhaoman
 * @date 2020/6/23 0023 23:21
 * @description 测试Controller
 */

@RestController
public class TestController {

    @Resource
    private TestService testService;

    @GetMapping("/test")
    public List<Test> test() {
        return testService.list();
    }
}
