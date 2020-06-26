package com.course.server.service;

import com.course.server.mapper.ChapterMapper;
import com.course.server.mapper.TestMapper;
import com.course.server.pojo.Chapter;
import com.course.server.pojo.ChapterExample;
import com.course.server.pojo.Test;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author zhuzhaoman
 * @date 2020/6/24 0024 13:16
 * @description 大章业务层
 */

@Service
public class ChapterService {

    @Resource
    private ChapterMapper chapterMapper;

    public List<Chapter> list() {
        return chapterMapper.selectByExample(null);
    }
}
