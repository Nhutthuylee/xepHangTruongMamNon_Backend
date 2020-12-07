package com.example.xepHangTruongMamNon.Model.resp;

import java.util.List;

public class CustomerGetSchoolResponse {
    private int id;
    private String name;
    private String address;
    private String phoneNumber;
    private String schoolType;
    private String acceptChildrenAge;
    private String tuition;
    private String introduce;
    private String methodsOfEducationIntroduce;
    private String infrastructureIntroduce;
    private String teachersIntroduce;
    private String nutritionIntroduce;
    private Boolean haveSwimmingPool;
    private Boolean haveOutdoorPlayground;
    private Boolean haveIndoorPlayground;
    private Boolean haveLibrary;
    private Boolean haveMonitoringCamera;
    private Boolean haveBreadfastService;
    private Boolean haveLateReceptionService;
    private Boolean haveBusService;
    private Boolean haveSaturdayService;
    private String avatar;
    private List<CustomerGetAllImageSchool> listImage;

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

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public List<CustomerGetAllImageSchool> getListImage() {
        return listImage;
    }

    public void setListImage(List<CustomerGetAllImageSchool> listImage) {
        this.listImage = listImage;
    }

    // public CustomerGetSchoolResponse(int id, String name, String address, String
    // phoneNumber, String acceptChildrenAge,
    // String tuition, String introduce, String methodsOfEducationIntroduce, String
    // infrastructureIntroduce,
    // String teachersIntroduce, String nutritionIntroduce, Boolean
    // haveSwimmingPool,
    // Boolean haveOutdoorPlayground, Boolean haveIndoorPlayground, Boolean
    // haveLibrary,
    // Boolean haveMonitoringCamera, Boolean haveBreadfastService, Boolean
    // haveLateReceptionService,
    // Boolean haveBusService, Boolean haveSaturdayService,
    // List<CustomerGetAllCommentForSchool> listComment,
    // String avatar, List<CustomerGetAllImageSchool> listImage) {
    // this.id = id;
    // this.name = name;
    // this.address = address;
    // this.phoneNumber = phoneNumber;
    // this.acceptChildrenAge = acceptChildrenAge;
    // this.tuition = tuition;
    // this.introduce = introduce;
    // this.methodsOfEducationIntroduce = methodsOfEducationIntroduce;
    // this.infrastructureIntroduce = infrastructureIntroduce;
    // this.teachersIntroduce = teachersIntroduce;
    // this.nutritionIntroduce = nutritionIntroduce;
    // this.haveSwimmingPool = haveSwimmingPool;
    // this.haveOutdoorPlayground = haveOutdoorPlayground;
    // this.haveIndoorPlayground = haveIndoorPlayground;
    // this.haveLibrary = haveLibrary;
    // this.haveMonitoringCamera = haveMonitoringCamera;
    // this.haveBreadfastService = haveBreadfastService;
    // this.haveLateReceptionService = haveLateReceptionService;
    // this.haveBusService = haveBusService;
    // this.haveSaturdayService = haveSaturdayService;
    // this.listComment = listComment;
    // this.avatar = avatar;
    // this.listImage = listImage;
    // }

    public String getSchoolType() {
        return schoolType;
    }

    public void setSchoolType(String schoolType) {
        this.schoolType = schoolType;
    }

    public CustomerGetSchoolResponse(int id, String name, String address, String phoneNumber, String schoolType,
            String acceptChildrenAge, String tuition, String introduce, String methodsOfEducationIntroduce,
            String infrastructureIntroduce, String teachersIntroduce, String nutritionIntroduce,
            Boolean haveSwimmingPool, Boolean haveOutdoorPlayground, Boolean haveIndoorPlayground, Boolean haveLibrary,
            Boolean haveMonitoringCamera, Boolean haveBreadfastService, Boolean haveLateReceptionService,
            Boolean haveBusService, Boolean haveSaturdayService, String avatar,
            List<CustomerGetAllImageSchool> listImage) {
        this.id = id;
        this.name = name;
        this.address = address;
        this.phoneNumber = phoneNumber;
        this.schoolType = schoolType;
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
        this.avatar = avatar;
        this.listImage = listImage;
    }
}
