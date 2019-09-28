package com.example.easy_ride;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.Toast;

import com.example.easy_ride.Model.Driver;
import com.example.easy_ride.Model.User;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.material.snackbar.Snackbar;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.rengwuxian.materialedittext.MaterialEditText;

public class DriverRegistraion extends AppCompatActivity {
    FirebaseDatabase database;
    DatabaseReference Drivers;
    FirebaseAuth auth;
    RelativeLayout rootlayout;
    Button Register,Home;
    EditText Surname,Names,ID,Contact,Email,Physical,Code,Plate,Password,Ownercode;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_driver_registraion);
        auth = FirebaseAuth.getInstance();
        rootlayout = findViewById(R.id.root);
        database = FirebaseDatabase.getInstance();
        Drivers = database.getReference("Drivers");
        Surname = findViewById(R.id.txtSurname);
        Names = findViewById(R.id.txtFullname);
        ID = findViewById(R.id.txtIdno);
        Contact = findViewById(R.id.txtContactNumber);
        Email= findViewById(R.id.txtEmail);
        Plate = findViewById(R.id.txtNumberPlate);
        Physical = findViewById(R.id.txtPhysicalAddress);
        Code = findViewById(R.id.txtCode);
        Password = findViewById(R.id.txtPassword);
        Ownercode = findViewById(R.id.txtOwnerCode);
        Register = findViewById(R.id.btnSignup2);

 Register.setOnClickListener(new View.OnClickListener() {
     @Override
     public void onClick(View view) {
         insertData();
     }
 });
    }

    private void insertData() {

        if(TextUtils.isEmpty(Names.getText().toString())){
            Snackbar.make(rootlayout,"Please Enter Your First Name", Snackbar.LENGTH_SHORT).show();
            return;
        }
        if(TextUtils.isEmpty(Plate.getText().toString())){
            Snackbar.make(rootlayout,"Please Enter Your Registration Number", Snackbar.LENGTH_SHORT).show();
            return;
        }
        if(TextUtils.isEmpty(Ownercode.getText().toString())){
            Snackbar.make(rootlayout,"Please Enter The Owner Code ", Snackbar.LENGTH_SHORT).show();
            return;
        }
        if(TextUtils.isEmpty(Surname.getText().toString())){
            Snackbar.make(rootlayout,"Please Enter Your Surname Name", Snackbar.LENGTH_SHORT).show();
            return;
        }
        if(TextUtils.isEmpty(Physical.getText().toString())){
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
        }  if(TextUtils.isEmpty(Contact.getText().toString()) || Contact.getText().toString().length() != 10){
            Snackbar.make(rootlayout,"Please Check Your Phone number", Snackbar.LENGTH_SHORT).show();
            return;
        }
        if(TextUtils.isEmpty(Email.getText().toString())){
            Snackbar.make(rootlayout,"Please Enter Your Email Address", Snackbar.LENGTH_SHORT).show();
            return;
        }
        if(TextUtils.isEmpty(ID.getText().toString())){
            Snackbar.make(rootlayout,"Please Check Your ID Number", Snackbar.LENGTH_SHORT).show();
            return;
        }


        auth.createUserWithEmailAndPassword(Email.getText().toString(),Password.getText().toString()).addOnSuccessListener(new OnSuccessListener<AuthResult>() {
            @Override
            public void onSuccess(AuthResult authResult) {
                Driver driver = new Driver();
                driver.setFullName(Names.getText().toString());
                driver.setSurname(Surname.getText().toString());
                driver.setAddress(Physical.getText().toString());
                driver.setCode(Code.getText().toString());
                driver.setIdnumber(ID.getText().toString());
                driver.setEmail(Email.getText().toString());
                driver.setContact(Contact.getText().toString());
                driver.setNumberPlate(Plate.getText().toString());
                driver.setPassword(Password.getText().toString());
                driver.setOwnerCode(Ownercode.getText().toString());

                Drivers.child(FirebaseAuth.getInstance().getCurrentUser().getUid()).setValue(driver).addOnSuccessListener(new OnSuccessListener<Void>() {
                    @Override
                    public void onSuccess(Void aVoid) {
                        Toast.makeText(DriverRegistraion.this, "Account Created", Toast.LENGTH_SHORT).show();
                        Intent intent = new Intent(DriverRegistraion.this, Homepage.class);
                        startActivity(intent);
                    }
                });
            }
        }).addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception e) {
                Toast.makeText(DriverRegistraion.this, ""+e.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }
}
