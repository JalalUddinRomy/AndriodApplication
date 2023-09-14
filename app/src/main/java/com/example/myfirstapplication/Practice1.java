package com.example.myfirstapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.Toast;

public class Practice1 extends AppCompatActivity {
    EditText GmailID, passwordID;
    Spinner spinner, genderSpinner;
    ImageView salah, alison, van;
    SharedPreferences sharedPreferences;
    String player[] = {"Select one", "Mohammad Salah", "Allison Backer", "Virgil van Dijk"};
    String Gender[] = {"Select Gender", "Male", "Female", "None"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_practice1);
        GmailID = findViewById(R.id.MailId);
        passwordID = findViewById(R.id.passwordID);
        sharedPreferences = getApplicationContext().getSharedPreferences("Preference", MODE_PRIVATE);
        spinner = findViewById(R.id.favtrSpinner);
        genderSpinner = findViewById(R.id.genderSpinner);
        salah = findViewById(R.id.salah);
        van = findViewById(R.id.van);
        alison = findViewById(R.id.alison);
        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<>(Practice1.this, android.R.layout.simple_list_item_1, player);
        spinner.setAdapter(arrayAdapter);
        ArrayAdapter<String> arrayAdapter1 = new ArrayAdapter<>(Practice1.this, android.R.layout.simple_list_item_1, Gender);
        genderSpinner.setAdapter(arrayAdapter1);
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                String item = spinner.getSelectedItem().toString();
                Toast.makeText(Practice1.this, "Select your Favourite player", Toast.LENGTH_SHORT).show();
                if (item.contains("Salah")) {
                    salah.setVisibility(view.VISIBLE);
                    van.setVisibility(view.GONE);
                    alison.setVisibility(view.GONE);
                } else if (item.contains("Allison Backer")) {
                    alison.setVisibility(view.VISIBLE);
                    salah.setVisibility(view.GONE);
                    van.setVisibility(view.GONE);

                } else if (item.contains("Virgil van Dijk")) {
                    van.setVisibility(view.VISIBLE);
                    salah.setVisibility(view.GONE);
                    alison.setVisibility(view.GONE);
                } else {
                    van.setVisibility(view.GONE);
                    salah.setVisibility(view.GONE);
                    alison.setVisibility(view.GONE);

                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
        genderSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                String item2 = genderSpinner.getSelectedItem().toString();
                Toast.makeText(Practice1.this, "" + item2, Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

    }


    public void loginBtn(View view) {
        String getMail = sharedPreferences.getString("gmail", null);
        String getPassword = sharedPreferences.getString("password", null);
        String Gmail = GmailID.getText().toString();
        String password = passwordID.getText().toString();
        if (Gmail.equals(getMail) && password.equals(getPassword)) {
            Toast.makeText(this, "Login successful!", Toast.LENGTH_SHORT).show();
            Intent intent = new Intent(Practice1.this, PlayerList.class);
            startActivity(intent);
        }
        else if (!password.equals(getPassword)) {
            Toast.makeText(this, "Wrong Password", Toast.LENGTH_SHORT).show();
        }
        else if (!Gmail.equals(getMail)) {
            Toast.makeText(this, "Wrong Email", Toast.LENGTH_SHORT).show();
        }

        else {
            Toast.makeText(this, "Wrong password and Gmail", Toast.LENGTH_SHORT).show();
        }
    }
}
