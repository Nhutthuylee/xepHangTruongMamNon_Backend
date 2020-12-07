package com.example.xepHangTruongMamNon.Service;

// import java.io.FileNotFoundException;
// import java.io.IOException;
// import java.util.List;

// import com.example.xepHangTruongMamNon.Entity.Review;
import com.example.xepHangTruongMamNon.Model.ServiceResult;
// import com.example.xepHangTruongMamNon.Repository.ReviewRepository;
// import com.example.xepHangTruongMamNon.Utils.MF.SetRanking;

// import org.springframework.beans.factory.annotation.Autowired;

public interface AdminService {

        ServiceResult getAllCustomer();

        ServiceResult getAllSchool();

        ServiceResult getCustomerByEmail(String email);

        ServiceResult createUser(String name, String email, String password, String address, String avatarURL,
                        String roleName);

        ServiceResult updateCustomerInfo(int id, String name, String email, String address, String roleName);

        ServiceResult deleteUserById(int id);

        ServiceResult createSchool(String schoolName, String phoneNumber, String address, String tuition, String image,
                        String ward, String schoolType);

        ServiceResult getPaginationCustomer(int page, int size);

        ServiceResult getPaginationSchool(int page, int size);

        ServiceResult getAllCommentBySchool(int schoolId);

        ServiceResult deleteCommentById(int id);

        ServiceResult setNewRanking();
        ServiceResult getListRanking();

        // static ServiceResult setNewRanking() throws FileNotFoundException,
        // IOException {
        // String inputFile =
        // "E:\\DATN\\Source\\MF-Based-Recommendation-master\\ten.csv";

        // List<Review> list = reviewRepository.findAll();
        // SetRanking.Readdata(inputFile);
        // return null;
        // };

}
