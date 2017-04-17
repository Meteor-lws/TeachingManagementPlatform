package com.ruicai.examination.vo.examination;

import java.util.List;

/**
 * Created by 朱高 on 2017/4/11.
 */
public class ManagementDatagrid {
    List<Management> list;
    private Management management;
    private long total;
    private int page;
    private int rows;
    private String sort;
    private String order;

    public long getTotal() {
        return total;
    }

    public void setTotal(long total) {
        this.total = total;
    }

    public List<Management> getList() {
        return list;
    }

    public void setList(List<Management> list) {
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

    public Management getManagement() {
        return management;
    }

    @Override
    public String toString() {
        return "ManagementDatagrid{" +
                "list=" + list +
                ", management=" + management +
                ", total=" + total +
                ", page=" + page +
                ", rows=" + rows +
                ", sort='" + sort + '\'' +
                ", order='" + order + '\'' +
                '}';
    }

    public void setManagement(Management management) {
        this.management = management;
    }

}
