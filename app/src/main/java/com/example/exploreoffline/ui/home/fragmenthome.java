package com.example.exploreoffline.ui.home;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.exploreoffline.Adapter.RouteAdpater;
import com.example.exploreoffline.Models.RouteModel;
import com.example.exploreoffline.R;

import java.util.ArrayList;


public class fragmenthome extends Fragment {
    RecyclerView recyclerView;

    public fragmenthome() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_fragmenthome, container, false);
        recyclerView = view.findViewById(R.id.recyclerview);
        ArrayList<RouteModel> list = new ArrayList<>();
        list.add(new RouteModel("Route",R.drawable.tapola));
        list.add(new RouteModel("Route",R.drawable.panchgani));
        list.add(new RouteModel("Route",R.drawable.kshetra));
        list.add(new RouteModel("Route",R.drawable.pratapgad));
//        list.add(new RouteModel("Route",R.drawable.meda));
        RouteAdpater adpater = new RouteAdpater(list,getContext());
        recyclerView.setAdapter(adpater);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext());
        recyclerView.setLayoutManager(linearLayoutManager);

        return view;
    }
}