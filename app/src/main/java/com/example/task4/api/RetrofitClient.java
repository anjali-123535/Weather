package com.example.task4.api;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitClient {
    private static String BASE_URL = "http://api.openweathermap.org/";
    private static retrofit2.Retrofit retrofit = null;

    public static ApiService getClient() {

       /* HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();
        interceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
        OkHttpClient client = new OkHttpClient.Builder().addInterceptor(interceptor).build();*/


        retrofit = new retrofit2.Retrofit.Builder()
                .baseUrl(BASE_URL)
                // .client(client)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        return retrofit.create(ApiService.class);

    }
}
