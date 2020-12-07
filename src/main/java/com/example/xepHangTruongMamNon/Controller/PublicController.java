package com.example.xepHangTruongMamNon.Controller;

import javax.validation.Valid;

import com.example.xepHangTruongMamNon.Model.ServiceResult;
import com.example.xepHangTruongMamNon.Model.req.CustomerGetAllCommentForSchoolRequest;
import com.example.xepHangTruongMamNon.Model.req.CustomerGetCustomerInfoByIdRequest;
import com.example.xepHangTruongMamNon.Model.req.CustomerGetListSchoolRequest;
import com.example.xepHangTruongMamNon.Model.req.CustomerGetSchoolByWardIdRequest;
import com.example.xepHangTruongMamNon.Model.req.CustomerGetSchoolRequest;
import com.example.xepHangTruongMamNon.Service.CustomerService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
// import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/public")
public class PublicController {

    @Autowired
    CustomerService userService;

    @PostMapping("/paginateSchool")
    public ResponseEntity<ServiceResult> paginateSchool(@RequestBody CustomerGetListSchoolRequest request) {
        return new ResponseEntity<>(userService.getListShool(request.getPage(), request.getSize()), HttpStatus.OK);
    }

    @PostMapping("/getShoolInfoByName")
    public ResponseEntity<ServiceResult> getSchoolInfoByName(@Valid @RequestBody CustomerGetSchoolRequest request) {
        return new ResponseEntity<>(userService.getSchoolInfoByName(request.getName()), HttpStatus.OK);
    }

    @PostMapping("/getUserInfomation")
    public ResponseEntity<ServiceResult> getUserInfomation(
            @Valid @RequestBody CustomerGetCustomerInfoByIdRequest request) {
        return new ResponseEntity<>(userService.getUserInfoById(request.getId()), HttpStatus.OK);
    }

    @PostMapping("/getAllCommentForSchool")
    public ResponseEntity<ServiceResult> getAllCommentForSchool(
            @Valid @RequestBody CustomerGetAllCommentForSchoolRequest request) {
        return new ResponseEntity<>(userService.getListCommentForSchool(request.getSchoolId()), HttpStatus.OK);
    }

    @GetMapping("/getRankingList")
    public ResponseEntity<ServiceResult> getRankingList() {
        return new ResponseEntity<>(userService.getListRanking(), HttpStatus.OK);
    }
    @PostMapping("/getSchoolByWardId")
    public ResponseEntity<ServiceResult> getSchoolByWardId(@Valid @RequestBody CustomerGetSchoolByWardIdRequest request){
        return new ResponseEntity<>(userService.getlistSchoolByWardId(request.getId()),HttpStatus.OK);
    }
}
