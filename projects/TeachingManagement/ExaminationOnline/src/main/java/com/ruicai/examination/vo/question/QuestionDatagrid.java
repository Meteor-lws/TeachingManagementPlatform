package com.ruicai.examination.vo.question;

import java.util.List;

/**
 *
 * Created by 朱高 on 2017/4/18.
 */
public class QuestionDatagrid {
    private long total;
    private List<Question> rows;

    public long getTotal() {
        return this.total;
    }

    public void setTotal(long total) {
        this.total = total;
    }

    public List<Question> getRows() {
        return rows;
    }

    public void setRows(List<Question> rows) {
        this.rows = rows;
    }
}
