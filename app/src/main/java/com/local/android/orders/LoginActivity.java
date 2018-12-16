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
import com.local.android.orders.model.Login;
import com.local.android.orders.network.RetrofitClientInstance;
import com.local.android.orders.retrofit.DataService;

import es.dmoral.toasty.Toasty;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class LoginActivity extends Activity {
    private Button btnLogin;
    private EditText edtPhone;
    private EditText edtPasswd;
    private Intent intent;
    private LoginHandler loginHandler;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Helper.setFullScreenAndColorBar(this);
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
                btnLogin.setEnabled(false);
                loginHandler = new LoginHandler(edtPhone.getText().toString(), edtPasswd.getText().toString());
                if (loginHandler.validateInput(loginHandler.getPhone(), loginHandler.getPassword())) {
                    DataService service = RetrofitClientInstance.getRetrofitInstance().create(DataService.class);
                    Call<Login> call = service.login(loginHandler.getPhone(), loginHandler.getPassword());
                    call.enqueue(new Callback<Login>() {
                        @Override
                        public void onResponse(Call<Login> call, Response<Login> response) {
                            Login login = response.body();
                            if (login.getStatus()) {
                                Helper.USER = login.getUser();
                                intent = new Intent(LoginActivity.this, MainActivity.class);
                                startActivity(intent);
                                finish();
                            } else {
                                Toasty.error(getApplicationContext(), login.getMessage(), Toast.LENGTH_SHORT).show();
                            }
                        }

                        @Override
                        public void onFailure(Call<Login> call, Throwable t) {
                            Toasty.error(getApplicationContext(), Helper.WRONG, Toast.LENGTH_SHORT).show();
                        }
                    });

                } else {
                    Toasty.error(getApplicationContext(), loginHandler.getMessage(), Toast.LENGTH_LONG, true).show();
                }
                btnLogin.setEnabled(true);
            }
        });
    }
}
