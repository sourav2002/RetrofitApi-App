package com.example.retrofitapiapp;

import com.example.retrofitapiapp.model.model;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface myApi {

    @GET("posts")
    Call<List<model>> getModels();
}
