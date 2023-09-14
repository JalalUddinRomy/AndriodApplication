package com.example.myfirstapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

public class SpleshScreen extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splesh_screen);
        Thread thread = new Thread() {
            @Override
            public void run() {
                try {
                    sleep(4000);
                    Intent intent = new Intent(SpleshScreen.this, RegistrationActivity.class);
                    startActivity(intent);
                    finish();
                } catch (Exception e) {
                }
            }

        };
        thread.start();

        }

    }
