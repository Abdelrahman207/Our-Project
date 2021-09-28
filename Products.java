
package com.store.dal.entity;


public class Products {
    private int productId ;
    private String productName ;
    private int productPrice ; 
    private int productQuantity ;
    private Country productCountry ;

    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public int getProductPrice() {
        return productPrice;
    }

    public void setProductPrice(int productPrice) {
        this.productPrice = productPrice;
    }

    public int getProductQuantity() {
        return productQuantity;
    }

    public void setProductQuantity(int productQuantity) {
        this.productQuantity = productQuantity;
    }

    public Country getProductCountry() {
        return productCountry;
    }

    public void setProductCountry(Country productCountry) {
        this.productCountry = productCountry;
    }
    
    
    
}
