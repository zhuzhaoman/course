package com.course.server.service;

import com.course.server.dto.${Pojo}Dto;
import com.course.server.dto.PageDto;
import com.course.server.mapper.${Pojo}Mapper;
import com.course.server.pojo.${Pojo};
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
public class ${Pojo}Service {

    @Resource
    private ${Pojo}Mapper ${pojo}Mapper;

    /**
     * 分页查询大章列表
     * @param pageDto
     */
    public void list(PageDto pageDto) {
        PageHelper.startPage(pageDto.getPage(), pageDto.getSize());
        List<${Pojo}> ${pojo}List = ${pojo}Mapper.selectByExample(null);

        // 设置DTO信息
        PageInfo<${Pojo}> pageInfo = new PageInfo<>(${pojo}List);
        pageDto.setTotal(pageInfo.getTotal());

        List<${Pojo}Dto> ${pojo}DtoList = CopyUtil.copyList(${pojo}List, ${Pojo}Dto.class);

        // 设置DTO信息
        pageDto.setList(${pojo}DtoList);
    }

    /**
     * 保存大章
     * @param ${pojo}Dto
     * @return
     */
    public boolean save(${Pojo}Dto ${pojo}Dto) {

        ${Pojo} ${pojo} = CopyUtil.copy(${pojo}Dto, ${Pojo}.class);

        /**
         * 判断id是否为空
         */
        if (StringUtils.isEmpty(${pojo}Dto.getId())) {
            return this.insert(${pojo}); // 添加
        } else {
            return this.update(${pojo}); // 修改
        }
    }

    /**
     * 添加大章
     * @param ${pojo}
     * @return
     */
    private boolean insert(${Pojo} ${pojo}) {

        String id = UUID.randomUUID().toString().replaceAll("-", "");
        ${pojo}.setId(id);

        int status = ${pojo}Mapper.insert(${pojo});

        return status > 0 ? true : false;
    }

    /**
     * 修改大章
     * @param ${pojo}
     * @return
     */
    private boolean update(${Pojo} ${pojo}) {

        int status = ${pojo}Mapper.updateByPrimaryKey(${pojo});

        return status > 0 ? true : false;
    }

    /**
     * 删除大章
     * @param id
     * @return
     */
    public boolean delete(String id) {
        int status = ${pojo}Mapper.deleteByPrimaryKey(id);
        return status > 0 ? true : false;
    }
}
