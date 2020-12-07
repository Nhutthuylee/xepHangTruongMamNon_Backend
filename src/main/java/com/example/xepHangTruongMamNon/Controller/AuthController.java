package com.example.xepHangTruongMamNon.Controller;

import javax.validation.Valid;

import com.example.xepHangTruongMamNon.Model.ServiceResult;
import com.example.xepHangTruongMamNon.Model.req.CustomerCheckReviewedSchoolByUserIdRequest;
import com.example.xepHangTruongMamNon.Model.req.CustomerCreateCommentRequest;
import com.example.xepHangTruongMamNon.Model.req.CustomerCreateNewReivewRequest;
import com.example.xepHangTruongMamNon.Model.req.CustomerSignInRequest;
import com.example.xepHangTruongMamNon.Model.req.CustomerSignOutRequest;
import com.example.xepHangTruongMamNon.Model.req.CustomerSignUpRequest;
import com.example.xepHangTruongMamNon.Service.AmazonS3ClientService;
import com.example.xepHangTruongMamNon.Service.CustomerService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
public class AuthController {

    @Autowired
    CustomerService customerService;

    @Autowired
    private AmazonS3ClientService amazonS3ClientService;

    @GetMapping({ "/hello" })
    public String firstPage() {
        return "Hello world";
    }

    @PostMapping("/signin")
    public ResponseEntity<ServiceResult> signIn(@Valid @RequestBody CustomerSignInRequest request) {
        System.out.println(request.getEmail());
        return new ResponseEntity<>(customerService.signIn(request.getEmail(), request.getPassword()), HttpStatus.OK);
    }

    @PostMapping("/signup")
    public ResponseEntity<ServiceResult> signUp(@Valid @RequestBody CustomerSignUpRequest request) {
        return new ResponseEntity<>(
                customerService.sinUpCustomer(request.getEmail(), request.getPassword(), request.getUsername()),
                HttpStatus.OK);
    }

    @DeleteMapping("/signout")
    public ResponseEntity<ServiceResult> signOut(@RequestBody CustomerSignOutRequest request) {
        return new ResponseEntity<>(customerService.signOut(request.getToken()), HttpStatus.OK);
    }

    @PostMapping("/createComment")
    public ResponseEntity<ServiceResult> createComment(@RequestBody CustomerCreateCommentRequest request) {
        return new ResponseEntity<>(
                customerService.createComment(request.getUserId(), request.getSchoolId(), request.getContent()),
                HttpStatus.OK);
    }

    @PostMapping("/createReview")
    public ResponseEntity<ServiceResult> createReview(@RequestBody CustomerCreateNewReivewRequest request) {
        return new ResponseEntity<>(customerService.createNewReview(request.getUserId(), request.getSchoolId(),
                request.getDiem_danh_gia_csvc(), request.getDiem_dam_bao_so_luong_hoc_vien_mot_lop_hoc(),
                request.getDiem_dam_bao_so_luong_giao_vien_mot_lop_hoc(), request.getDiem_dich_vu_y_te(),
                request.getDiem_che_do_dinh_duong_va_bep_an(), request.getDiem_chuong_trinh_hoc(),
                request.getDiem_to_chuc_va_chat_luong_hoat_dong_ngoai_khoa(), request.getDiem_dam_bao_an_ninh_trat_tu(),
                request.getDiem_dam_bao_an_toan_cho_be(), request.getDiem_dam_bao_giai_dap_van_de_tu_phu_huynh(),
                request.getDiem_quan_he_giao_vien_nha_truong_voi_phu_huynh(),
                request.getDiem_thai_do_giao_vien_ngoai_lop_hoc(), request.getDiem_thai_do_giao_vien_trong_lop_hoc(),
                request.getDiem_dam_bao_ve_sinh_ca_nhan_cho_be(), request.getDiem_muc_do_muon_den_truong_cua_be()),
                HttpStatus.OK);
    }

    @PostMapping("/updateAvatar")
    public ResponseEntity<ServiceResult> updateAvatar(@RequestParam("id") int id,
            @RequestPart(value = "file") MultipartFile file) {
        this.amazonS3ClientService.uploadFileToS3Bucket(file, true);
        String img = "https://hatsukoi.s3-us-west-2.amazonaws.com/" + file.getOriginalFilename();
        return new ResponseEntity<>(customerService.updateAvatar(id, img), HttpStatus.OK);
    }

    @PostMapping("/checkReviewed")
    public ResponseEntity<ServiceResult> checkReviewed(
            @RequestBody CustomerCheckReviewedSchoolByUserIdRequest request) {
        return new ResponseEntity<>(customerService.checkReviewedByUserId(request.getUserId(), request.getSchoolId()),
                HttpStatus.OK);
    }

}
