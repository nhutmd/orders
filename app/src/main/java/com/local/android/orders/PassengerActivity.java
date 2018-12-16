package com.local.android.orders;

import android.os.Bundle;
import android.os.CountDownTimer;
import android.support.v4.app.FragmentActivity;
import android.widget.Toast;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;
import com.local.android.orders.contains.Helper;
import com.local.android.orders.model.Location;
import com.local.android.orders.network.RetrofitClientInstance;
import com.local.android.orders.retrofit.DataService;

import es.dmoral.toasty.Toasty;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class PassengerActivity extends FragmentActivity implements OnMapReadyCallback {

    private SupportMapFragment mMapFragment;
    private GoogleMap googleMap;
    private CountDownTimer tim;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Helper.setFullScreenAndColorBar(this);
        setContentView(R.layout.activity_passenger);
        mMapFragment = (SupportMapFragment) getSupportFragmentManager().findFragmentById(R.id.map);
        mMapFragment.getMapAsync(this);
    }

    @Override
    public void onMapReady(final GoogleMap googleMap) {
        MarkerOptions markerOptions = new MarkerOptions()
                .position(new LatLng(0, 0))
                .title("Đơn Hàng Đang Chuyển");
        final Marker marker = googleMap.addMarker(markerOptions);
        tim = new CountDownTimer(Helper.TIME_COUNT_MAX, 5000) {
            public void onTick(long millisUntilFinished) {
                DataService service = RetrofitClientInstance.getRetrofitInstance().create(DataService.class);
                Call<Location> call = service.getLatLng("2");
                call.enqueue(new Callback<Location>() {
                    @Override
                    public void onResponse(Call<Location> call, Response<Location> response) {
                        Location location = response.body();
//                        Toasty.info(PassengerActivity.this, location.getLat() + " " + location.getLon(), Toast.LENGTH_SHORT).show();
                        if (location.getStatus()) {
                            marker.setPosition(new LatLng(Double.valueOf(location.getLat()), Double.valueOf(location.getLon())));
                            googleMap.animateCamera(CameraUpdateFactory.newLatLngZoom(marker.getPosition(), 15.0f));
                        }
                    }

                    @Override
                    public void onFailure(Call<Location> call, Throwable t) {
                    }
                });
            }

            public void onFinish() {

            }
        }.start();

    }

    @Override
    public void onBackPressed() {
        tim.cancel();
        finish();
    }
}
