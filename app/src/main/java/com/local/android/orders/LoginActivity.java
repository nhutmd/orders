package com.local.android.orders;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.local.android.orders.contains.Helper;
import com.local.android.orders.handler.LoginHandler;

import es.dmoral.toasty.Toasty;

public class LoginActivity extends Activity {
    private Button btnLogin;
    private EditText edtPhone;
    private EditText edtPasswd;
    private Intent intent;
    private LoginHandler loginHandler;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Helper.setFullScreen(this);
        setContentView(R.layout.activity_login);
        btnLogin = findViewById(R.id.login_btnSubmit);
        edtPhone = findViewById(R.id.login_edtPhone);
        edtPasswd = findViewById(R.id.login_edtPasswd);
        this.setOnClickLogin(btnLogin);
    }

    public void setOnClickLogin(Button btn) {
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                loginHandler = new LoginHandler(edtPhone.getText().toString(), edtPasswd.getText().toString());
                if (loginHandler.validateInput(loginHandler.getPhone(), loginHandler.getPassword())) {
                    Toasty.success(getApplicationContext(), "Tài Khoản Xác Thực!", Toast.LENGTH_LONG, true).show();
                } else {
                    Toasty.error(getApplicationContext(), loginHandler.getMessage(), Toast.LENGTH_LONG, true).show();
                }
                intent = new Intent(LoginActivity.this, MainActivity.class);
                startActivity(intent);
                finish();
            }
        });
    }
}
