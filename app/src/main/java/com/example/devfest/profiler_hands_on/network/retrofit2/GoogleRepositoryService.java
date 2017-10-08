package com.example.devfest.profiler_hands_on.network.retrofit2;

import retrofit2.Call;
import retrofit2.http.GET;


public interface GoogleRepositoryService {
    @GET("master-index.xml")
    Call<String> listGroups();
}