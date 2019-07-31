package com.levelup.bibangamba.weatherapp.service;

import com.levelup.bibangamba.weatherapp.models.WeatherResponse;

import retrofit2.Call;
import retrofit2.http.GET;

import static com.levelup.bibangamba.weatherapp.utils.Constants.API_ENDPOINT;

public interface WeatherAPIService {


    @GET(API_ENDPOINT)
    Call<WeatherResponse> getNewYorkWeather();
}
