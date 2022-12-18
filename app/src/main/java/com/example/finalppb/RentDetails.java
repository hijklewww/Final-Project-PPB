package com.example.finalppb;

import android.annotation.SuppressLint;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

public class RentDetails extends AppCompatActivity  {

    TextView getic,gettype,getnama,getalamat,getnombor,getperiod,getdate,gettotal;
    ImageView getgambar;
    Button btexit;
    int iPeriod, iHarga,dTotal;
    String Total;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rent_details);
        getSupportActionBar().setTitle("Details of Rent Car");

        getic =findViewById(R.id.getIc);
        gettype = findViewById(R.id.getType);
        getnama = findViewById(R.id.getname);
        getalamat = findViewById(R.id.getaddr);
        getnombor = findViewById(R.id.getnumber);
        getperiod = findViewById(R.id.getPeriod);
        getdate = findViewById(R.id.getDate);
        gettotal = findViewById(R.id.getharga);
        getgambar = findViewById(R.id.getpics);
        btexit=findViewById(R.id.btexit);
        showData();

    }

    @SuppressLint("SetTextI18n")
    private void showData(){
        String type = getIntent().getExtras().getString("type"); //code for read data based on type data string
        String ic =getIntent().getExtras().getString("IC");
        String name=getIntent().getExtras().getString("Name");
        String address=getIntent().getExtras().getString("Addr");
        String numPhone=getIntent().getExtras().getString("Nohp");
        String period=getIntent().getExtras().getString("period");
        String date=getIntent().getExtras().getString("Date");

        switch (type) {
            case "Honda Civic":
                iHarga = 320000;
                break;
            case "Toyota Camry":
                iHarga = 300000;
                break;
            case "Perodua Myvi":
                iHarga = 500000;
                break;
            case "BMW Series":
                iHarga = 420000;
                break;
            case "Perodua Bezza":
                iHarga = 330000;
                break;
        }

        //calculation
        iPeriod=Integer.parseInt(period); //return integer
        dTotal=iHarga*iPeriod;
        Total=String.valueOf(dTotal);

        switch (type){
            case "Honda Civic":
                getgambar.setImageResource(R.drawable.civic);
                gettype.setText(type);
                getnama.setText(name);
                getalamat.setText(address);
                getnombor.setText(numPhone);
                getperiod.setText(period);
                getdate.setText(date);
                gettotal.setText(Total);
                getic.setText(ic);
                break;
            case "Toyota Camry":
                getgambar.setImageResource(R.drawable.camry);
                gettype.setText(type);
                getnama.setText(name);
                getalamat.setText(address);
                getnombor.setText(numPhone);
                getperiod.setText(period);
                getdate.setText(date);
                gettotal.setText(Total);
                getic.setText(ic);
                break;
            case "Perodua Myvi":
                getgambar.setImageResource(R.drawable.myvi);
                gettype.setText(type);
                getnama.setText(name);
                getalamat.setText(address);
                getnombor.setText(numPhone);
                getperiod.setText(period);
                getdate.setText(date);
                gettotal.setText(Total);
                getic.setText(ic);
                break;
            case "BMW Series":
                getgambar.setImageResource(R.drawable.bmw);
                gettype.setText(type);
                getnama.setText(name);
                getalamat.setText(address);
                getnombor.setText(numPhone);
                getperiod.setText(period);
                getdate.setText(date);
                gettotal.setText(Total);
                getic.setText(ic);
                break;
            case "Perodua Bezza":
                getgambar.setImageResource(R.drawable.bezza);
                gettype.setText(type);
                getnama.setText(name);
                getalamat.setText(address);
                getnombor.setText(numPhone);
                getperiod.setText(period);
                getdate.setText(date);
                gettotal.setText(Total);
                getic.setText(ic);
                break;
        }

        btexit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder builder = new AlertDialog.Builder(RentDetails.this);
                builder.setCancelable(false);
                builder.setMessage("You want to quit from this page?");
                builder.setPositiveButton("YES", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        finish();
                        System.exit(0);
                    }
                });
                builder.setNegativeButton("NO", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.cancel();
                    }
                });
                AlertDialog alert = builder.create();
                alert.show();
            }
        });
    }
}