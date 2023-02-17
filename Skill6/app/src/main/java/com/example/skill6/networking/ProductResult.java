package com.example.skill6.networking;

import com.google.gson.annotations.SerializedName;

public class ProductResult {
    @SerializedName("id")
    int id;

    @SerializedName("title")
    String title;
    @SerializedName("product")
    String product;
    @SerializedName("image")
    String image;

    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getProduct() {
        return product;
    }

    public String getImage() {
        return image;
    }
}
