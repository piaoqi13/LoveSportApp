package com.touna.lovesportapp.model;

/**
 * created by collin on 2015-12-16.
 */
public class CoachInfo {
    private String url = null;
    private String name = null;
    private String fromStadium = null;
    private String price = null;

    public CoachInfo(String url, String name, String fromStadium, String price) {
        this.url = url;
        this.name = name;
        this.fromStadium = fromStadium;
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

    public String getFromStadium() {
        return fromStadium;
    }

    public void setFromStadium(String fromStadium) {
        this.fromStadium = fromStadium;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }
}
