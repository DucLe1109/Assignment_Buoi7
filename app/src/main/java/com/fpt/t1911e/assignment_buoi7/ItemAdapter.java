package com.fpt.t1911e.assignment_buoi7;

import android.app.Activity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class ItemAdapter extends RecyclerView.Adapter {
    private Activity activity;
    private List<Item> list_item;

    public ItemAdapter(Activity activity, List<Item> list_item) {
        this.activity = activity;
        this.list_item = list_item;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = activity.getLayoutInflater().inflate(R.layout.hour_item, parent, false);
        ItemHolder holder = new ItemHolder(itemView);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        ItemHolder new_holder = (ItemHolder) holder;
        Item _item = list_item.get(position);

        String date_hour = convertTime(_item.getDateTime());
        new_holder.tvHour.setText(date_hour);
        new_holder.tvTemp2.setText(String.valueOf(_item.getTemperature().getValue()));

        int number_of_icon = _item.getWeatherIcon();
        String url_icon;
        if (number_of_icon < 10) {
            url_icon = "https://developer.accuweather.com/sites/default/files/0" + number_of_icon + "-s.png";
        } else {
            url_icon = "https://developer.accuweather.com/sites/default/files/" + number_of_icon + "-s.png";
        }
        Glide.with(this.activity).load(url_icon).into(new_holder.ivIcon);
    }

    @Override
    public int getItemCount() {
        return list_item.size();
    }

    public String convertTime(String inputTime) {
        SimpleDateFormat inFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss");
        Date date = null;
        try {
            date = inFormat.parse(inputTime);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        SimpleDateFormat outFormat = new SimpleDateFormat("ha");
        String goal = outFormat.format(date);
        return goal;
    }


    public class ItemHolder extends RecyclerView.ViewHolder {
        public TextView tvHour, tvTemp2;
        public ImageView ivIcon;

        public ItemHolder(@NonNull View itemView) {
            super(itemView);
            tvHour = itemView.findViewById(R.id.tvHour);
            tvTemp2 = itemView.findViewById(R.id.tvTemp2);
            ivIcon = itemView.findViewById(R.id.ivIcon);
        }
    }
}
