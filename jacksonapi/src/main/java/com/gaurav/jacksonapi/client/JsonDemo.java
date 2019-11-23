package com.gaurav.jacksonapi.client;

import com.gaurav.jacksonapi.domain.Product;
import com.gaurav.jacksonapi.util.JsonUtil;

public class JsonDemo {

	public static void main(String[] args) {
		
			Product product=new Product();
			product.setProductId(1001);
			product.setProductName("Laptop");
			product.setProductPrice(45000);
			// Convert java object to Json
			String jsonProduct=JsonUtil.convertJavaToJson(product);
			System.out.println("Json Format : "+jsonProduct);
			System.out.println("================================================================");
			
			// Convert Json object to java
			Product prod=JsonUtil.convertJsonToJava(jsonProduct,Product.class);
			System.out.println("Product Id : "+prod.getProductId()+", Product Name : "+prod.getProductName()
			+", Product Price : "+prod.getProductPrice());
	}
}
