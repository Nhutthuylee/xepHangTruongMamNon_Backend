package com.example.xepHangTruongMamNon.Model.resp;

public class AdminGetAllCommentBySchoolResponse {
    private int id;
    private String username;
    private String content;

    public AdminGetAllCommentBySchoolResponse(int id, String username, String content) {
        this.id = id;
        this.username = username;
        this.content = content;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
