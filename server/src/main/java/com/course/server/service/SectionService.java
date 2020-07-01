package com.course.server.service;

import com.course.server.dto.PageDto;
import com.course.server.dto.SectionDto;
import com.course.server.mapper.SectionMapper;
import com.course.server.pojo.Section;
import com.course.server.utils.CopyUtil;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import javax.annotation.Resource;
import java.util.List;
import java.util.UUID;

/**
 * @author zhuzhaoman
 * @date 2020/6/24 0024 13:16
 * @description 大章业务层
 */

@Service
public class SectionService {

    @Resource
    private SectionMapper sectionMapper;

    /**
     * 分页查询大章列表
     * @param pageDto
     */
    public void list(PageDto pageDto) {
        PageHelper.startPage(pageDto.getPage(), pageDto.getSize());
        List<Section> sectionList = sectionMapper.selectByExample(null);

        // 设置DTO信息
        PageInfo<Section> pageInfo = new PageInfo<>(sectionList);
        pageDto.setTotal(pageInfo.getTotal());

        List<SectionDto> sectionDtoList = CopyUtil.copyList(sectionList, SectionDto.class);

        // 设置DTO信息
        pageDto.setList(sectionDtoList);
    }

    /**
     * 保存大章
     * @param sectionDto
     * @return
     */
    public boolean save(SectionDto sectionDto) {

        Section section = CopyUtil.copy(sectionDto, Section.class);

        /**
         * 判断id是否为空
         */
        if (StringUtils.isEmpty(sectionDto.getId())) {
            return this.insert(section); // 添加
        } else {
            return this.update(section); // 修改
        }
    }

    /**
     * 添加大章
     * @param section
     * @return
     */
    private boolean insert(Section section) {

        String id = UUID.randomUUID().toString().replaceAll("-", "");
        section.setId(id);

        int status = sectionMapper.insert(section);

        return status > 0 ? true : false;
    }

    /**
     * 修改大章
     * @param section
     * @return
     */
    private boolean update(Section section) {

        int status = sectionMapper.updateByPrimaryKey(section);

        return status > 0 ? true : false;
    }

    /**
     * 删除大章
     * @param id
     * @return
     */
    public boolean delete(String id) {
        int status = sectionMapper.deleteByPrimaryKey(id);
        return status > 0 ? true : false;
    }
}
