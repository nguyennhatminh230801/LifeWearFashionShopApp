package com.nguyennhatminh614.lifewearfashionshopapp.Model;

import com.google.gson.annotations.SerializedName;

public class CategoryModel {
    @SerializedName("id")
    private int id;

    @SerializedName("parent_id")
    private Integer parent_id;

    @SerializedName("slug")
    private String slug;

    @SerializedName("name")
    private String name;

    public CategoryModel() {
    }

    public CategoryModel(int id, Integer parent_id, String slug, String name) {
        this.id = id;
        this.parent_id = parent_id;
        this.slug = slug;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Integer getParent_id() {
        return parent_id;
    }

    public void setParent_id(Integer parent_id) {
        this.parent_id = parent_id;
    }

    public String getSlug() {
        return slug;
    }

    public void setSlug(String slug) {
        this.slug = slug;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "CategoryModel{" +
                "id=" + id +
                ", parent_id=" + parent_id +
                ", slug='" + slug + '\'' +
                ", name='" + name + '\'' +
                '}';
    }
}
