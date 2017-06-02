package com.naver.mongodata.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.naver.mongodata.dao.ProductDAO;
import com.naver.mongodata.vo.Product;
@Service
public class ProductServiceImpl implements ProductService {
@Autowired
//실제 업무는 DAO가 엄청많기 떄문에  인터페이스 이름 먼저쓰고 소문자나 대문자로 바꿔서 사용을 꼭해야한다 
private ProductDAO productDAO;
	@Override
	public void insert(HttpServletRequest request) {
		// TODO Auto-generated method stub

		//Controller가 넘겨준 매개변수를 가지고 DAO의 파라미터를 만든후 결과를 전달하는역활
		String name = request.getParameter("name");
		String manufacture = request.getParameter("manufacture");
		String category = request.getParameter("category");
		int price = Integer.parseInt(request.getParameter("price"));
		
		Product product = new Product();
		product.setName(name);
		product.setManufacture(manufacture);
		product.setCategory(category);
		product.setPrice(price);
				
		productDAO.insert(product);
		
	}
@Override
public List<Product> list() {
return productDAO.list();
	}
@Override
public Product detail(String id) {
return productDAO.detail(id);
}
@Override
public void delete(String id) {
	productDAO.delete(id);
	
}
@Override
public void update(Product product) {
	productDAO.updateProduct(product);
}
}
