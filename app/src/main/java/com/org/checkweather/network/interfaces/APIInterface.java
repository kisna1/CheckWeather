package com.org.checkweather.network.interfaces;

import com.org.checkweather.view.model.Forecast;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface APIInterface {

    @GET("forecast")
    Call<Forecast> doGetForecast(@Query("q") String p,
                                 @Query("appid")  String appid,
                                 @Query("cnt")  int cnt,
                                 @Query("units")  String units);



}
