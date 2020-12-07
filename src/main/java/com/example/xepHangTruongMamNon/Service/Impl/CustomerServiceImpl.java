package com.example.xepHangTruongMamNon.Service.Impl;

import java.util.ArrayList;
import java.util.List;

import com.example.xepHangTruongMamNon.Entity.Comment;
import com.example.xepHangTruongMamNon.Entity.Image;
import com.example.xepHangTruongMamNon.Entity.JwtEntity;
import com.example.xepHangTruongMamNon.Entity.NurserySchool;
import com.example.xepHangTruongMamNon.Entity.Ranking;
import com.example.xepHangTruongMamNon.Entity.Review;
import com.example.xepHangTruongMamNon.Entity.User;
import com.example.xepHangTruongMamNon.Model.ServiceResult;
import com.example.xepHangTruongMamNon.Model.ServiceResult.Status;
import com.example.xepHangTruongMamNon.Model.enums.RoleName;
import com.example.xepHangTruongMamNon.Model.resp.CustomerSignInSignUpResponse;
import com.example.xepHangTruongMamNon.Repository.CommentRepository;
import com.example.xepHangTruongMamNon.Repository.ImageRepository;
import com.example.xepHangTruongMamNon.Repository.JwtRepository;
import com.example.xepHangTruongMamNon.Repository.RankingRepository;
import com.example.xepHangTruongMamNon.Repository.ReviewRepository;
import com.example.xepHangTruongMamNon.Repository.RoleRepository;
import com.example.xepHangTruongMamNon.Repository.SchoolRepository;
import com.example.xepHangTruongMamNon.Repository.UserRepository;
import com.example.xepHangTruongMamNon.Service.CustomerService;
import com.example.xepHangTruongMamNon.Utils.JwtUtil;
import com.example.xepHangTruongMamNon.Model.resp.CustomerCreateCommentResponse;
import com.example.xepHangTruongMamNon.Model.resp.CustomerCreateNewReviewResponse;
import com.example.xepHangTruongMamNon.Model.resp.CustomerGetAllCommentForSchool;
import com.example.xepHangTruongMamNon.Model.resp.CustomerGetAllImageSchool;
import com.example.xepHangTruongMamNon.Model.resp.CustomerGetCustomerInfoById;
import com.example.xepHangTruongMamNon.Model.resp.CustomerGetListRankingResponse;
import com.example.xepHangTruongMamNon.Model.resp.CustomerGetSchoolByWardIdResponse;
import com.example.xepHangTruongMamNon.Model.resp.CustomerGetSchoolResponse;
import com.example.xepHangTruongMamNon.Model.resp.CustomerPaginationSchoolListResponse;
import com.example.xepHangTruongMamNon.Model.resp.CustomerPaginationSchoolResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class CustomerServiceImpl implements CustomerService {

    @Autowired
    UserRepository userRepository;
    @Autowired
    PasswordEncoder encoder;

    @Autowired
    SchoolRepository schoolRepository;

    @Autowired
    ImageRepository imageRepository;

    @Autowired
    CommentRepository commentRepository;

    @Autowired
    RoleRepository roleRepository;

    @Autowired
    JwtUtil jwtUtil;

    @Autowired
    JwtRepository jwtRepository;

    @Autowired
    RankingRepository rankingRepository;

    @Autowired
    ReviewRepository reviewRepository;

    private JwtEntity saveJwt(String token) {
        JwtEntity jwtEntity = new JwtEntity();
        jwtEntity.setToken(token);
        return jwtRepository.save(jwtEntity);
    }

    @Override
    public ServiceResult signIn(String email, String password) {
        ServiceResult result = new ServiceResult();
        User customer = userRepository.findByEmail(email).orElse(null);
        if (customer != null) {
            if (!customer.isDeleted()) {
                if (password.equals(customer.getPassword())) {
                    String jwt = jwtUtil.generateToken(email);
                    CustomerSignInSignUpResponse response = new CustomerSignInSignUpResponse(customer.getId(),
                            customer.getEmail(), customer.getUsername(), customer.getRole().getName().name(),
                            customer.getAvatar(), jwt);
                    saveJwt(jwt);
                    result.setMessage("You signed in successfully");
                    result.setData(response);
                } else {
                    result.setStatus(ServiceResult.Status.FAILED);
                    result.setMessage("Email or password is not correct");
                }
            } else {
                result.setStatus(ServiceResult.Status.FAILED);
                result.setMessage("Cannot sign in with this account");
            }
        } else {
            result.setMessage("This account was not signed up");
            result.setStatus(ServiceResult.Status.FAILED);
        }
        System.out.println(result.getMessage());
        return result;
    }

    @Override
    public ServiceResult getListShool(int page, int size) {
        ServiceResult result = new ServiceResult();
        Pageable info = PageRequest.of(page - 1, size, Sort.by("id").ascending());
        Page<NurserySchool> schoolList = schoolRepository.findAll(info);
        boolean isSchoolListEmpty = schoolList.isEmpty();
        if (!isSchoolListEmpty) {
            int totalPages = schoolList.getTotalPages();
            List<CustomerPaginationSchoolResponse> responses = new ArrayList<>();
            for (NurserySchool entity : schoolList) {
                // Image avatar = imageRepository.findByNurserySchoolId(entity.getId());
                CustomerPaginationSchoolResponse response = new CustomerPaginationSchoolResponse(entity.getId(),
                        entity.getName(), entity.getAddress(), entity.getPhoneNumber(), entity.getTuition(),
                        entity.getSchoolType().getTypeName(), entity.getWard().getName(), entity.getAvatar());
                responses.add(response);
            }
            CustomerPaginationSchoolListResponse response = new CustomerPaginationSchoolListResponse(totalPages,
                    responses);
            result.setMessage("Successfully");
            result.setData(response);

        } else {
            result.setMessage("Product list is empty");
            result.setStatus(ServiceResult.Status.FAILED);
        }
        return result;
    }

    private CustomerGetAllCommentForSchool createGetAllCommentResponse(Comment entity) {
        return new CustomerGetAllCommentForSchool(entity.getUser().getId(), entity.getUser().getUsername(),
                entity.getUser().getAvatar(), entity.getContent());
    }

    private List<CustomerGetAllCommentForSchool> getListComment(int id) {
        List<Comment> list = commentRepository.findByNurserySchoolId(id);
        List<CustomerGetAllCommentForSchool> response = new ArrayList<>();
        for (Comment entity : list) {
            response.add(createGetAllCommentResponse(entity));
        }
        return response;
    }

    private CustomerGetAllImageSchool createGetAllImageResponse(Image entity) {
        return new CustomerGetAllImageSchool(entity.getImageLink());
    }

    private List<CustomerGetAllImageSchool> getListImage(int id) {
        List<Image> list = imageRepository.findAllByNurserySchoolId(id);
        List<CustomerGetAllImageSchool> response = new ArrayList<>();
        for (Image entity : list) {
            response.add(createGetAllImageResponse(entity));
        }
        return response;
    }

    @Override
    public ServiceResult getSchoolInfoByName(String name) {
        ServiceResult result = new ServiceResult();
        NurserySchool school = schoolRepository.findByName(name).orElse(null);
        if (school != null) {
            // Image avatar = imageRepository.findByNurserySchoolId(school.getId());
            List<CustomerGetAllImageSchool> images = getListImage(school.getId());
            CustomerGetSchoolResponse response = new CustomerGetSchoolResponse(school.getId(), school.getName(),
                    school.getAddress(), school.getPhoneNumber(), school.getSchoolType().getTypeName(),
                    school.getAcceptChildrenAge(), school.getTuition(), school.getIntroduce(),
                    school.getMethodsOfEducationIntroduce(), school.getInfrastructureIntroduce(),
                    school.getTeachersIntroduce(), school.getNutritionIntroduce(), school.getHaveSwimmingPool(),
                    school.getHaveOutdoorPlayground(), school.getHaveIndoorPlayground(), school.getHaveLibrary(),
                    school.getHaveMonitoringCamera(), school.getHaveBreadfastService(),
                    school.getHaveLateReceptionService(), school.getHaveBusService(), school.getHaveSaturdayService(),
                    school.getAvatar(), images);
            result.setMessage("Get school sucessfully");
            result.setData(response);
        } else {
            result.setMessage("School not found");
            result.setStatus(Status.FAILED);
        }
        return result;
    }

    @Override
    public ServiceResult sinUpCustomer(String email, String password, String name) {
        ServiceResult result = new ServiceResult();
        boolean isEmailExist = userRepository.existsByEmail(email);
        if (isEmailExist) {
            if (userRepository.existsByEmailAndDeleted(email, true)) {
                result.setStatus(Status.FAILED);
                result.setMessage("This email cannot be used to sign up");
            } else {
                result.setStatus(Status.FAILED);
                result.setMessage("This account was signed up");
            }
        } else {
            if (name != null && email != null && password != null) {
                User customer = new User(name, password, email);
                customer.setRole(roleRepository.findByName(RoleName.USER));
                customer.setAvatar("https://www.howkteam.vn/Content/images/avatar/avatar.png");
                userRepository.save(customer);
                String jwt = jwtUtil.generateToken(email);
                CustomerSignInSignUpResponse response = new CustomerSignInSignUpResponse(customer.getId(),
                        customer.getEmail(), customer.getUsername(), customer.getRole().getName().name(),
                        customer.getAvatar(), jwt);
                saveJwt(jwt);
                result.setMessage("You signed up successfully");
                result.setData(response);
            } else {
                result.setStatus(Status.FAILED);
                result.setMessage("Fields cannot be empty");
            }
        }
        return result;
    }

    @Override
    public ServiceResult signOut(String token) {
        ServiceResult result = new ServiceResult();
        String authHeader = token.replace("Beare", "");
        JwtEntity jwt = jwtRepository.findByToken(authHeader).orElse(null);
        if (jwt != null) {
            jwtRepository.delete(jwt);
            result.setMessage("Sign out successfully");
        } else {
            result.setStatus(ServiceResult.Status.FAILED);
            result.setMessage("Cannot sign out");
        }
        return result;
    }

    @Override
    public ServiceResult getUserInfoById(int id) {
        ServiceResult result = new ServiceResult();
        User customer = userRepository.findById(id).orElse(null);
        if (customer != null) {
            CustomerGetCustomerInfoById response = new CustomerGetCustomerInfoById(customer.getId(),
                    customer.getUsername(), customer.getAddress(), customer.getEmail(), customer.getAvatar());
            result.setMessage("get info successfully");
            result.setData(response);

        } else {
            result.setMessage("User not found");
            result.setStatus(Status.FAILED);
        }
        return result;
    }

    @Override
    public ServiceResult getListCommentForSchool(int id) {

        ServiceResult result = new ServiceResult();

        List<CustomerGetAllCommentForSchool> list = getListComment(id);
        result.setData(list);
        result.setMessage("get all comment for this school successfully");

        return result;
    }

    @Override
    public ServiceResult createComment(int userId, int schoolId, String content) {
        ServiceResult result = new ServiceResult();
        User customer = userRepository.findById(userId).orElse(null);
        NurserySchool school = schoolRepository.findById(schoolId).orElse(null);

        if (content != null) {
            Comment comment = new Comment(customer, school, content);
            commentRepository.save(comment);
            CustomerCreateCommentResponse response = new CustomerCreateCommentResponse(comment.getId(),
                    comment.getUser().getId(), comment.getNurserySchool().getId(), comment.getContent());
            result.setMessage("Create new Comment successfully");
            result.setData(response);
        } else {
            result.setStatus(Status.FAILED);
            result.setMessage("Comment is null");
        }
        return result;
    }

    private CustomerGetListRankingResponse createGetRankingResponse(Ranking entity) {

        // Image avatar = imageRepository.findByNurserySchoolId(entity.getId());
        return new CustomerGetListRankingResponse(entity.getRank(), entity.getRate(), entity.getNurserySchool().getId(),
                entity.getNurserySchool().getName(), entity.getNurserySchool().getAddress(),
                entity.getNurserySchool().getWard().getName(), entity.getNurserySchool().getSchoolType().getTypeName(),
                entity.getNurserySchool().getPhoneNumber(), entity.getNurserySchool().getTuition(),
                entity.getNurserySchool().getAvatar());
    }

    private List<CustomerGetListRankingResponse> createRankingResponseList() {
        List<Ranking> listRank = rankingRepository.findAll();
        List<CustomerGetListRankingResponse> responses = new ArrayList<>();
        for (Ranking entity : listRank) {
            responses.add(createGetRankingResponse(entity));
        }
        return responses;
    }

    @Override
    public ServiceResult getListRanking() {
        ServiceResult result = new ServiceResult();
        List<CustomerGetListRankingResponse> rankingEntityList = createRankingResponseList();
        result.setData(rankingEntityList);
        result.setMessage("get list ranking successfully");
        return result;
    }

    @Override
    public ServiceResult createNewReview(int userId, int schoolId, float diem_danh_gia_csvc,
            float diem_dam_bao_so_luong_hoc_vien_mot_lop_hoc, float diem_dam_bao_so_luong_giao_vien_mot_lop_hoc,
            float diem_dich_vu_y_te, float diem_che_do_dinh_duong_va_bep_an, float diem_chuong_trinh_hoc,
            float diem_to_chuc_va_chat_luong_hoat_dong_ngoai_khoa, float diem_dam_bao_an_ninh_trat_tu,
            float diem_dam_bao_an_toan_cho_be, float diem_dam_bao_giai_dap_van_de_tu_phu_huynh,
            float diem_quan_he_giao_vien_nha_truong_voi_phu_huynh, float diem_thai_do_giao_vien_ngoai_lop_hoc,
            float diem_thai_do_giao_vien_trong_lop_hoc, float diem_dam_bao_ve_sinh_ca_nhan_cho_be,
            float diem_muc_do_muon_den_truong_cua_be) {

        ServiceResult result = new ServiceResult();
        User user = userRepository.findById(userId).orElse(null);
        NurserySchool school = schoolRepository.findById(schoolId).orElse(null);
        Review review = new Review(user, school, diem_danh_gia_csvc, diem_dam_bao_so_luong_hoc_vien_mot_lop_hoc,
                diem_dam_bao_so_luong_giao_vien_mot_lop_hoc, diem_dich_vu_y_te, diem_che_do_dinh_duong_va_bep_an,
                diem_chuong_trinh_hoc, diem_to_chuc_va_chat_luong_hoat_dong_ngoai_khoa, diem_dam_bao_an_ninh_trat_tu,
                diem_dam_bao_an_toan_cho_be, diem_dam_bao_giai_dap_van_de_tu_phu_huynh,
                diem_quan_he_giao_vien_nha_truong_voi_phu_huynh, diem_thai_do_giao_vien_ngoai_lop_hoc,
                diem_thai_do_giao_vien_trong_lop_hoc, diem_dam_bao_ve_sinh_ca_nhan_cho_be,
                diem_muc_do_muon_den_truong_cua_be);
        reviewRepository.save(review);

        CustomerCreateNewReviewResponse response = new CustomerCreateNewReviewResponse(review.getUser().getUsername(),
                review.getNurserySchool().getName(), review.getDiem_danh_gia_csvc(),
                review.getDiem_dam_bao_so_luong_hoc_vien_mot_lop_hoc(),
                review.getDiem_dam_bao_so_luong_giao_vien_mot_lop_hoc(), review.getDiem_dich_vu_y_te(),
                review.getDiem_che_do_dinh_duong_va_bep_an(), review.getDiem_chuong_trinh_hoc(),
                review.getDiem_to_chuc_va_chat_luong_hoat_dong_ngoai_khoa(), review.getDiem_dam_bao_an_ninh_trat_tu(),
                review.getDiem_dam_bao_an_toan_cho_be(), review.getDiem_dam_bao_giai_dap_van_de_tu_phu_huynh(),
                review.getDiem_quan_he_giao_vien_nha_truong_voi_phu_huynh(),
                review.getDiem_thai_do_giao_vien_ngoai_lop_hoc(), review.getDiem_thai_do_giao_vien_trong_lop_hoc(),
                review.getDiem_dam_bao_ve_sinh_ca_nhan_cho_be(), review.getDiem_muc_do_muon_den_truong_cua_be());

        result.setData(response);
        result.setMessage("ratting successfully");
        return result;
    }

    private CustomerGetSchoolByWardIdResponse createGetSchoolByWardIdResponse(NurserySchool entity) {
        // Image avatar = imageRepository.findByNurserySchoolId(entity.getId());
        return new CustomerGetSchoolByWardIdResponse(entity.getId(), entity.getName(), entity.getAddress(),
                entity.getAvatar(), entity.getPhoneNumber(), entity.getTuition(), entity.getWard().getName());
    }

    @Override
    public ServiceResult getlistSchoolByWardId(int id) {
        ServiceResult result = new ServiceResult();
        List<NurserySchool> schoolList = schoolRepository.findByWardId(id);
        List<CustomerGetSchoolByWardIdResponse> responses = new ArrayList<>();
        for (NurserySchool entity : schoolList) {
            responses.add(createGetSchoolByWardIdResponse(entity));
        }
        result.setData(responses);
        result.setMessage("get school by ward successfully");
        return result;
    }

    @Override
    public ServiceResult updateAvatar(int id, String avatar_link) {
        ServiceResult result = new ServiceResult();
        User customer = userRepository.findById(id).orElse(null);
        customer.setAvatar(avatar_link);
        userRepository.save(customer);
        CustomerGetCustomerInfoById response = new CustomerGetCustomerInfoById(customer.getId(), customer.getUsername(),
                customer.getAddress(), customer.getEmail(), customer.getAvatar());
        result.setMessage("update avatar successfully");
        result.setData(response);
        return result;
    }

    @Override
    public ServiceResult checkReviewedByUserId(int userId, int schoolId) {
        ServiceResult result = new ServiceResult();
        Review reviewed = reviewRepository.findByUserIdAndNurserySchoolId(userId, schoolId).orElse(null);
        if(reviewed == null){
            result.setMessage("user nay chua danh gia truowng nay");
            result.setStatus(Status.FAILED);
        }else{
            result.setMessage("user nay da danh gia");
        }
        return result;
    }

}
