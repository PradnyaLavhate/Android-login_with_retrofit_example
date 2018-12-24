package com.androidexamples.lavhatepradnya.loginwithretrofit.Login;

/*
 * Copyright (c) 2018.  Written By Pradnya Lavhate
 */

import retrofit2.Call;
import retrofit2.http.GET;

public interface LoginApi {

 public static final String BASE_URL="https://3ab4444d-5321-463b-9b6b-a118fd90a51d.mock.pstmn.io";

 @GET("login3")
 Call<LoginResponse>login();

}
