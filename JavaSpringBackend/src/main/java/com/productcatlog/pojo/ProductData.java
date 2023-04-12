package com.productcatlog.pojo;

import java.util.Arrays;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "product_data")
public class ProductData {

	@Id
	private String productid;
	private String name;

	private String brand;

	private String price;

	private String size;
	private String review;
	private String inStock;
	private String color;

	@OneToMany(targetEntity = ProductPincode.class, cascade = CascadeType.ALL)
	@JoinColumn(name = "prid_fk", referencedColumnName = "productid")
	private List<ProductPincode> pincode;

	@Lob
	private byte[] productimage;

	public ProductData() {
		super();
		// TODO Auto-generated constructor stub
	}

	public ProductData(String productid, String name, String brand, String price, String size, String review,
			String inStock, String color, List<ProductPincode> pincode, byte[] productimage) {
		super();
		this.productid = productid;
		this.name = name;
		this.brand = brand;
		this.price = price;
		this.size = size;
		this.review = review;
		this.inStock = inStock;
		this.color = color;
		this.pincode = pincode;
		this.productimage = productimage;
	}

	public String getProductid() {
		return productid;
	}

	public void setProductid(String productid) {
		this.productid = productid;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

	public String getPrice() {
		return price;
	}

	public void setPrice(String price) {
		this.price = price;
	}

	public String getSize() {
		return size;
	}

	public void setSize(String size) {
		this.size = size;
	}

	public String getReview() {
		return review;
	}

	public void setReview(String review) {
		this.review = review;
	}

	public String getInStock() {
		return inStock;
	}

	public void setInStock(String inStock) {
		this.inStock = inStock;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public List<ProductPincode> getPincode() {
		return pincode;
	}

	public void setPincode(List<ProductPincode> pincode) {
		this.pincode = pincode;
	}

	public byte[] getProductimage() {
		return productimage;
	}

	public void setProductimage(byte[] productimage) {
		this.productimage = productimage;
	}

	@Override
	public String toString() {
		return "ProductData [productid=" + productid + ", name=" + name + ", brand=" + brand + ", price=" + price
				+ ", size=" + size + ", review=" + review + ", inStock=" + inStock + ", color=" + color + ", pincode="
				+ pincode + ", productimage=" + Arrays.toString(productimage) + "]";
	}
	
	
	
	
	

}
