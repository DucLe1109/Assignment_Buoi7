package com.fpt.t1911e.assignment_buoi7;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface ApiManager {

    public static String SERVER = "http://dataservice.accuweather.com/";

    @GET("forecasts/v1/hourly/12hour/353412?apikey=CxILqfbYMdKI30fs02iXyl2JZJdF2MeU&language=vi-vn&metric=true")
    Call<List<Item>> getData_Hour();

    @GET("forecasts/v1/daily/5day/353412?apikey=CxILqfbYMdKI30fs02iXyl2JZJdF2MeU&language=vi-vn&metric=true")
    Call<List<Item2>> getData_Day();

}
