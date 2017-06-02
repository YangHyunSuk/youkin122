package com.naver.mongodata.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.naver.mongodata.vo.Product;

public interface ProductService {
//서비스의 매개변수는 Controller의 파라미터를 넘겨받는 방법에 의해 결정 
public void insert(HttpServletRequest request);

public List<Product>list();


public Product detail(String id);


public void delete(String id);
//수정처리;
public void update(Product product);
}

