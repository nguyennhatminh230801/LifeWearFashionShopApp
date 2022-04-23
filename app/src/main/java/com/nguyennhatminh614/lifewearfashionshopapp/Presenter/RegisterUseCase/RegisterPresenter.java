package com.nguyennhatminh614.lifewearfashionshopapp.Presenter.RegisterUseCase;

import com.nguyennhatminh614.lifewearfashionshopapp.Model.AccountModel;
import com.nguyennhatminh614.lifewearfashionshopapp.util.api.APIService;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class RegisterPresenter implements IRegister.Presenter{
    private IRegister.View mRegisterView;

    public void setLogicForView(IRegister.View mRegisterView) {
        this.mRegisterView = mRegisterView;
    }

    @Override
    public void onHandleRegister(AccountModel accountModel) {
        APIService.apiService.registerMethod(accountModel).enqueue(new Callback<AccountModel>() {
            @Override
            public void onResponse(Call<AccountModel> call, Response<AccountModel> response) {

            }

            @Override
            public void onFailure(Call<AccountModel> call, Throwable t) {

            }
        });
    }
}
