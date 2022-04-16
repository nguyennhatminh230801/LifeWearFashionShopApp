package com.nguyennhatminh614.lifewearfashionshopapp.Presenter.LoginUseCase;

import com.google.gson.annotations.SerializedName;

public class FailureLoginResponseModel {
    @SerializedName("message")
    private String message;

    @SerializedName("errors")
    private ErrorsLoginModel1 loginModel;
}
