package com.nguyennhatminh614.lifewearfashionshopapp.View;

import android.Manifest;
import android.annotation.SuppressLint;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;
import androidx.appcompat.widget.AppCompatCheckBox;
import androidx.core.app.ActivityCompat;

import com.google.android.material.textfield.TextInputLayout;
import com.nguyennhatminh614.lifewearfashionshopapp.Model.TempAccountModel;
import com.nguyennhatminh614.lifewearfashionshopapp.Presenter.LoginUseCase.ILogin;
import com.nguyennhatminh614.lifewearfashionshopapp.Presenter.LoginUseCase.LoginPresenter;
import com.nguyennhatminh614.lifewearfashionshopapp.R;
import com.nguyennhatminh614.lifewearfashionshopapp.util.constant.HttpStatusCode;

import java.util.Objects;

import okhttp3.ResponseBody;

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

        //Gửi yêu cầu đọc thông tin điện thoại
        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.READ_PHONE_STATE) != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.READ_PHONE_STATE}, 101);
        }

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

        SharedPreferences sharedPreferences = getSharedPreferences("saveData", MODE_PRIVATE);
        String deviceName = sharedPreferences.getString("Device Name", "No Device");

        //Sự kiện đăng nhập
        btnLogin.setOnClickListener(view -> {
            mLoginPresenter.onHandleLogin(new TempAccountModel(username, password, deviceName));
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
            public void onLoginSuccess(int responseCode, ResponseBody requestBody) {

                if(responseCode == HttpStatusCode.OK.getValue()){
                    Toast.makeText(getBaseContext(), R.string.loginSuccess, Toast.LENGTH_SHORT).show();
                    SharedPreferences sharedPreferences = getSharedPreferences("saveData", MODE_PRIVATE);
                    SharedPreferences.Editor editor = sharedPreferences.edit();

                    //Nếu bấm vào "Lưu mật khẩu", thì sẽ lưu thông tin tài khoản vào thiết bị
                    if(chkSavePassword.isChecked()){

                        editor.putString("username", Objects.requireNonNull(txtUsername.getEditText()).getText().toString()).apply();
                        editor.putString("password", Objects.requireNonNull(txtPassword.getEditText()).getText().toString()).apply();
                    }
                }
                else if(responseCode == HttpStatusCode.UNPROCESSABLE_ENTITY.getValue()){

                }

            }

            //Xảy ra khi gửi thông tin tài khoản lên hệ thống thất bại
            @Override
            public void onLoginFailure() {
                Toast.makeText(getBaseContext(), R.string.loginFail, Toast.LENGTH_SHORT).show();
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

    @RequiresApi(api = Build.VERSION_CODES.O)
    @Override
    public void onRequestPermissionsResult(int requestCode, String[] permissions, int[] grantResults)   {
        switch (requestCode) {
            case 101:
                if (grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                if (ActivityCompat.checkSelfPermission(this, Manifest.permission.READ_PHONE_STATE) !=        PackageManager.PERMISSION_GRANTED) {
                    return;
                }
                    SharedPreferences sharedPreferences = getSharedPreferences("saveData", MODE_PRIVATE);
                    SharedPreferences.Editor editor = sharedPreferences.edit();

                    editor.putString("Device Name", Build.DEVICE);
            } else {
                //not granted
                    Toast.makeText(getBaseContext(), "Not granted", Toast.LENGTH_SHORT).show();
            }
            break;
            default:
                super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        }
    }
    @RequiresApi(api = Build.VERSION_CODES.O)
    @Override
    protected void onResume() {
        super.onResume();
        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.READ_PHONE_STATE) != PackageManager.PERMISSION_GRANTED) {
            return;
        }
    }
}