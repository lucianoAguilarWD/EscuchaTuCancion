package com.example.escuchatucancion;

import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;

public class Artist implements Parcelable {

    private String nombre, foto, genero;

    public Artist(String nombre, String foto, String genero){
        this.nombre = nombre;
        this.foto = foto;
        this.genero = genero;
    }

    public String getNombre() {
        return nombre;
    }

    public String getGenero() {
        return genero;
    }

    public String getFoto() {
        return foto;
    }

    protected Artist(Parcel in) {
        nombre = in.readString();
        foto = in.readString();
        genero = in.readString();
    }

    public static final Creator<Artist> CREATOR = new Creator<Artist>() {
        @Override
        public Artist createFromParcel(Parcel in) {
            return new Artist(in);
        }

        @Override
        public Artist[] newArray(int size) {
            return new Artist[size];
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
        dest.writeString(genero);
    }
}
