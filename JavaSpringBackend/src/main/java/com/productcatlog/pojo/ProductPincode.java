package com.productcatlog.pojo;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class ProductPincode {
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long pinid;
	private String pincode;
	public ProductPincode() {
		super();
		// TODO Auto-generated constructor stub
	}
	public ProductPincode(Long pinid, String pincode) {
		super();
		this.pinid = pinid;
		this.pincode = pincode;
	}
	public Long getId() {
		return pinid;
	}
	public void setId(Long pinid) {
		this.pinid = pinid;
	}
	public String getPincode() {
		return pincode;
	}
	public void setPincode(String pincode) {
		this.pincode = pincode;
	}
	@Override
	public String toString() {
		return "ProductPincode [id=" + pinid + ", pincode=" + pincode + "]";
	}
	
	

}
