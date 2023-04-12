package com.productcatlog.services;

import java.util.List;

import com.productcatlog.pojo.ProductData;

public interface ProductService {
	
	//create product
     public ProductData createProduct(ProductData user) throws Exception;
     
    //get product by id
 	
 	public ProductData getproduct(String productid);
 	
 	//get all data 
 	
 	public List<ProductData> getAll();
 	
 	public List<ProductData> searchresult(String sdata);
		

}
