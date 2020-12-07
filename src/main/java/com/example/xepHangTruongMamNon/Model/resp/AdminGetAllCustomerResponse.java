package com.example.xepHangTruongMamNon.Model.resp;

public class AdminGetAllCustomerResponse {
    private int id;
    private String name;
    private String email;
    private String address;
    private String avatar;
    private String role;

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

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public AdminGetAllCustomerResponse(int id, String name, String email, String address, String avatar, String role) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.address = address;
        this.avatar = avatar;
        this.role = role;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }
}
