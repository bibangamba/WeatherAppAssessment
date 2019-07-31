package com.levelup.bibangamba.weatherapp.adapters;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.levelup.bibangamba.weatherapp.R;
import com.levelup.bibangamba.weatherapp.models.HourlyWeatherData;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class HourlyWeatherAdapter extends
        RecyclerView.Adapter<HourlyWeatherAdapter.HourlyWeatherViewHolder> {
    private List<HourlyWeatherData> mHourlyWeatherDataList;

    public HourlyWeatherAdapter(List<HourlyWeatherData> hourlyWeatherDataList) {
        mHourlyWeatherDataList = hourlyWeatherDataList;
    }

    @NonNull
    @Override
    public HourlyWeatherViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View listItem = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.hourly_weather_list_item, viewGroup, false);

        return new HourlyWeatherViewHolder(listItem);
    }

    @Override
    public void onBindViewHolder(@NonNull HourlyWeatherViewHolder hourlyWeatherViewHolder, int i) {
        HourlyWeatherData hourlyWeatherData = mHourlyWeatherDataList.get(i);
        String weatherSummary = hourlyWeatherData.getSummary();
        String temperature = String.format("%s°C", hourlyWeatherData.getTemperature());
        SimpleDateFormat formatter = new SimpleDateFormat("HH:mm");
        String weatherHour = formatter.format(new Date(hourlyWeatherData.getTime()));
        hourlyWeatherViewHolder.listItemSummaryTextView.setText(weatherSummary);
        hourlyWeatherViewHolder.listItemTemperatureTextView.setText(temperature);
        hourlyWeatherViewHolder.listItemTimeTextView.setText(weatherHour);
    }

    @Override
    public int getItemCount() {
        return mHourlyWeatherDataList.size();
    }

    class HourlyWeatherViewHolder extends RecyclerView.ViewHolder {
        TextView listItemSummaryTextView;
        TextView listItemTemperatureTextView;
        TextView listItemTimeTextView;

        HourlyWeatherViewHolder(@NonNull View itemView) {
            super(itemView);
            listItemSummaryTextView = itemView.findViewById(R.id.list_item_summary_textview);
            listItemTemperatureTextView = itemView.findViewById(R.id.list_item_temperature_textview);
            listItemTimeTextView = itemView.findViewById(R.id.list_item_hour_textview);
        }
    }
}
