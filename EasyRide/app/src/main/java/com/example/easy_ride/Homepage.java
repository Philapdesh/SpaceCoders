package com.example.easy_ride;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import io.paperdb.Paper;

public class Homepage extends AppCompatActivity {
 Button Login,Register;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Paper.init(this);
        setContentView(R.layout.activity_homepage);
 Login = findViewById(R.id.btnLogin);
 Register = findViewById(R.id.btnregister);
        Login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Paper.book().write("Home","Login");
                Intent intent = new Intent(Homepage.this,AccountType.class);
                startActivity(intent);
            }
        });
        Register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Paper.book().write("Home","Register");
                Intent intent = new Intent(Homepage.this,AccountType.class);
                startActivity(intent);
            }
        });
    }
}
