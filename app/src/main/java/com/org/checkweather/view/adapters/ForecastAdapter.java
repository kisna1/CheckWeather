package com.org.checkweather.view.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.org.checkweather.R;
import com.org.checkweather.view.model.Forecast;

import java.util.ArrayList;
import java.util.List;

public class ForecastAdapter extends RecyclerView.Adapter<ForecastAdapter.ViewHolder> {


    private List<Forecast.list> forecastArrayList ;
    private Context mContext;

    public ForecastAdapter(List<Forecast.list> forecastArrayList, Context mContext) {
        this.forecastArrayList = forecastArrayList;
        this.mContext = mContext;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.cardview_forecast_item, parent, false);

        return new ForecastAdapter.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int position) {
        Forecast.list list = forecastArrayList.get(position);

        viewHolder.txtTemp.setText("Temperature : Min " + list.main.temp_min + " Max : " + list.main.temp_max);

        viewHolder.txtWeather.setText("Weather: " + list.weather.get(0).main + " Desc : " + list.weather.get(0).description);

        viewHolder.txtClouds.setText("Clouds : " + list.clouds.all);

        viewHolder.txtWind.setText("Wind : Speed " + list.wind.speed);

        viewHolder.txtDateTime.setText(list.dt_txt);
    }

    @Override
    public int getItemCount() {
        if(forecastArrayList != null )
            return  forecastArrayList.size();
        else
            return 0;
    }

    public static class ViewHolder extends RecyclerView.ViewHolder{

        TextView txtTemp, txtWeather, txtClouds, txtWind, txtDateTime;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            this.txtTemp = itemView.findViewById(R.id.txtTemp);
            this.txtWeather = itemView.findViewById(R.id.txtWeather);
            this.txtClouds = itemView.findViewById(R.id.txtClouds);
            this.txtWind = itemView.findViewById(R.id.txtWind);
            this. txtDateTime  = itemView.findViewById(R.id.txtDateTime);
        }
    }
}
