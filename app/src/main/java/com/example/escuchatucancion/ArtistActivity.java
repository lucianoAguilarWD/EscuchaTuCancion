package com.example.escuchatucancion;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class ArtistActivity extends AppCompatActivity {

    private ImageView[] imageViews;
    private TextView[] textViews;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_artist);

        List<Artist> artists = initArtist();

        Intent intent = getIntent();
        String genre = intent.getStringExtra("GENRE");

        Intent intentA = getIntent();
        String artistIntent = intentA.getStringExtra("ARTIST");
        if( artistIntent != null){
            for (Artist artist: artists) {
                if(artist.getNombre().equals(artistIntent)){
                    genre = artist.getGenero();
                }
            }
        }

        // Inicializa tus ImageView y TextView aquí
        imageViews = new ImageView[]{
                findViewById(R.id.ivArtista1),
                findViewById(R.id.ivArtista2),
                findViewById(R.id.ivArtista3),
                findViewById(R.id.ivArtista4)
        };

        textViews = new TextView[]{
                findViewById(R.id.tvArtista1),
                findViewById(R.id.tvArtista2),
                findViewById(R.id.tvArtista3),
                findViewById(R.id.tvArtista4)
        };



        // Use an array to hold the index since it is effectively final
        final int[] index = {0};

        // Use a traditional for loop to handle UI updates
        for (Artist artist : artists) {
            if (artist.getGenero().equals(genre) && index[0] < 4) {
                String foto = artist.getFoto();
                // Supongamos que `foto` contiene el nombre del recurso drawable
                @SuppressLint("DiscouragedApi")
                int resId = getResources().getIdentifier(foto, "drawable", getPackageName());
                imageViews[index[0]].setImageResource(resId);
                textViews[index[0]].setText(artist.getNombre());
                index[0]++;
            }
        }

        initializeUI();
    }

    private List<Artist> initArtist() {
        return new ArrayList<>(Arrays.asList(
                new Artist("Epica", "epica", "Power"),
                new Artist("Dio", "dio", "Power"),
                new Artist("Dragon Force", "dragon_force", "Power"),
                new Artist("Sonata Artica", "sonata_artica", "Power"),
                new Artist("Callejeros", "callejeros", "Rock"),
                new Artist("Charly Garcia", "charly", "Rock"),
                new Artist("Divididos", "divididos", "Rock"),
                new Artist("Dire Straits", "dire_straits", "Rock"),
                new Artist("Metallica", "metallica", "Metal"),
                new Artist("Avenged Sevenfold", "avenged_sevenfold", "Metal"),
                new Artist("Black Sabbath", "black_sabbath", "Metal"),
                new Artist("Almafuerte", "almafuerte", "Metal"),
                new Artist("Accept", "accept", "Hard"),
                new Artist("AC/DC", "acdc", "Hard"),
                new Artist("Three Days Grace", "three_days_grace", "Hard"),
                new Artist("Judas Priest", "judas_priest", "Hard")
        ));
    }


    private void initializeUI() {
        CardView volverAInicio = findViewById(R.id.home);
        CardView volverAtras = findViewById(R.id.back);
        CardView artista1 = findViewById(R.id.artista1);
        CardView artista2 = findViewById(R.id.artista2);
        CardView artista3 = findViewById(R.id.artista3);
        CardView artista4 = findViewById(R.id.artista4);
        TextView tvArtista1 = findViewById(R.id.tvArtista1);
        TextView tvArtista2 = findViewById(R.id.tvArtista2);
        TextView tvArtista3 = findViewById(R.id.tvArtista3);
        TextView tvArtista4 = findViewById(R.id.tvArtista4);

        setNavigateTo(volverAInicio, this::navigateToMenu);
        setNavigateTo(volverAtras, this::navigateToGenre);


        List<Artist> artists = initArtist();

        for (Artist artist : artists) {
            if (artist.getNombre().equals(tvArtista1.getText().toString())) {
                setNavigateToWithArtist(artista1, artist);
            } else if (artist.getNombre().equals(tvArtista2.getText().toString())) {
                setNavigateToWithArtist(artista2, artist);
            } else if (artist.getNombre().equals(tvArtista3.getText().toString())) {
                setNavigateToWithArtist(artista3, artist);
            } else if (artist.getNombre().equals(tvArtista4.getText().toString())) {
                setNavigateToWithArtist(artista4, artist);
            }
        }
    }

    // Método para configurar el listener del botón de inicio
    private void setNavigateTo(CardView cardView, Runnable action) {
        cardView.setOnClickListener(v -> action.run());
    }

    private void setNavigateToWithArtist(CardView cardView, Artist artist) {
        cardView.setOnClickListener(v -> navigateToAlbums(artist));
    }

    private void navigateToGenre(){
        Intent intent = new Intent(ArtistActivity.this, MusicGenresActivity.class);
        startActivity(intent);
    }

    // Método para navegar al menú
    private void navigateToMenu() {
        Intent intent = new Intent(ArtistActivity.this, MenuActivity.class);
        startActivity(intent);
    }

    private void navigateToAlbums(Artist artist) {
        Intent intent = new Intent(ArtistActivity.this, AlbumsActivity.class);
        intent.putExtra("ARTIST", (Parcelable) artist);
        startActivity(intent);
    }


}