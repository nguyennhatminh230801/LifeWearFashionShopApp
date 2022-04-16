package com.nguyennhatminh614.lifewearfashionshopapp.Model;

import com.google.gson.annotations.SerializedName;

public class CoverModel {
    @SerializedName("id")
    private int id;

    @SerializedName("image")
    private String imageLink;

    public CoverModel() {
    }

    public CoverModel(int id, String imageLink) {
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
        return "CoverModel{" +
                "id=" + id +
                ", imageLink='" + imageLink + '\'' +
                '}';
    }
}
