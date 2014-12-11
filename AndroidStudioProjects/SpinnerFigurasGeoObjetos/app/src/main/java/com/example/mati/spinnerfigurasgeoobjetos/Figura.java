package com.example.mati.spinnerfigurasgeoobjetos;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by mati on 4/12/14.
 */

public abstract class Figura implements Parcelable
{
    public String tipo;

    protected Figura(String tipo){
        this.tipo=tipo;
    }

    @Override
    public void writeToParcel(Parcel parcel, int flags)
    {
        parcel.writeString(tipo);
    }

    protected Figura(Parcel in) {
        this.tipo = in.readString();
    }

    public String getTipo() {
        return this.tipo;
    }





}





