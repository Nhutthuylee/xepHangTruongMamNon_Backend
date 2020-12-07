package com.example.xepHangTruongMamNon.Model.resp;

import java.util.List;

public class CustomerPaginationSchoolListResponse {
    private int totalPage;
    private List<CustomerPaginationSchoolResponse> responses;

    public CustomerPaginationSchoolListResponse(int totalPage, List<CustomerPaginationSchoolResponse> responses) {
        this.totalPage = totalPage;
        this.responses = responses;
    }

    public int getTotalPage() {
        return totalPage;
    }

    public void setTotalPage(int totalPage) {
        this.totalPage = totalPage;
    }

    public List<CustomerPaginationSchoolResponse> getResponses() {
        return responses;
    }

    public void setResponses(List<CustomerPaginationSchoolResponse> responses) {
        this.responses = responses;
    }

}
