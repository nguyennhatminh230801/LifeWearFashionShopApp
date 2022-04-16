package com.nguyennhatminh614.lifewearfashionshopapp.View;

import android.annotation.SuppressLint;
import android.content.SharedPreferences;
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

import java.util.Objects;

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

    //Khi Activity chạy đến onStart sẽ thực hiện việc lấy tài khoản, mật khẩu đã lưu trong thiết bị
    @Override
    protected void onStart() {
        super.onStart();

        //Lấy thông tin tài khoản, mật khẩu được lưu trong thiết bị
        SharedPreferences sharedPreferences = getSharedPreferences("saveData", MODE_PRIVATE);
        String username = sharedPreferences.getString("username", null);
        String password = sharedPreferences.getString("password", null);

        //Nếu tài khoản và mật khẩu tồn tại trong thiết bị thì gán ngược lại vào trong View
        if (username != null && password != null){
            Objects.requireNonNull(txtPassword.getEditText()).setText(password);
            Objects.requireNonNull(txtUsername.getEditText()).setText(username);
        }
    }

    private void addEvents() {
        //Lấy thông tin tài khoản, mật khẩu
        String username = Objects.requireNonNull(txtUsername.getEditText()).getText().toString();
        String password = Objects.requireNonNull(txtPassword.getEditText()).getText().toString();

        //Sự kiện đăng nhập
        btnLogin.setOnClickListener(view -> {
            mLoginPresenter.onHandleLogin(new TempAccountModel(username, password, "android"));
        });

        //Sự kiện quên mật khẩu
        btnForgetPassword.setOnClickListener(view -> {});
    }

    @SuppressLint("CommitPrefEdits")
    private void registerPresenter() {
        mLoginPresenter = new LoginPresenter();

        mLoginPresenter.setLogicForView(new ILogin.View() {
            //Xảy ra khi gửi tài khoản lên hệ thống thành công
            @Override
            public void onEventSuccess() {
                Toast.makeText(getBaseContext(), "Đăng Nhập Thành Công", Toast.LENGTH_SHORT).show();

                //Nếu bấm vào "Lưu mật khẩu", thì sẽ lưu thông tin tài khoản vào thiết bị
                if(chkSavePassword.isChecked()){
                    SharedPreferences sharedPreferences = getSharedPreferences("saveData", MODE_PRIVATE);
                    SharedPreferences.Editor editor = sharedPreferences.edit();
                    editor.putString("username", Objects.requireNonNull(txtUsername.getEditText()).getText().toString()).apply();
                    editor.putString("password", Objects.requireNonNull(txtPassword.getEditText()).getText().toString()).apply();
                }
            }

            //Xảy ra khi gửi thông tin tài khoản lên hệ thống thất bại
            @Override
            public void onEventError() {
                Toast.makeText(getBaseContext(), "Đăng Nhập Thất Bại", Toast.LENGTH_SHORT).show();
            }
        });
    }

    //Ánh xạ (Mapping) các thành phần trong View sang Activity
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