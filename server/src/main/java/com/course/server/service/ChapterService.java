package com.course.server.service;

import com.course.server.dto.ChapterDto;
import com.course.server.dto.PageDto;
import com.course.server.mapper.ChapterMapper;
import com.course.server.pojo.Chapter;
import com.course.server.utils.CopyUtil;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

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

        List<ChapterDto> chapterDtoList = CopyUtil.copyList(chapterList, ChapterDto.class);

        // 设置DTO信息
        pageDto.setList(chapterDtoList);
    }

    /**
     * 保存大章
     * @param chapterDto
     * @return
     */
    public boolean save(ChapterDto chapterDto) {

        Chapter chapter = CopyUtil.copy(chapterDto, Chapter.class);

        /**
         * 判断id是否为空
         */
        if (StringUtils.isEmpty(chapterDto.getId())) {
            return this.insert(chapter); // 添加
        } else {
            return this.update(chapter); // 修改
        }
    }

    /**
     * 添加大章
     * @param chapter
     * @return
     */
    private boolean insert(Chapter chapter) {

        String id = UUID.randomUUID().toString().replaceAll("-", "");
        chapter.setId(id);

        int status = chapterMapper.insert(chapter);

        return status > 0 ? true : false;
    }

    /**
     * 修改大章
     * @param chapter
     * @return
     */
    private boolean update(Chapter chapter) {

        int status = chapterMapper.updateByPrimaryKey(chapter);

        return status > 0 ? true : false;
    }

    /**
     * 删除大章
     * @param id
     * @return
     */
    public boolean delete(String id) {
        int status = chapterMapper.deleteByPrimaryKey(id);
        return status > 0 ? true : false;
    }
}
