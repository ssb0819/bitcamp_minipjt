package com.model2.mvc.common;

public class UploadFile {
	
	private String originFileName;
	private String saveFileName;
	private int prodNo;
	
	
	public String getOriginFileName() {
		return originFileName;
	}
	public void setOriginFileName(String originFileName) {
		this.originFileName = originFileName;
	}
	public String getSaveFileName() {
		return saveFileName;
	}
	public void setSaveFileName(String saveFileName) {
		this.saveFileName = saveFileName;
	}
	public int getProdNo() {
		return prodNo;
	}
	public void setProdNo(int prodNo) {
		this.prodNo = prodNo;
	}
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "UploadFile : originFileName = "+originFileName+"saveFileName = "+saveFileName;
	}
		
}
