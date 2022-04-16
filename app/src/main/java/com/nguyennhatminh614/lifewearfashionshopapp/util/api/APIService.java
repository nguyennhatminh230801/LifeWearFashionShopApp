package com.nguyennhatminh614.lifewearfashionshopapp.util.api;

import com.nguyennhatminh614.lifewearfashionshopapp.Model.TempAccountModel;
import com.nguyennhatminh614.lifewearfashionshopapp.Model.AccountModel;
import com.nguyennhatminh614.lifewearfashionshopapp.Model.Product;
import com.nguyennhatminh614.lifewearfashionshopapp.util.constant.BaseAPI;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.Body;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.POST;

public interface APIService {
    Retrofit retrofit = new Retrofit.Builder()
            .baseUrl(BaseAPI.baseURL)
            .addConverterFactory(GsonConverterFactory.create())
            .build();

    APIService apiService = retrofit.create(APIService.class);

    @POST("login")
    @Headers({"Accept: application/json"})
    @FormUrlEncoded
    Call<TempAccountModel> loginMethod(@Body TempAccountModel tempAccountModel);

    @POST("register")
    @Headers({"Accept: application/json"})
    @FormUrlEncoded
    Call<AccountModel> registerMethod(@Body AccountModel accountModel);

    @GET("products")
    @Headers({"Accept: application/json"})
    Call<ArrayList<Product>> getAllProducts();
}
