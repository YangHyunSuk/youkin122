package com.naver.dbtjd122.dao;

import java.util.List;

import com.naver.dbtjd122.domain.Product;

public interface ProductDAO {
public void insert(Product product);
	
	public List<Product> list();
	
	public Product detail(String id);
	
	public void delete(String id);
	
	public void updateProduct(Product product);


}
