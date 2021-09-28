package com.store.dal.entity;

public class Country {

    private int seqId;
    private Products product;
    private String countryName;
    private int productModel;
    private int productCountryQuantity;

    public int getSeqId() {
        return seqId;
    }

    public void setSeqId(int seqId) {
        this.seqId = seqId;
    }

    public Products getProduct() {
        return product;
    }

    public void setProduct(Products product) {
        this.product = product;
    }

    public String getCountryName() {
        return countryName;
    }

    public void setCountryName(String countryName) {
        this.countryName = countryName;
    }

    public int getProductModel() {
        return productModel;
    }

    public void setProductModel(int productModel) {
        this.productModel = productModel;
    }

    public int getProductCountryQuantity() {
        return productCountryQuantity;
    }

    public void setProductCountryQuantity(int productCountryQuantity) {
        this.productCountryQuantity = productCountryQuantity;
    }

}
