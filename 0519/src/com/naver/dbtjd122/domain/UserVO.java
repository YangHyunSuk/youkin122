package com.naver.dbtjd122.domain;

public class UserVO {
private String id;
private String pw;
private String name;
private String image;


public String getImage() {
	return image;
}
public void setImage(String image) {
	this.image = image;
}
public String getId() {
	return id;
}
public void setId(String id) {
	this.id = id;
}
public String getPw() {
	return pw;
}
public void setPw(String pw) {
	this.pw = pw;
}
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
@Override
public String toString() {
	return "UserVO [id=" + id + ", pw=" + pw + ", name=" + name + ", image=" + image + "]";
}


}
