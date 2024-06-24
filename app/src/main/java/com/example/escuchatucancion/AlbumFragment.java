package com.example.escuchatucancion;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class AlbumFragment extends Fragment {

    private static final String ARG_ALBUM = "album";
    private static final String TAG = "AlbumFragment";
    private Album album;
    private MediaPlayer mediaPlayer;
    private FloatingActionButton btnPlay1;
    private FloatingActionButton btnPause1;
    private FloatingActionButton btnPlay2;
    private FloatingActionButton btnPause2;

    private Map<Integer, Integer> songMap = new HashMap<>();

    public static AlbumFragment newInstance(Album album) {
        AlbumFragment fragment = new AlbumFragment();
        Bundle args = new Bundle();
        args.putParcelable(ARG_ALBUM, album);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            album = getArguments().getParcelable(ARG_ALBUM);
        }
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_album, container, false);

        ImageView ivCaratula = view.findViewById(R.id.ivCaratula);
        TextView tvCancion1 = view.findViewById(R.id.tvCancion1);
        TextView tvCancion2 = view.findViewById(R.id.tvCancion2);
        btnPlay1 = view.findViewById(R.id.btnPlay1);
        btnPause1 = view.findViewById(R.id.btnPause1);
        btnPlay2 = view.findViewById(R.id.btnPlay2);
        btnPause2 = view.findViewById(R.id.btnPause2);

        if (album != null) {
            // Obtener el ID del recurso de la carátula
            int resId = getResourceId(album.getFoto(), "drawable");
            if (resId != 0) {
                ivCaratula.setImageResource(resId);
            } else {
                Log.e(TAG, "Error: Recurso de carátula no encontrado para " + album.getFoto());
            }

            // Obtener los nombres de las canciones
            List<String> canciones = album.getCanciones();
            if (canciones.size() > 0) {
                tvCancion1.setText(formatSongName(canciones.get(0)));
                songMap.put(0, getResourceId(canciones.get(0), "raw"));
            }
            if (canciones.size() > 1) {
                tvCancion2.setText(formatSongName(canciones.get(1)));
                songMap.put(1, getResourceId(canciones.get(1), "raw"));
            }

            // Configurar MediaPlayer para la primera canción
            btnPlay1.setOnClickListener(v -> playSong(0));

            btnPause1.setOnClickListener(v -> pauseSong());

            // Configurar MediaPlayer para la segunda canción
            btnPlay2.setOnClickListener(v -> playSong(1));

            btnPause2.setOnClickListener(v -> pauseSong());
        } else {
            Log.e(TAG, "Error: El álbum es nulo");
        }

        return view;
    }

    private void playSong(int songIndex) {
        Integer songResId = songMap.get(songIndex);
        if (songResId != null) {
            try {
                releaseMediaPlayer();
                mediaPlayer = MediaPlayer.create(getActivity(), songResId);
                if (mediaPlayer != null) {
                    mediaPlayer.start();
                } else {
                    Log.e(TAG, "Error: MediaPlayer es nulo al crear para songResId " + songResId);
                }
            } catch (Exception e) {
                Log.e(TAG, "Error al reproducir la canción: " + e.getMessage());
            }
        } else {
            Log.e(TAG, "Error: Recurso de canción no encontrado para songIndex " + songIndex);
        }
    }

    private void pauseSong() {
        if (mediaPlayer != null && mediaPlayer.isPlaying()) {
            mediaPlayer.pause();
        }
    }

    private void releaseMediaPlayer() {
        if (mediaPlayer != null) {
            mediaPlayer.release();
            mediaPlayer = null;
        }
    }

    @Override
    public void onPause() {
        super.onPause();
        releaseMediaPlayer();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        releaseMediaPlayer();
    }

    private String formatSongName(String songNameWithUnderscore) {
        // Reemplazar guiones bajos con espacios
        return songNameWithUnderscore.replace("_", " ");
    }

    private int getResourceId(String resourceName, String resourceType) {
        int resId = getResources().getIdentifier(resourceName, resourceType, getActivity().getPackageName());
        if (resId == 0) {
            Log.e(TAG, "Error: Recurso no encontrado para " + resourceName + " de tipo " + resourceType);
        }
        return resId;
    }
}
