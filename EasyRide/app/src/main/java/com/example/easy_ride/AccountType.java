package com.example.easy_ride;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import io.paperdb.Paper;

public class AccountType extends AppCompatActivity {
 Button Driver,Passenger;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_account_type);
        Paper.init(this);
        Driver = findViewById(R.id.Driverbtn);
        Passenger = findViewById(R.id.Passengerbtn);
        Driver.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               if (Paper.book().read("Home").equals("Register")){
                   Intent intent = new Intent(AccountType.this,DriverRegistraion.class);
                   startActivity(intent);
               }else {
                   Intent intent = new Intent(AccountType.this,LoginPage.class);
                   startActivity(intent);
               }


            }
        });
        Passenger.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (Paper.book().read("Home").equals("Register")){
                    Intent intent = new Intent(AccountType.this,PassengerRegistration.class);
                    startActivity(intent);
                }else {
                    Intent intent = new Intent(AccountType.this,LoginPage.class);
                    startActivity(intent);
                }

            }
        });
    }
}
