package com.nguyennhatminh614.lifewearfashionshopapp.Presenter.LoginUseCase;

import com.nguyennhatminh614.lifewearfashionshopapp.Model.TempAccountModel;
import com.nguyennhatminh614.lifewearfashionshopapp.util.ILogicCase;

public interface ILogin {
    interface View extends ILogicCase {

    }

    interface Presenter{
        void onHandleLogin(TempAccountModel tempAccountModel);
    }
}
