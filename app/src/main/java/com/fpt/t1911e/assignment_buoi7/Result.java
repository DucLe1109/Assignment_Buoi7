package com.fpt.t1911e.assignment_buoi7;

import java.util.List;

public class Result {
    public List<com.fpt.t1911e.assignment_buoi7.DailyForecasts> getDailyForecasts() {
        return DailyForecasts;
    }

    public void setDailyForecasts(List<com.fpt.t1911e.assignment_buoi7.DailyForecasts> dailyForecasts) {
        DailyForecasts = dailyForecasts;
    }

    private List<DailyForecasts> DailyForecasts;
}
