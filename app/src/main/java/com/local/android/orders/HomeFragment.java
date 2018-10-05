package com.local.android.orders;

import android.os.Bundle;
import android.app.Fragment;
import android.support.design.widget.BottomNavigationView;
import android.support.design.widget.FloatingActionButton;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.local.android.orders.contains.Helper;

import es.dmoral.toasty.Toasty;


public class HomeFragment extends Fragment {
    private FloatingActionButton floatingActionButton;
    private BottomNavigationView navigationView;

    public HomeFragment() {

    }

    public static HomeFragment newInstance() {
        HomeFragment fragment = new HomeFragment();
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        final View rootView = inflater.inflate(R.layout.fragment_home, container, false);
        floatingActionButton = rootView.findViewById(R.id.fab_create_order);
        navigationView = rootView.findViewById(R.id.home_bottom_navigation);
        floatingActionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                fabBtnClick();
            }
        });
        navigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(MenuItem menuItem) {
                switch (menuItem.getItemId()) {
                    case R.id.home_nav_view_main: {
                        MainActivity.setSelectDrawer(Helper.ID_MENU_DRAWER_HOME);
                        Helper.viewFragmentInFragment(getFragmentManager(), NavHomeOrdersFragment.newInstance(), R.id.fragment_content_home);
                        break;
                    }
                    case R.id.home_nav_view_coin: {
                        Helper.viewFragmentInFragment(getFragmentManager(), NavHomeCoinFragment.newInstance(), R.id.fragment_content_home);
                        break;
                    }
                    case R.id.home_nav_view_profile: {
                        MainActivity.setSelectDrawer(Helper.ID_MENU_DRAWER_PROFILE);
                        Helper.viewFragmentInFragment(getFragmentManager(), NavHomeProfileFragment.newInstance(), R.id.fragment_content_home);
                        break;
                    }
                }
                return true;
            }
        });
        MainActivity.setSelectDrawer(Helper.ID_MENU_DRAWER_HOME);
        Helper.viewFragmentInFragment(getFragmentManager(), NavHomeOrdersFragment.newInstance(), R.id.fragment_content_home);
        return rootView;
    }

    public void fabBtnClick() {
        Toasty.success(getContext(), Helper.SUCCESS, Toast.LENGTH_LONG).show();
    }

}
