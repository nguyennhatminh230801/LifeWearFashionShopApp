package com.nguyennhatminh614.lifewearfashionshopapp.Model;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

public class Product {
    @SerializedName("id")
    private int id;

    @SerializedName("name")
    private String name;

    @SerializedName("slug")
    private String slug;

    @SerializedName("description")
    private String description;

    @SerializedName("status")
    private String status;

    @SerializedName("category_id")
    private String category_id;

    @SerializedName("brand_id")
    private String brand_id;

    @SerializedName("created_at")
    private String created_at;

    @SerializedName("updated_at")
    private String updated_at;

    @SerializedName("image")
    private ArrayList<ImageModel> listImages;

    @SerializedName("cover")
    private CoverModel coverModel;

    @SerializedName("category")
    private CategoryModel categoryModel;

    @SerializedName("brand")
    private BrandModel brandModel;

    public Product() {
    }

    public Product(int id, String name, String slug, String description, String status, String category_id, String brand_id, String created_at, String updated_at, ArrayList<ImageModel> listImages, CoverModel coverModel, CategoryModel categoryModel, BrandModel brandModel) {
        this.id = id;
        this.name = name;
        this.slug = slug;
        this.description = description;
        this.status = status;
        this.category_id = category_id;
        this.brand_id = brand_id;
        this.created_at = created_at;
        this.updated_at = updated_at;
        this.listImages = listImages;
        this.coverModel = coverModel;
        this.categoryModel = categoryModel;
        this.brandModel = brandModel;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSlug() {
        return slug;
    }

    public void setSlug(String slug) {
        this.slug = slug;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getCategory_id() {
        return category_id;
    }

    public void setCategory_id(String category_id) {
        this.category_id = category_id;
    }

    public String getBrand_id() {
        return brand_id;
    }

    public void setBrand_id(String brand_id) {
        this.brand_id = brand_id;
    }

    public String getCreated_at() {
        return created_at;
    }

    public void setCreated_at(String created_at) {
        this.created_at = created_at;
    }

    public String getUpdated_at() {
        return updated_at;
    }

    public void setUpdated_at(String updated_at) {
        this.updated_at = updated_at;
    }

    public ArrayList<ImageModel> getListImages() {
        return listImages;
    }

    public void setListImages(ArrayList<ImageModel> listImages) {
        this.listImages = listImages;
    }

    public CoverModel getCoverModel() {
        return coverModel;
    }

    public void setCoverModel(CoverModel coverModel) {
        this.coverModel = coverModel;
    }

    public CategoryModel getCategoryModel() {
        return categoryModel;
    }

    public void setCategoryModel(CategoryModel categoryModel) {
        this.categoryModel = categoryModel;
    }

    public BrandModel getBrandModel() {
        return brandModel;
    }

    public void setBrandModel(BrandModel brandModel) {
        this.brandModel = brandModel;
    }

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", slug='" + slug + '\'' +
                ", description='" + description + '\'' +
                ", status='" + status + '\'' +
                ", category_id='" + category_id + '\'' +
                ", brand_id='" + brand_id + '\'' +
                ", created_at='" + created_at + '\'' +
                ", updated_at='" + updated_at + '\'' +
                ", listImages=" + listImages +
                ", coverModel=" + coverModel +
                ", categoryModel=" + categoryModel +
                ", brandModel=" + brandModel +
                '}';
    }
}
