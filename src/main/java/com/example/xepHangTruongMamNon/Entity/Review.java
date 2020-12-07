package com.example.xepHangTruongMamNon.Entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table
public class Review {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    @ManyToOne
    @JoinColumn(name = "nurserySchool_id", nullable = false)
    private NurserySchool nurserySchool;

    @Column(name = "diem_danh_gia_csvc")
    private float diem_danh_gia_csvc;
    @Column(name = "diem_dam_bao_so_luong_hoc_vien_mot_lop_hoc")
    private float diem_dam_bao_so_luong_hoc_vien_mot_lop_hoc;
    @Column(name = "diem_dam_bao_so_luong_giao_vien_mot_lop_hoc")
    private float diem_dam_bao_so_luong_giao_vien_mot_lop_hoc;
    @Column(name = "diem_dich_vu_y_te")
    private float diem_dich_vu_y_te;
    @Column(name = "diem_che_do_dinh_duong_va_bep_an")
    private float diem_che_do_dinh_duong_va_bep_an;
    @Column(name = "diem_chuong_trinh_hoc")
    private float diem_chuong_trinh_hoc;
    @Column(name = "diem_to_chuc_va_chat_luong_hoat_dong_ngoai_khoa")
    private float diem_to_chuc_va_chat_luong_hoat_dong_ngoai_khoa;
    @Column(name = "diem_dam_bao_an_ninh_trat_tu")
    private float diem_dam_bao_an_ninh_trat_tu;
    @Column(name = "diem_dam_bao_an_toan_cho_be")
    private float diem_dam_bao_an_toan_cho_be;
    @Column(name = "diem_dam_bao_giai_dap_van_de_tu_phu_huynh")
    private float diem_dam_bao_giai_dap_van_de_tu_phu_huynh;
    @Column(name = "diem_quan_he_giao_vien_nha_truong_voi_phu_huynh")
    private float diem_quan_he_giao_vien_nha_truong_voi_phu_huynh;
    @Column(name = "diem_thai_do_giao_vien_ngoai_lop_hoc")
    private float diem_thai_do_giao_vien_ngoai_lop_hoc;
    @Column(name = "diem_thai_do_giao_vien_trong_lop_hoc")
    private float diem_thai_do_giao_vien_trong_lop_hoc;
    @Column(name = "diem_dam_bao_ve_sinh_ca_nhan_cho_be")
    private float diem_dam_bao_ve_sinh_ca_nhan_cho_be;
    @Column(name = "diem_muc_do_muon_den_truong_cua_be")
    private float diem_muc_do_muon_den_truong_cua_be;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public NurserySchool getNurserySchool() {
        return nurserySchool;
    }

    public void setNurserySchool(NurserySchool nurserySchool) {
        this.nurserySchool = nurserySchool;
    }

    public Review() {
    }

