package com.example.easy_ride;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.easy_ride.Common.common;
import com.example.easy_ride.Model.Driver;
import com.example.easy_ride.Model.User;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.material.snackbar.Snackbar;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.rengwuxian.materialedittext.MaterialEditText;

import org.w3c.dom.Text;

import io.paperdb.Paper;

public class LoginPage extends AppCompatActivity {
 MaterialEditText ID,Password,Email;
 Button Login;
 FirebaseAuth auth;
 FirebaseDatabase database ;
 DatabaseReference Users,Drivers;
 RelativeLayout rootlayout;
 TextView text;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_page);
        ID = findViewById(R.id.txtidnumber);
        Password = findViewById(R.id.txtPassword);
        Email = findViewById(R.id.txtEmailAddress);
        Login = findViewById(R.id.btnLogin1);
        Paper.init(this);
        auth = FirebaseAuth.getInstance();
        database = FirebaseDatabase.getInstance();
        Users = database.getReference("Users");
     rootlayout = findViewById(R.id.rootlayout) ;
     Drivers = database.getReference("Drivers");
        Login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if(TextUtils.isEmpty(Email.getText().toString())){
                    Snackbar.make(rootlayout,"Please Enter Your Email Address", Snackbar.LENGTH_SHORT).show();
                    return;
                }
                if(TextUtils.isEmpty(ID.getText().toString())){
                    Snackbar.make(rootlayout,"Please Check Your ID Number", Snackbar.LENGTH_SHORT).show();
                    return;
                }if(TextUtils.isEmpty(Password.getText().toString())){
                    Snackbar.make(rootlayout,"Please Check Your Password", Snackbar.LENGTH_SHORT).show();
                    return;
                }


                if(Paper.book().read("type")== "passenger"){
                    PassengerLogin();
                }else{
                    DriverLogin();
                }

            }
        });
    }

    private void PassengerLogin() {
        auth.signInWithEmailAndPassword(Email.getText().toString(),Password.getText().toString())
                .addOnSuccessListener(new OnSuccessListener<AuthResult>() {
                    @Override
                    public void onSuccess(AuthResult authResult) {
                        final String userid = FirebaseAuth.getInstance().getCurrentUser().getUid().toString();

                        Users.addValueEventListener(new ValueEventListener() {
                            @Override
                            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {

                                common.user = dataSnapshot.child(userid).getValue(User.class);
                                if (common.user.getIDnumber() == ID.getText().toString()){
                                    Intent intent = new Intent(LoginPage.this,PassengerHome.class);
                                    startActivity(intent);
                                }else {
                                    Toast.makeText(LoginPage.this, "User ID Number not Correct", Toast.LENGTH_SHORT).show();
                                }
                            }

                            @Override
                            public void onCancelled(@NonNull DatabaseError databaseError) {

                                Toast.makeText(LoginPage.this, ""+databaseError.getMessage(), Toast.LENGTH_SHORT).show();
                            }
                        });
                    }
                }).addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception e) {
                Toast.makeText(LoginPage.this, ""+e.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void DriverLogin() {
        auth.signInWithEmailAndPassword(Email.getText().toString(),Password.getText().toString())
                .addOnSuccessListener(new OnSuccessListener<AuthResult>() {
                    @Override
                    public void onSuccess(AuthResult authResult) {
                        final String userid = FirebaseAuth.getInstance().getCurrentUser().getUid().toString();

                        Drivers.addValueEventListener(new ValueEventListener() {
                            @Override
                            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {

                                Driver driver = dataSnapshot.child(userid).getValue(Driver.class);
                               if (driver.getIdnumber().equals(ID.getText().toString())){
                                  common.driver = driver;
                                   Intent intent = new Intent(LoginPage.this,DriverHome.class);
                                   startActivity(intent);
                               }else {
                                   Toast.makeText(LoginPage.this, "Driver ID Number not Correct", Toast.LENGTH_SHORT).show();
                               }
                            }

                            @Override
                            public void onCancelled(@NonNull DatabaseError databaseError) {

                                Toast.makeText(LoginPage.this, ""+databaseError.getMessage(), Toast.LENGTH_SHORT).show();
                            }
                        });
                    }
                }).addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception e) {
                Toast.makeText(LoginPage.this, ""+e.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }
}
