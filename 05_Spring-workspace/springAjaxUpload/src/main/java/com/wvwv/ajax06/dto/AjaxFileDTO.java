package com.wvwv.ajax06.dto;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

//client의 파라메터에 매핑하는 데이터클래스
public class AjaxFileDTO {
	private List<MultipartFile> images;

	public AjaxFileDTO() {
		super();
	}

	public AjaxFileDTO(List<MultipartFile> images) {
		super();
		this.images = images;
	}

	public List<MultipartFile> getImages() {
		return images;
	}

	public void setImages(List<MultipartFile> images) {
		this.images = images;
	}
	
}
