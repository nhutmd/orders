package com.local.android.orders;


import android.os.Bundle;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


public class NavHomeOrdersFragment extends Fragment {

    public NavHomeOrdersFragment() {
    }

    public static NavHomeOrdersFragment newInstance() {
        NavHomeOrdersFragment fragment = new NavHomeOrdersFragment();
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View rootView = inflater.inflate(R.layout.fragment_nav_home_orders, container, false);
        return rootView;
    }

}
