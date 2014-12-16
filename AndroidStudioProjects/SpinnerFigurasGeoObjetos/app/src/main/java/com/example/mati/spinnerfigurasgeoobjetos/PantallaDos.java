package com.example.mati.spinnerfigurasgeoobjetos;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

/**
 * Created by juandiegoariasmartin on 25/11/14.
 */
public class PantallaDos extends Activity {
    private  String recuperamos_variable_tipo;
    private int intColIni;
    private int intFilIni;
    private int intColFin;
    private int intFilFin;
    private int intRadio;

    public double doubleArea;


    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.pantalla_dos);



    }

    class MiDibujoRectangulo extends View {
        public MiDibujoRectangulo(Context c) {
            super(c);
        }
        protected void onDraw(Canvas lienzo) {
            lienzo.drawColor(Color.GRAY);
            Paint miPincel = new Paint();
            miPincel.setStyle(Paint.Style.STROKE);
            lienzo.drawRect(intColIni, intFilIni, intColFin, intFilFin, miPincel);

            miPincel.setTextSize(30);
            lienzo.drawText("Area: "+String.valueOf(doubleArea ), 220, 220, miPincel);
        }
    }

    class MiDibujoCirculo extends View {
        public MiDibujoCirculo(Context c) {
            super(c);
        }

        protected void onDraw(Canvas lienzo) {

            int altoDiv2 = lienzo.getHeight() / 2;
            int anchoDiv2 = lienzo.getWidth() / 2;

            lienzo.drawColor(Color.GRAY);
            Paint miPincel = new Paint();
            miPincel.setStyle(Paint.Style.STROKE);
            lienzo.drawCircle(anchoDiv2, altoDiv2, intRadio, miPincel);

            miPincel.setTextSize(30);
            lienzo.drawText("Area: " + String.valueOf(doubleArea), 220, 220, miPincel);

        }
    }


    public void showToast(String text) {
        Toast.makeText(this, text, Toast.LENGTH_SHORT).show();
    }

}
