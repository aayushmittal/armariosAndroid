package com.example.aayush.armarios;

/**
 * Created by aayush on 01/10/16.
 */


import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

public abstract class ApiInterface {

    @GET("url")
    abstract Call<JSONObject> getURLS(@Query("type") String type);

}
