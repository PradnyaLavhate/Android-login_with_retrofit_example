package com.androidexamples.lavhatepradnya.loginwithretrofit;

import android.app.ProgressDialog;
import android.support.design.widget.TextInputLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.androidexamples.lavhatepradnya.loginwithretrofit.Login.LoginContract;

/**
 *
 */
public class LoginActivity extends AppCompatActivity implements LoginContract.LoginViewContract {

    private EditText editUserName;
    private EditText editPassword;

    private LoginPresenter loginPresenter;
    private TextInputLayout textInputUserName;
    private TextInputLayout textInputPassword;
    private ProgressDialog dialog;
    private Button btnLogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        textInputUserName = (TextInputLayout) findViewById(R.id.textInputLayoutUserName);
        textInputPassword = (TextInputLayout) findViewById(R.id.textInputLayoutPassword);
        editUserName = (EditText) findViewById(R.id.editTextUserName);
        editPassword = (EditText) findViewById(R.id.editTextLoginPassword);
        dialog = new ProgressDialog(this);
        dialog.setTitle(R.string.app_name);
        dialog.setMessage("Loging in...Please Wait");

        loginPresenter = new LoginPresenter(this);

        btnLogin = (Button) findViewById(R.id.buttonLogin);
        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                loginPresenter.login();
            }
        });
    }

    @Override
    public void onLoginSuccessful() {
        Toast.makeText(this, "Login Successful", Toast.LENGTH_SHORT).show();

    }

    @Override
    public void onLoginFailed(String errorMessage) {
        Toast.makeText(this, "Login Failed", Toast.LENGTH_SHORT).show();

    }

    @Override
    public void stopProgressBar() {
        if (dialog != null && dialog.isShowing()) {
            dialog.dismiss();
        }
    }

    @Override
    public void startProgressBar() {
        if (dialog != null) {
            dialog.show();
        }
    }

    @Override
    public void showUserNameError() {

    }

    @Override
    public void showPasswordError() {

    }
}
