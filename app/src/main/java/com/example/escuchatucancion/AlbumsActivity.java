package com.example.escuchatucancion;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class AlbumsActivity extends AppCompatActivity {

    private ImageView[] imageViews;
    private TextView[] textViews;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_albums);

        Artist artist = getIntent().getParcelableExtra("ARTIST");
        String artistA = getIntent().getStringExtra("ALBUM");

        TextView tvTitle = findViewById(R.id.tvTitle);
        String art = "";

        if (artist != null) {
            // muestra el nombre del artista
            String artistName = artist.getNombre();
            tvTitle.setText(artistName);
            art = artistName;
        } else {
            if (artistA != null) {
                tvTitle.setText(artistA);
                art = artistA;
            }
        }

        imageViews = new ImageView[]{
                findViewById(R.id.ivAlbum1),
                findViewById(R.id.ivAlbum2),
                findViewById(R.id.ivAlbum3),
                findViewById(R.id.ivAlbum4)
        };

        textViews = new TextView[]{
                findViewById(R.id.tvAlbum1),
                findViewById(R.id.tvAlbum2),
                findViewById(R.id.tvAlbum3),
                findViewById(R.id.tvAlbum4)
        };

        List<Album> albums = initAlbums();

        final int[] index = {0};

        for (Album album : albums) {
            if (album.getArtist().equals(art) && index[0] < 4) {
                String foto = album.getFoto();

                @SuppressLint("DiscouragedApi")
                int resId = getResources().getIdentifier(foto, "drawable", getPackageName());
                imageViews[index[0]].setImageResource(resId);
                textViews[index[0]].setText(album.getNombre());
                index[0]++;
            }
        }

        initializeUI(albums, art);
    }

    private List<Album> initAlbums() {
        return new ArrayList<>(Arrays.asList(
                // hard
                new Album("Back In Back", "acdc_ab1", "AC/DC", Arrays.asList("hells_bells", "shoot_to_thrill")),
                new Album("High Voltage", "acdc_ab2", "AC/DC", Arrays.asList("its_a_long_way_to_the_top", "live_wire")),
                new Album("Stiff Upper Lip", "acdc_ab3", "AC/DC", Arrays.asList("safe_in_new_york_city", "stiff_upper_lip")),
                new Album("Rock Or Bust", "acdc_ab4", "AC/DC", Arrays.asList("rock_or_bust", "play_ball")),
                new Album("The Rise of Chaos", "accept_ab1", "Accept", Arrays.asList("the_rise_of_chaos", "koolaid")),
                new Album("Blind Rage", "accept_ab2", "Accept", Arrays.asList("the_curse", "dark_side_of_my_heart")),
                new Album("Stalingrad", "accept_ab3", "Accept", Arrays.asList("stalingrad", "shadow_soldiers")),
                new Album("Blood of the Nations", "accept_ab4", "Accept", Arrays.asList("pandemic", "new_world_comin")),
                new Album("Defenders Of The Faith", "judas_priest_ab1", "Judas Priest", Arrays.asList("the_sentinel", "rock_hard_ride_free")),
                new Album("Firepower", "judas_priest_ab2", "Judas Priest", Arrays.asList("lightning_strike", "no_surrender")),
                new Album("Screaming For Vengeance", "judas_priest_ab4", "Judas Priest", Arrays.asList("painkiller", "a_touch_of_evil")),
                new Album("Painkiller", "judas_priest_ab3", "Judas Priest", Arrays.asList("youve_got_another_thing_comin", "electric_eye")),
                new Album("One X", "three_days_grace_ab1", "Three Days Grace", Arrays.asList("its_all_over", "pain")),
                new Album("Life Starts Now", "three_days_grace_ab2", "Three Days Grace", Arrays.asList("on_my_own", "world_so_cold")),
                new Album("Transit Of Venus", "three_days_grace_ab3", "Three Days Grace", Arrays.asList("broken_glass", "chalk_outline")),
                new Album("Human", "three_days_grace_ab4", "Three Days Grace", Arrays.asList("human_race", "i_am_machine")),
                // power
                new Album("The Divine Conspiracy", "epica_ab1", "Epica", Arrays.asList("chasing_the_dragon", "the_obsessive_devotion")),
                new Album("The Phantom Agony", "epica_ab2", "Epica", Arrays.asList("facade_of_reality", "run_for_a_fall")),
                new Album("The Quantum Enigma", "epica_ab3", "Epica", Arrays.asList("chemical_insomnia", "reverence")),
                new Album("The Classic Conspiracy", "epica_ab4", "Epica", Arrays.asList("adagio", "never_enough")),
                new Album("The Power Of Within", "dragonforce_ab1", "Dragon Force", Arrays.asList("cry_thunder", "fallen_world")),
                new Album("Maximum Overload", "dragonforce_ab2", "Dragon Force", Arrays.asList("symphony_of_the_night", "three_hammers")),
                new Album("Inhuman Rampage", "dragonforce_ab3", "Dragon Force", Arrays.asList("cry_for_eternity", "revolution_deathsquad")),
                new Album("Extreme Power Metal", "dragonforce_ab4", "Dragon Force", Arrays.asList("paid_in_full", "out_in_the_fields")),
                new Album("Silence", "sonata_artica_ab1", "Sonata Artica", Arrays.asList("false_news_travel_fast", "weballergy")),
                new Album("Winterheart's Guild", "sonata_artica_ab2", "Sonata Artica", Arrays.asList("silver_tongue", "gravenimage")),
                new Album("Successor", "sonata_artica_ab3", "Sonata Artica", Arrays.asList("san_sebastian", "i_want_out")),
                new Album("Ecliptica", "sonata_artica_ab4", "Sonata Artica", Arrays.asList("eight_commandment", "my_land")),
                new Album("Magica", "dio_ab1", "Dio", Arrays.asList("losing_my_insanity", "as_long_as_its_not_about_love")),
                new Album("Diamonds: The Best Of Dio", "dio_ab2", "Dio", Arrays.asList("sacred_heart", "lock_up_the_wolves")),
                new Album("To Heaven Through Hell", "dio_ab3", "Dio", Arrays.asList("children_of_the_sea", "dream_evil")),
                new Album("Holy Diver", "dio_ab4", "Dio", Arrays.asList("rainbow_in_the_dark", "straight_through_the_heart")),
                // metal
                new Album("Ultimando", "almafuerte_ab1", "Almafuerte", Arrays.asList("todo_es_en_vano_si_no_hay_amor", "patria_al_hombro")),
                new Album("Toro y Pampa", "almafuerte_ab2", "Almafuerte", Arrays.asList("donde_esta_mi_corazon", "debes_saberlo")),
                new Album("Almafuerte", "almafuerte_ab3", "Almafuerte", Arrays.asList("triunfo", "se_vos")),
                new Album("A Fondo Blanco", "almafuerte_ab4", "Almafuerte", Arrays.asList("aguante_bonavena", "a_vos_amigo")),
                new Album("Avenged Sevenfold", "avenged_sevenfold_ab1", "Avenged Sevenfold", Arrays.asList("lost", "a_little_piece_of_heaven")),
                new Album("Hail To The King", "avenged_sevenfold_ab2", "Avenged Sevenfold", Arrays.asList("shepherd_of_fire", "this_means_war")),
                new Album("City Of Evil", "avenged_sevenfold_ab3", "Avenged Sevenfold", Arrays.asList("beast_and_the_harlot", "seize_the_day")),
                new Album("Nightmare", "avenged_sevenfold_ab4", "Avenged Sevenfold", Arrays.asList("buried_alive", "so_far_away")),
                new Album("Master Of Reality", "black_sabbath_ab1", "Black Sabbath", Arrays.asList("children_of_the_grave", "sweet_leaf")),
                new Album("Black Sabbath", "black_sabbath_ab2", "Black Sabbath", Arrays.asList("the_wizard", "nib")),
                new Album("Greatest Hits", "black_sabbath_ab3", "Black Sabbath", Arrays.asList("iron_man", "paranoid")),
                new Album("Heaven And Hell", "black_sabbath_ab4", "Black Sabbath", Arrays.asList("heaven_and_hell", "neon_knights")),
                new Album("Ride The Lightning", "metallica_ab1", "Metallica", Arrays.asList("fade_to_black", "for_whom_the_bell_tolls")),
                new Album("Metallica", "metallica_ab2", "Metallica", Arrays.asList("sad_but_true", "enter_sandman")),
                new Album("Master Of Puppets", "metallica_ab3", "Metallica", Arrays.asList("battery", "master_of_puppets")),
                new Album("Kill 'Em All", "metallica_ab4", "Metallica", Arrays.asList("whiplash", "seek_destroy")),
                // Rock
                new Album("Callejeros", "callejeros_ab1", "Callejeros", Arrays.asList("sin_paciencia", "creo")),
                new Album("Roncanroles Sin Destino", "callejeros_ab2", "Callejeros", Arrays.asList("un_lugar_perfecto", "se_que_no_se")),
                new Album("Presión", "callejeros_ab3", "Callejeros", Arrays.asList("presion", "otro_viento_mejor")),
                new Album("Sed", "callejeros_ab4", "Callejeros", Arrays.asList("milonga_el_rocanrol", "el_nudo")),
                new Album("Piano Bar", "charly_garcia_ab1", "Charly Garcia", Arrays.asList("cerca_de_la_revolucion", "demoliendo_hoteles")),
                new Album("Clics Modernos", "charly_garcia_ab2", "Charly Garcia", Arrays.asList("no_soy_un_extranio", "nos_siguen_pegando_abajo")),
                new Album("Pubis Angelical", "charly_garcia_ab3", "Charly Garcia", Arrays.asList("yo_no_quiero_volverme_tan_loco", "yendo_de_la_cama_al_living")),
                new Album("La Hija De La Lagrima", "charly_garcia_ab4", "Charly Garcia", Arrays.asList("la_sal_no_sala", "chipi_chipi")),
                new Album("Greatest Hits", "dire_straits_ab1", "Dire Straits", Arrays.asList("walk_of_life", "tunnel_of_love")),
                new Album("Sultans Of Swing", "dire_straits_ab2", "Dire Straits", Arrays.asList("sultans_of_swing", "heavy_fuel")),
                new Album("On Every Street", "dire_straits_ab3", "Dire Straits", Arrays.asList("when_it_comes_to_you", "fades_to_black")),
                new Album("Making Movies", "dire_straits_ab4", "Dire Straits", Arrays.asList("hand_in_hand", "skateaway")),
                new Album("Narigon Del Siglo", "divididos_ab1", "Divididos", Arrays.asList("elefantes_en_europa", "par_mil")),
                new Album("Gol De Mujer", "divididos_ab2", "Divididos", Arrays.asList("vientito_de_tucuman", "nene_de_antes")),
                new Album("La Era De La Boludez", "divididos_ab3", "Divididos", Arrays.asList("que_ves", "el_arriero")),
                new Album("Acariciando Lo Aspero", "divididos_ab4", "Divididos", Arrays.asList("ala_delta", "el_treinta_y_ocho"))
        ));
    }


    private void initializeUI(List<Album> albums, String artist) {
        CardView volverAInicio = findViewById(R.id.home);
        CardView volverAtras = findViewById(R.id.back);
        CardView genres = findViewById(R.id.genres);

        CardView album1 = findViewById(R.id.album1);
        CardView album2 = findViewById(R.id.album2);
        CardView album3 = findViewById(R.id.album3);
        CardView album4 = findViewById(R.id.album4);
        TextView tvTitle = findViewById(R.id.tvTitle);

        setNavigateTo(volverAInicio, this::navigateToMenu);
        setNavigateTo(genres, this::navigateToGenre);
        setNavigateToWithAlbumsToArtist(volverAtras, tvTitle.getText().toString());

        List<Album> artistAlbums = new ArrayList<>();
        for (Album album : albums) {
            if (album.getArtist().equals(artist)) {
                artistAlbums.add(album);
            }
        }

        if (artistAlbums.size() > 0) setNavigateToWithAlbums(album1, artistAlbums, 0);
        if (artistAlbums.size() > 1) setNavigateToWithAlbums(album2, artistAlbums, 1);
        if (artistAlbums.size() > 2) setNavigateToWithAlbums(album3, artistAlbums, 2);
        if (artistAlbums.size() > 3) setNavigateToWithAlbums(album4, artistAlbums, 3);
    }


    // Método para configurar el listener del botón de inicio
    private void setNavigateTo(CardView cardView, Runnable action) {
        cardView.setOnClickListener(v -> action.run());
    }

    private void setNavigateToWithAlbums(CardView cardView, List<Album> albums, int index) {
        cardView.setOnClickListener(v -> navigateToSongs(albums, index));
    }

    private void setNavigateToWithAlbumsToArtist(CardView cardView, String artist) {
        cardView.setOnClickListener(v -> navigateToArtist(artist));
    }

    private void navigateToGenre() {
        Intent intent = new Intent(AlbumsActivity.this, MusicGenresActivity.class);
        startActivity(intent);
    }

    // Método para navegar al menú
    private void navigateToMenu() {
        Intent intent = new Intent(AlbumsActivity.this, MenuActivity.class);
        startActivity(intent);
    }

    private void navigateToSongs(List<Album> albums, int index) {
        Intent intent = new Intent(AlbumsActivity.this, SwipeAlbumActivity.class);
        intent.putParcelableArrayListExtra("ALBUMS", new ArrayList<>(albums));
        intent.putExtra("SELECTED_INDEX", index);
        startActivity(intent);
    }

    private void navigateToArtist(String artist) {
        Intent intent = new Intent(AlbumsActivity.this, ArtistActivity.class);
        intent.putExtra("ARTIST", artist);
        startActivity(intent);
    }

}