package com.local.android.orders;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

import com.local.android.orders.contains.Helper;

public class FlashActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Helper.setFullScreenAndColorBar(this);
        setContentView(R.layout.activity_flash);
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent i = new Intent(FlashActivity.this, LoginActivity.class);
                startActivity(i);
                finish();
            }
        }, Helper.SPLASH_TIME_OUT);
    }
}
