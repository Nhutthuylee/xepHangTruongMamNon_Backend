package com.example.xepHangTruongMamNon.Model.resp;

public class CustomerCreateCommentResponse {
    private int id;
    private int userId;
    private int schoolId;
    private String content;

    public CustomerCreateCommentResponse(int id, int userId, int schoolId, String content) {
        this.id = id;
        this.userId = userId;
        this.schoolId = schoolId;
        this.content = content;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getSchoolId() {
        return schoolId;
    }

    public void setSchoolId(int schoolId) {
        this.schoolId = schoolId;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
