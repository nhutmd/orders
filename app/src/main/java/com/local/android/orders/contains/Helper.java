package com.local.android.orders.contains;

import android.app.Activity;
import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.os.Build;
import android.support.v4.widget.DrawerLayout;
import android.text.TextUtils;
import android.util.Patterns;
import android.view.Window;
import android.view.WindowManager;

import com.local.android.orders.R;
import com.local.android.orders.model.User;

public class Helper {
    public static String URL = "https://lampstack.herokuapp.com/";
    public static int SPLASH_TIME_OUT = 2000;
    public static int TIME_COUNT_MAX = 999999999;
    public static String[] MESSAGES_ERROR = new String[]{
            "Số điện thoai không hợp lệ",
            "Mật khẩu không để rỗng"
    };
    public static String SUCCESS = "Thành công";
    public static String CREATE_ORDER = "Tạo đơn hàng mới";
    public static int ID_MENU_DRAWER_HOME = 0;
    public static int ID_MENU_DRAWER_PROFILE = 1;
    public static String LOADING = "Đang tải...";
    public static String WRONG = "Kết nối thất bại...";
    public static User USER;

    public final static String PUBNUB_PUBLISH_KEY = "pub-c-e5569376-0f0e-40e4-832b-d2cd9881f892";
    public final static String PUBNUB_SUBSCRIBE_KEY = "sub-c-f1d85560-f40f-11e8-babf-1e3d8cb2a384";
    public final static String PUBNUB_CHANNEL_NAME = "drivers_location";

    public static void setFullScreenAndColorBar(Activity activity) {
        if (android.os.Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            activity.getWindow().setNavigationBarColor(activity.getResources().getColor(R.color.colorWhite));
        }

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

    public static boolean isEmpty(String txt) {
        return !isNotEmpty(txt);
    }

    public static boolean isPhone(String phone) {
        return phone.length() >= 9 && phone.length() <= 11 && Patterns.PHONE.matcher(phone).matches();
    }
}
