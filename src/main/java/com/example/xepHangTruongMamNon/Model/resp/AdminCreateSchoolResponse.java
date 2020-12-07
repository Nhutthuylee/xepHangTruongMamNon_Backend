package com.example.xepHangTruongMamNon.Model.resp;

public class AdminCreateSchoolResponse {
    private int id;
    private String schoolName;
    private String image_url;
    private String phoneNumber;
    private String address;
    private String ward;
    private String schoolType;

    public AdminCreateSchoolResponse(int id, String schoolName, String image_url, String phoneNumber, String address,
            String ward, String schoolType) {
        this.id = id;
        this.schoolName = schoolName;
        this.image_url = image_url;
        this.phoneNumber = phoneNumber;
        this.address = address;
        this.ward = ward;
        this.schoolType = schoolType;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getSchoolName() {
        return schoolName;
    }

    public void setSchoolName(String schoolName) {
        this.schoolName = schoolName;
    }

    public String getImage_url() {
        return image_url;
    }

    public void setImage_url(String image_url) {
        this.image_url = image_url;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getWard() {
        return ward;
    }

    public void setWard(String ward) {
        this.ward = ward;
    }

    public String getSchoolType() {
        return schoolType;
    }

    public void setSchoolType(String schoolType) {
        this.schoolType = schoolType;
    }

}
