package com.naver.dbtjd122.domain;

import org.springframework.web.multipart.MultipartFile;

public class UserDTO {
private String name;
private String pw;
private String id;
//Spring 에서는 file 객체를 MultipartFrile 로받을수 있다 .
private MultipartFile image;
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
public String getPw() {
	return pw;
}
public void setPw(String pw) {
	this.pw = pw;
}
public String getId() {
	return id;
}
public void setId(String id) {
	this.id = id;
}
public MultipartFile getImage() {
	return image;
}
public void setImage(MultipartFile image) {
	this.image = image;
}
@Override
public String toString() {
	return "UserDTO [name=" + name + ", pw=" + pw + ", id=" + id + ", image=" + image + "]";
}	
}
