package com.levelup.bibangamba.weatherapp.view;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.TextView;

import com.levelup.bibangamba.weatherapp.R;
import com.levelup.bibangamba.weatherapp.adapters.HourlyWeatherAdapter;
import com.levelup.bibangamba.weatherapp.models.HourlyWeatherData;
import com.levelup.bibangamba.weatherapp.presenter.WeatherPresenter;

import java.util.List;
import java.util.Locale;

public class WeatherActivity extends AppCompatActivity implements WeatherView {

    private TextView mWeatherSummaryTextView;
    private TextView mWeatherTemperatureTextView;
    private RecyclerView mRecyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_weather);
        mWeatherSummaryTextView = findViewById(R.id.weather_summary_name_textview);
        mWeatherTemperatureTextView = findViewById(R.id.temperature_textview);

        mRecyclerView = findViewById(R.id.hourly_weather_data_recycler_view);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));

        WeatherPresenter weatherPresenter = new WeatherPresenter(this);
        weatherPresenter.getWeatherData();
    }

    @Override
    public void setCurrentWeather(String summary, double temperature) {
        mWeatherSummaryTextView.setText(summary);
        mWeatherTemperatureTextView.setText(String.format(Locale.getDefault(),
                "%s°C", temperature));
    }

    @Override
    public void setHourlyWeatherData(List<HourlyWeatherData> hourlyWeatherDataList) {
        HourlyWeatherAdapter adapter = new HourlyWeatherAdapter(hourlyWeatherDataList);
        mRecyclerView.setAdapter(adapter);
    }
}
