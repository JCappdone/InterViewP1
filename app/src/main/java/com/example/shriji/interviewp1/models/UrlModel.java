package com.example.shriji.interviewp1.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class UrlModel {

    @SerializedName("site")
    @Expose
    private String site;
    @SerializedName("price")
    @Expose
    private Float price;
    @SerializedName("currency")
    @Expose
    private String currency;
    @SerializedName("url")
    @Expose
    private String url;
    @SerializedName("last_check")
    @Expose
    private String lastCheck;
    @SerializedName("in_stock")
    @Expose
    private Integer inStock;
    @SerializedName("change_day")
    @Expose
    private String changeDay;
    @SerializedName("weekly_avg")
    @Expose
    private String weeklyAvg;
    @SerializedName("monthly_avg")
    @Expose
    private String monthlyAvg;
    @SerializedName("last_changed")
    @Expose
    private String lastChanged;
    @SerializedName("old_price")
    @Expose
    private Integer oldPrice;

    public String getSite() {
        return site;
    }

    public void setSite(String site) {
        this.site = site;
    }

    public Float getPrice() {
        return price;
    }

    public void setPrice(Float price) {
        this.price = price;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getLastCheck() {
        return lastCheck;
    }

    public void setLastCheck(String lastCheck) {
        this.lastCheck = lastCheck;
    }

    public Integer getInStock() {
        return inStock;
    }

    public void setInStock(Integer inStock) {
        this.inStock = inStock;
    }

    public String getChangeDay() {
        return changeDay;
    }

    public void setChangeDay(String changeDay) {
        this.changeDay = changeDay;
    }

    public String getWeeklyAvg() {
        return weeklyAvg;
    }

    public void setWeeklyAvg(String weeklyAvg) {
        this.weeklyAvg = weeklyAvg;
    }

    public String getMonthlyAvg() {
        return monthlyAvg;
    }

    public void setMonthlyAvg(String monthlyAvg) {
        this.monthlyAvg = monthlyAvg;
    }

    public String getLastChanged() {
        return lastChanged;
    }

    public void setLastChanged(String lastChanged) {
        this.lastChanged = lastChanged;
    }

    public Integer getOldPrice() {
        return oldPrice;
    }

    public void setOldPrice(Integer oldPrice) {
        this.oldPrice = oldPrice;
    }

    @Override
    public String toString() {
        return url;
    }
}