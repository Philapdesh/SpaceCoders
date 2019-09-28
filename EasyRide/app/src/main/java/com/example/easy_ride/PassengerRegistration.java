package com.example.easy_ride;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.Toast;

import com.example.easy_ride.Model.User;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.material.snackbar.Snackbar;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.rengwuxian.materialedittext.MaterialEditText;

public class PassengerRegistration extends AppCompatActivity {
    FirebaseDatabase database;
    DatabaseReference Users;
    FirebaseAuth auth;
    RelativeLayout rootlayout;
    Boolean valid = false;
    MaterialEditText UserID,Name,Surname,Address,Code,contact,EmailAdress,Password;
    Button Register,Home;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_passenger_registration);
        auth = FirebaseAuth.getInstance();
        database = FirebaseDatabase.getInstance();
        Register = findViewById(R.id.btnSignup);
        Users = database.getReference("Users");
Register.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View view) {
        insertData();
    }
});

    }

    private void insertData() {


        if(TextUtils.isEmpty(Name.getText().toString())){
            Snackbar.make(rootlayout,"Please Enter Your First Name", Snackbar.LENGTH_SHORT).show();
            return;
        }
        if(TextUtils.isEmpty(Surname.getText().toString())){
            Snackbar.make(rootlayout,"Please Enter Your Surname Name", Snackbar.LENGTH_SHORT).show();
            return;
        }
        if(TextUtils.isEmpty(Address.getText().toString())){
            Snackbar.make(rootlayout,"Please Enter Your Home Address", Snackbar.LENGTH_SHORT).show();
            return;
        }
        if(TextUtils.isEmpty(Code.getText().toString())){
            Snackbar.make(rootlayout,"Please Enter Your Province Code", Snackbar.LENGTH_SHORT).show();
            return;
        }
        if(TextUtils.isEmpty(Password.getText().toString())){
            Snackbar.make(rootlayout,"Please Enter Your First Name", Snackbar.LENGTH_SHORT).show();
            return;
        }  if(TextUtils.isEmpty(contact.getText().toString()) || contact.getText().toString().length() != 10){
            Snackbar.make(rootlayout,"Please Check Your Phone number", Snackbar.LENGTH_SHORT).show();
            return;
        }
        if(TextUtils.isEmpty(EmailAdress.getText().toString())){
            Snackbar.make(rootlayout,"Please Enter Your Email Address", Snackbar.LENGTH_SHORT).show();
            return;
        }
        if(TextUtils.isEmpty(UserID.getText().toString())){
            Snackbar.make(rootlayout,"Please Check Your ID Number", Snackbar.LENGTH_SHORT).show();
            return;
        }



        auth.createUserWithEmailAndPassword(EmailAdress.getText().toString(),Password.getText().toString()).addOnSuccessListener(new OnSuccessListener<AuthResult>() {
            @Override
            public void onSuccess(AuthResult authResult) {
                User user = new User();
                user.setName(Name.getText().toString());
                user.setSurname(Surname.getText().toString());
                user.setPhysicalAddress(Address.getText().toString());
                user.setCode(Code.getText().toString());
                user.setAmmount("0");
                user.setPassword(Password.getText().toString());
                user.setContact(contact.getText().toString());
                user.setEmail(EmailAdress.getText().toString());
                user.setIDnumber(UserID.getText().toString());

                Users.child( FirebaseAuth.getInstance().getCurrentUser().getUid()).setValue(user).addOnSuccessListener(new OnSuccessListener<Void>() {
                    @Override
                    public void onSuccess(Void aVoid) {
                        Toast.makeText(PassengerRegistration.this, "Account Created", Toast.LENGTH_SHORT).show();
                        Intent intent = new Intent(PassengerRegistration.this,Homepage.class);
                        startActivity(intent);
                    }
                }).addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        Toast.makeText(PassengerRegistration.this, ""+e.getMessage(), Toast.LENGTH_SHORT).show();
                    }
                });
            }
        });
    }
}
