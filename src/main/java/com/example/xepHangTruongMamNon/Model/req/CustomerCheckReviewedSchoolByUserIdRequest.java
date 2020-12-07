package com.example.xepHangTruongMamNon.Model.req;

public class CustomerCheckReviewedSchoolByUserIdRequest {
    private int userId;
    private int schoolId;

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getSchoolId() {
        return schoolId;
    }

    public void setSchoolId(int schoolId) {
        this.schoolId = schoolId;
    }
}
