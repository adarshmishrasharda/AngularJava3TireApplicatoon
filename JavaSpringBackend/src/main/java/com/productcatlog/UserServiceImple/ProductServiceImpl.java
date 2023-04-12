package com.productcatlog.UserServiceImple;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.productcatlog.pojo.ProductData;
import com.productcatlog.repository.ProductRepository;
import com.productcatlog.services.ProductService;

@Service
public class ProductServiceImpl implements ProductService {
	
	
	@Autowired
	private ProductRepository productRepository;

	@Override
	public ProductData createProduct(ProductData pdata) throws Exception {
		// TODO Auto-generated method stub
		

		//ProductData localproduct=null;
 
	    ProductData localproduct=this.productRepository.findByProductid(pdata.getProductid());
		
		if(localproduct!=null)
		{
			System.out.println("product  already exist");
			throw new Exception("product al ready present with given id");
		}
		else
		{
			localproduct=this.productRepository.save(pdata);
		}
		
		
		return localproduct;
		
	}

	@Override
	public ProductData getproduct(String productid) {
		// TODO Auto-generated method stub
		System.out.println(productid);
		System.out.println("enter into product service imple");
		ProductData data=this.productRepository.findByProductid(productid);
		System.out.println("data of image value is"+data.getProductimage());
		return data;
	}

	@Override
	public List<ProductData> getAll() {
		// TODO Auto-generated method stub
		return this.productRepository.findAll();
	}

	@Override
	public List<ProductData> searchresult(String sdata) {
		// TODO Auto-generated method stub
		
		List<ProductData> serdata = this.productRepository.getSearchData(sdata);
		return serdata;
	}

}
