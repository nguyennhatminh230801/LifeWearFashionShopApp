package com.nguyennhatminh614.lifewearfashionshopapp.Presenter.LoginUseCase;

import com.google.gson.Gson;
import com.nguyennhatminh614.lifewearfashionshopapp.Model.TempAccountModel;
import com.nguyennhatminh614.lifewearfashionshopapp.util.api.APIService;

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
        APIService.apiService.loginMethod(tempAccountModel).enqueue(new Callback<TempAccountModel>() {
            //Xảy ra khi gửi dữ liệu tài khoản thành công
            @Override
            public void onResponse(Call<TempAccountModel> call, Response<TempAccountModel> response) {
                mView.onEventSuccess();
            }

            //Xảy ra khi gửi dữ liệu tài khoản thất bại
            @Override
            public void onFailure(Call<TempAccountModel> call, Throwable t) {
                mView.onEventError();
            }
        });
    }
}
