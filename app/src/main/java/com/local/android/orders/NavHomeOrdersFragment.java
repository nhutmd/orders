package com.local.android.orders;


import android.app.ProgressDialog;
import android.content.Context;
import android.os.Bundle;
import android.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.local.android.orders.adapter.OrderAdapter;
import com.local.android.orders.contains.Helper;
import com.local.android.orders.handler.ItemClickListener;
import com.local.android.orders.model.Order;
import com.local.android.orders.network.RetrofitClientInstance;
import com.local.android.orders.retrofit.DataService;

import java.util.List;

import es.dmoral.toasty.Toasty;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class NavHomeOrdersFragment extends Fragment {
    private OrderAdapter adapter;
    private RecyclerView recyclerView;
    private ProgressDialog progressDialog;


    public NavHomeOrdersFragment() {
    }

    public static NavHomeOrdersFragment newInstance() {
        NavHomeOrdersFragment fragment = new NavHomeOrdersFragment();
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        final View rootView = inflater.inflate(R.layout.fragment_nav_home_orders, container, false);
        final Context context = this.getContext();
        progressDialog = new ProgressDialog(this.getContext());
        progressDialog.setMessage(Helper.LOADING);
        progressDialog.show();

        DataService service = RetrofitClientInstance.getRetrofitInstance().create(DataService.class);
        Call<List<Order>> call = service.getOrders();
        call.enqueue(new Callback<List<Order>>() {
            @Override
            public void onResponse(Call<List<Order>> call, Response<List<Order>> response) {
                RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(context);
                progressDialog.dismiss();
                recyclerView = rootView.findViewById(R.id.home_rec_orders);
                adapter = new OrderAdapter(context, response.body(), new ItemClickListener() {
                    @Override
                    public void onClick(View v, String code) {
                        Toasty.info(getContext(), code + "", Toast.LENGTH_SHORT).show();
                    }
                });
                recyclerView.setHasFixedSize(true);
                recyclerView.setLayoutManager(layoutManager);
                recyclerView.setAdapter(adapter);
            }

            @Override
            public void onFailure(Call<List<Order>> call, Throwable t) {
                progressDialog.dismiss();
                Toasty.error(getContext(), Helper.WRONG, Toast.LENGTH_SHORT).show();
            }
        });
        return rootView;
    }
}
