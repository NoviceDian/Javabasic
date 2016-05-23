package com.dian.entity;

import java.sql.Date;

//员工实体类
public class Employee {

	private Integer id;
	private String name;
	private char sex;
	private Date birth;
	private String phone;
	private String address;
	private Date joinTime;
	private String pwd;
	private Boolean isLeader;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public char getSex() {
		return sex;
	}
	public void setSex(char sex) {
		this.sex = sex;
	}
	public Date getBirth() {
		return birth;
	}
	public void setBirth(Date birth) {
		this.birth = birth;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public Date getJoinTime() {
		return joinTime;
	}
	public void setJoinTime(Date joinTime) {
		this.joinTime = joinTime;
	}
	public String getPwd() {
		return pwd;
	}
	public void setPwd(String pwd) {
		this.pwd = pwd;
	}
	public Boolean getIsLeader() {
		return isLeader;
	}
	public void setIsLeader(Boolean isLeader) {
		this.isLeader = isLeader;
	}
	
}
