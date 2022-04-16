package com.nguyennhatminh614.lifewearfashionshopapp.Presenter.RegisterUseCase;

import com.nguyennhatminh614.lifewearfashionshopapp.Model.AccountModel;
import com.nguyennhatminh614.lifewearfashionshopapp.util.ILogicCase;

public interface IRegister {
    interface View extends ILogicCase {

    }

    interface Presenter{
        void onHandleRegister(AccountModel accountModel);
    }
}
