package com.local.android.orders;


import android.os.Bundle;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.local.android.orders.contains.Helper;


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
        TextView txtName = rootView.findViewById(R.id.nav_home_profile_name);
        TextView txtPhone = rootView.findViewById(R.id.nav_home_profile_phone);
        TextView txtEmail = rootView.findViewById(R.id.nav_home_profile_email);
        TextView txtSex = rootView.findViewById(R.id.nav_home_profile_sex);
        txtName.setText(Helper.USER.getName());
        txtPhone.setText(Helper.USER.getPhone());
        txtEmail.setText(Helper.USER.getEmail());
        txtSex.setText(Helper.USER.getSex());
        return rootView;
    }
}
