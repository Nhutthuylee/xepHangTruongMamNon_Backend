package com.example.xepHangTruongMamNon.Service.Impl;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.HashMap;
import com.example.xepHangTruongMamNon.Entity.Comment;
// import com.example.xepHangTruongMamNon.Entity.Image;
import com.example.xepHangTruongMamNon.Entity.NurserySchool;
import com.example.xepHangTruongMamNon.Entity.Ranking;
import com.example.xepHangTruongMamNon.Entity.Review;
import com.example.xepHangTruongMamNon.Entity.SchoolType;
import com.example.xepHangTruongMamNon.Entity.User;
import com.example.xepHangTruongMamNon.Entity.Ward;
import com.example.xepHangTruongMamNon.Model.ServiceResult;
import com.example.xepHangTruongMamNon.Model.ServiceResult.Status;
import com.example.xepHangTruongMamNon.Model.enums.RoleName;
import com.example.xepHangTruongMamNon.Model.resp.AdminCreateSchoolResponse;
import com.example.xepHangTruongMamNon.Model.resp.AdminCreateUserResponse;
import com.example.xepHangTruongMamNon.Model.resp.AdminGetAllCommentBySchoolResponse;
import com.example.xepHangTruongMamNon.Model.resp.AdminGetAllCustomerResponse;
import com.example.xepHangTruongMamNon.Model.resp.AdminGetCustomerByEmailResponse;
import com.example.xepHangTruongMamNon.Model.resp.AdminGetCustomerPaginationResponse;
import com.example.xepHangTruongMamNon.Model.resp.AdminGetListRankingResponse;
import com.example.xepHangTruongMamNon.Model.resp.AdminGetOneCustomerPaginationResponse;
import com.example.xepHangTruongMamNon.Model.resp.AdminPaginationSchoolListResponse;
import com.example.xepHangTruongMamNon.Model.resp.AdminPaginationSchoolResponse;
import com.example.xepHangTruongMamNon.Model.resp.AdminUpdateCustomerResponse;
import com.example.xepHangTruongMamNon.Repository.CommentRepository;
import com.example.xepHangTruongMamNon.Repository.ImageRepository;
import com.example.xepHangTruongMamNon.Repository.RankingRepository;
import com.example.xepHangTruongMamNon.Repository.ReviewRepository;
import com.example.xepHangTruongMamNon.Repository.RoleRepository;
import com.example.xepHangTruongMamNon.Repository.SchoolRepository;
import com.example.xepHangTruongMamNon.Repository.SchoolTypeRepository;
import com.example.xepHangTruongMamNon.Repository.UserPaginationRespository;
import com.example.xepHangTruongMamNon.Repository.UserRepository;
import com.example.xepHangTruongMamNon.Repository.WardRepository;
import com.example.xepHangTruongMamNon.Service.AdminService;
import com.example.xepHangTruongMamNon.Utils.MF.SetRanking;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.data.domain.Sort;

@Service
public class AdminServiceImpl implements AdminService {

    @Autowired
    UserRepository userRepository;

    @Autowired
    RoleRepository roleRepository;

    @Autowired
    UserPaginationRespository userPaginationRespository;

    @Autowired
    SchoolRepository schoolRepository;

    @Autowired
    ImageRepository imageRepository;
    @Autowired
    CommentRepository commentRepository;

    @Autowired
    WardRepository wardRepository;

    @Autowired
    ReviewRepository reviewRepository;

    @Autowired
    SchoolTypeRepository schoolTypeRepository;
    @Autowired
    SetRanking setRanking;
    @Autowired
    RankingRepository rankingRepository;

    private AdminGetAllCustomerResponse createGetAllCustomerResponse(User entity) {
        return new AdminGetAllCustomerResponse(entity.getId(), entity.getUsername(), entity.getEmail(),
                entity.getAddress(), entity.getAvatar(), entity.getRole().getName().name());
    }

    private List<AdminGetAllCustomerResponse> createCustomerGetResponseList() {
        List<User> customerList = userRepository.findByDeletedAndRoleName(false, RoleName.USER);
        List<AdminGetAllCustomerResponse> responseList = new ArrayList<>();
        for (User entity : customerList) {
            responseList.add(createGetAllCustomerResponse(entity));
        }
        return responseList;
    }

    private boolean isRoleExisted(String roleName) {
        boolean isRoleExisted = Arrays.stream(RoleName.values()).anyMatch(t -> t.name().equals(roleName));
        return isRoleExisted;
    }

