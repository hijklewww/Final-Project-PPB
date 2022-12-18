package com.example.finalppb;


import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main); //references to activitymain xml
        getSupportActionBar().setTitle("Drive2Gether"); //set the top title



        Button btnInformation = findViewById(R.id.btnInfo); //declare button
        Button btnRental = findViewById(R.id.btnRent);

        btnInformation.setOnClickListener(v -> { //allow to perform action on button Info and Rent
            startActivity(new Intent(MainActivity.this, RegisterCarRentalActivity.class)); //start activity and connect with 2nd activity class
        });
        btnRental.setOnClickListener(v -> {
            Intent rent = new Intent(getApplicationContext(), RentalActivity.class);  //use to return the context which is link to application
            startActivity(rent);
        });

    }

}