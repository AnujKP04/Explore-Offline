package com.example.exploreoffline.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.exploreoffline.Models.RouteModel;
import com.example.exploreoffline.R;
import com.example.exploreoffline.routefragment;

import java.util.ArrayList;

public class RouteAdpater extends RecyclerView.Adapter<RouteAdpater.viewHolder> {

    ArrayList<RouteModel> list;
    Context context;


    public RouteAdpater(ArrayList<RouteModel> list, Context context) {
        this.list = list;
        this.context = context;
    }

    public RouteAdpater(ArrayList<RouteModel> list, routefragment context){

    }

    @NonNull
    @Override
    public RouteAdpater.viewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.sample_routerecyclerview,parent,false);
        return new viewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RouteAdpater.viewHolder holder, int position) {
     RouteModel model = list.get(position);
     holder.imageView.setImageResource(model.getPic());
     holder.textView.setText(model.getText());
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class viewHolder extends RecyclerView.ViewHolder {

        ImageView imageView;
        TextView textView;
        public viewHolder(@NonNull View itemView) {
            super(itemView);
             imageView = itemView.findViewById(R.id.imageView3);
             textView = itemView.findViewById(R.id.textView2);
        }
    }
}
