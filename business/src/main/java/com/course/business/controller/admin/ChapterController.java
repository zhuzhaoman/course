package com.course.business.controller.admin;

import com.course.server.dto.ChapterDto;
import com.course.server.service.ChapterService;
import com.course.server.utils.JSONResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.*;

/**
 * @author zhuzhaoman
 * @date 2020/6/26 0026 20:32
 * @description 描述
 */
@RestController
@RequestMapping("/admin")
public class ChapterController {

    @Resource
    private ChapterService chapterService;

    @RequestMapping("/list")
    public JSONResult list() {
        List<ChapterDto> chapterDtoList = chapterService.list();
        return JSONResult.ok(chapterDtoList);
    }

    @PostMapping("/login")
    public JSONResult login() {
        Map<String, String> map = new HashMap();
        map.put("token", "admin-token");
        return JSONResult.ok(map);
    }

    @GetMapping("/info")
    public JSONResult info() {
        Map<String, Object> map = new HashMap<>();
        map.put("roles", Arrays.asList("admin"));
        map.put("introduction", "I am a super administrator");
        map.put("avatar", "https://wpimg.wallstcn.com/f778738c-e4f8-4870-b634-56703b4acafe.gif");
        map.put("name", "Super Admin");
        return JSONResult.ok(map);
    }
}
