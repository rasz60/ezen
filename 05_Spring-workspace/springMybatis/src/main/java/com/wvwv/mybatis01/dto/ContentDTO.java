package com.wvwv.mybatis01.dto;

public class ContentDTO {
	private int mId;
	private String mWriter;
	private String mContent;

	public ContentDTO() {
		super();
	}
	
	public ContentDTO(int mId, String mWriter, String mContent) {
		this.mId = mId;
		this.mWriter = mWriter;
		this.mContent = mContent;
	}
	
	public int getmId() {
		return mId;
	}
	
	public void setmId(int mId) {
		this.mId = mId;
	}

	public String getmWriter() {
		System.out.println("get");
		return mWriter;
	}
	
	public void setmWriter(String mWriter) {
		this.mWriter = mWriter;
	}
	
	public String getmContent() {
		return mContent;
	}
	
	public void setmContent(String mContent) {
		this.mContent = mContent;
	}
	
}
