package com.wanderast.bayanihan.util;


import com.google.gson.JsonArray;
import com.google.gson.JsonObject;

import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.GET;

public class Rest {

    public interface APIService {
        @GET("person")
        Call<JsonArray> getPersons();

    }

    public static APIService endpoint() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://wanderast01a.southeastasia.cloudapp.azure.com/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        APIService apiService = retrofit.create(APIService.class);
        return apiService;
    }
}
