package com.example.sayed.againretrofit;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Created by nurud on 10/1/2017.
 */

public interface FlowerServiceAPI {

    @GET("feeds/flowers.json")
    Call<ArrayList<FlowerRespose>> getFlowerResponse();

}