    @Override
    public ServiceResult getAllCustomer() {
        ServiceResult result = new ServiceResult();
        List<AdminGetAllCustomerResponse> customerEntityList = createCustomerGetResponseList();
        int lengthOfListUser = customerEntityList.size();
        result.setMessage("Get all customer successfully");
        result.setData(lengthOfListUser);
        return result;
    }

    @Override
    public ServiceResult getAllSchool() {
        ServiceResult result = new ServiceResult();
        List<NurserySchool> schools = (List<NurserySchool>) schoolRepository.findAll();
        int lengthOfListSchool = schools.size();
        result.setData(lengthOfListSchool);
        result.setMessage("Get length of list school successfully");
        return result;
    }

    @Override
    public ServiceResult getCustomerByEmail(String email) {
        ServiceResult result = new ServiceResult();
        User user = userRepository.findByEmail(email).orElse(null);
        if (user != null) {
            AdminGetCustomerByEmailResponse response = new AdminGetCustomerByEmailResponse(user.getUsername(),
                    user.getEmail(), user.getAddress(), user.getAvatar(), user.isDeleted());
            result.setMessage("Get customer successfully");
            result.setData(response);
        } else {
            result.setMessage("Customer not found");
            result.setStatus(Status.FAILED);
        }
        return result;
    }

    @Override
    public ServiceResult createUser(String name, String email, String password, String address, String avatarURL,
            String roleName) {
        ServiceResult result = new ServiceResult();
        if (name != null && email != null && password != null && avatarURL != null && roleName != null) {
            if (isRoleExisted(roleName)) {
                boolean isEmailExisted = userRepository.existsByEmail(email);
                if (!isEmailExisted) {
                    User user = new User(name, password, email, avatarURL, address,
                            roleRepository.findByName(RoleName.valueOf(roleName)));
                    userRepository.save(user);
                    AdminCreateUserResponse response = new AdminCreateUserResponse(user.getId(), user.getUsername(),
                            user.getEmail(), user.getPassword(), user.getAvatar(), user.getRole().getName().name());
                    result.setMessage("Create successfully");
                    result.setData(response);
                } else {
                    result.setMessage("This account was created");
                    result.setStatus(ServiceResult.Status.FAILED);
                }
            } else {
                result.setMessage("role is not exist");
                result.setStatus(Status.FAILED);
            }
        } else {
            result.setMessage("Fields cannot be empty");
            result.setStatus(Status.FAILED);
        }
        return result;
    }

    @Override
    public ServiceResult createSchool(String schoolName, String phoneNumber, String address, String tuition,
            String image, String ward, String schoolType) {
        ServiceResult result = new ServiceResult();
        Ward phuong = wardRepository.findByName(ward);
        SchoolType loaiTruong = schoolTypeRepository.findByName(schoolType);
        if (schoolName != null && ward != null) {
            NurserySchool school = new NurserySchool(schoolName, address, phuong, phoneNumber, tuition, loaiTruong,
                    image);
            schoolRepository.save(school);
            AdminCreateSchoolResponse response = new AdminCreateSchoolResponse(school.getId(), school.getName(),
                    school.getAvatar(), school.getPhoneNumber(), school.getAddress(), school.getWard().getName(),
                    school.getSchoolType().getTypeName());
            result.setMessage("Tạo thành công trường");
            result.setData(response);
        } else {
            result.setMessage("Fields cannot be empty");
            result.setStatus(Status.FAILED);
        }
        return result;
    }

    @Override
    public ServiceResult updateCustomerInfo(int id, String name, String email, String address, String roleName) {
        ServiceResult result = new ServiceResult();
        User user = userRepository.findByIdAndDeletedAndRoleName(id, false, RoleName.USER).orElse(null);
        if (user != null) {
            if (name != null && email != null && roleName != null && address != null) {
                if (isRoleExisted(roleName)) {
                    user.setUsername(name);
                    user.setEmail(email);
                    // if (!password.equals("")) {
                    // user.setPassword(password);
                    // } else {
                    // user.setPassword(user.getPassword());
                    // }
                    user.setAddress(address);
                    // user.setAvatar(avatarURL);
                    user.setRole(roleRepository.findByName(RoleName.valueOf(roleName)));
                    userRepository.save(user);
                    AdminUpdateCustomerResponse response = new AdminUpdateCustomerResponse(user.getId(),
                            user.getUsername(), user.getEmail(), user.getPassword(), user.getAddress(),
                            user.getAvatar(), user.getRole().getName().name());
                    result.setMessage("Update customer successfully");
                    result.setData(response);
                } else {
                    result.setMessage("role is not exist");
                    result.setStatus(Status.FAILED);
                }
            } else {
                result.setMessage("Fields cannot be empty");
                result.setStatus(ServiceResult.Status.FAILED);
            }
        } else {
            result.setMessage("Customer not found");
            result.setStatus(ServiceResult.Status.FAILED);
        }
        return result;
    }

