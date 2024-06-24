package com.example.escuchatucancion;

import android.content.Intent;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;


public class InformationActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_information);

        initializeUI();
    }

    private void initializeUI() {
        CardView volverAInicio = findViewById(R.id.home);
        CardView genres = findViewById(R.id.genres);

        setNavigateTo(volverAInicio, this::navigateToMenu);
        setNavigateTo(genres, this::navigateToGenre);

    }

    private void setNavigateTo(CardView cardView, Runnable action) {
        cardView.setOnClickListener(v -> action.run());
    }

    private void navigateToGenre(){
        Intent intent = new Intent(InformationActivity.this, MusicGenresActivity.class);
        startActivity(intent);
    }

    // Método para navegar al menú
    private void navigateToMenu() {
        Intent intent = new Intent(InformationActivity.this, MenuActivity.class);
        startActivity(intent);
    }
}