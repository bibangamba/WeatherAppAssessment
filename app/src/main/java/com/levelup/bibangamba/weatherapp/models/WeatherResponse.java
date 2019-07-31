package com.levelup.bibangamba.weatherapp.models;

public class WeatherResponse {
    private CurrentWeather currently;
    private HourlyWeather hourly;

    public CurrentWeather getCurrently() {
        return currently;
    }

    public HourlyWeather getHourly() {
        return hourly;
    }
}
