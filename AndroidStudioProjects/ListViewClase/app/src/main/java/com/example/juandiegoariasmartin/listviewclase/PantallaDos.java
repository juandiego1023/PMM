package com.example.juandiegoariasmartin.listviewclase;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

/**
 * Created by juandiegoariasmartin on 11/11/14.
 */
public class PantallaDos extends Activity {
    private Button btnVolver;
    private TextView tvDiaRecibido;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pantalla_dos);

        btnVolver= (Button)findViewById(R.id.btnVolver);
        tvDiaRecibido= (TextView)findViewById(R.id.tvDiaRecibido);

        btnVolver.setOnClickListener( new View.OnClickListener(){
            public void onClick(View v){
                Intent vueltaIntent= new Intent();
                setResult(RESULT_OK, vueltaIntent);
                finish();
            }
        });

        Bundle  miBundleRecoger = getIntent().getExtras();
        tvDiaRecibido.setText(miBundleRecoger.getString("TEXTO"));

    }
}

