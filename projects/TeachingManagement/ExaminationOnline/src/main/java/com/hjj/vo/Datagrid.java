package com.hjj.vo;

import java.util.List;

/**
 * Created by 朱高 on 2017/3/22.
 */
public class Datagrid {
    private List list;
    private int page;
    private int rows;
    private String sort;
    private String order;

    public List getList() {
        return list;
    }

    public void setList(List list) {
        this.list = list;
    }

    public int getPage() {
        return page;
    }

    public void setPage(int page) {
        this.page = page;
    }

    public int getRows() {
        return rows;
    }

    public void setRows(int rows) {
        this.rows = rows;
    }

    public String getSort() {
        return sort;
    }

    public void setSort(String sort) {
        this.sort = sort;
    }

    public String getOrder() {
        return order;
    }

    public void setOrder(String order) {
        this.order = order;
    }

    @Override
    public String toString() {
        return "Datagrid{" +
                "list=" + list +
                ", page=" + page +
                ", rows=" + rows +
                ", sort='" + sort + '\'' +
                ", order='" + order + '\'' +
                '}';
    }
}
