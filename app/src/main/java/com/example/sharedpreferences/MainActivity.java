package com.example.sharedpreferences;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private TextView txtNama, txtEmail;
    private Button btnUbah;

    private static final String PREFS_NAME = "user_pref";
    private static final String NAME = "name";
    private static final String EMAIL = "email";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        txtNama= findViewById(R.id.txtNama);
        txtEmail=findViewById(R.id.txtEmail);

        btnUbah = findViewById(R.id.btnUbah);
        btnUbah.setOnClickListener(this);

        SharedPreferences preferences = getSharedPreferences(PREFS_NAME,MODE_PRIVATE);
        String name = preferences.getString(NAME,"");
        String email = preferences.getString(EMAIL,"");

        txtNama.setText(name.isEmpty() ? "....." : name);
        txtEmail.setText(email.isEmpty() ? "....." : email);
    }

    @Override
    public void onClick(View v) {
        if (v.getId()== R.id.btnUbah){
            Intent intent = new Intent(this,FormActivity.class);
            startActivity(intent);
        }

    }
}