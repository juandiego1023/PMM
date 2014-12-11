package com.example.mati.spinnerfigurasgeoobjetos;


import android.os.Parcel;

public class Rectangulo extends Figura {
    private int lado;
    private int altura;

    public Rectangulo(int lado, int altura) {
        super("rectangulo");
        this.lado = lado;
        this.altura = altura;
    }

    public static final Creator<Rectangulo> CREATOR = new Creator<Rectangulo>() {
        public Rectangulo createFromParcel(Parcel in) {
            return new Rectangulo(in);
        }

        public Rectangulo[] newArray(int size) {
            return new Rectangulo[size];
        }
    };

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel out, int flags) {
        super.writeToParcel(out, flags);
        out.writeInt(lado);
        out.writeInt(altura);
    }

    public Rectangulo(Parcel in) {
        super(in);
        lado = in.readInt();
        altura= in.readInt();
    }


}
