package com.example.exploreoffline;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.example.exploreoffline.Adapter.RouteAdpater;
import com.example.exploreoffline.Models.RouteModel;

import java.util.ArrayList;

public class routes extends AppCompatActivity {
    RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_routes);

    recyclerView = findViewById(R.id.routesrecyclerview);
        ArrayList<RouteModel> list = new ArrayList<>();
        list.add(new RouteModel("Panchgani",R.drawable.panchgani));
        list.add(new RouteModel("Shetra",R.drawable.kshetra));
        list.add(new RouteModel("Tapola",R.drawable.tapola));
        list.add(new RouteModel("Pratapgad",R.drawable.pratapgad));
        list.add(new RouteModel("Medha",R.drawable.wilson));
        RouteAdpater routeAdpater = new RouteAdpater(list,this);
        recyclerView.setAdapter(routeAdpater);

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(linearLayoutManager);

//        GridLayoutManager gridLayoutManager = new GridLayoutManager(this,2);
//        recyclerView.setLayoutManager(gridLayoutManager);


    }
}