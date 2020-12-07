package com.example.xepHangTruongMamNon.Model.resp;

public class AdminCreateUserResponse {
    private int id;
    private String name;
    private String email;
    private String password;
    private String avatarURL;
    private String roleName;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getAvatarURL() {
        return avatarURL;
    }

    public void setAvatarURL(String avatarURL) {
        this.avatarURL = avatarURL;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    public AdminCreateUserResponse(int id, String name, String email, String password, String avatarURL,
            String roleName) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.password = password;
        this.avatarURL = avatarURL;
        this.roleName = roleName;
    }
}
