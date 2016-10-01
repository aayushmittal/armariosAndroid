package com.example.aayush.armarios;

/**
 * Created by aayush on 01/10/16.
 */


import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.POST;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface ApiInterface {

    @GET("url")
    Call<JSONObject> getURLS(@Query("type") String type);

    @POST("upload")
    Call<String> sendImage(@Body String string, @Header("Authorization") String  s);

}
