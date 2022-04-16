package com.nguyennhatminh614.lifewearfashionshopapp.Presenter.LoginUseCase;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class SuccessLoginResponseModel {
    @SerializedName("token")
    @Expose
    private String token;

    public SuccessLoginResponseModel() {
    }

    public SuccessLoginResponseModel(String token) {
        this.token = token;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    @Override
    public String toString() {
        return "SuccessLoginResponseModel{" +
                "token='" + token + '\'' +
                '}';
    }
}
