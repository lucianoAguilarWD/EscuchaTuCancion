package com.example.escuchatucancion;

import android.content.Intent;
import android.os.Bundle;


import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.viewpager2.widget.ViewPager2;
import java.util.List;

public class SwipeAlbumActivity extends AppCompatActivity {

    private ViewPager2 viewPager;
    private AlbumPagerAdapter adapter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_swipe_album);

        List<Album> albums = getIntent().getParcelableArrayListExtra("ALBUMS");
        int selectedIndex = getIntent().getIntExtra("SELECTED_INDEX", 0);

        if (albums == null || albums.isEmpty()) {
            return;
        }

        viewPager = findViewById(R.id.viewPager);
        adapter = new AlbumPagerAdapter(this, albums);
        viewPager.setAdapter(adapter);

        // Establecer la posición inicial del ViewPager
        viewPager.setCurrentItem(selectedIndex, false);

        initializeUI(albums.get(selectedIndex));
    }

    private void initializeUI(Album firstAlbum) {
        CardView volverAInicio = findViewById(R.id.home);
        CardView volverAtras = findViewById(R.id.back);
        CardView genres = findViewById(R.id.genres);
        CardView artist = findViewById(R.id.artist);

        setNavigateTo(volverAInicio, this::navigateToMenu);
        setNavigateTo(genres, this::navigateToGenre);
        setNavigateToWithSwipeToArtist(artist, firstAlbum.getArtist());
        setNavigateToWithSwipeToAlbums(volverAtras, firstAlbum.getArtist());
    }

    private void setNavigateTo(CardView cardView, Runnable action) {
        cardView.setOnClickListener(v -> action.run());
    }

    private void setNavigateToWithSwipeToArtist(CardView cardView, String artist) {
        cardView.setOnClickListener(v -> navigateToArtist(artist));
    }

    private void setNavigateToWithSwipeToAlbums(CardView cardView, String artist) {
        cardView.setOnClickListener(v -> navigateToAlbum(artist));
    }

    private void navigateToGenre() {
        Intent intent = new Intent(SwipeAlbumActivity.this, MusicGenresActivity.class);
        startActivity(intent);
    }

    private void navigateToMenu() {
        Intent intent = new Intent(SwipeAlbumActivity.this, MenuActivity.class);
        startActivity(intent);
    }

    private void navigateToArtist(String artist) {
        Intent intent = new Intent(SwipeAlbumActivity.this, ArtistActivity.class);
        intent.putExtra("ARTIST", artist);
        startActivity(intent);
    }

    private void navigateToAlbum(String artist) {
        Intent intent = new Intent(SwipeAlbumActivity.this, AlbumsActivity.class);
        intent.putExtra("ALBUM", artist);
        startActivity(intent);
    }
}