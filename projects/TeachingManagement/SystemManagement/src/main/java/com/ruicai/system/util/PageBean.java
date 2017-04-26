package com.ruicai.system.util;

import java.util.List;

/**
 * Created by wy on 2017/4/13.
 */
public class PageBean<T> {
    private Integer page;//页码
    private Integer rowNums;//每页显示多少条数据
    private Integer total;//总共多少条数据
    private List<T> rows;//数据列表

    public Integer getPage() {
        return page;
    }

    public void setPage(Integer page) {
        this.page = page;
    }

    public Integer getRowNums() {
        return rowNums;
    }

    public void setRowNums(Integer rowNums) {
        this.rowNums = rowNums;
    }

    public Integer getTotal() {
        return total;
    }

    public void setTotal(Integer total) {
        this.total = total;
    }

    public List<T> getRows() {
        return rows;
    }

    public void setRows(List<T> rows) {
        this.rows = rows;
    }
}