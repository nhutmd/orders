package com.local.android.orders;


import android.os.Bundle;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


public class NavHomeProfileFragment extends Fragment {


    public NavHomeProfileFragment() {

    }

    public static NavHomeProfileFragment newInstance() {
        return new NavHomeProfileFragment();
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_nav_home_profile, container, false);
        return rootView;
    }
}
