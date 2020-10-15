package com.example.task4.ui;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelProviders;

import android.os.Bundle;
import android.util.Log;

import com.example.task4.R;
import com.example.task4.databinding.ActivityMainBinding;
import com.example.task4.model.WeatherResponse;
import com.example.task4.model.repository.MainRepository;
import com.example.task4.viewmodel.MainViewModel;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = MainActivity.class.getName();
    MainViewModel mainViewModel;
    public static String lat = "24.473900";
    public static String lon = "75.144600";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_main);
       // com.example.task4.databinding.ActivityMainBinding activityMainBindinga=DataBindingUtil.setContentView(this,R.layout.activity_main);
         final ActivityMainBinding activityMainBinding=DataBindingUtil.setContentView(this, R.layout.activity_main);
        mainViewModel= ViewModelProviders.of(this).get(MainViewModel.class);
             activityMainBinding.setLifecycleOwner(this);
             mainViewModel.getCurrentWeatherData("manasa").observe(this, new Observer<WeatherResponse>() {
                 @Override
                 public void onChanged(WeatherResponse weatherResponse) {
                     if (weatherResponse != null) {
                        // activityMainBinding.txtCountry.setText(weatherResponse.name);
                         //activityMainBinding.txtLat.setText(weatherResponse.toString());
                         //activityMainBinding.txtLon.setText(" ");
                         //activityMainBinding.txtPressure.setText(" ");
                         Log.d(TAG,"response is not null");
                         activityMainBinding.setWeather(weatherResponse);
                     }
                     else{
                         Log.d(TAG,"response is null");
                     }
                 }
             });

    }
}