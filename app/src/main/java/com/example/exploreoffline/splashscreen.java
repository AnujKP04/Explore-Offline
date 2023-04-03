package com.example.exploreoffline;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.widget.ImageView;

public class splashscreen extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splashscreen);

//        getSupportActionBar().hide();

//        ImageView imageView = new (ImageView)findViewById(R.id.splashimg);
//        imageView.setBackgroundResource(R.drawable.splashimg);

        // Using handler

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intent = new Intent(splashscreen.this,login.class);
                startActivity(intent);
                finish();
            }
        },3000);

//        Thread thread = new Thread(){
//            @Override
//            public void run() {
//                try {
//                    sleep(2000);
//                }
//                catch (Exception e){
//                    e.printStackTrace();
//                }
//                finally {
//                    Intent ilogin = new Intent(splashscreen.this,MainActivity.class);
//                    startActivity(ilogin);
////                    finish();
//                }
//            }
//        };
    }
}