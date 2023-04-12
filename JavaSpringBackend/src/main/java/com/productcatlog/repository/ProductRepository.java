package com.productcatlog.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.productcatlog.pojo.ProductData;

public interface ProductRepository extends JpaRepository<ProductData, String> {
	
	public ProductData findByProductid(String username);
	
	
	@Query("select u from ProductData u where u.name=:n or brand=:n or color=:n")
	public List<ProductData> getSearchData(@Param("n") String name);

}
