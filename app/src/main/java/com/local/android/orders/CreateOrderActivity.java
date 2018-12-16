package com.local.android.orders;

import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.local.android.orders.contains.Helper;
import com.local.android.orders.model.Fetch;
import com.local.android.orders.network.RetrofitClientInstance;
import com.local.android.orders.retrofit.DataService;
import com.mvc.imagepicker.ImagePicker;
import com.squareup.picasso.Picasso;
import com.weiwangcn.betterspinner.library.BetterSpinner;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.net.URI;

import es.dmoral.toasty.Toasty;
import okhttp3.MediaType;
import okhttp3.MultipartBody;
import okhttp3.RequestBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class CreateOrderActivity extends AppCompatActivity {
    public static final int GALLERY_ONLY_REQ = 1212;
    private BetterSpinner spinner;
    private ImageView imageView;
    private String imagePath = "";
    private String uri;
    private String pathFromGallery;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Helper.setFullScreenAndColorBar(this);
        setContentView(R.layout.activity_create_order);
        spinner = findViewById(R.id.create_order_spn);
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_dropdown_item_1line, getResources().getStringArray(R.array.price_array));
        findViewById(R.id.create_order_spn);
        spinner.setAdapter(adapter);
        imageView = findViewById(R.id.create_order_img);
        ImagePicker.setMinQuality(600, 600);
        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ImagePicker.pickImageGalleryOnly(CreateOrderActivity.this, GALLERY_ONLY_REQ);
            }
        });
        Button btn = findViewById(R.id.create_order_btn);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TextView txtTitle = findViewById(R.id.create_order_title);
                TextView txtContent = findViewById(R.id.create_order_content);
                TextView txtAddressFrom = findViewById(R.id.create_order_address_from);
                TextView txtAddressTo = findViewById(R.id.create_order_address_to);
                if (Helper.isEmpty(txtTitle.getText().toString()) ||
                        Helper.isEmpty(txtContent.getText().toString()) ||
                        Helper.isEmpty(txtAddressFrom.getText().toString()) ||
                        Helper.isEmpty(txtAddressTo.getText().toString()) ||
                        Helper.isEmpty(spinner.getText().toString())) {
                    Toasty.error(getApplicationContext(), "Chưa Điền Đủ Thông Tin", Toast.LENGTH_SHORT).show();
                    return;
                }
                File file = new File(imagePath);
                RequestBody requestBody = RequestBody.create(MediaType.parse(getContentResolver().getType(Uri.parse(imagePath))), file);
                MultipartBody.Part filePart = MultipartBody.Part.createFormData("image", file.getName(), requestBody);
                DataService service = RetrofitClientInstance.getRetrofitInstance().create(DataService.class);
                Call<Fetch> call = service.store(txtTitle.toString(), txtContent.toString(), spinner.getText().toString(), txtAddressFrom.toString(), txtAddressTo.toString(), filePart, Helper.USER.getId());
                call.enqueue(new Callback<Fetch>() {
                    @Override
                    public void onResponse(Call<Fetch> call, Response<Fetch> response) {
                        if (response.body().getStatus()) {
                            Toasty.success(getApplicationContext(), "Tạo Đơn Hàng Thành Công", Toast.LENGTH_SHORT).show();
                        } else {
                            Toasty.error(getApplicationContext(), "Tạo Đơn Hàng Thất Bại", Toast.LENGTH_SHORT).show();
                        }
                    }

                    @Override
                    public void onFailure(Call<Fetch> call, Throwable t) {
                        Toasty.error(getApplicationContext(), Helper.WRONG, Toast.LENGTH_SHORT).show();
                    }
                });
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        switch (requestCode) {
            case GALLERY_ONLY_REQ:
                imagePath = ImagePicker.getImagePathFromResult(getApplicationContext(), requestCode, resultCode, data);
                pathFromGallery = "file:///" + imagePath;
                Picasso.with(getApplicationContext()).load(pathFromGallery).into(imageView);
                uri = imagePath;
                break;
            default:
                Bitmap bitmap = ImagePicker.getImageFromResult(getApplicationContext(), requestCode, resultCode, data);
                if (bitmap != null) {
                    imageView.setImageBitmap(bitmap);
                }
        }
        InputStream is = ImagePicker.getInputStreamFromResult(getApplicationContext(), requestCode, resultCode, data);
        if (is != null) {
            try {
                is.close();
            } catch (IOException ex) {

            }
        }
        super.onActivityResult(requestCode, resultCode, data);
    }
}
