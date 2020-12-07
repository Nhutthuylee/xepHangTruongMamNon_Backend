package com.example.xepHangTruongMamNon.Model.resp;

public class AdminGetCustomerByEmailResponse {
    private String name;
    private String email;
    private String address;
    private String avatar;
    private Boolean deleted;

    public AdminGetCustomerByEmailResponse(String name, String email, String address, String avatar, Boolean deleted) {
        this.name = name;
        this.email = email;
        this.address = address;
        this.avatar = avatar;
        this.deleted = deleted;
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

    public Boolean getDeleted() {
        return deleted;
    }

    public void setDeleted(Boolean deleted) {
        this.deleted = deleted;
    }

}
