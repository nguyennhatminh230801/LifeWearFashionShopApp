package com.nguyennhatminh614.lifewearfashionshopapp.Model;

import com.google.gson.annotations.SerializedName;

public class ImageModel {
    @SerializedName("id")
    private int id;

    @SerializedName("image")
    private String imageLink;

    public ImageModel() {
    }

    public ImageModel(int id, String imageLink) {
        this.id = id;
        this.imageLink = imageLink;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getImageLink() {
        return imageLink;
    }

    public void setImageLink(String imageLink) {
        this.imageLink = imageLink;
    }

    @Override
    public String toString() {
        return "ImageModel{" +
                "id=" + id +
                ", imageLink='" + imageLink + '\'' +
                '}';
    }
}