    @Override
    public ServiceResult deleteUserById(int id) {
        ServiceResult result = new ServiceResult();
        User user = userRepository.findByIdAndDeletedAndRoleName(id, false, RoleName.USER).orElse(null);
        if (user != null) {
            user.setDeleted(true);
            userRepository.save(user);
            // userRepository.delete(user);
            result.setMessage("Delete customer successfully");
        } else {
            result.setMessage("Customer not found");
            result.setStatus(ServiceResult.Status.FAILED);
        }
        return result;
    }

    @Override
    public ServiceResult getPaginationCustomer(int page, int size) {
        ServiceResult result = new ServiceResult();
        Pageable info = PageRequest.of(page - 1, size, Sort.by("id").ascending());
        // Page<User> userList = userRepository.findAll(info);
        Page<User> userList = userPaginationRespository.findAllByDeleted(info, false);
        boolean isUserListEmpty = userList.isEmpty();
        if (!isUserListEmpty) {
            int totalPages = userList.getTotalPages();
            List<AdminGetOneCustomerPaginationResponse> responses = new ArrayList<>();
            for (User entity : userList) {
                AdminGetOneCustomerPaginationResponse response = new AdminGetOneCustomerPaginationResponse(
                        entity.getId(), entity.getUsername(), entity.getEmail(), entity.getAddress(),
                        entity.getAvatar());
                responses.add(response);
            }
            AdminGetCustomerPaginationResponse response = new AdminGetCustomerPaginationResponse(totalPages, responses);
            result.setMessage("Successfully");
            result.setData(response);
        } else {
            result.setMessage("user list is empty");
            result.setStatus(ServiceResult.Status.FAILED);
        }
        return result;
    }

    @Override
    public ServiceResult getPaginationSchool(int page, int size) {
        ServiceResult result = new ServiceResult();
        Pageable info = PageRequest.of(page - 1, size, Sort.by("id").ascending());
        Page<NurserySchool> schoolList = schoolRepository.findAll(info);
        boolean isSchoolListEmpty = schoolList.isEmpty();
        if (!isSchoolListEmpty) {
            int totalPages = schoolList.getTotalPages();
            List<AdminPaginationSchoolResponse> responses = new ArrayList<>();
            for (NurserySchool entity : schoolList) {
                // Image avatar = imageRepository.findByNurserySchoolId(entity.getId());
                AdminPaginationSchoolResponse response = new AdminPaginationSchoolResponse(entity.getId(),
                        entity.getName(), entity.getAddress(), entity.getPhoneNumber(), entity.getTuition(),
                        entity.getSchoolType().getTypeName(), entity.getWard().getName(), entity.getAvatar());
                responses.add(response);
            }
            AdminPaginationSchoolListResponse response = new AdminPaginationSchoolListResponse(totalPages, responses);
            result.setMessage("Successfully");
            result.setData(response);

        } else {
            result.setMessage("School list is empty");
            result.setStatus(ServiceResult.Status.FAILED);
        }
        return result;
    }

    private AdminGetAllCommentBySchoolResponse createGetCommentByShoolResponse(Comment entity) {
        return new AdminGetAllCommentBySchoolResponse(entity.getId(), entity.getUser().getUsername(),
                entity.getContent());
    }

    private List<AdminGetAllCommentBySchoolResponse> createCommentGetResponseList(int schoolId) {

        List<Comment> commentList = commentRepository.findByNurserySchoolId(schoolId);
        List<AdminGetAllCommentBySchoolResponse> responseList = new ArrayList<>();
        for (Comment entity : commentList) {
            responseList.add(createGetCommentByShoolResponse(entity));
        }
        return responseList;
    }

    @Override
    public ServiceResult getAllCommentBySchool(int schoolId) {
        ServiceResult result = new ServiceResult();
        List<AdminGetAllCommentBySchoolResponse> commentEntityList = createCommentGetResponseList(schoolId);
        result.setMessage("Get all comment by nursery school id successfully");
        result.setData(commentEntityList);
        return result;
    }

    @Override
    public ServiceResult deleteCommentById(int id) {
        ServiceResult result = new ServiceResult();
        Comment comment = commentRepository.findById(id).orElse(null);
        if (comment != null) {
            commentRepository.delete(comment);
            result.setMessage("delete comment successfully");
        } else {
            result.setMessage("comment not found");
            result.setStatus(ServiceResult.Status.FAILED);
        }
        return result;
    }

