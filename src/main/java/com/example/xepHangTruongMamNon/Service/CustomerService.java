package com.example.xepHangTruongMamNon.Service;

import com.example.xepHangTruongMamNon.Model.ServiceResult;

public interface CustomerService {
    ServiceResult signIn(String email, String password);

    ServiceResult sinUpCustomer(String email, String password, String name);

    ServiceResult getListShool(int page, int size);

    ServiceResult getListRanking();

    ServiceResult getSchoolInfoByName(String name);

    ServiceResult signOut(String token);

    ServiceResult getUserInfoById(int id);

    ServiceResult getListCommentForSchool(int id);

    ServiceResult createComment(int userId, int schoolId, String content);

    ServiceResult createNewReview(int userId, int schoolId, float diem_danh_gia_csvc,
            float diem_dam_bao_so_luong_hoc_vien_mot_lop_hoc, float diem_dam_bao_so_luong_giao_vien_mot_lop_hoc,
            float diem_dich_vu_y_te, float diem_che_do_dinh_duong_va_bep_an, float diem_chuong_trinh_hoc,
            float diem_to_chuc_va_chat_luong_hoat_dong_ngoai_khoa, float diem_dam_bao_an_ninh_trat_tu,
            float diem_dam_bao_an_toan_cho_be, float diem_dam_bao_giai_dap_van_de_tu_phu_huynh,
            float diem_quan_he_giao_vien_nha_truong_voi_phu_huynh, float diem_thai_do_giao_vien_ngoai_lop_hoc,
            float diem_thai_do_giao_vien_trong_lop_hoc, float diem_dam_bao_ve_sinh_ca_nhan_cho_be,
            float diem_muc_do_muon_den_truong_cua_be);

    ServiceResult getlistSchoolByWardId(int id);

    ServiceResult updateAvatar(int id, String avatar_link);

    ServiceResult checkReviewedByUserId(int userId, int schoolId);

}
