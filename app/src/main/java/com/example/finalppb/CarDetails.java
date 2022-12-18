package com.example.finalppb;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class CarDetails extends AppCompatActivity {
    Button btn_sewa;
    TextView  GetNama, GetHarga;
    ImageView GetGambar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_car_details);
        getSupportActionBar().setTitle("Car Details"); //set top title
        getSupportActionBar().setDisplayHomeAsUpEnabled(true); //showing the back button in action bar

        btn_sewa=findViewById(R.id.btnRental);
        GetGambar = findViewById(R.id.pictures);
        GetNama = findViewById(R.id.name);
        GetHarga = findViewById(R.id.price);

        showData(); //display data
        btn_sewa.setOnClickListener(v -> {
            Intent sewa=new Intent(getApplicationContext(),RentalActivity.class); //describes activity to start
            startActivity(sewa);
        });
    }

    @SuppressLint("SetTextI18n")
    private void showData(){ //function to display data
        String nama = getIntent().getExtras().getString("MyName"); //code for read data based on type data string
        switch (nama){
            case "Honda Civic":
                GetNama.setText("Civic");
                GetGambar.setImageResource(R.drawable.civic);
                GetHarga.setText("Rp.320.000");
                break;

            case "Toyota Camry":
                GetNama.setText("Camry");
                GetGambar.setImageResource(R.drawable.camry);
                GetHarga.setText("Rp.300.000");
                break;

            case "Perodua Myvi":
                GetNama.setText("Myvi");
                GetGambar.setImageResource(R.drawable.myvi);
                GetHarga.setText("Rp.500.000");
                break;

            case "BMW Series":
                GetNama.setText("BMW");
                GetGambar.setImageResource(R.drawable.bmw);
                GetHarga.setText("Rp.420.000");
                break;

            case "Perodua Bezza":
                GetNama.setText("Bezza");
                GetGambar.setImageResource(R.drawable.bezza);
                GetHarga.setText("Rp.330.000");
                break;
        }
    }
}