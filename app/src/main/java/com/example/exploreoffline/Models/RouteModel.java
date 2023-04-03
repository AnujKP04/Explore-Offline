package com.example.exploreoffline.Models;

import android.view.View;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class RouteModel {
    String text;

    int pic;



    public RouteModel(String text, int pic) {
//        super();
        this.text = text;
        this.pic = pic;
    }


    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public int getPic() {
        return pic;
    }

    public void setPic(int pic) {
        this.pic = pic;
    }
}
