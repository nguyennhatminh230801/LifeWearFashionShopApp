package com.nguyennhatminh614.lifewearfashionshopapp.util.api;

import com.nguyennhatminh614.lifewearfashionshopapp.Model.Account;
import com.nguyennhatminh614.lifewearfashionshopapp.Model.AccountDTO;
import com.nguyennhatminh614.lifewearfashionshopapp.util.constant.BaseAPI;

import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.Body;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;

public interface APIService {
    Retrofit retrofit = new Retrofit.Builder()
            .baseUrl(BaseAPI.baseURL)
            .addConverterFactory(GsonConverterFactory.create())
            .build();

    APIService apiService = retrofit.create(APIService.class);

    @POST("login")
    @FormUrlEncoded
    Call<Account> loginMethod(@Body Account account);

    @POST("register")
    @FormUrlEncoded
    Call<AccountDTO> registerMethod(@Body AccountDTO accountDT0);

}
