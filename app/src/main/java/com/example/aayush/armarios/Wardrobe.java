package com.example.aayush.armarios;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.GridView;
import android.widget.Toast;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Wardrobe extends AppCompatActivity {
    WardrobeGridAdapter wardrobeGridAdapter;
    ArrayList<UrlData> urls;
    JSONObject object;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_wardrobe);
        GridView gridView = (GridView) findViewById(R.id.wardrobeGridView);

        Intent i = getIntent();
        String type = i.getStringExtra("type");
        urls = new ArrayList<>();
        wardrobeGridAdapter = new WardrobeGridAdapter(this,urls);
        gridView.setAdapter(wardrobeGridAdapter);
        //get urls

        Call<JSONObject> call = ApiClient.getInterface().getURLS(type);
        //Toast.makeText(Wardrobe.this, "Here", Toast.LENGTH_SHORT).show();
        call.enqueue(new Callback<JSONObject>() {
            @Override
            public void onResponse(Call<JSONObject> call, Response<JSONObject> response) {
                if(response.isSuccessful()) {
                    object = response.body();
                    urls = object.getUrl();

                    wardrobeGridAdapter.notifyDataSetChanged();
                    //Toast.makeText(Wardrobe.this, "here1", Toast.LENGTH_SHORT).show();


                }
                else{
                    Toast.makeText(Wardrobe.this, "No data Retrieved. Please Add data or check you internet Connection", Toast.LENGTH_SHORT).show();
                }
                }



            @Override
            public void onFailure(Call<JSONObject> call, Throwable t) {
                Toast.makeText(Wardrobe.this, "Please check your internet connection", Toast.LENGTH_SHORT).show();
            }
        });

    }
}
