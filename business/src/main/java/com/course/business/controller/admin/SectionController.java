package com.course.business.controller.admin;

import com.course.server.aspect.LogAspect;
import com.course.server.dto.SectionDto;
import com.course.server.dto.PageDto;
import com.course.server.service.SectionService;
import com.course.server.utils.JSONResult;
import com.course.server.utils.ValidatorUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.*;

/**
 * @author zhuzhaoman
 * @date 2020/6/26 0026 20:32
 * @description 描述
 */
@RestController
@RequestMapping("/admin/section")
public class SectionController {

    private static final Logger LOGGER = LoggerFactory.getLogger(LogAspect.class);
    public static final String BUSINESS_NAME = "小节";

    @Resource
    private SectionService sectionService;

    @PostMapping("/list")
    public JSONResult list(@RequestBody PageDto pageDto) {
        sectionService.list(pageDto);
        return JSONResult.ok(pageDto);
    }

    @PostMapping("/save")
    public JSONResult save(@RequestBody SectionDto sectionDto) {

        // 参数校验
        //ValidatorUtil.require(sectionDto.getName(), "名称");
        ValidatorUtil.require(sectionDto.getCourseId(), "课程ID");
        ValidatorUtil.length(sectionDto.getCourseId(), "课程ID", 1, 8);

        boolean status = sectionService.save(sectionDto);

        return status ? JSONResult.ok("保存成功！") : JSONResult.errorMsg("保存失败！");
    }

    @DeleteMapping("/delete/{id}")
    public JSONResult delete(@PathVariable String id) {
        boolean status = sectionService.delete(id);

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
