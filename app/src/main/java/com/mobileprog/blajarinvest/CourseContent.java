package com.mobileprog.blajarinvest;

public class CourseContent {

    private long id;
    private long courseId;
    private String text;
    private int page;

    public CourseContent(long id, long courseId, String text, int page) {
        this.id = id;
        this.courseId = courseId;
        this.text = text;
        this.page = page;
    }

    public CourseContent(long courseId, String text, int page) {
        this.courseId = courseId;
        this.text = text;
        this.page = page;
    }

    public CourseContent() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getCourseId() {
        return courseId;
    }

    public void setCourseId(long courseId) {
        this.courseId = courseId;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public int getPage() {
        return page;
    }

    public void setPage(int page) {
        this.page = page;
    }
}
