package com.example.sayed.againretrofit;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {

    private String FlowerUrl = "http://services.hanselandpetal.com/feeds/flowers.json";
    private final String FLR_BASE_URL = "http://services.hanselandpetal.com/";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(FLR_BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        FlowerServiceAPI flowerServiceAPI = retrofit.create(FlowerServiceAPI.class);
        Call<ArrayList<FlowerRespose>> flowerResponse =flowerServiceAPI.getFlowerResponse();
        flowerResponse.enqueue(new Callback<ArrayList<FlowerRespose>>() {
            @Override
            public void onResponse(Call<ArrayList<FlowerRespose>> call, Response<ArrayList<FlowerRespose>> response) {
                ArrayList<FlowerRespose> flowerResposes = response.body();
                String size = String.valueOf(flowerResposes.size());
                Toast.makeText(MainActivity.this, size, Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onFailure(Call<ArrayList<FlowerRespose>> call, Throwable t) {

            }
        });

    }
}
