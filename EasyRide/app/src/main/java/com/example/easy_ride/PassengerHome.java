package com.example.easy_ride;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.easy_ride.Common.common;
import com.example.easy_ride.Model.Rides;
import com.example.easy_ride.Model.Token;
import com.example.easy_ride.ViewHolder.PaymentRecyclerView;
import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.rengwuxian.materialedittext.MaterialEditText;
import com.squareup.picasso.Picasso;

import io.paperdb.Paper;

public class PassengerHome extends AppCompatActivity {
   TextView name,surname,Amount;
   EditText Pin,Number;
   Button Recharge,Transfer,Ping,Logout,Cancel,Submit,Profile;
   LinearLayout Rlayout,Tlayout;
   ImageView imageView;
   FirebaseDatabase database;
    RecyclerView recyclerView;
    public RecyclerView.LayoutManager layoutManager;
    FirebaseRecyclerAdapter<Rides, PaymentRecyclerView> adapter;
    DatabaseReference Rides;
   DatabaseReference Token;
   Button Taxi;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_passenger_home);
        Paper.init(this);

        Taxi = findViewById(R.id.CatchATaxi);
        Taxi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });
        /*
        Picasso.with(getBaseContext()).load(Paper.book().read("Image").toString()).into(imageView);
        name.setText(common.user.getName());
        surname.setText(common.user.getSurname());
        Amount.setText(common.user.getAmmount());

database = FirebaseDatabase.getInstance();
Token = database.getReference("Token");


        Recharge.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Rlayout.setVisibility(View.INVISIBLE);

            }
        });
        Cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Rlayout.setVisibility(View.VISIBLE);
            }
        });
        Submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Token.addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                        if(dataSnapshot.child(Pin.getText().toString()).exists()){
                            com.example.easy_ride.Model.Token token = dataSnapshot.child(Pin.getText().toString()).getValue(Token.class);
                            if (token.getStatus().equals("Used")){
                                Toast.makeText(PassengerHome.this, "Voucher Already Used", Toast.LENGTH_SHORT).show();
                            }else {
                                com.example.easy_ride.Model.Token token1 = new Token();
                                token1  = dataSnapshot.child(Pin.getText().toString()).getValue(com.example.easy_ride.Model.Token.class);
                                token1.setStatus("Used");
                                Token.child(Pin.getText().toString()).setValue(token1);
                                Toast.makeText(PassengerHome.this, "Voucher Recharged", Toast.LENGTH_SHORT).show();

                            }

                        }else {
                            Toast.makeText(PassengerHome.this, "Invalid Ticked", Toast.LENGTH_SHORT).show();
                        }



                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError databaseError) {

                    }
                });
            }
        });

        Transfer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Tlayout.setVisibility(View.INVISIBLE);
            }
        });
        Ping.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
        Logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(PassengerHome.this,Homepage.class);
                startActivity(intent);
            }
        });

    }

*/
    }



}
