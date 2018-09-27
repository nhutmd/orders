package com.local.android.orders;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.local.android.orders.contains.Helper;

public class LoginActivity extends Activity {
    private Button btnLogin;
    private Intent intent;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Helper.setFullScreen(this);
        setContentView(R.layout.activity_login);
        btnLogin = findViewById(R.id.login_btnSubmit);
        this.setOnClickLogin(btnLogin);
    }

    public void setOnClickLogin(Button btn){
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                intent = new Intent(LoginActivity.this, MainActivity.class);
                startActivity(intent);
                finish();
            }
        });
    }
}
