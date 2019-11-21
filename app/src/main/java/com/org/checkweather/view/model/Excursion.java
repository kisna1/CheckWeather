package com.org.checkweather.view.model;

import android.os.Parcel;
import android.os.Parcelable;

public class Excursion implements Parcelable {

    private String sourceName;
    private String destName;
    private String price;
    private String startDate;
    private String endDate;
    private String weather;

    public Excursion(String sourceName, String destName, String price, String startDate, String endDate, String weather) {
        this.sourceName = sourceName;
        this.destName = destName;
        this.price = price;
        this.startDate = startDate;
        this.endDate = endDate;
        this.weather = weather;
    }

    public String getSourceName() {
        return sourceName;
    }

    public void setSourceName(String sourceName) {
        this.sourceName = sourceName;
    }

    public String getDestName() {
        return destName;
    }

    public void setDestName(String destName) {
        this.destName = destName;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public String getEndDate() {
        return endDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }

    public String getWeather() {
        return weather;
    }

    public void setWeather(String weather) {
        this.weather = weather;
    }

    public static final Creator CREATOR = new Creator() {
        public Excursion createFromParcel(Parcel in ) {
            return new Excursion( in );
        }

        public Excursion[] newArray(int size) {
            return new Excursion[size];
        }
    };

    public Excursion(Parcel in ) {
        readFromParcel( in );
    }

    private void readFromParcel(Parcel in ) {
        sourceName = in.readString();
        destName = in.readString();
        price = in.readString();
        startDate = in.readString();
        endDate = in.readString();
        weather = in.readString();
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(sourceName);
        dest.writeString(destName);
        dest.writeString(price);
        dest.writeString(startDate);
        dest.writeString(endDate);
        dest.writeString(weather);

    }
}
