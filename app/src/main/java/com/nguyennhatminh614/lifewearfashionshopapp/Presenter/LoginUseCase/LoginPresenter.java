package com.nguyennhatminh614.lifewearfashionshopapp.Presenter.LoginUseCase;

import com.nguyennhatminh614.lifewearfashionshopapp.Model.Account;
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
    public void onHandleLogin(Account account) {
        APIService.apiService.loginMethod(account).enqueue(new Callback<Account>() {
            @Override
            public void onResponse(Call<Account> call, Response<Account> response) {
                mView.LoginSuccess();
            }

            @Override
            public void onFailure(Call<Account> call, Throwable t) {
                mView.LoginFailure();
            }
        });
    }

    @Override
    public void onValidateAccount(Account account) {

    }

    @Override
    public void onForgetPasswordEvent(String username) {

    }
}
