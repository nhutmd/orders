package com.local.android.orders.model;

import com.google.gson.annotations.SerializedName;

public class Order {
    @SerializedName("code")
    private String code;
    @SerializedName("title")
    private String title;
    @SerializedName("image")
    private String image;
    @SerializedName("price")
    private String price;
    private String content;
    @SerializedName("address_from")
    private String addressFrom;
    @SerializedName("address_to")
    private String addressTo;
    @SerializedName("date")
    private String date;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getContent() {

        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getAddressFrom() {
        return addressFrom;
    }

    public void setAddressFrom(String addressFrom) {
        this.addressFrom = addressFrom;
    }

    public String getAddressTo() {
        return addressTo;
    }

    public void setAddressTo(String addressTo) {
        this.addressTo = addressTo;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }
}
