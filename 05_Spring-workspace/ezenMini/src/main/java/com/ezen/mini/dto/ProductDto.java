package com.ezen.mini.dto;

public class ProductDto {
	private String rPhoto;
	private String rCuisine;
	private String rName;
	private String rTitle;
	private String rContent;
	
	public ProductDto() {
		super();
	}
	
	public ProductDto(String rPhoto, String rCuisine, String rName, String rTitle, String rContent) {
		super();
		this.rPhoto = rPhoto;
		this.rCuisine = rCuisine;
		this.rName = rName;
		this.rTitle = rTitle;
		this.rContent = rContent;
	}
	
	public String getrPhoto() {
		return rPhoto;
	}
	
	public void setrPhoto(String rPhoto) {
		this.rPhoto = rPhoto;
	}
	
	public String getrCuisine() {
		return rCuisine;
	}
	
	public void setrCuisine(String rCuisine) {
		this.rCuisine = rCuisine;
	}
	
	public String getrName() {
		return rName;
	}
	
	public void setrName(String rName) {
		this.rName = rName;
	}
	
	public String getrTitle() {
		return rTitle;
	}
	
	public void setrTitle(String rTitle) {
		this.rTitle = rTitle;
	}
	
	public String getrContent() {
		return rContent;
	}
	
	public void setrContent(String rContent) {
		this.rContent = rContent;
	}
	
}
