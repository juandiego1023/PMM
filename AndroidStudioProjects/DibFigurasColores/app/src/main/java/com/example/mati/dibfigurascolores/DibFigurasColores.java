package com.example.mati.dibfigurascolores;

import android.app.Activity;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;


public class DibFigurasColores extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(new MiDibujo(this));
    }


    class MiDibujo extends View {


        public MiDibujo(Context c) {
            super(c);
        }

        protected void onDraw(Canvas lienzo){
            int alto=lienzo.getHeight();
            int ancho=lienzo.getWidth();
            int altoDiv2=lienzo.getHeight()/2;
            int anchoDiv2=lienzo.getWidth()/2;

            int colIni=10;
            int filIni=10;
            int colFin=50;
            int filFin=50;

            lienzo.drawColor(Color.GRAY);

            //arriba izquierda
            Paint miPincelRed= new Paint();
            miPincelRed.setColor(Color.RED);
            miPincelRed.setStyle(Paint.Style.STROKE);
            lienzo.drawRect(colIni,filIni,colFin,filFin,miPincelRed);

            //arriba derecha
            Paint miPincelBlue= new Paint();
            miPincelBlue.setColor(Color.BLUE);
            miPincelBlue.setStyle(Paint.Style.STROKE);
            lienzo.drawRect(ancho-colFin,filIni,ancho-colIni,filFin,miPincelBlue);

            //abajo izquierda
            Paint miPincelGreen= new Paint();
            miPincelGreen.setColor(Color.GREEN);
            miPincelGreen.setStyle(Paint.Style.STROKE);
            lienzo.drawRect(colIni,altoDiv2,colFin,altoDiv2+filFin,miPincelGreen);

            //abajo derecha
            Paint miPincelYellow= new Paint();
            miPincelYellow.setColor(Color.YELLOW);
            miPincelYellow.setStyle(Paint.Style.STROKE);
            lienzo.drawRect(ancho-colFin,altoDiv2,ancho-colIni,altoDiv2+filFin,miPincelYellow);

            //circulo
            Paint miPincelPink= new Paint();
            miPincelPink.setColor(Color.parseColor("#F5A9F2"));
            miPincelPink.setStyle(Paint.Style.STROKE);

            miPincelPink.setStrokeWidth(15);
            lienzo.drawCircle(anchoDiv2,altoDiv2/2,200,miPincelPink);
        }

    }


}
