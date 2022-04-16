package com.nguyennhatminh614.lifewearfashionshopapp.Presenter.LoginUseCase;

import com.google.gson.annotations.SerializedName;

public class FailureLoginResponseModel {
    @SerializedName("message")
    private String message;

    @SerializedName("errors")
    private ErrorsLoginModel1 loginModel;

    public FailureLoginResponseModel() {
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public ErrorsLoginModel1 getLoginModel() {
        return loginModel;
    }

    public void setLoginModel(ErrorsLoginModel1 loginModel) {
        this.loginModel = loginModel;
    }

    @Override
    public String toString() {
        return "FailureLoginResponseModel{" +
                "message='" + message + '\'' +
                ", loginModel=" + loginModel +
                '}';
    }
}
