package com.example.aayush.armarios;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

/**
 * Created by aayush on 01/10/16.
 */
public class UrlData implements Serializable{
    @SerializedName("url")
    String url;

    public String getUrl() {
        return url;
    }
}
