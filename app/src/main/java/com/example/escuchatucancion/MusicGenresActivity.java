package com.example.escuchatucancion;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;


import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;


public class MusicGenresActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_music_genres);
        CardView volverAInicio = findViewById(R.id.home);
        volverAInicio.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MusicGenresActivity.this, MenuActivity.class);
                startActivity(intent);
            }

        });
    }
}