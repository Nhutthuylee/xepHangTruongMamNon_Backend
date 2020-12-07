package com.example.xepHangTruongMamNon.Model.resp;

// import com.example.xepHangTruongMamNon.Entity.NurserySchool;

public class CustomerGetListRankingResponse {
    private int rank;
    private float rate;
    private int schoolId;
    private String schoolName;
    private String address;
    private String ward;
    private String schoolType;
    private String phoneNumber;
    private String tuition;
    private String image;

    public int getRank() {
        return rank;
    }

    public void setRank(int rank) {
        this.rank = rank;
    }

    public int getSchoolId() {
        return schoolId;
    }

    public void setSchoolId(int schoolId) {
        this.schoolId = schoolId;
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

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public CustomerGetListRankingResponse(int rank, float rate, int schoolId, String schoolName, String address, String ward,
            String schoolType, String phoneNumber, String tuition, String image) {
        this.rank = rank;
        this.rate = rate;
        this.schoolId = schoolId;
        this.schoolName = schoolName;
        this.address = address;
        this.ward = ward;
        this.schoolType = schoolType;
        this.phoneNumber = phoneNumber;
        this.tuition = tuition;
        this.image = image;
    }

    public String getTuition() {
        return tuition;
    }

    public void setTuition(String tuition) {
        this.tuition = tuition;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public float getRate() {
        return rate;
    }

    public void setRate(float rate) {
        this.rate = rate;
    }

}
