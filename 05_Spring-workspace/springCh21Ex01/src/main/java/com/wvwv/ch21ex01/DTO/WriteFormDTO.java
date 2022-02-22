package com.wvwv.ch21ex01.DTO;

public class WriteFormDTO {
	private String bName;
	private String bTitle;
	private String bContent;
	public WriteFormDTO() {}
	
	public WriteFormDTO(String bName, String bTitle, String bContent) {
		this.bName = bName;
		this.bTitle = bTitle;
		this.bContent = bContent;
	}
	public String getbName() {
		return bName;
	}
	public void setbName(String bName) {
		this.bName = bName;
	}
	public String getbTitle() {
		return bTitle;
	}
	public void setbTitle(String bTitle) {
		this.bTitle = bTitle;
	}
	public String getbContent() {
		return bContent;
	}
	public void setbContent(String bContent) {
		this.bContent = bContent;
	}
	
	
}
