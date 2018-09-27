package com.local.android.orders;

import android.app.Activity;
import android.app.FragmentManager;
import android.support.design.widget.NavigationView;
import android.app.Fragment;
import android.app.FragmentTransaction;
import android.support.v4.widget.DrawerLayout;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.Toast;

import com.local.android.orders.contains.Helper;

import es.dmoral.toasty.Toasty;

public class MainActivity extends Activity {
    private DrawerLayout mDrawerLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Helper.setFullScreen(this);
        setContentView(R.layout.activity_main);
        mDrawerLayout = findViewById(R.id.home_drawer_layout);
        NavigationView navigationView = findViewById(R.id.home_nav_view);
        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(MenuItem menuItem) {
                menuItem.setCheckable(true);
                switch (menuItem.getItemId()) {
                    case R.id.drawer_nav_home: {
                        viewFragment(HomeFragment.newInstance(), R.id.home_content_frame);
                        break;
                    }
                    case R.id.drawer_nav_profile: {
                        viewFragment(ProfileFragment.newInstance(), R.id.home_content_frame);
                        break;
                    }
                    case R.id.drawer_nav_orders: {
                        viewFragment(OrdersFragment.newInstance(), R.id.home_content_frame);
                        break;
                    }
                    case R.id.drawer_nav_order_ship: {
                        viewFragment(OrderShipFragment.newInstance(), R.id.home_content_frame);
                        break;
                    }
                    case R.id.drawer_nav_pay: {
                        viewFragment(PayFragment.newInstance(), R.id.home_content_frame);
                        break;
                    }
                    case R.id.drawer_nav_logout: {
                        Toasty.error(MainActivity.this, "Nhấn Chọn Thoát", Toast.LENGTH_SHORT, true).show();
                        break;
                    }
                }
                mDrawerLayout.closeDrawers();
                return true;
            }
        });
        navigationView.getMenu().getItem(0).setChecked(true);
        viewFragment(HomeFragment.newInstance(), R.id.home_content_frame);
    }

    public void viewFragment(Fragment fragment, int id) {
        FragmentTransaction fragmentTransaction;
        FragmentManager fragmentManager = getFragmentManager();
        fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(id, fragment);
        fragmentTransaction.commit();
        mDrawerLayout.closeDrawers();
    }
}
