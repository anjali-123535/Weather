package com.example.task4.model.repository;

import android.app.Application;
import android.util.Log;

import androidx.lifecycle.MutableLiveData;

import com.example.task4.api.ApiService;
import com.example.task4.api.RetrofitClient;
import com.example.task4.model.WeatherResponse;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainRepository {
    private static final String TAG = "MainRepository";
    private static final MainRepository ourInstance = new MainRepository();
   private WeatherResponse weatherResponse;
    ApiService apiService;
    private String API="41cf1d38bcf821602fc65444fa902011";
    private MutableLiveData<WeatherResponse> weatherResponseMutableLiveData=new MutableLiveData<>();
    public static MainRepository getInstance() {
        return ourInstance;
    }
    private MainRepository()
    {
        apiService=RetrofitClient.getClient();
    }

    public MutableLiveData<WeatherResponse> getWeatherData(String city)
    {
        Call <WeatherResponse>call=apiService.getCurrentWeatherData(city,API);
        call.enqueue(new Callback<WeatherResponse>() {
            @Override
            public void onResponse(Call<WeatherResponse> call, Response<WeatherResponse> response) {
                if (response.code() == 200) {
                    Log.d(TAG,"rescponse code is 200");
                    weatherResponse = response.body();
                    assert weatherResponse != null;
                    weatherResponseMutableLiveData.setValue(weatherResponse);
                }
            }

            @Override
            public void onFailure(Call<WeatherResponse> call, Throwable t) {
Log.d(TAG,t.toString());
            }
        });
        return weatherResponseMutableLiveData;

    }

}
