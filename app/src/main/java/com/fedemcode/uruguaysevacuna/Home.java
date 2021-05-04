package com.fedemcode.uruguaysevacuna;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Home extends AppCompatActivity {

    Button info;
    Button vacu;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        info=(Button)findViewById(R.id.btnInformacion);
        vacu=(Button)findViewById(R.id.btnVacunatorios);


        info.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent i=new Intent(Home.this, Dashboard.class);
                startActivity(i);
            }
        });

        vacu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent i=new Intent(Home.this, activity_tabla_vacunatorios.class);
                startActivity(i);
            }
        });
    }
}