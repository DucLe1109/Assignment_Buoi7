package com.fpt.t1911e.assignment_buoi7;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.google.gson.JsonElement;

import java.util.ArrayList;
import java.util.List;
import java.util.Observable;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {
    private List<Item> list_item = new ArrayList<>();
    private List<Item2> list_item2 = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false);
        ItemAdapter adapter = new ItemAdapter(this, list_item);
        RecyclerView recyclerView = findViewById(R.id._12Hour_RecycleView);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(adapter);

//        RecyclerView.LayoutManager layoutManager2 = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
//        Item2Adapter adapter2 = new Item2Adapter(this, list_item2);
//        RecyclerView recyclerView2 = findViewById(R.id._5Days_RecycleView);
//        recyclerView2.setLayoutManager(layoutManager2);
//        recyclerView2.setAdapter(adapter2);

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(ApiManager.SERVER)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        ApiManager service = retrofit.create(ApiManager.class);

        service.getData_Hour().enqueue(new Callback<List<Item>>() {
            @Override
            public void onResponse(Call<List<Item>> call, Response<List<Item>> response) {
                List<Item> list = response.body();
                if (list != null) {
                    for (Item x : list) {
                        list_item.add(x);
                    }
                    adapter.notifyDataSetChanged();
                }
            }

            @Override
            public void onFailure(Call<List<Item>> call, Throwable t) {

            }
        });

//        service.getData_Day().enqueue(new Callback<List<Item2>>() {
//            @Override
//            public void onResponse(Call<List<Item2>> call, Response<List<Item2>> response) {
//                List<Item2> list = response.body();
//                if (list != null) {
//                    for (Item2 x : list) {
//                        list_item2.add(x);
//                    }
//                    adapter.notifyDataSetChanged();
//                }
//            }
//
//            @Override
//            public void onFailure(Call<List<Item2>> call, Throwable t) {
//
//            }
//        });
    }
}