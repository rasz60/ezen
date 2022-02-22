package com.wvwv.jspMVC.DTO;

import java.sql.Timestamp;

public class BDto {
	// DB column과 동일한 이름의 변수 생성
	private int bId, bHit,  bStep, bIndent, bGroup;
	private String bName, bTitle, bContent;
	private Timestamp bDate;

	public BDto() {
		super();
	}

	public BDto(int bHit, int bStep, int bIndent, int bId, String bName, String bTitle, int bGroup, String bContent, Timestamp bDate) {
		super();
		this.bHit = bHit;
		this.bStep = bStep;
		this.bIndent = bIndent;
		this.bId = bId;
		this.bName = bName;
		this.bTitle = bTitle;
		this.bGroup = bGroup;
		this.bContent = bContent;
		this.bDate = bDate;
	}

	public int getbHit() {
		return bHit;
	}

	public void setbHit(int bHit) {
		this.bHit = bHit;
	}

	public int getbStep() {
		return bStep;
	}

	public void setbStep(int bStep) {
		this.bStep = bStep;
	}

	public int getbIndent() {
		return bIndent;
	}

	public void setbIndent(int bIndent) {
		this.bIndent = bIndent;
	}

	public int getbId() {
		return bId;
	}

	public void setbId(int bId) {
		this.bId = bId;
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

	public int getbGroup() {
		return bGroup;
	}

	public void setbGroup(int bGroup) {
		this.bGroup = bGroup;
	}

	public String getbContent() {
		return bContent;
	}

	public void setbContent(String bContent) {
		this.bContent = bContent;
	}

	public Timestamp getbDate() {
		return bDate;
	}

	public void setbDate(Timestamp bDate) {
		this.bDate = bDate;
	}
		
}
