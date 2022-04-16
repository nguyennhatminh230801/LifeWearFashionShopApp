package com.nguyennhatminh614.lifewearfashionshopapp.Presenter.RegisterUseCase;

import com.nguyennhatminh614.lifewearfashionshopapp.Model.AccountDTO;

public interface IRegister {
    interface View{
        void RegisterSuccess();
        void RegisterFailure();
    }

    interface Presenter{
        void onHandleRegister(AccountDTO accountDTO);
    }
}
