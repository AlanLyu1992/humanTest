package com.iweb.nct.entity;

public class User {
	private int id;
	private String loginname;
	private String loginpass;
	private String uname;
	private String image;
	
	public User(){}
	public User(String loginname, String loginpass, String uname){
		this.loginname = loginname;
		this.loginpass = loginpass;
		this.uname = uname;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getLoginname() {
		return loginname;
	}
	public void setLoginname(String loginname) {
		this.loginname = loginname;
	}
	public String getLoginpass() {
		return loginpass;
	}
	public void setLoginpass(String loginpass) {
		this.loginpass = loginpass;
	}
	public String getUname() {
		return uname;
	}
	public void setUname(String uname) {
		this.uname = uname;
	}
	public String getImage() {
		return image;
	}
	public void setImage(String image) {
		this.image = image;
	}
	
	
}
