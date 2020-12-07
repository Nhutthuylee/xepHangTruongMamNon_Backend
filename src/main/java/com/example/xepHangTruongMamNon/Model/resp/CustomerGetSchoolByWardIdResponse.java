package com.example.xepHangTruongMamNon.Model.resp;

public class CustomerGetSchoolByWardIdResponse {
    private int schoolId;
    private String schoolName;
    private String address;
    private String image;
    private String phoneNumber;
    private String tuition;
    private String ward;

    public CustomerGetSchoolByWardIdResponse(int id, String schoolName, String address, String image,
            String phoneNumber, String tuition, String ward) {
        this.schoolId = id;
        this.schoolName = schoolName;
        this.address = address;
        this.image = image;
        this.phoneNumber = phoneNumber;
        this.tuition = tuition;
        this.ward = ward;
    }

    public int getSchoolId() {
        return schoolId;
    }

    public void setSchoolId(int id) {
        this.schoolId = id;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
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

    public String getWard() {
        return ward;
    }

    public void setWard(String ward) {
        this.ward = ward;
    }

    public String getSchoolName() {
        return schoolName;
    }

    public void setSchoolName(String schoolName) {
        this.schoolName = schoolName;
    }
}
