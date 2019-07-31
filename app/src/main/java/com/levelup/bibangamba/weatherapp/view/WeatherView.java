package com.levelup.bibangamba.weatherapp.view;

import com.levelup.bibangamba.weatherapp.models.HourlyWeatherData;

import java.util.List;

public interface WeatherView {
     void setCurrentWeather(String summary, double temperature);
    void setHourlyWeatherData(List<HourlyWeatherData> hourlyWeatherDataList);
}
