package com.naver.mongodata.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Repository;

import com.naver.mongodata.vo.Product;
@Repository
public class ProductDAOImpl implements ProductDAO {
@Autowired
//몽고 db 사용 
private  MongoTemplate mongoTemplate ;

@Override
	public void insert(Product product) {
	mongoTemplate.insert(product,"products");

	}

	@Override
	public List<Product> list() {
//프로덕트 가져와주세요  어디서 가져올껀데 프로덕트에서 
		return mongoTemplate.findAll(Product.class,"products");	
		}

	@Override
public Product detail(String id) {	
return mongoTemplate.findById(id, Product.class,"products");
	}

	@Override
	public void delete(String id) {
	Query query=new Query(new Criteria("Objectid").is(id));
mongoTemplate.remove(query,"products");
	
	}

	@Override
	public void updateProduct(Product product) {
		Query query=new Query(new Criteria("Objectid").is(product.getId()));
		Update update =new Update();
		update.set("name",product.getManufacture());
		update.set("category",product.getManufacture());
		update.set("manufacture",product.getManufacture());
		update.set("price",product.getManufacture());
	//products 컬렉션에서 quer에 맞는 데이터를 조회해서 update 내용으로 수정한다 
	mongoTemplate.updateFirst(query, update, "products");
	}

}
