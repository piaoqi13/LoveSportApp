package com.touna.lovesportapp.model;

/**
 * created by collin on 2015-12-12.
 */
public class RecommendStadiumInfo {
    private String url = null;
    private String name = null;
    private String location = null;
    private String price = null;

    public RecommendStadiumInfo(String url, String name, String location, String price) {
        this.url = url;
        this.name = name;
        this.location = location;
        this.price = price;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }
}
