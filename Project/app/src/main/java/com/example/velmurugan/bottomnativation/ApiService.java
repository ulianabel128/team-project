package com.example.velmurugan.bottomnativation;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface ApiService {

    @GET("bottom_navigationview.json")
    Call<List<Movie>> getshops();
}
