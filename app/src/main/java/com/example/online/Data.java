package com.example.online;

public class Data {
    String reading,type,time,date;

    Data(){

    }

    public Data(String reading, String type, String time, String date) {
        this.reading = reading;
        this.type = type;
        this.time = time;
        this.date = date;
    }

    public String getReading() {
        return reading;
    }

    public String getType() {
        return type;
    }

    public String getTime() {
        return time;
    }

    public String getDate() {
        return date;
    }
}
