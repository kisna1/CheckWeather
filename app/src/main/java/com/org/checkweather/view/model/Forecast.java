package com.org.checkweather.view.model;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Forecast {

    @SerializedName("cod")
    public String cod;

    @SerializedName("message")
    public String message;

    @SerializedName("list")
    public List<list> list;


    public String getCod() {
        return cod;
    }

    public String getMessage() {
        return message;
    }

    public List<Forecast.list> getList() {
        return list;
    }

    public static class list {

        @SerializedName("dt")
        public int dt;

        @SerializedName("dt_txt")
        public String dt_txt;

        @SerializedName("main")
        public Main main;


        @SerializedName("weather")
        public List<Weather> weather;

        @SerializedName("clouds")
        public Clouds clouds;

        @SerializedName("wind")
        public Wind wind;

        public int getDt() {
            return dt;
        }

        public String getDt_txt() {
            return dt_txt;
        }

        public Main getMain() {
            return main;
        }

        public List<Weather> getWeather() {
            return weather;
        }

        public Clouds getClouds() {
            return clouds;
        }

        public Wind getWind() {
            return wind;
        }
    }

    public static class Main {

        @SerializedName("temp_min")
        public double temp_min;

        @SerializedName("temp_max")
        public double temp_max;

        public double getTemp_min() {
            return temp_min;
        }

        public double getTemp_max() {
            return temp_max;
        }
    }

    public static class Weather {

        @SerializedName("dt")
        public int dt;

        @SerializedName("main")
        public String main;

        @SerializedName("description")
        public String description;

        public int getDt() {
            return dt;
        }

        public String getMain() {
            return main;
        }

        public String getDescription() {
            return description;
        }
    }

    public static class Clouds {
        @SerializedName("all")
        public int all;

        public int getAll() {
            return all;
        }
    }

    public static class Wind {
        @SerializedName("speed")
        public double speed;

        public double getSpeed() {
            return speed;
        }
    }
}
