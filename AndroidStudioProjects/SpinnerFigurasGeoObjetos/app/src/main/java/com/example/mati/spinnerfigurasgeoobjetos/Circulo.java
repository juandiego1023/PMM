package com.example.mati.spinnerfigurasgeoobjetos;


import android.os.Parcel;
import android.os.Parcelable;

public class Circulo extends Figura {
    private Double radio;

    public Circulo(Double radio) {
        super("circulo");
        this.radio = radio;
    }

    public static final Parcelable.Creator<Circulo> CREATOR = new Parcelable.Creator<Circulo>() {
        public Circulo createFromParcel(Parcel in) {
            return new Circulo(in);
        }

        public Circulo[] newArray(int size) {
            return new Circulo[size];
        }
    };

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel out, int flags) {
        super.writeToParcel(out, flags);
        out.writeDouble(radio);
    }

    private Circulo(Parcel in) {
        super(in);
        radio = in.readDouble();
    }


}
