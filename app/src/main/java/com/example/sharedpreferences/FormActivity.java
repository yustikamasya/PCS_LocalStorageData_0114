package com.example.sharedpreferences;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class FormActivity extends AppCompatActivity implements View.OnClickListener{
    private EditText edtNama, edtEmail;
    private Button btnSimpan;

    private static final String PREFS_NAME = "user_pref";
    private static final String NAME = "name";
    private static final String EMAIL = "email";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_form);

        edtNama = findViewById(R.id.edtNama);
        edtEmail = findViewById(R.id.edtEmail);

        btnSimpan = findViewById(R.id.btnSimpan);
        btnSimpan.setOnClickListener(this);

        SharedPreferences preferences = getSharedPreferences(PREFS_NAME,MODE_PRIVATE);


        String name = preferences.getString(NAME,"");
        String email = preferences.getString(EMAIL,"");

        edtNama.setText(name.isEmpty() ? "....." : name);
        edtEmail.setText(email.isEmpty() ? "....." : email);
    }

    @Override
    public void onClick(View v) {
        if(v.getId()==R.id.btnSimpan){
            SharedPreferences preferences = getSharedPreferences(PREFS_NAME,MODE_PRIVATE);
            SharedPreferences.Editor editor = preferences.edit();

            String name= edtNama.getText().toString().trim();
            String email = edtEmail.getText().toString().trim();

            editor.putString(NAME,name);
            editor.putString(EMAIL,email);

            editor.apply();
            Toast.makeText(this,"Data tersimpan di Shared Preferences",Toast.LENGTH_SHORT).show();

            Intent intent = new Intent(this,MainActivity.class);
            startActivity(intent);
        }
    }
}