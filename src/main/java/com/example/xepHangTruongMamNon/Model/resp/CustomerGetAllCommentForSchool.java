package com.example.xepHangTruongMamNon.Model.resp;

public class CustomerGetAllCommentForSchool {
    private int userId;
    private String username;
    private String avatar;
    private String content;

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public CustomerGetAllCommentForSchool(int userId, String username, String avatar, String content) {
        this.userId = userId;
        this.username = username;
        this.avatar = avatar;
        this.content = content;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

}
