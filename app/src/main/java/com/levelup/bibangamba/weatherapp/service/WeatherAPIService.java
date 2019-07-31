package com.levelup.bibangamba.weatherapp.service;

import com.levelup.bibangamba.weatherapp.models.WeatherResponse;

import retrofit2.Call;
import retrofit2.http.GET;

public interface WeatherAPIService {
    @GET("/forecast/60708be47531409008d4292425e128e2/42.3601,-71.0589")
    Call<WeatherResponse> getNewYorkWeather();
}
