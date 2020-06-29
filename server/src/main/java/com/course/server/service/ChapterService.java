package com.course.server.service;

import com.course.server.dto.ChapterDto;
import com.course.server.dto.PageDto;
import com.course.server.mapper.ChapterMapper;
import com.course.server.pojo.Chapter;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

/**
 * @author zhuzhaoman
 * @date 2020/6/24 0024 13:16
 * @description 大章业务层
 */

@Service
public class ChapterService {

    @Resource
    private ChapterMapper chapterMapper;

    /**
     * 分页查询大章列表
     * @param pageDto
     */
    public void list(PageDto pageDto) {
        PageHelper.startPage(pageDto.getPage(), pageDto.getSize());
        List<Chapter> chapterList = chapterMapper.selectByExample(null);

        // 设置DTO信息
        PageInfo<Chapter> pageInfo = new PageInfo<>(chapterList);
        pageDto.setTotal(pageInfo.getTotal());

        List<ChapterDto> chapterDtoList = new ArrayList<>();
        for (Chapter chapter: chapterList){
            ChapterDto chapterDto = new ChapterDto();
            BeanUtils.copyProperties(chapter, chapterDto);
            chapterDtoList.add(chapterDto);
        }

        // 设置DTO信息
        pageDto.setList(chapterDtoList);
    }

    /**
     * 添加大章
     * @param chapterDto
     */
    public boolean save(ChapterDto chapterDto) {
        String id = UUID.randomUUID().toString().replaceAll("-", "");

        Chapter chapter = new Chapter();
        BeanUtils.copyProperties(chapterDto, chapter);
        chapter.setId(id);

        int status = chapterMapper.insert(chapter);

        return status > 0 ? true : false;
    }
}
