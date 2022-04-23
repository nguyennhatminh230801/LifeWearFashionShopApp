package com.nguyennhatminh614.lifewearfashionshopapp.Presenter.LoginUseCase;

import com.nguyennhatminh614.lifewearfashionshopapp.Model.TempAccountModel;

import okhttp3.ResponseBody;

public interface ILogin {
    interface View {
        void onLoginSuccess(int responseCode, ResponseBody requestBody);
        void onLoginFailure();
    }

    interface Presenter{
        void onHandleLogin(TempAccountModel tempAccountModel);
    }
}
