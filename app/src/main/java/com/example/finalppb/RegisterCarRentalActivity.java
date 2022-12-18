package com.example.finalppb;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.Collections;

//tambah data pada list view guna Array dan ArrayList
public class RegisterCarRentalActivity extends AppCompatActivity {
     private String[] kereta  = {"Honda Civic","Toyota Camry","Perodua Myvi","BMW Series","Perodua Bezza"};
     private ArrayList<String> data; //arraylist to support data kereta

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register_car_rental);
        getSupportActionBar().setTitle("Registered Car");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        ListView listView = findViewById(R.id.listCar);
        data = new ArrayList<>();
        getData(); //masukkan data dlm ArrayList
        ArrayList<String> arrayList = new ArrayList<>();

        ArrayAdapter<String> adapter = new ArrayAdapter<> //control how data in ListView showed
                (this, R.layout.support_simple_spinner_dropdown_item, data);
        listView.setAdapter(adapter); //panggil adapter pada listView guna function setAdapter


        //set action on listView by implement onItemClick
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String getName = data.get(position); //getName akan ambil data dari Arraylist follow position

                Intent sendData = new Intent(RegisterCarRentalActivity.this, CarDetails.class);
                sendData.putExtra("MyName", getName); //method to send data in the next activityn
                startActivity(sendData); //when activity start the data also be send to the next activity or next interface.
            }
        });
    }

    private void getData() {
        Collections.addAll(data, kereta); //add all data cars in arraylist
    }

}


