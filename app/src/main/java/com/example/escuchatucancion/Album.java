package com.example.escuchatucancion;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.List;

public class Album implements Parcelable {
    private String nombre, foto, artist;
    private List<String> canciones;

    public Album(String nombre, String foto, String artist , List<String> canciones){
        this.nombre = nombre;
        this.foto = foto;
        this.artist = artist;
        this.canciones = canciones;
    }

    public String getNombre(){
        return nombre;
    }

    public String getFoto(){
        return foto;
    }

    public String getArtist(){
        return artist;
    }

    public List<String> getCanciones() {
        return canciones;
    }

    protected Album(Parcel in) {
        nombre = in.readString();
        foto = in.readString();
        artist = in.readString();
        canciones = in.createStringArrayList();
    }

    public static final Creator<Album> CREATOR = new Creator<Album>() {
        @Override
        public Album createFromParcel(Parcel in) {
            return new Album(in);
        }

        @Override
        public Album[] newArray(int size) {
            return new Album[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(nombre);
        dest.writeString(foto);
        dest.writeString(artist);
        dest.writeStringList(canciones);
    }

}
