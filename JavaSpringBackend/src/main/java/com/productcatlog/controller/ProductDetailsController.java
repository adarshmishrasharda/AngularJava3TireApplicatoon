package com.productcatlog.controller;

import java.util.Base64;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.productcatlog.pojo.ProductData;
import com.productcatlog.pojo.TestString;
import com.productcatlog.services.ProductService;

@RestController
@RequestMapping("/product")
@CrossOrigin("*")
public class ProductDetailsController {
	
	@Autowired
	private ProductService productService;
	
	@PostMapping("/data")
	public ProductData productData(@RequestBody ProductData pdata) throws Exception
	{
		
		return this.productService.createProduct(pdata);
		
		
	}
	//public ProductData productData(@RequestBody ProductData pdata) throws Exception

	//get product by id
	@GetMapping("/{id}")
	public ProductData getUser(@PathVariable("id") String productid)
	{
		System.out.println("enter into product controller id controller");
		System.out.println("productId is"+productid);
		ProductData data= this.productService.getproduct(productid);
		System.out.println("whole data for given id is"+data);
		
//        String encodeBase64;
//        encodeBase64 = Base64.getEncoder().encodeToString(data.getProductimage());
//        TestString testStr = new TestString();
//        testStr.setTestString(encodeBase64);
		//System.out.println("whole data for given id is"+data);
        //System.out.println("Image string is "+testStr);
		return data;
	}
	
	// all product in database
	
	@GetMapping("/getall")
	public List<ProductData> getAllData()
	{
		return this.productService.getAll();
		
	}
	
	@GetMapping("/search/{name}")
	public List<ProductData> getSearchData(@PathVariable("name") String sadata)
	{
		System.out.println("inside search thae vale of pth varable is...."+sadata);
		List<ProductData> sedata = this.productService.searchresult(sadata);
		return sedata;
	}
	

}
