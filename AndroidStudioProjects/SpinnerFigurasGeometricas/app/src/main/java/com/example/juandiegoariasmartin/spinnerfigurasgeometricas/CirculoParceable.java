package com.example.juandiegoariasmartin.spinnerfigurasgeometricas;

import android.os.Parcel;
import android.os.Parcelable;

public class CirculoParceable implements Parcelable {
    public String radio;

    public CirculoParceable() {

    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel out, int flags) {
        out.writeString(radio);
    }

    public static final Parcelable.Creator<CirculoParceable> CREATOR
            = new Parcelable.Creator<CirculoParceable>() {
        public CirculoParceable createFromParcel(Parcel in) {
            return new CirculoParceable(in);
        }

        public CirculoParceable[] newArray(int size) {
            return new CirculoParceable[size];
        }
    };

    public CirculoParceable(Parcel in) {
        radio = in.readString();
    }
}

