package com.local.android.orders.contains;

import android.app.Activity;
import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.support.v4.widget.DrawerLayout;
import android.text.TextUtils;
import android.util.Patterns;
import android.view.Window;
import android.view.WindowManager;

public class Helper {
    public static int SPLASH_TIME_OUT = 2000;
    public static String[] MESSAGES_ERROR = new String[]{
            "Số điện thoai không hợp lệ",
            "Mật khẩu không để rỗng"
    };
    public static String SUCCESS = "Thành công";
    public static int ID_MENU_DRAWER_HOME = 0;
    public static int ID_MENU_DRAWER_PROFILE = 1;

    public static void setFullScreen(Activity activity) {
        activity.requestWindowFeature(Window.FEATURE_NO_TITLE);
        activity.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
    }

    public static void viewFragment(DrawerLayout mDrawerLayout, FragmentManager fragmentManager, Fragment fragment, int id) {
        FragmentTransaction fragmentTransaction;
        fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(id, fragment);
        fragmentTransaction.commit();
        mDrawerLayout.closeDrawers();
    }

    public static void viewFragmentInFragment(FragmentManager fragmentManager, Fragment fragment, int id) {
        Fragment selectedFragment;
        FragmentTransaction transaction;
        selectedFragment = fragment;
        transaction = fragmentManager.beginTransaction();
        transaction.replace(id, selectedFragment);
        transaction.commit();
    }

    public static boolean isNotEmpty(String txt) {
        return !TextUtils.isEmpty(txt);
    }

    public static boolean isPhone(String phone) {
        return phone.length() >= 10 && phone.length() <= 11 && Patterns.PHONE.matcher(phone).matches();
    }
}
