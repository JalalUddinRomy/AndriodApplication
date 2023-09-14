package com.example.myfirstapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import java.util.regex.Pattern;
import android.widget.TextView;
import android.widget.Toast;
import android.text.method.HideReturnsTransformationMethod;
import android.text.method.PasswordTransformationMethod;


public class RegistrationActivity extends AppCompatActivity {
    EditText FullnameTv, GmailTv, PhoneTv, CountryTv, PasswordTv;
    SharedPreferences sharedPreferences;
    Pattern Gmailpattern, PasswordPattern;
    Button showHideBtn;
    boolean hidePass;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration);
        hidePass=true;
        FullnameTv = findViewById(R.id.fullnameRid);
        GmailTv = findViewById(R.id.emailRid);
        PhoneTv = findViewById(R.id.phoneNoRid);
        CountryTv = findViewById(R.id.CountrynameRid);
        PasswordTv = findViewById(R.id.passwordRid);
        showHideBtn=findViewById(R.id.hideShowId);
        sharedPreferences = getApplicationContext().getSharedPreferences("Preference", MODE_PRIVATE);
        Gmailpattern = Pattern.compile("[a-zA-z0-9._]+@gmail.com");
        PasswordPattern = Pattern.compile(("^(?=.*[A-Za-z])(?=.*\\d)[A-Za-z\\d@$!%*?&]{8,}$"));
    }


    public void registrationBtn(View view) {
        String name = FullnameTv.getText().toString();
        String gmail = GmailTv.getText().toString();
        String password = PasswordTv.getText().toString();
        String phone = PhoneTv.getText().toString();
        String country = CountryTv.getText().toString();
        SharedPreferences.Editor editor = sharedPreferences.edit();
        if (Gmailpattern.matcher(gmail).matches() & PasswordPattern.matcher(password).matches()) {
            editor.putString("gmail", gmail);
            editor.putString("name", name);
            editor.putString("country", country);
            editor.putString("phone", phone);
            editor.putString("password", password);
            Intent intent = new Intent(RegistrationActivity.this, Practice1.class);
            startActivity(intent);

        } else if (!Gmailpattern.matcher(gmail).matches()) {
            Toast.makeText(this, "Invalid email", Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(this, "Invalid Password. Password must be at least 8 characters and contain letters and numbers.", Toast.LENGTH_SHORT).show();
        }


        editor.commit();
        editor.apply();

    }

    public void showHideBtn(View view) {
        if(hidePass){

            PasswordTv.setTransformationMethod(HideReturnsTransformationMethod.getInstance());
            showHideBtn.setBackground(ContextCompat.getDrawable(this,R.drawable.hidepassword));
            hidePass=false;
        } else{
            PasswordTv.setTransformationMethod(PasswordTransformationMethod.getInstance());
            showHideBtn.setBackground(ContextCompat.getDrawable(this,R.drawable.baseline_remove_red_eye_24));
            hidePass=true;
        }
    }
}

