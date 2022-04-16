package com.nguyennhatminh614.lifewearfashionshopapp.View;

import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;
import androidx.appcompat.widget.AppCompatCheckBox;

import com.google.android.material.textfield.TextInputLayout;
import com.nguyennhatminh614.lifewearfashionshopapp.Model.TempAccountModel;
import com.nguyennhatminh614.lifewearfashionshopapp.Presenter.LoginUseCase.ILogin;
import com.nguyennhatminh614.lifewearfashionshopapp.Presenter.LoginUseCase.LoginPresenter;
import com.nguyennhatminh614.lifewearfashionshopapp.R;

public class LoginActivity extends AppCompatActivity {
    TextView txtPassword_note, txtUsername_note;
    TextInputLayout txtUsername, txtPassword;
    AppCompatCheckBox chkSavePassword;
    AppCompatButton btnLogin, btnForgetPassword;
    LoginPresenter mLoginPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        getMappingItem();
        registerPresenter();
        addEvents();
    }

    private void addEvents() {
        String username = txtUsername.getEditText().getText().toString();
        String password = txtPassword.getEditText().getText().toString();

        //Login Event
        btnLogin.setOnClickListener(view -> mLoginPresenter.onHandleLogin(new TempAccountModel(username, password, "android")));

        //Forget Password Event
        btnForgetPassword.setOnClickListener(view -> mLoginPresenter.onForgetPasswordEvent(username));
    }

    private void registerPresenter() {
        mLoginPresenter = new LoginPresenter();

        mLoginPresenter.setLogicForView(new ILogin.View() {
            @Override
            public void onEventSuccess() {
                Toast.makeText(getBaseContext(), "Đăng Nhập Thành Công", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onEventError() {
                Toast.makeText(getBaseContext(), "Đăng Nhập Thất Bại", Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void getMappingItem() {
        txtPassword_note = findViewById(R.id.txtPassword_note);
        txtUsername_note = findViewById(R.id.txtUsername_note);
        txtUsername = findViewById(R.id.txtUsername);
        txtPassword = findViewById(R.id.txtPassword);
        chkSavePassword = findViewById(R.id.chkSavePassword);
        btnLogin = findViewById(R.id.btnLogin);
        btnForgetPassword = findViewById(R.id.btnForgetPassword);
    }
}