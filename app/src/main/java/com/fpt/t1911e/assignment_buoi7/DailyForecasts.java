package com.fpt.t1911e.assignment_buoi7;

public class DailyForecasts {
    private String Date;
    private Temperature Temperature;
    private Day Day;

    public Day getDay() {
        return Day;
    }

    public void setDay(Day day) {
        Day = day;
    }

    public String getDate() {
        return Date;
    }

    public void setDate(String date) {
        Date = date;
    }

    public com.fpt.t1911e.assignment_buoi7.Temperature getTemperature() {
        return Temperature;
    }

    public void setTemperature(com.fpt.t1911e.assignment_buoi7.Temperature temperature) {
        Temperature = temperature;
    }
}
