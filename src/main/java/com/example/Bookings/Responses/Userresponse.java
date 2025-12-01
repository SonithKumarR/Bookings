package com.example.Bookings.Responses;

public class Userresponse {

    private int userId;

    private String name;

    public Userresponse(int userId, String name, int age, String emailId, String mobileNo) {
		super();
		this.userId = userId;
		this.name = name;
		this.age = age;
		this.emailId = emailId;
		this.mobileNo = mobileNo;
	}
    
    public Userresponse() {}

	private int age;

    private String emailId;

    private String mobileNo;

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
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
