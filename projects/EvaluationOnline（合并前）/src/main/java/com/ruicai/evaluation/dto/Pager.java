package com.ruicai.evaluation.dto;

/**
 * 分页传输类
 * <p>
 * Created by lws on 2017/3/27.
 */
public class Pager {
    private int page;
    private int rows;

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

    @Override
    public String toString() {
        return "Pager{" +
                "page=" + page +
                ", rows=" + rows +
                '}';
    }
}
