package com.nguyennhatminh614.lifewearfashionshopapp.Presenter.LoginUseCase;

import com.nguyennhatminh614.lifewearfashionshopapp.Model.Account;

public interface ILogin {
    interface View{
        void LoginSuccess();
        void LoginFailure();
    }

    interface Presenter{
        void onHandleLogin(Account account);
        void onValidateAccount(Account account);
        void onForgetPasswordEvent(String username);
    }
}
