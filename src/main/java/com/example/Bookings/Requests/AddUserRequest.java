package com.example.Bookings.Requests;

public class AddUserRequest {
    private String name;
    private Integer age;
    private String emailId;
    private String mobileNo;

    // Constructor
    public AddUserRequest() {}

    public AddUserRequest(String name, Integer age, String emailId, String mobileNo) {
        this.name = name;
        this.age = age;
        this.emailId = emailId;
        this.mobileNo = mobileNo;
    }

    // Getter and Setter methods
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getEmailId() {
        return emailId;
    }

    public void setEmailId(String emailId) {
        this.emailId = emailId;
    }

    public String getMobileNo() {
        return mobileNo;
    }

    public void setMobileNo(String mobileNo) {
        this.mobileNo = mobileNo;
    }
}
