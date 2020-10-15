package com.example.task4.api;

import com.example.task4.model.WeatherResponse;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface ApiService {
    @GET("data/2.5/weather?")
    Call <WeatherResponse>getCurrentWeatherData(@Query("q") String city, @Query("APPID") String app_id);
}
