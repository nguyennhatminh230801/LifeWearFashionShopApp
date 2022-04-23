package com.nguyennhatminh614.lifewearfashionshopapp.Presenter.RegisterUseCase;

import com.nguyennhatminh614.lifewearfashionshopapp.Model.AccountModel;

public interface IRegister {
    interface View {

    }

    interface Presenter{
        void onHandleRegister(AccountModel accountModel);
    }
}
