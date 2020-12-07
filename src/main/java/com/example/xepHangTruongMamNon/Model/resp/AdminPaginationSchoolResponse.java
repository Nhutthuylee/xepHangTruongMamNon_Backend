package com.example.xepHangTruongMamNon.Model.resp;

public class AdminPaginationSchoolResponse {
    private int id;
    private String schoolName;
    private String address;
    private String phoneNumber;
    private String tuition;
    private String schoolType;
    private String ward;
    private String image;

    public AdminPaginationSchoolResponse(int id, String schoolName, String address, String phoneNumber, String tuition,
            String schoolType, String ward, String image) {
        this.id = id;
        this.schoolName = schoolName;
        this.address = address;
        this.phoneNumber = phoneNumber;
        this.tuition = tuition;
        this.schoolType = schoolType;
        this.ward = ward;
        this.image = image;
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

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getTuition() {
        return tuition;
    }

    public void setTuition(String tuition) {
        this.tuition = tuition;
    }

    public String getSchoolType() {
        return schoolType;
    }

    public void setSchoolType(String schoolType) {
        this.schoolType = schoolType;
    }

    public String getWard() {
        return ward;
    }

    public void setWard(String ward) {
        this.ward = ward;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

}
