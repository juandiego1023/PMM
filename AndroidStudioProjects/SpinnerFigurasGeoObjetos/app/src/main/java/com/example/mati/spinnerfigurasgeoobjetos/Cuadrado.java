package com.example.mati.spinnerfigurasgeoobjetos;


import android.os.Parcel;

public class Cuadrado extends Rectangulo {
    private int lado;
    private int altura;

    public Cuadrado(int lado, int altura) {
        super(lado, altura);
        tipo = "cuadrado";
    }

    public Cuadrado() {
        super(0, 0);
        tipo = "cuadrado";
    }

    public static final Creator<Cuadrado> CREATOR = new Creator<Cuadrado>() {
        public Cuadrado createFromParcel(Parcel in) {
            return new Cuadrado(in);
        }

        public Cuadrado[] newArray(int size) {
            return new Cuadrado[size];
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

    private Cuadrado(Parcel in) {
        super(in);
        lado = in.readInt();
        altura = in.readInt();

    }


}
