package com.example.xepHangTruongMamNon.Entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "nurserySchool")
public class NurserySchool {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "nurserySchoolName", nullable = false)
    private String name;

    @Column(name = "address")
    private String address;

    @Column(name = "avatar")
    private String avatar;

    @ManyToOne()
    @JoinColumn(name = "ward_id", nullable = false)
    private Ward ward;

    @Column(name = "phoneNumber")
    private String phoneNumber;

    @Column(name = "acceptChildrenAge")
    private String acceptChildrenAge;

    @Column(name = "tuition")
    private String tuition;// hoc phi

    @ManyToOne()
    @JoinColumn(name = "schoolType_id", nullable = false)
    private SchoolType schoolType;

    @Column(name = "introduce")
    private String introduce;

    @Column(name = "methodsOfEducationIntroduce")
    private String methodsOfEducationIntroduce;

    @Column(name = "infrastructureIntroduce")
    private String infrastructureIntroduce;

    @Column(name = "teachersIntroduce")
    private String teachersIntroduce;

    @Column(name = "nutritionIntroduce")
    private String nutritionIntroduce;

    @Column(name = "haveSwimmingPool")
    private Boolean haveSwimmingPool;

    @Column(name = "haveOutdoorPlayground")
    private Boolean haveOutdoorPlayground;

    @Column(name = "haveIndoorPlayground")
    private Boolean haveIndoorPlayground;

    @Column(name = "haveLibrary")
    private Boolean haveLibrary;

    @Column(name = "haveMonitoringCamera")
    private Boolean haveMonitoringCamera;

    @Column(name = "haveBreadfastService")
    private Boolean haveBreadfastService;

    @Column(name = "haveLateReceptionService")
    private Boolean haveLateReceptionService;

    @Column(name = "haveBusService")
    private Boolean haveBusService;

    @Column(name = "haveSaturdayService")
    private Boolean haveSaturdayService;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER, mappedBy = "nurserySchool")
    private List<Image> listImg;

    @OneToMany(mappedBy = "nurserySchool")
    private List<Comment> comments;

    @OneToMany(mappedBy = "nurserySchool")
    private List<Review> reviews;

    @OneToMany(mappedBy = "nurserySchool")
    private List<Ranking> ranking;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getAcceptChildrenAge() {
        return acceptChildrenAge;
    }

    public void setAcceptChildrenAge(String acceptChildrenAge) {
        this.acceptChildrenAge = acceptChildrenAge;
    }

    public String getTuition() {
        return tuition;
    }

    public void setTuition(String tuition) {
        this.tuition = tuition;
    }

    public String getIntroduce() {
        return introduce;
    }

    public void setIntroduce(String introduce) {
        this.introduce = introduce;
    }

    public String getMethodsOfEducationIntroduce() {
        return methodsOfEducationIntroduce;
    }

    public void setMethodsOfEducationIntroduce(String methodsOfEducationIntroduce) {
        this.methodsOfEducationIntroduce = methodsOfEducationIntroduce;
    }

    public String getInfrastructureIntroduce() {
        return infrastructureIntroduce;
    }

    public void setInfrastructureIntroduce(String infrastructureIntroduce) {
        this.infrastructureIntroduce = infrastructureIntroduce;
    }

    public String getTeachersIntroduce() {
        return teachersIntroduce;
    }

    public void setTeachersIntroduce(String teachersIntroduce) {
        this.teachersIntroduce = teachersIntroduce;
    }

    public String getNutritionIntroduce() {
        return nutritionIntroduce;
    }

    public void setNutritionIntroduce(String nutritionIntroduce) {
        this.nutritionIntroduce = nutritionIntroduce;
    }

    public Boolean getHaveSwimmingPool() {
        return haveSwimmingPool;
    }

    public void setHaveSwimmingPool(Boolean haveSwimmingPool) {
        this.haveSwimmingPool = haveSwimmingPool;
    }

    public Boolean getHaveOutdoorPlayground() {
        return haveOutdoorPlayground;
    }

    public void setHaveOutdoorPlayground(Boolean haveOutdoorPlayground) {
        this.haveOutdoorPlayground = haveOutdoorPlayground;
    }

    public Boolean getHaveIndoorPlayground() {
        return haveIndoorPlayground;
    }

    public void setHaveIndoorPlayground(Boolean haveIndoorPlayground) {
        this.haveIndoorPlayground = haveIndoorPlayground;
    }

    public Boolean getHaveLibrary() {
        return haveLibrary;
    }

    public void setHaveLibrary(Boolean haveLibrary) {
        this.haveLibrary = haveLibrary;
    }

    public Boolean getHaveMonitoringCamera() {
        return haveMonitoringCamera;
    }

    public void setHaveMonitoringCamera(Boolean haveMonitoringCamera) {
        this.haveMonitoringCamera = haveMonitoringCamera;
    }

    public Boolean getHaveBreadfastService() {
        return haveBreadfastService;
    }

    public void setHaveBreadfastService(Boolean haveBreadfastService) {
        this.haveBreadfastService = haveBreadfastService;
    }

    public Boolean getHaveLateReceptionService() {
        return haveLateReceptionService;
    }

    public void setHaveLateReceptionService(Boolean haveLateReceptionService) {
        this.haveLateReceptionService = haveLateReceptionService;
    }

    public Boolean getHaveBusService() {
        return haveBusService;
    }

    public void setHaveBusService(Boolean haveBusService) {
        this.haveBusService = haveBusService;
    }

    public Boolean getHaveSaturdayService() {
        return haveSaturdayService;
    }

    public void setHaveSaturdayService(Boolean haveSaturdayService) {
        this.haveSaturdayService = haveSaturdayService;
    }

    public NurserySchool() {

    }

    public NurserySchool(String name, String address, String avatar, String phoneNumber, String acceptChildrenAge,
            String tuition, String introduce, String methodsOfEducationIntroduce, String infrastructureIntroduce,
            String teachersIntroduce, String nutritionIntroduce, Boolean haveSwimmingPool,
            Boolean haveOutdoorPlayground, Boolean haveIndoorPlayground, Boolean haveLibrary,
            Boolean haveMonitoringCamera, Boolean haveBreadfastService, Boolean haveLateReceptionService,
            Boolean haveBusService, Boolean haveSaturdayService) {
        this.name = name;
        this.address = address;
        this.avatar = avatar;
        this.phoneNumber = phoneNumber;
        this.acceptChildrenAge = acceptChildrenAge;
        this.tuition = tuition;
        this.introduce = introduce;
        this.methodsOfEducationIntroduce = methodsOfEducationIntroduce;
        this.infrastructureIntroduce = infrastructureIntroduce;
        this.teachersIntroduce = teachersIntroduce;
        this.nutritionIntroduce = nutritionIntroduce;
        this.haveSwimmingPool = haveSwimmingPool;
        this.haveOutdoorPlayground = haveOutdoorPlayground;
        this.haveIndoorPlayground = haveIndoorPlayground;
        this.haveLibrary = haveLibrary;
        this.haveMonitoringCamera = haveMonitoringCamera;
        this.haveBreadfastService = haveBreadfastService;
        this.haveLateReceptionService = haveLateReceptionService;
        this.haveBusService = haveBusService;
        this.haveSaturdayService = haveSaturdayService;
    }

    public Ward getWard() {
        return ward;
    }

    public void setWard(Ward ward) {
        this.ward = ward;
    }

    public SchoolType getSchoolType() {
        return schoolType;
    }

    public void setSchoolType(SchoolType schoolType) {
        this.schoolType = schoolType;
    }

    public List<Image> getListImg() {
        return listImg;
    }

    public void setListImg(List<Image> listImg) {
        this.listImg = listImg;
    }

    public List<Comment> getComments() {
        return comments;
    }

    public void setComments(List<Comment> comments) {
        this.comments = comments;
    }

    public List<Review> getReviews() {
        return reviews;
    }

    public void setReviews(List<Review> reviews) {
        this.reviews = reviews;
    }

    public NurserySchool(String name, String address, Ward ward, String phoneNumber, String tuition,
            SchoolType schoolType, String avatar) {
        this.name = name;
        this.address = address;
        this.ward = ward;
        this.phoneNumber = phoneNumber;
        this.tuition = tuition;
        this.schoolType = schoolType;
        this.avatar = avatar;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public List<Ranking> getRanking() {
        return ranking;
    }

    public void setRanking(List<Ranking> ranking) {
        this.ranking = ranking;
    }

    // public List<Comment> getListComment() {
    // return listComment;
    // }

    // public void setListComment(List<Comment> listComment) {
    // this.listComment = listComment;
    // }

    // public List<Review> getListReview() {
    // return listReview;
    // }

    // public void setListReview(List<Review> listReview) {
    // this.listReview = listReview;
    // }

}
