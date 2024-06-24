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

        initializeUI();
    }

    // Método para inicializar los componentes de la UI
    // Inicializar los componentes de la UI
    private void initializeUI() {
        CardView volverAInicio = findViewById(R.id.home);
        CardView rock = findViewById(R.id.genre_rock);
        CardView metal = findViewById(R.id.genre_metal);
        CardView hard = findViewById(R.id.genre_hard);
        CardView power = findViewById(R.id.genre_power);
        // según el botón que sea presionado envia al usuario a las pantallas con información sobre el genero seleccionado
        setNavigateTo(volverAInicio, this::navigateToMenu);
        setNavigateToWithGenre(rock, "Rock");
        setNavigateToWithGenre(metal, "Metal");
        setNavigateToWithGenre(hard, "Hard");
        setNavigateToWithGenre(power, "Power");
    }

    // Método para configurar el listener del botón de inicio
    private void setNavigateTo(CardView cardView, Runnable action) {
        cardView.setOnClickListener(v -> action.run());
    }

    private void setNavigateToWithGenre(CardView cardView, String genre) {
        cardView.setOnClickListener(v -> navigateToArtist(genre));
    }

    // Método para navegar al menú
    private void navigateToMenu() {
        Intent intent = new Intent(MusicGenresActivity.this, MenuActivity.class);
        startActivity(intent);
    }


    private void navigateToArtist(String genre) {
        Intent intent = new Intent(MusicGenresActivity.this, ArtistActivity.class);
        intent.putExtra("GENRE", genre);
        startActivity(intent);
    }

}