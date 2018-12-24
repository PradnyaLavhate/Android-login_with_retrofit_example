package com.androidexamples.lavhatepradnya.loginwithretrofit;

/*
 * Copyright (c) 2018.  Written By Pradnya Lavhate
 */

import android.media.MediaCodec;
import android.os.PatternMatcher;
import android.support.design.widget.TextInputLayout;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;

import com.androidexamples.lavhatepradnya.loginwithretrofit.Login.LoginApi;
import com.androidexamples.lavhatepradnya.loginwithretrofit.Login.LoginContract;
import com.androidexamples.lavhatepradnya.loginwithretrofit.Login.LoginResponse;

import java.util.regex.Pattern;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class LoginPresenter implements LoginContract.LoginPresenterContract {
    private static final String TAG = "LoginPresenter";

    private LoginContract.LoginViewContract loginView;

    public LoginPresenter(LoginContract.LoginViewContract loginView) {
        this.loginView = loginView;
    }

    @Override
    public void validateUserName(TextInputLayout layoutUserName) {
        layoutUserName.getEditText().addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });

    }

    @Override
    public void validatePassword(TextInputLayout layoutPassword) {
        layoutPassword.getEditText().addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

                Pattern pattern = Pattern.compile("", Pattern.CASE_INSENSITIVE);
//                PatternMatcher matcher=pattern.matcher(String.);
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });
    }

    @Override
    public void login() {

        loginView.startProgressBar();
        Retrofit retrofit = new Retrofit.Builder().baseUrl(LoginApi.BASE_URL).addConverterFactory(GsonConverterFactory.create()).build();

        LoginApi loginApi = retrofit.create(LoginApi.class);

        Call<LoginResponse> loginResponseCall;
        loginResponseCall = loginApi.login();


        loginResponseCall.enqueue(new Callback<LoginResponse>() {
            @Override
            public void onResponse(Call<LoginResponse> call, Response<LoginResponse> response) {
                Log.d(TAG, "onResponse: " + response.body());
                loginView.stopProgressBar();
                loginView.onLoginSuccessful();
            }

            @Override
            public void onFailure(Call<LoginResponse> call, Throwable t) {

                loginView.onLoginFailed(t.getMessage());
            }
        });

    }


    class validateLoginField {

        public void validateUsername() {

        }

        public void validatePassword() {

        }
    }
}
