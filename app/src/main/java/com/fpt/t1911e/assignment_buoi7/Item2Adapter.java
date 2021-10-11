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

public class Item2Adapter extends RecyclerView.Adapter {
    private Activity activity;
    private List<Item2> list_item2;

    public Item2Adapter(Activity activity, List<Item2> list_item2) {
        this.activity = activity;
        this.list_item2 = list_item2;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = activity.getLayoutInflater().inflate(R.layout.day_item, parent, false);
        Item2Holder holder = new Item2Holder(itemView);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        Item2Holder item2Holder = (Item2Holder) holder;
        Item2 _item = list_item2.get(position);
        String _day = convertTime(_item.getDailyForecasts().getDate());
        item2Holder.tvDay.setText(_day);

        int number_of_icon = _item.getDailyForecasts().getDay().getIcon();
        String url_icon;
        if (number_of_icon < 10) {
            url_icon = "https://developer.accuweather.com/sites/default/files/0" + number_of_icon + "-s.png";
        } else {
            url_icon = "https://developer.accuweather.com/sites/default/files/" + number_of_icon + "-s.png";
        }
        Glide.with(this.activity).load(url_icon).into(item2Holder.ivIcon2);

        item2Holder.tvMax_temp.setText(String.valueOf(_item.getDailyForecasts().getTemperature().getMaximum().getValue()));
        item2Holder.tvMin_temp.setText(String.valueOf(_item.getDailyForecasts().getTemperature().getMinimum().getValue()));
    }

    @Override
    public int getItemCount() {
        return 0;
    }


    public String convertTime(String inputTime) {
        SimpleDateFormat inFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss");
        Date date = null;
        try {
            date = inFormat.parse(inputTime);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        SimpleDateFormat outFormat = new SimpleDateFormat("EEEE");
        String goal = outFormat.format(date);
        return goal;
    }

    public class Item2Holder extends RecyclerView.ViewHolder {
        TextView tvDay, tvMin_temp, tvMax_temp;
        ImageView ivIcon2;

        public Item2Holder(@NonNull View itemView) {
            super(itemView);
            tvDay = itemView.findViewById(R.id.tvDay);
            tvMin_temp = itemView.findViewById(R.id.tvMin_temp);
            tvMax_temp = itemView.findViewById(R.id.tvMax_temp);
            ivIcon2 = itemView.findViewById(R.id.ivIcon2);
        }
    }
}
