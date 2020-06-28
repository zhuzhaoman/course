package com.course.server.dto;

import java.util.List;

/**
 * @author zhuzhaoman
 * @date 2020/6/28 0028 13:46
 * @description 通用分页DTO
 */
public class PageDto<T> {

    // 当前页码
    protected Integer page = 0;

    // 每页条数
    protected Integer size = 0;

    // 总条数
    protected Long total;

    protected List<T> list;

    public Integer getPage() {
        return page;
    }

    public void setPage(Integer page) {
        this.page = page;
    }

    public Integer getSize() {
        return size;
    }

    public void setSize(Integer size) {
        this.size = size;
    }

    public Long getTotal() {
        return total;
    }

    public void setTotal(Long total) {
        this.total = total;
    }

    public List<T> getList() {
        return list;
    }

    public void setList(List<T> list) {
        this.list = list;
    }
}
