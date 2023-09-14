package com.example.myfirstapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {
    Button Nextbutton;
    EditText Name;
    EditText Phone;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Nextbutton=findViewById(R.id.NextButton);
        Name=findViewById(R.id.Name);
        Phone=findViewById(R.id.Phone);
        Nextbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this, "Hlw!", Toast.LENGTH_SHORT).show();
            }
        });
        Name.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this, "Enter your Name", Toast.LENGTH_SHORT).show();
            }
        });
        Phone.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this, "Enter your PhoneNumber", Toast.LENGTH_SHORT).show();
            }
        });

    }
}