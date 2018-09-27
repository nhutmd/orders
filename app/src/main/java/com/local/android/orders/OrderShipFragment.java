package com.local.android.orders;


import android.os.Bundle;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


public class OrderShipFragment extends Fragment {


    public OrderShipFragment() {

    }

    public static OrderShipFragment newInstance(){
        return new OrderShipFragment();
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_order_ship, container, false);
    }

}
