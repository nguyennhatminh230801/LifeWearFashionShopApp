package com.nguyennhatminh614.lifewearfashionshopapp.Presenter.LoginUseCase;

import com.google.gson.Gson;
import com.nguyennhatminh614.lifewearfashionshopapp.Model.TempAccountModel;
import com.nguyennhatminh614.lifewearfashionshopapp.util.api.APIService;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class LoginPresenter implements ILogin.Presenter{
    private ILogin.View mView;

    public void setLogicForView(ILogin.View mView) {
        this.mView = mView;
    }

    @Override
    public void onHandleLogin(TempAccountModel tempAccountModel) {
        APIService.apiService.loginMethod(tempAccountModel).enqueue(new Callback<ResponseBody>() {
            @Override
            public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                mView.onLoginSuccess(response.code(), response.body());
            }

            @Override
            public void onFailure(Call<ResponseBody> call, Throwable t) {
                mView.onLoginFailure();
            }
        });
    }
}
