package com.ruicai.system.vo;

import java.util.ArrayList;
import java.util.List;

/**
 * Datagrid实体类
 *
 * Created by lws on 2017/4/11.
 */
public class Datagrid<T> {
    private long total;
    private List<T> rows = new ArrayList<>();

    public long getTotal() {
        return total;
    }

    public void setTotal(long total) {
        this.total = total;
    }

    public List<T> getRows() {
        return rows;
    }

    public void setRows(List<T> rows) {
        this.rows = rows;
    }

    @Override
    public String toString() {
        return "Datagrid{" +
                "total=" + total +
                ", rows=" + rows +
                '}';
    }
}
