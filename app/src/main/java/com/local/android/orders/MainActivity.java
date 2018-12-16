package com.local.android.orders;

import android.app.Activity;
import android.app.FragmentManager;
import android.content.Intent;
import android.support.design.widget.NavigationView;
import android.support.v4.widget.DrawerLayout;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.Toast;

import com.local.android.orders.contains.Helper;

import es.dmoral.toasty.Toasty;

public class MainActivity extends Activity {
    private DrawerLayout mDrawerLayout;
    private FragmentManager fragmentManager = getFragmentManager();
    private static NavigationView navigationView;
    private Intent intent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Helper.setFullScreenAndColorBar(this);
        setContentView(R.layout.activity_main);
        mDrawerLayout = findViewById(R.id.home_drawer_layout);
        navigationView = findViewById(R.id.home_nav_view);
        navigationView.getMenu().getItem(0).setChecked(true);
        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(MenuItem menuItem) {
                menuItem.setCheckable(true);
                switch (menuItem.getItemId()) {
                    case R.id.drawer_nav_home: {
                        Helper.viewFragment(mDrawerLayout, MainActivity.this.fragmentManager, HomeFragment.newInstance(), R.id.home_content_frame);
                        break;
                    }
                    case R.id.drawer_nav_profile: {
                        Helper.viewFragment(mDrawerLayout, MainActivity.this.fragmentManager, ProfileFragment.newInstance(), R.id.home_content_frame);
                        break;
                    }
                    case R.id.drawer_nav_orders: {
                        Helper.viewFragment(mDrawerLayout, MainActivity.this.fragmentManager, OrdersFragment.newInstance(), R.id.home_content_frame);
                        break;
                    }
                    case R.id.drawer_nav_order_ship: {
                        Helper.viewFragment(mDrawerLayout, MainActivity.this.fragmentManager, OrderShipFragment.newInstance(), R.id.home_content_frame);
                        break;
                    }
                    case R.id.drawer_nav_pay: {
                        Helper.viewFragment(mDrawerLayout, MainActivity.this.fragmentManager, PayFragment.newInstance(), R.id.home_content_frame);
                        break;
                    }
                    case R.id.drawer_nav_track: {
                        Helper.viewFragment(mDrawerLayout, MainActivity.this.fragmentManager, TrackFragment.newInstance(), R.id.home_content_frame);
                        break;
                    }
                    case R.id.drawer_nav_logout: {
                        Toasty.info(MainActivity.this, "Đăng Xuất", Toast.LENGTH_SHORT, true).show();
                        intent = new Intent(MainActivity.this, LoginActivity.class);
                        startActivity(intent);
                        finish();
                        break;
                    }
                }
                return true;
            }
        });
        Helper.viewFragment(mDrawerLayout, MainActivity.this.fragmentManager, HomeFragment.newInstance(), R.id.home_content_frame);
    }

    public static void setSelectDrawer(int id) {
        navigationView.getMenu().getItem(id).setChecked(true);
    }
}
