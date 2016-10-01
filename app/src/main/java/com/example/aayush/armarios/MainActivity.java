package com.example.aayush.armarios;

import android.content.Intent;
import android.graphics.Bitmap;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Base64;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.Toast;

import java.io.ByteArrayOutputStream;
import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {
    ArrayList<String> categories;
    MainActivityGripAdapter mainActivityGripAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        GridView gridView = (GridView) findViewById(R.id.MainActivityGridView);
        categories = new ArrayList<>();
        categories.add("Accessories");
        categories.add("Dresses");
        categories.add("Jacket and coats");
        categories.add("Pants and Jeans");
        categories.add("Pullovers");
        categories.add("TShirt");
        categories.add("Shirt");
        categories.add("Night Wear");


        mainActivityGripAdapter = new MainActivityGripAdapter(MainActivity.this,categories);

        gridView.setAdapter(mainActivityGripAdapter);
        mainActivityGripAdapter.notifyDataSetChanged();

        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                //Toast.makeText(MainActivity.this, "here1", Toast.LENGTH_SHORT).show();
                Intent i = new Intent();
                i.putExtra("category",categories.get(position));
                i.setClass(MainActivity.this,Wardrobe.class);
                startActivity(i);

            }
        });
        gridView.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
                Intent i = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                if (i.resolveActivity(getPackageManager()) != null) {
                    startActivityForResult(i, 1);
                }
                return true;
            }
        });

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        //super.onActivityResult(requestCode, resultCode, data);
        //convert to base64
        Bundle extras = data.getExtras();
        Bitmap imageBitmap = (Bitmap) extras.get("data");
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        imageBitmap.compress(Bitmap.CompressFormat.PNG, 100, byteArrayOutputStream);
        byte[] byteArray = byteArrayOutputStream.toByteArray();
        String encoded = Base64.encode(byteArray, Base64.DEFAULT).toString();
        //conversion Ended

        Call<String> call = ImgurApiClient.getInterface().sendImage(encoded,"Client-ID " + "2646f0a0cdd2914");
        Toast.makeText(MainActivity.this, "Here", Toast.LENGTH_SHORT).show();
        call.enqueue(new Callback<String>() {
            @Override
            public void onResponse(Call<String> call, Response<String> response) {
                if(response.isSuccessful()) {
                    Log.i("Responce",response.toString());
                    Toast.makeText(MainActivity.this, "Here2", Toast.LENGTH_SHORT).show();

                }
                else{
                    Log.e("errorRes",response.toString());
                    Log.e("yo",response.message() + response.code());
                    Toast.makeText(MainActivity.this, "No data Retrieved. Please Add data or check you internet Connection", Toast.LENGTH_SHORT).show();
                }
            }



            @Override
            public void onFailure(Call<String> call, Throwable t) {
                Toast.makeText(MainActivity.this, "Please check your internet connection", Toast.LENGTH_SHORT).show();
            }
        });

    }
}
