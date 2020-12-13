package com.example.velmurugan.bottomnativation;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class LatestFragment extends Fragment {

    private ApiService apiService;
    private RecyclerView shopsRecyclerview;
    private LatestRecyclerviewAdapter recyclerviewAdapter;
    private List<Movie> movieList;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = LayoutInflater.from(container.getContext()).inflate(R.layout.latest_layout,container,false);
        movieList = new ArrayList<>();
        shopsRecyclerview = (RecyclerView)view.findViewById(R.id.recycler_view);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getContext());
        shopsRecyclerview.setLayoutManager(layoutManager);
        apiService = LatestRepo.getInstance().create(ApiService.class);
        recyclerviewAdapter = new LatestRecyclerviewAdapter(getContext(), movieList);
        shopsRecyclerview.setAdapter(recyclerviewAdapter);
        loadshopData();
        return view;
    }


    private void loadshopData() {

        Call<List<Movie>> listCall = apiService.getshops();

//        listCall.enqueue(new Callback<List<Movie>>() {
//            @Override
//            public void onResponse(Call<List<Movie>> call, Response<List<Movie>> response) {
//                movieList = response.body();
//                recyclerviewAdapter.loadShops(movieList);
//                Log.d("Response",response.body().toString());
//            }
//
//            @Override
//            public void onFailure(Call<List<Movie>> call, Throwable t) {
//                Log.d("Response",t.toString());
//
//            }
//        });
    }
}
