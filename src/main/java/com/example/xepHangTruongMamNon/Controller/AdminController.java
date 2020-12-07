package com.example.xepHangTruongMamNon.Controller;

// import java.io.FileNotFoundException;
// import java.io.IOException;

import javax.validation.Valid;

import com.example.xepHangTruongMamNon.Model.ServiceResult;
import com.example.xepHangTruongMamNon.Model.req.AdminDeleteCommentById;
import com.example.xepHangTruongMamNon.Model.req.AdminDeleteCustomerRequest;
import com.example.xepHangTruongMamNon.Model.req.AdminGetCustomerByEmailRequest;
import com.example.xepHangTruongMamNon.Model.req.AdminGetCustomerPaginationRequest;
import com.example.xepHangTruongMamNon.Model.req.AdminGetSchoolPaginationRequest;
import com.example.xepHangTruongMamNon.Model.req.AdminUpdateCustomerRequest;
import com.example.xepHangTruongMamNon.Model.req.AdminGetCommentByNurserySchoolIdRequest;
import com.example.xepHangTruongMamNon.Service.AdminService;
import com.example.xepHangTruongMamNon.Service.AmazonS3ClientService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
// import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/admin")
// @PreAuthorize("hasRole('ADMIN')")
public class AdminController {

    @Autowired
    AdminService adminService;

    @Autowired
    AmazonS3ClientService amazonS3ClientService;

    @GetMapping("/all")
    public ResponseEntity<ServiceResult> getAllCustomer() {
        return new ResponseEntity<>(adminService.getAllCustomer(), HttpStatus.OK);
    }

    @GetMapping("/getById")
    public ResponseEntity<ServiceResult> getCustomerById(@Valid @RequestBody AdminGetCustomerByEmailRequest request) {
        return new ResponseEntity<>(adminService.getCustomerByEmail(request.getEmail()), HttpStatus.OK);
    }

    @PostMapping("/create")
    public ResponseEntity<ServiceResult> createUser(@RequestParam("username") String username,
            @RequestParam("email") String email, @RequestParam("password") String password,
            @RequestParam("address") String address,
            @RequestParam(value = "file", required = false) MultipartFile file) {
        this.amazonS3ClientService.uploadFileToS3Bucket(file, true);
        System.out.println(file.getOriginalFilename());
        String img = "https://hatsukoi.s3-us-west-2.amazonaws.com/" + file.getOriginalFilename();
        return new ResponseEntity<>(adminService.createUser(username, email, password, address, img, "USER"),
                HttpStatus.OK);
    }

    @PostMapping("/createSchool")
    public ResponseEntity<ServiceResult> creatSchool(@RequestParam("schoolName") String schoolName,
            @RequestParam("address") String address, @RequestParam("phoneNumber") String phoneNumber,
            @RequestParam("ward") String ward, @RequestParam("schoolType") String schoolType,
            @RequestParam("tuition") String tuition,
            @RequestParam(value = "file", required = false) MultipartFile file) {
        String img = "https://hatsukoi.s3-us-west-2.amazonaws.com/" + file.getOriginalFilename();
        return new ResponseEntity<>(
                adminService.createSchool(schoolName, phoneNumber, address, tuition, img, ward, schoolType),
                HttpStatus.OK);
    }

    @PutMapping("/update")
    public ResponseEntity<ServiceResult> updateCustomer(@Valid @RequestBody AdminUpdateCustomerRequest request) {
        return new ResponseEntity<>(adminService.updateCustomerInfo(request.getId(), request.getName(),
                request.getEmail(), request.getAddress(), request.getRole()), HttpStatus.OK);
    }

    @DeleteMapping("/delete")
    public ResponseEntity<ServiceResult> deleteCustomer(@Valid @RequestBody AdminDeleteCustomerRequest request) {
        return new ResponseEntity<>(adminService.deleteUserById(request.getId()), HttpStatus.OK);
    }

    @PostMapping("/paginationUser")
    public ResponseEntity<ServiceResult> paginationUser(@RequestBody AdminGetCustomerPaginationRequest request) {
        return new ResponseEntity<>(adminService.getPaginationCustomer(request.getPage(), request.getSize()),
                HttpStatus.OK);
    }

    @PostMapping("/paginationSchool")
    public ResponseEntity<ServiceResult> paginationSchool(@RequestBody AdminGetSchoolPaginationRequest request) {
        return new ResponseEntity<>(adminService.getPaginationSchool(request.getPage(), request.getSize()),
                HttpStatus.OK);
    }

    @PostMapping("/getCommentBySchoolId")
    public ResponseEntity<ServiceResult> getCommentBySchoolId(
            @RequestBody AdminGetCommentByNurserySchoolIdRequest request) {
        return new ResponseEntity<>(adminService.getAllCommentBySchool(request.getSchoolId()), HttpStatus.OK);
    }

    @DeleteMapping("/deleteComment")
    public ResponseEntity<ServiceResult> deleteComment(@Valid @RequestBody AdminDeleteCommentById request) {
        return new ResponseEntity<>(adminService.deleteCommentById(request.getId()), HttpStatus.OK);
    }

    @GetMapping("/newRanking")
    public ResponseEntity<ServiceResult> newRaking() {
        // return new ResponseEntity<>(AdminService.setNewRanking(), HttpStatus.OK);
        return new ResponseEntity<>(adminService.setNewRanking(), HttpStatus.OK);
    }

    @GetMapping("/getRanking")
    public ResponseEntity<ServiceResult> getRanking() {
        return new ResponseEntity<>(adminService.getListRanking(), HttpStatus.OK);
    }

    @GetMapping("/getAllSchool")
    public ResponseEntity<ServiceResult> getAllSchool() {
        return new ResponseEntity<>(adminService.getAllSchool(), HttpStatus.OK);
    }
}
