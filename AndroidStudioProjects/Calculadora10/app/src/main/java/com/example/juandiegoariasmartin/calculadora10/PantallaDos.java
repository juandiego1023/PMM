package com.example.juandiegoariasmartin.calculadora10;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

/**
 * Created by juandiegoariasmartin on 9/11/14.
 */
public class PantallaDos extends Activity {
    private Button botonVolver;
    private TextView tvResRecTitulo;
    private TextView resultadoRecibido;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pantalla_dos);

            botonVolver= (Button)findViewById(R.id.buttonVolver);
            tvResRecTitulo= (TextView)findViewById(R.id.tvResRecTitulo);
            resultadoRecibido= (TextView)findViewById(R.id.tvResultadoRecibido);

            botonVolver.setOnClickListener( new View.OnClickListener(){
                public void onClick(View v){
                    Intent vueltaIntent= new Intent();
                    setResult(RESULT_OK, vueltaIntent);
                    finish();
                }
            });

            Bundle  miBundleRecoger = getIntent().getExtras();
            resultadoRecibido.setText(miBundleRecoger.getString("TEXTO"));

            int resultadoRecibidoInt=Integer.parseInt(miBundleRecoger.getString("TEXTO"));

            boolean siEsPositivoResultado=resultadoRecibidoInt>0;
            if(siEsPositivoResultado){
                tvResRecTitulo.setTextColor(Color.BLUE);
                resultadoRecibido.setTextColor(Color.BLUE);

            }else {
                tvResRecTitulo.setTextColor(Color.RED);
                resultadoRecibido.setTextColor(Color.RED);
            }
    }
}

