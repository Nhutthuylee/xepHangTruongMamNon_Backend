package com.example.xepHangTruongMamNon.Model.resp;

public class CustomerGetCustomerInfoById {
    private int id;
    private String name;
    private String address;
    private String email;
    private String avatar;

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

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public CustomerGetCustomerInfoById(int id, String name, String address, String email, String avatar) {
        this.id = id;
        this.name = name;
        this.address = address;
        this.email = email;
        this.avatar = avatar;
    }
}
