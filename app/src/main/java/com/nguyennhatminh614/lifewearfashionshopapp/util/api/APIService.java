package com.nguyennhatminh614.lifewearfashionshopapp.util.api;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.nguyennhatminh614.lifewearfashionshopapp.Model.AccountModel;
import com.nguyennhatminh614.lifewearfashionshopapp.Model.Product;
import com.nguyennhatminh614.lifewearfashionshopapp.Model.TempAccountModel;

import java.util.ArrayList;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.Body;
import retrofit2.http.Field;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.POST;
import retrofit2.http.Query;

public interface APIService {
    String baseURL = "https://lifewear.mn07.xyz/api/";

    Gson gson = new GsonBuilder().setDateFormat("yyyy-MM-dd HH:mm:ss").create();

    Retrofit retrofit = new Retrofit.Builder()
            .baseUrl(baseURL)
            .addConverterFactory(GsonConverterFactory.create(gson))
            .build();

    APIService apiService = retrofit.create(APIService.class);

    // @Post(base_url/login):
    // Check tai khoan va dang nhap vao he thong
    @POST("login")
    @Headers({
            "Accept: application/json",
            "Content-Type: application/json"
    })
    Call<TempAccountModel> loginMethod(@Body TempAccountModel tempAccountModel);

    // @Post(base_url/register):
    // Dang ky 1 tai khoan moi
    @POST("register")
    @Headers({
            "Accept: application/json",
            "Content-Type: application/json"
    })
    Call<AccountModel> registerMethod(@Body AccountModel accountModel);

    // Lay tat ca san pham trong CSDL
    @GET("products")
    @Headers({
            "Accept: application/json",
            "Authorization: Bearer 1|WuYQmYk6cmjXo8SZWTV5LuF7vXT7BSIQ90Ot0QBZ"
    })
    Call<ArrayList<Product>> getAllProducts(@Query("limit") Integer maximumProductsNumber, @Query("start") Integer StartFromID);

    //Lấy mã reset qua email
    @POST("forgot")
    @Headers({
            "Accept: application/json",
            "Content-Type: application/json"
    })
    Call<String> getResetPasswordCodeThroughEmail(@Field("email") String email);

    //Chức năng Reset mật khẩu
    @POST("reset_password")
    @Headers({
            "Accept: application/json",
            "Content-Type: application/json"
    })
    Call<ResponseBody> resetPassword(@Field("email") String email, @Field("reset_code") String resetCode, @Field("password") String newPassword);

    //Xác thực mật khẩu nhận được
    @POST("reset_password/verify")
    @Headers({
            "Accept: application/json",
            "Content-Type: application/json"
    })
    Call<ResponseBody> verifyingResetPassword(@Field("email") String email, @Field("reset_code") String resetCode);

    //Lấy auth user
//    @GET("user")
//    @Headers({
//            "Accept: application/json",
//            "Authorization: Bearer 1|WuYQmYk6cmjXo8SZWTV5LuF7vXT7BSIQ90Ot0QBZ"
//    })
}
