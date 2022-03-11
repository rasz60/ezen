package com.wvwv.sslex01.dto;

public class JoinDto {
	private String pId;
	private String pPw;
	private String pAddress;
	private String pHobby;
	private String pProfile;
	
	public JoinDto() {
		super();
	}
	
	public JoinDto(String pId, String pPw, String pAddress, String pHobby, String pProfile) {
		super();
		this.pId = pId;
		this.pPw = pPw;
		this.pAddress = pAddress;
		this.pHobby = pHobby;
		this.pProfile = pProfile;
	}
	
	public String getpId() {
		return pId;
	}
	
	public void setpId(String pId) {
		this.pId = pId;
	}
	
	public String getpPw() {
		return pPw;
	}
	
	public void setpPw(String pPw) {
		this.pPw = pPw;
	}
	
	public String getpAddress() {
		return pAddress;
	}
	
	public void setpAddress(String pAddress) {
		this.pAddress = pAddress;
	}
	
	public String getpHobby() {
		return pHobby;
	}
	
	public void setpHobby(String pHobby) {
		this.pHobby = pHobby;
	}
	
	public String getpProfile() {
		return pProfile;
	}
	
	public void setpProfile(String pProfile) {
		this.pProfile = pProfile;
	}

}
