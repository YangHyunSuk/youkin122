package com.naver.mongodata.vo;

public class Product {
	private String id;
	private String manufacture;
	private String category;
	private String name;
	private Integer price;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getManufacture() {
		return manufacture;
	}
	public void setManufacture(String manufacture) {
		this.manufacture = manufacture;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Integer getPrice() {
		return price;
	}
	public void setPrice(Integer price) {
		this.price = price;
	}
	@Override
	public String toString() {
		return "Product [id=" + id + ", manufacture=" + manufacture + ", category=" + category + ", name=" + name
				+ ", price=" + price + "]";
	}
	

}
