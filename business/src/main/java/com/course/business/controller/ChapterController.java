package com.course.business.controller;

import com.course.server.pojo.Chapter;
import com.course.server.service.ChapterService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author zhuzhaoman
 * @date 2020/6/26 0026 20:32
 * @description 描述
 */
@RestController
public class ChapterController {

    @Resource
    private ChapterService chapterService;

    @RequestMapping("/list")
    public List<Chapter> list() {
        return chapterService.list();
    }
}
