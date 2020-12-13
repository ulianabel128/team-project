package com.example.velmurugan.bottomnativation;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class LatestRepo {
    private static Retrofit retrofit = null;

    static Retrofit getInstance(){
        retrofit = new Retrofit.Builder().baseUrl("http://velmm.com/apis/").addConverterFactory(GsonConverterFactory.create()).build();
        return retrofit;
    }
}
