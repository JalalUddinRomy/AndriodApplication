package com.example.myfirstapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class PlayerList extends AppCompatActivity {
    TextView toolbar;
    ImageView actionBarImg;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_player_list);
        //toolbar=findViewById(R.id.toolbar);
        //actionBarImg=findViewById(R.id.actionBarImg);
       // toolbar.setText("Player List");
       /* actionBarImg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(PlayerList.this, Practice1.class);
                startActivity(intent);
            }
        });*/
    }
}