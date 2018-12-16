package com.local.android.orders;

import android.content.Intent;
import android.os.Bundle;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

public class TrackFragment extends Fragment {
    private Button driverButton;
    private Button passengerButton;

    public TrackFragment() {

    }

    public static TrackFragment newInstance() {
        return new TrackFragment();
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        final View rootView = inflater.inflate(R.layout.fragment_track, container, false);
        driverButton = rootView.findViewById(R.id.track_btnDriver);
        passengerButton = rootView.findViewById(R.id.track_btnPassenger);
        driverButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getContext(), DriverActivity.class));
            }
        });
        passengerButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getContext(), PassengerActivity.class));
            }
        });
        return rootView;
    }

}
