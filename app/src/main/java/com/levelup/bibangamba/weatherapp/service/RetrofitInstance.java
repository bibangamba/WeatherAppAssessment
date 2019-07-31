package com.levelup.bibangamba.weatherapp.service;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import static com.levelup.bibangamba.weatherapp.utils.Constants.BASE_URL;

public class RetrofitInstance {
    private static Retrofit mRetrofit = new Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build();

    private static final WeatherAPIService WEATHER_API_SERVICE = mRetrofit
            .create(WeatherAPIService.class);

    public static WeatherAPIService getWeatherApiServiceInstance(){return WEATHER_API_SERVICE;}

}
