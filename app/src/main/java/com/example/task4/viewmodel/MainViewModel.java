package com.example.task4.viewmodel;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;

import com.example.task4.model.WeatherResponse;
import com.example.task4.model.repository.MainRepository;

public class MainViewModel extends ViewModel {
    WeatherResponse weatherResponse;
    MainRepository mainRepository=MainRepository.getInstance();
    private static final String TAG = "MainViewModel";
    private LiveData<WeatherResponse> weatherResponseLiveData;
    public MainViewModel(){
        super();
       // weatherResponseLiveData=mainRepository.getWeatherDat
        // a();
    }

    public LiveData<WeatherResponse> getCurrentWeatherData( String city)
    {
       weatherResponseLiveData= mainRepository.getWeatherData(city);
       weatherResponse=weatherResponseLiveData.getValue();
        return weatherResponseLiveData;
    }
}
