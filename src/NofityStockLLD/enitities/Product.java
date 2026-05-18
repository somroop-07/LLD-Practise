package NofityStockLLD.enitities;

import NofityStockLLD.enums.ProductType;

public class Product {
	
     String productId;
     String productName;
     ProductType productType;
     int stock;
     
	 public Product(String productId, String productName, ProductType productType, int stock) {
		super();
		this.productId = productId;
		this.productName = productName;
		this.productType = productType;
		this.stock = stock;
	 }
	 public String getProductId() {
		 return productId;
	 }
	 public void setProductId(String productId) {
		 this.productId = productId;
	 }
	 public String getProductName() {
		 return productName;
	 }
	 public void setProductName(String productName) {
		 this.productName = productName;
	 }
	 public ProductType getProductType() {
		 return productType;
	 }
	 public void setProductType(ProductType productType) {
		 this.productType = productType;
	 }
	 public int getStock() {
		 return stock;
	 }
	 public void setStock(int stock) {
		 this.stock = stock;
	 }
     
     
     
}
