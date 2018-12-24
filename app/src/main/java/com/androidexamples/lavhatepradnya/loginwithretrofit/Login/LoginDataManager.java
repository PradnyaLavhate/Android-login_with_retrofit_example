package com.androidexamples.lavhatepradnya.loginwithretrofit.Login;

/*
 * Copyright (c) 2018.  Written By Pradnya Lavhate
 */

import android.widget.Toast;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class LoginDataManager {


    public LoginDataManager() {

    }

    public void login(String username, String password) {

        Retrofit retrofit = new Retrofit.Builder().baseUrl(LoginApi.BASE_URL).addConverterFactory(GsonConverterFactory.create()).build();

        LoginApi loginApi = retrofit.create(LoginApi.class);

        Call<LoginResponse> loginResponseCall ;
        loginResponseCall =loginApi.login();


        loginResponseCall.enqueue(new Callback<LoginResponse>() {
            @Override
            public void onResponse(Call<LoginResponse> call, Response<LoginResponse> response) {



            }

            @Override
            public void onFailure(Call<LoginResponse> call, Throwable t) {


            }
        });

    }
}
