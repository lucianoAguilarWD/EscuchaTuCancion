package com.example.escuchatucancion;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;


public class MenuActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);
        Button mostrarInformacion =  findViewById(R.id.btnInformation);
        mostrarInformacion.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MenuActivity.this, InformationActivity.class);
                startActivity(intent);
            }
        });
        Button mostrarGenerosMusicales = findViewById(R.id.btnMusicalGenre);
        mostrarGenerosMusicales.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MenuActivity.this, MusicGenresActivity.class);
                startActivity(intent);
            }

        });

    }

}