package com.nguyennhatminh614.lifewearfashionshopapp.Presenter.RegisterUseCase;

import com.nguyennhatminh614.lifewearfashionshopapp.Model.AccountDTO;
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
    public void onHandleRegister(AccountDTO accountDTO) {
        APIService.apiService.registerMethod(accountDTO).enqueue(new Callback<AccountDTO>() {
            @Override
            public void onResponse(Call<AccountDTO> call, Response<AccountDTO> response) {
                mRegisterView.RegisterSuccess();
            }

            @Override
            public void onFailure(Call<AccountDTO> call, Throwable t) {
                mRegisterView.RegisterFailure();
            }
        });
    }
}
