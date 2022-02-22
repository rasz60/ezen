package com.wvwv.ch08ex03;

public class AdminConnection {
	private String adminId;
	private String adminPw;
	private String subAdminId;
	private String subAdminPw;	
	
	public AdminConnection() {
		super();
	}
	
	public AdminConnection(String adminId, String adminPw, String subAdminId, String subAdminPw) {
		super();
		this.adminId = adminId;
		this.adminPw = adminPw;
		this.subAdminId = subAdminId;
		this.subAdminPw = subAdminPw;
	}

	public String getAdminId() {
		return adminId;
	}

	public void setAdminId(String adminId) {
		this.adminId = adminId;
	}

	public String getAdminPw() {
		return adminPw;
	}

	public void setAdminPw(String adminPw) {
		this.adminPw = adminPw;
	}
	
	public String getSubAdminPw() {
		return subAdminPw;
	}

	public void setSubAdminPw(String subAdminPw) {
		this.subAdminPw = subAdminPw;
	}

	public String getSubAdminId() {
		return subAdminId;
	}

	public void setSubAdminId(String subAdminId) {
		this.subAdminId = subAdminId;
	}

	@Override
	public String toString() {
		return "AdminConnection \n[adminId=" + adminId + ", adminPw=" + adminPw + " // subAdminId=" + subAdminId
				+ ", subAdminPw=" + subAdminPw + "]";
	}
	
	
}
