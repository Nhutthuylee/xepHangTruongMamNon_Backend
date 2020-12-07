package com.example.xepHangTruongMamNon.Model.resp;

import java.util.List;

public class AdminPaginationSchoolListResponse {
    private int totalPage;
    private List<AdminPaginationSchoolResponse> responses;

    public AdminPaginationSchoolListResponse(int totalPage, List<AdminPaginationSchoolResponse> responses) {
        this.totalPage = totalPage;
        this.responses = responses;
    }

    public int getTotalPage() {
        return totalPage;
    }

    public void setTotalPage(int totalPage) {
        this.totalPage = totalPage;
    }

    public List<AdminPaginationSchoolResponse> getResponses() {
        return responses;
    }

    public void setResponses(List<AdminPaginationSchoolResponse> responses) {
        this.responses = responses;
    }

}
