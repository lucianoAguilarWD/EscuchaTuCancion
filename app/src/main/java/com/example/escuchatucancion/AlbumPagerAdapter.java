package com.example.escuchatucancion;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.viewpager2.adapter.FragmentStateAdapter;

import java.util.List;

public class AlbumPagerAdapter extends FragmentStateAdapter {

    private List<Album> albums;

    public AlbumPagerAdapter(@NonNull FragmentActivity fragmentActivity, List<Album> albums) {
        super(fragmentActivity);
        this.albums = albums;
    }

    @NonNull
    @Override
    public Fragment createFragment(int position) {
        return AlbumFragment.newInstance(albums.get(position));
    }

    @Override
    public int getItemCount() {
        return albums.size();
    }
}