package com.course.server.service;

import com.course.server.mapper.TestMapper;
import com.course.server.pojo.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author zhuzhaoman
 * @date 2020/6/24 0024 13:16
 * @description 描述
 */

@Service
public class TestService {

    @Autowired
    private TestMapper testMapper;

    public List<Test> list() {
        return testMapper.list();
    }
}
