package com.local.android.orders;


import android.os.Bundle;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class NavHomeCoinFragment extends Fragment {


    public NavHomeCoinFragment() {

    }

    public static NavHomeCoinFragment newInstance(){
        return new NavHomeCoinFragment();
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_nav_home_coin, container, false);
        return rootView;
    }

}
