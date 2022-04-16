package com.nguyennhatminh614.lifewearfashionshopapp.Presenter.LoginUseCase;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

public class ErrorsLoginModel1 {
    @SerializedName("email")
    private ArrayList<String> listEmailValidateError;

    public ErrorsLoginModel1() {
    }

    public ErrorsLoginModel1(ArrayList<String> listEmailValidateError) {
        this.listEmailValidateError = listEmailValidateError;
    }

    public ArrayList<String> getListEmailValidateError() {
        return listEmailValidateError;
    }

    public void setListEmailValidateError(ArrayList<String> listEmailValidateError) {
        this.listEmailValidateError = listEmailValidateError;
    }


}
