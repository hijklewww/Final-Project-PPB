package com.example.finalppb;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import java.util.Calendar;

public class RentalActivity extends AppCompatActivity {
    DatePickerDialog picker; //user interface control that used to select date
    Button bt_tgl;
    TextView date;

    EditText edtname,edtAddress,edtPhoneNum,edtlama,edtIc;
    Spinner spinmerk; //dropdown list
    Button btnsimpan,btncancel;


    String Name,Addr,Nohp,type,period,Date,IC;
    String[] type_car={"Honda Civic","Toyota Camry","Perodua Myvi","BMW Series","Perodua Bezza"};
    String jenis;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rental);
        getSupportActionBar().setTitle("RENT");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        date=findViewById(R.id.date);
        bt_tgl=findViewById(R.id.bt_tgl);
        edtIc=findViewById(R.id.edtIc);
        edtname=findViewById(R.id.edtname);
        edtAddress=findViewById(R.id.edtAddress);
        edtPhoneNum=findViewById(R.id.edtPhoneNum);
        edtlama=findViewById(R.id.edtlama);
        spinmerk=findViewById(R.id.spinmerk);

        //set layout file for list items
        ArrayAdapter adapter=new ArrayAdapter(this,android.R.layout.simple_spinner_dropdown_item,type_car);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinmerk.setAdapter(adapter); //data will be displayed as the row
        spinmerk.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) { //Callback method to be invoked when an item in this AdapterView has been clicked.
                jenis=type_car[position];
            }
            @Override
            public void onNothingSelected(AdapterView<?> parent) {
            }
        });


        bt_tgl.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final Calendar cldr = Calendar.getInstance(); //to get the calendar using the current time zone and locale of the system
                int day = cldr.get(Calendar.DAY_OF_MONTH);
                int month = cldr.get(Calendar.MONTH);
                int year = cldr.get(Calendar.YEAR);

                picker = new DatePickerDialog(RentalActivity.this, new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
                        date.setText(dayOfMonth + "/" + (monthOfYear + 1) + "/" + year); //set date to our text view
                    }
                }, year, month, day); //pass year, month and day for selected date in our date picker
                picker.show(); //show picker date
            }
        });


        btnsimpan=findViewById(R.id.btnSave);
        btnsimpan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                IC=edtIc.getText().toString();
                Name=edtname.getText().toString();
                Addr=edtAddress.getText().toString();
                Nohp=edtPhoneNum.getText().toString();
                period=edtlama.getText().toString();
                type= jenis;
                Date=date.getText().toString();

                if (IC.isEmpty()||Name.isEmpty()||Addr.isEmpty()||Nohp.isEmpty()||period.isEmpty()||type.isEmpty()||Date.isEmpty()){
                    Toast.makeText(RentalActivity.this,"(*) Cannot be null !",Toast.LENGTH_SHORT).show(); //pop up message
                    return;
                }

                Intent i=new Intent(getApplicationContext(),RentDetails.class); //input data will be show in rent details class activity
                i.putExtra("Name",Name);
                i.putExtra("Addr",Addr);
                i.putExtra("Nohp",Nohp);
                i.putExtra("period",period);
                i.putExtra("type",type);
                i.putExtra("IC",IC);
                i.putExtra("Date",Date);
                startActivity(i);
            }
        });

        btncancel=findViewById(R.id.btnCancel);
        btncancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(RentalActivity.this, MainActivity.class);
                startActivity(intent);
                finish();
            }
        });



    }

}