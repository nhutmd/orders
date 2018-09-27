package com.local.android.orders.contains;

import android.app.Activity;
import android.view.Window;
import android.view.WindowManager;

public class Helper {
    public static int SPLASH_TIME_OUT = 2000;

    public static void setFullScreen(Activity activity) {
        activity.requestWindowFeature(Window.FEATURE_NO_TITLE);
        activity.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
    }
}
