package com.ruicai.education.util;

import java.util.List;

/**
 * Created by wy on 2017/4/13.
 */
public class PageBean<T> {
    private Integer page;//页码
    private Integer rows;//每页显示多少条数据
    private Integer total;//总共多少条数据
    private List<T> list;//数据列表

    public List<T> getList() {
        return list;
    }

    public void setList(List<T> list) {
        this.list = list;
    }

    public Integer getPage() {
        return page;
    }

    public void setPage(Integer page) {
        this.page = page;
    }

    public Integer getRows() {
        return rows;
    }

    public void setRows(Integer rows) {
        this.rows = rows;
    }

    public Integer getTotal() {
        return total;
    }

    public void setTotal(Integer total) {
        this.total = total;
    }
}
