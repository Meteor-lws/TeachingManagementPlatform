package com.ruicai.examination.po.examination;

public class ExaminationPaper {
    private String id;

    /**
     * 考试阶段
     * 外键：指向数据字典的ID
     */
    private String paperStage;

    /**
     * 试卷科目
     * 外键：指向数据字典ID
     */
    private String paperSubject;

    /**
     * 试卷状态
     * 外键：指向数据字典ID
     */
    private String paperStatus;

    /**
     * 出题人
     * 外键:指向老师ID
     */
    private String paperAuthor;

    /**
     * 试卷标题
     */
    private String paperTitle;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    public String getPaperStage() {
        return paperStage;
    }

    public void setPaperStage(String paperStage) {
        this.paperStage = paperStage == null ? null : paperStage.trim();
    }

    public String getPaperSubject() {
        return paperSubject;
    }

    public void setPaperSubject(String paperSubject) {
        this.paperSubject = paperSubject == null ? null : paperSubject.trim();
    }

    public String getPaperStatus() {
        return paperStatus;
    }

    public void setPaperStatus(String paperStatus) {
        this.paperStatus = paperStatus == null ? null : paperStatus.trim();
    }

    public String getPaperAuthor() {
        return paperAuthor;
    }

    public void setPaperAuthor(String paperAuthor) {
        this.paperAuthor = paperAuthor == null ? null : paperAuthor.trim();
    }

    public String getPaperTitle() {
        return paperTitle;
    }

    public void setPaperTitle(String paperTitle) {
        this.paperTitle = paperTitle == null ? null : paperTitle.trim();
    }
}