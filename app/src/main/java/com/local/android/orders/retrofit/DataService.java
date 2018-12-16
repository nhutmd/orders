package com.local.android.orders.retrofit;

import com.local.android.orders.model.Fetch;
import com.local.android.orders.model.Location;
import com.local.android.orders.model.Login;
import com.local.android.orders.model.Order;

import java.util.List;

import okhttp3.MultipartBody;
import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.Multipart;
import retrofit2.http.POST;
import retrofit2.http.Part;
import retrofit2.http.Query;

public interface DataService {
    @POST("api/user/login")
    @FormUrlEncoded
    Call<Login> login(@Field("phone") String phone,
                      @Field("password") String password);

    @GET("api/order/list")
    Call<List<Order>> getOrders();

    @POST("api/location/fetch")
    @FormUrlEncoded
    Call<Fetch> fetch(@Field("id_order") String id_order,
                      @Field("lat") String lat,
                      @Field("lon") String lon);

    @GET("api/location/get")
    Call<Location> getLatLng(@Query(value = "id_order") String id_order);

    @Multipart
    @POST("api/order/store")
    @FormUrlEncoded
    Call<Fetch> store(@Field("title") String title,
                      @Field("content") String content,
                      @Field("price") String price,
                      @Field("address_from") String address_from,
                      @Field("address_to") String address_to,
                      @Part MultipartBody.Part file,
                      @Field("id_user") int id_user);
}