    @Override
    public ServiceResult setNewRanking() {
        List<Review> list = reviewRepository.findAll();
        // System.out.println(list.size());
        Map<Integer, ArrayList<ArrayList<Float>>> tieuchi = new HashMap<Integer, ArrayList<ArrayList<Float>>>();

        for (Review entity : list) {
            ArrayList<ArrayList<Float>> xxx = new ArrayList<ArrayList<Float>>();
            float tc1 = entity.getDiem_che_do_dinh_duong_va_bep_an();
            float tc2 = entity.getDiem_chuong_trinh_hoc();
            float tc3 = entity.getDiem_dam_bao_an_ninh_trat_tu();
            float tc4 = entity.getDiem_dam_bao_an_toan_cho_be();
            float tc5 = entity.getDiem_dam_bao_giai_dap_van_de_tu_phu_huynh();
            float tc6 = entity.getDiem_dam_bao_so_luong_giao_vien_mot_lop_hoc();
            float tc7 = entity.getDiem_dam_bao_so_luong_hoc_vien_mot_lop_hoc();
            float tc8 = entity.getDiem_dam_bao_ve_sinh_ca_nhan_cho_be();
            float tc9 = entity.getDiem_danh_gia_csvc();
            float tc10 = entity.getDiem_dich_vu_y_te();
            float tc11 = entity.getDiem_muc_do_muon_den_truong_cua_be();
            float tc12 = entity.getDiem_quan_he_giao_vien_nha_truong_voi_phu_huynh();
            float tc13 = entity.getDiem_thai_do_giao_vien_ngoai_lop_hoc();
            float tc14 = entity.getDiem_thai_do_giao_vien_trong_lop_hoc();
            float tc15 = entity.getDiem_to_chuc_va_chat_luong_hoat_dong_ngoai_khoa();
            float user = entity.getUser().getId();

            int school = entity.getNurserySchool().getId();
            ArrayList<Float> temp = new ArrayList<>();
            temp.add(user);
            temp.add(tc1);
            temp.add(tc2);
            temp.add(tc3);
            temp.add(tc4);
            temp.add(tc5);
            temp.add(tc6);
            temp.add(tc7);
            temp.add(tc8);
            temp.add(tc9);
            temp.add(tc10);
            temp.add(tc11);
            temp.add(tc12);
            temp.add(tc13);
            temp.add(tc14);
            temp.add(tc15);
            xxx.add(temp);
            if (tieuchi.get(school) == null) {
                tieuchi.put(school, xxx);
            }
            tieuchi.get(school).add(temp);
        }

        Map<Integer, Float> rank = setRanking.Readdata(tieuchi);
        Set<Integer> set22 = rank.keySet();
        int dem = tieuchi.size();
        for (Integer key : set22) {
            // System.out.println("school:" + key + " point:" + rank.get(key) + " rank:" +
            // dem);
            Ranking newRank = rankingRepository.findByNurserySchoolId(key).orElse(null);
            if (newRank == null) {
                NurserySchool newschool = schoolRepository.findById(key).orElse(null);
                Ranking rankNewSchool = new Ranking(newschool, dem, (float) rank.get(key));
                rankingRepository.save(rankNewSchool);

            } else {
                newRank.setRank(dem);
                newRank.setRate(rank.get(key));
                rankingRepository.save(newRank);
            }
            dem -= 1;
        }

        return null;
    }

    private AdminGetListRankingResponse createGetRankingResponse(Ranking entity) {
        return new AdminGetListRankingResponse(entity.getRank(), entity.getRate(), entity.getNurserySchool().getId(),
                entity.getNurserySchool().getName(), entity.getNurserySchool().getAddress(),
                entity.getNurserySchool().getWard().getName(), entity.getNurserySchool().getSchoolType().getTypeName(),
                entity.getNurserySchool().getPhoneNumber(), entity.getNurserySchool().getTuition(),
                entity.getNurserySchool().getAvatar());
    }

    private List<AdminGetListRankingResponse> createRankingResponseList() {
        List<Ranking> lisRankings = rankingRepository.findAll();
        List<AdminGetListRankingResponse> responses = new ArrayList<>();
        for (Ranking entity : lisRankings) {
            responses.add(createGetRankingResponse(entity));
        }
        return responses;
    }

    @Override
    public ServiceResult getListRanking() {
        ServiceResult result = new ServiceResult();
        List<AdminGetListRankingResponse> rankingEntityList = createRankingResponseList();
        result.setData(rankingEntityList);
        result.setMessage("get list ranking successfully");
        return result;
    }

}
