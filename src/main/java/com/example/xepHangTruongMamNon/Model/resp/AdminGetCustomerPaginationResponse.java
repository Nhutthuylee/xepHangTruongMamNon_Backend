package com.example.xepHangTruongMamNon.Model.resp;

import java.util.List;

public class AdminGetCustomerPaginationResponse {
    private int totalPage;
    private List<AdminGetOneCustomerPaginationResponse> responses;

    public AdminGetCustomerPaginationResponse(int totalPage, List<AdminGetOneCustomerPaginationResponse> responses) {
        this.totalPage = totalPage;
        this.responses = responses;
    }

    public int getTotalPage() {
        return totalPage;
    }

    public void setTotalPage(int totalPage) {
        this.totalPage = totalPage;
    }

    public List<AdminGetOneCustomerPaginationResponse> getResponses() {
        return responses;
    }

    public void setResponses(List<AdminGetOneCustomerPaginationResponse> responses) {
        this.responses = responses;
    }

}
