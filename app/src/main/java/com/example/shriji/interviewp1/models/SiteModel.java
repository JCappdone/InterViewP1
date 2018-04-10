package com.example.shriji.interviewp1.models;

import java.util.List;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class SiteModel {

    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("product_code")
    @Expose
    private String productCode;
    @SerializedName("product_cost")
    @Expose
    private String productCost;
    @SerializedName("min_price")
    @Expose
    private Float minPrice;
    @SerializedName("max_price")
    @Expose
    private Float maxPrice;
    @SerializedName("avg_price")
    @Expose
    private Float avgPrice;
    @SerializedName("smart_price")
    @Expose
    private Float smartPrice;
    @SerializedName("urls")
    @Expose
    private List<UrlModel> mUrlModels = null;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getProductCode() {
        return productCode;
    }

    public void setProductCode(String productCode) {
        this.productCode = productCode;
    }

    public String getProductCost() {
        return productCost;
    }

    public void setProductCost(String productCost) {
        this.productCost = productCost;
    }

    public Float getMinPrice() {
        return minPrice;
    }

    public void setMinPrice(Float minPrice) {
        this.minPrice = minPrice;
    }

    public Float getMaxPrice() {
        return maxPrice;
    }

    public void setMaxPrice(Float maxPrice) {
        this.maxPrice = maxPrice;
    }

    public Float getAvgPrice() {
        return avgPrice;
    }

    public void setAvgPrice(Float avgPrice) {
        this.avgPrice = avgPrice;
    }

    public Float getSmartPrice() {
        return smartPrice;
    }

    public void setSmartPrice(Float smartPrice) {
        this.smartPrice = smartPrice;
    }

    public List<UrlModel> getUrlModels() {
        return mUrlModels;
    }

    public void setUrlModels(List<UrlModel> urlModels) {
        this.mUrlModels = urlModels;
    }

}
