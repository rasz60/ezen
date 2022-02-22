package com.wvwv.ch23_ex02;

//데이터 클래스(Bean 클래스)
public class MemberInfo {
	private String name;
	private String id;
	private String pwd;
	
	public MemberInfo() {
		super();
	}
	
	public MemberInfo(String name, String id, String pwd) {
		super();
		this.name = name;
		this.id = id;
		this.pwd = pwd;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getId() {
		return id;
	}
	
	public void setId(String id) {
		this.id = id;
	}
	
	public String getPwd() {
		return pwd;
	}
	
	public void setPwd(String pwd) {
		this.pwd = pwd;
	}
	
	
}
