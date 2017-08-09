package com.test.dto;

public class BoardInfo {
private int biNum;
private String biTitle;
private String biContent;
private String biPwd;
private String creUsr;
private int dNum;
public int getdNum() {
	return dNum;
}
public void setdNum(int dNum) {
	this.dNum = dNum;
}
public void setBiTitle(String biTitle) {
	this.biTitle = biTitle;
}
public int getBiNum() {
	return biNum;
}
public void setBiNum(int biNum) {
	this.biNum = biNum;
}
public String getBiTitle() {
	return biTitle;
}
public void setBiTtitle(String biTtitle) {
	this.biTitle = biTtitle;
}
public String getBiContent() {
	return biContent;
}
public void setBiContent(String biContent) {
	this.biContent = biContent;
}
public String getBiPwd() {
	return biPwd;
}
public void setBiPwd(String biPwd) {
	this.biPwd = biPwd;
}
public String getCreUsr() {
	return creUsr;
}
public void setCreUsr(String creUsr) {
	this.creUsr = creUsr;
}

}