    public Review(User user, NurserySchool nurserySchool, float diem_danh_gia_csvc,
            float diem_dam_bao_so_luong_hoc_vien_mot_lop_hoc, float diem_dam_bao_so_luong_giao_vien_mot_lop_hoc,
            float diem_dich_vu_y_te, float diem_che_do_dinh_duong_va_bep_an, float diem_chuong_trinh_hoc,
            float diem_to_chuc_va_chat_luong_hoat_dong_ngoai_khoa, float diem_dam_bao_an_ninh_trat_tu,
            float diem_dam_bao_an_toan_cho_be, float diem_dam_bao_giai_dap_van_de_tu_phu_huynh,
            float diem_quan_he_giao_vien_nha_truong_voi_phu_huynh, float diem_thai_do_giao_vien_ngoai_lop_hoc,
            float diem_thai_do_giao_vien_trong_lop_hoc, float diem_dam_bao_ve_sinh_ca_nhan_cho_be,
            float diem_muc_do_muon_den_truong_cua_be) {
        this.user = user;
        this.nurserySchool = nurserySchool;
        this.diem_danh_gia_csvc = diem_danh_gia_csvc;
        this.diem_dam_bao_so_luong_hoc_vien_mot_lop_hoc = diem_dam_bao_so_luong_hoc_vien_mot_lop_hoc;
        this.diem_dam_bao_so_luong_giao_vien_mot_lop_hoc = diem_dam_bao_so_luong_giao_vien_mot_lop_hoc;
        this.diem_dich_vu_y_te = diem_dich_vu_y_te;
        this.diem_che_do_dinh_duong_va_bep_an = diem_che_do_dinh_duong_va_bep_an;
        this.diem_chuong_trinh_hoc = diem_chuong_trinh_hoc;
        this.diem_to_chuc_va_chat_luong_hoat_dong_ngoai_khoa = diem_to_chuc_va_chat_luong_hoat_dong_ngoai_khoa;
        this.diem_dam_bao_an_ninh_trat_tu = diem_dam_bao_an_ninh_trat_tu;
        this.diem_dam_bao_an_toan_cho_be = diem_dam_bao_an_toan_cho_be;
        this.diem_dam_bao_giai_dap_van_de_tu_phu_huynh = diem_dam_bao_giai_dap_van_de_tu_phu_huynh;
        this.diem_quan_he_giao_vien_nha_truong_voi_phu_huynh = diem_quan_he_giao_vien_nha_truong_voi_phu_huynh;
        this.diem_thai_do_giao_vien_ngoai_lop_hoc = diem_thai_do_giao_vien_ngoai_lop_hoc;
        this.diem_thai_do_giao_vien_trong_lop_hoc = diem_thai_do_giao_vien_trong_lop_hoc;
        this.diem_dam_bao_ve_sinh_ca_nhan_cho_be = diem_dam_bao_ve_sinh_ca_nhan_cho_be;
        this.diem_muc_do_muon_den_truong_cua_be = diem_muc_do_muon_den_truong_cua_be;
    }

    public float getDiem_danh_gia_csvc() {
        return diem_danh_gia_csvc;
    }

    public void setDiem_danh_gia_csvc(float diem_danh_gia_csvc) {
        this.diem_danh_gia_csvc = diem_danh_gia_csvc;
    }

    public float getDiem_dam_bao_so_luong_hoc_vien_mot_lop_hoc() {
        return diem_dam_bao_so_luong_hoc_vien_mot_lop_hoc;
    }

    public void setDiem_dam_bao_so_luong_hoc_vien_mot_lop_hoc(float diem_dam_bao_so_luong_hoc_vien_mot_lop_hoc) {
        this.diem_dam_bao_so_luong_hoc_vien_mot_lop_hoc = diem_dam_bao_so_luong_hoc_vien_mot_lop_hoc;
    }

    public float getDiem_dam_bao_so_luong_giao_vien_mot_lop_hoc() {
        return diem_dam_bao_so_luong_giao_vien_mot_lop_hoc;
    }

    public void setDiem_dam_bao_so_luong_giao_vien_mot_lop_hoc(float diem_dam_bao_so_luong_giao_vien_mot_lop_hoc) {
        this.diem_dam_bao_so_luong_giao_vien_mot_lop_hoc = diem_dam_bao_so_luong_giao_vien_mot_lop_hoc;
    }

    public float getDiem_dich_vu_y_te() {
        return diem_dich_vu_y_te;
    }

    public void setDiem_dich_vu_y_te(float diem_dich_vu_y_te) {
        this.diem_dich_vu_y_te = diem_dich_vu_y_te;
    }

    public float getDiem_che_do_dinh_duong_va_bep_an() {
        return diem_che_do_dinh_duong_va_bep_an;
    }

    public void setDiem_che_do_dinh_duong_va_bep_an(float diem_che_do_dinh_duong_va_bep_an) {
        this.diem_che_do_dinh_duong_va_bep_an = diem_che_do_dinh_duong_va_bep_an;
    }

    public float getDiem_chuong_trinh_hoc() {
        return diem_chuong_trinh_hoc;
    }

    public void setDiem_chuong_trinh_hoc(float diem_chuong_trinh_hoc) {
        this.diem_chuong_trinh_hoc = diem_chuong_trinh_hoc;
    }

