package com.levelup.bibangamba.weatherapp.presenter;

import android.util.Log;

import com.levelup.bibangamba.weatherapp.models.CurrentWeather;
import com.levelup.bibangamba.weatherapp.models.HourlyWeather;
import com.levelup.bibangamba.weatherapp.models.WeatherResponse;
import com.levelup.bibangamba.weatherapp.service.RetrofitInstance;
import com.levelup.bibangamba.weatherapp.service.WeatherAPIService;
import com.levelup.bibangamba.weatherapp.view.WeatherView;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class WeatherPresenter {
    WeatherAPIService mWeatherAPIService;
    WeatherView mWeatherView;
    CurrentWeather mCurrentWeather;
    HourlyWeather mHourlyWeather;

    public WeatherPresenter(WeatherView weatherView) {
        mWeatherAPIService = RetrofitInstance.getWeatherApiServiceInstance();
        mWeatherView = weatherView;
    }

    public void getWeatherData() {
        mWeatherAPIService.getNewYorkWeather().enqueue(new Callback<WeatherResponse>() {
            @Override
            public void onResponse(Call<WeatherResponse> call, Response<WeatherResponse> response) {
                WeatherResponse weatherResponse = response.body();
                Log.d("debugging presenter", response.body().toString());
                if (weatherResponse != null) {
                    mCurrentWeather = weatherResponse.getCurrently();
                    mHourlyWeather = weatherResponse.getHourly();

                    mWeatherView.setCurrentWeather(mCurrentWeather.getSummary(),
                            mCurrentWeather.getTemperature());
                    mWeatherView.setHourlyWeatherData(mHourlyWeather.getData());
                }

            }

            @Override
            public void onFailure(Call<WeatherResponse> call, Throwable t) {
//                Toast.makeText(, "", Toast.LENGTH_SHORT).show();
            }
        });
    }
}
