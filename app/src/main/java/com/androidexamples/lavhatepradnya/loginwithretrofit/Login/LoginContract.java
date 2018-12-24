package com.androidexamples.lavhatepradnya.loginwithretrofit.Login;

/*
 * Copyright (c) 2018.  Written By Pradnya Lavhate
 */

import android.support.design.widget.TextInputLayout;

public class LoginContract {

     public interface LoginPresenterContract{
         public void validateUserName(TextInputLayout layoutUserName);
         public void validatePassword(TextInputLayout layoutPassword);
         public void login();

    }

    public interface LoginViewContract{

         public void onLoginSuccessful();
         public void onLoginFailed(String errorMessage);
         public void stopProgressBar();
         public void startProgressBar();
         public void showUserNameError();
         public void showPasswordError();

    }

}