    public float getDiem_to_chuc_va_chat_luong_hoat_dong_ngoai_khoa() {
        return diem_to_chuc_va_chat_luong_hoat_dong_ngoai_khoa;
    }

    public void setDiem_to_chuc_va_chat_luong_hoat_dong_ngoai_khoa(
            float diem_to_chuc_va_chat_luong_hoat_dong_ngoai_khoa) {
        this.diem_to_chuc_va_chat_luong_hoat_dong_ngoai_khoa = diem_to_chuc_va_chat_luong_hoat_dong_ngoai_khoa;
    }

    public float getDiem_dam_bao_an_ninh_trat_tu() {
        return diem_dam_bao_an_ninh_trat_tu;
    }

    public void setDiem_dam_bao_an_ninh_trat_tu(float diem_dam_bao_an_ninh_trat_tu) {
        this.diem_dam_bao_an_ninh_trat_tu = diem_dam_bao_an_ninh_trat_tu;
    }

    public float getDiem_dam_bao_an_toan_cho_be() {
        return diem_dam_bao_an_toan_cho_be;
    }

    public void setDiem_dam_bao_an_toan_cho_be(float diem_dam_bao_an_toan_cho_be) {
        this.diem_dam_bao_an_toan_cho_be = diem_dam_bao_an_toan_cho_be;
    }

    public float getDiem_dam_bao_giai_dap_van_de_tu_phu_huynh() {
        return diem_dam_bao_giai_dap_van_de_tu_phu_huynh;
    }

    public void setDiem_dam_bao_giai_dap_van_de_tu_phu_huynh(float diem_dam_bao_giai_dap_van_de_tu_phu_huynh) {
        this.diem_dam_bao_giai_dap_van_de_tu_phu_huynh = diem_dam_bao_giai_dap_van_de_tu_phu_huynh;
    }

    public float getDiem_quan_he_giao_vien_nha_truong_voi_phu_huynh() {
        return diem_quan_he_giao_vien_nha_truong_voi_phu_huynh;
    }

    public void setDiem_quan_he_giao_vien_nha_truong_voi_phu_huynh(
            float diem_quan_he_giao_vien_nha_truong_voi_phu_huynh) {
        this.diem_quan_he_giao_vien_nha_truong_voi_phu_huynh = diem_quan_he_giao_vien_nha_truong_voi_phu_huynh;
    }

    public float getDiem_thai_do_giao_vien_ngoai_lop_hoc() {
        return diem_thai_do_giao_vien_ngoai_lop_hoc;
    }

    public void setDiem_thai_do_giao_vien_ngoai_lop_hoc(float diem_thai_do_giao_vien_ngoai_lop_hoc) {
        this.diem_thai_do_giao_vien_ngoai_lop_hoc = diem_thai_do_giao_vien_ngoai_lop_hoc;
    }

    public float getDiem_thai_do_giao_vien_trong_lop_hoc() {
        return diem_thai_do_giao_vien_trong_lop_hoc;
    }

    public void setDiem_thai_do_giao_vien_trong_lop_hoc(float diem_thai_do_giao_vien_trong_lop_hoc) {
        this.diem_thai_do_giao_vien_trong_lop_hoc = diem_thai_do_giao_vien_trong_lop_hoc;
    }

    public float getDiem_dam_bao_ve_sinh_ca_nhan_cho_be() {
        return diem_dam_bao_ve_sinh_ca_nhan_cho_be;
    }

    public void setDiem_dam_bao_ve_sinh_ca_nhan_cho_be(float diem_dam_bao_ve_sinh_ca_nhan_cho_be) {
        this.diem_dam_bao_ve_sinh_ca_nhan_cho_be = diem_dam_bao_ve_sinh_ca_nhan_cho_be;
    }

    public float getDiem_muc_do_muon_den_truong_cua_be() {
        return diem_muc_do_muon_den_truong_cua_be;
    }

    public void setDiem_muc_do_muon_den_truong_cua_be(float diem_muc_do_muon_den_truong_cua_be) {
        this.diem_muc_do_muon_den_truong_cua_be = diem_muc_do_muon_den_truong_cua_be;
    }

}
