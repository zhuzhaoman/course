package com.course.business.controller.admin;

import com.course.server.dto.ChapterDto;
import com.course.server.dto.PageDto;
import com.course.server.service.ChapterService;
import com.course.server.utils.JSONResult;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.*;

/**
 * @author zhuzhaoman
 * @date 2020/6/26 0026 20:32
 * @description 描述
 */
@RestController
@RequestMapping("/admin/chapter")
public class ChapterController {

    @Resource
    private ChapterService chapterService;

    @PostMapping("/list")
    public JSONResult list(@RequestBody PageDto pageDto) {
        chapterService.list(pageDto);
        return JSONResult.ok(pageDto);
    }

    @PostMapping("/save")
    public JSONResult save(@RequestBody ChapterDto chapterDto) {
        boolean status = chapterService.save(chapterDto);

        return status ? JSONResult.ok("保存成功！") : JSONResult.errorMsg("保存失败！");
    }

    @DeleteMapping("/delete/{id}")
    public JSONResult delete(@PathVariable String id) {
        boolean status = chapterService.delete(id);

        return status ? JSONResult.ok("删除成功！") : JSONResult.errorMsg("删除失败！");
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
