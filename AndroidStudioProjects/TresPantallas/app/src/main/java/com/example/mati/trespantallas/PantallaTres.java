package com.example.mati.trespantallas;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

/**
 * Created by juandiegoariasmartin on 7/11/14.
 */
public class PantallaTres extends Activity {
    public Button botonVolver;
    private static final int REQUEST_CODE = 3;

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pantalla_tres);

        botonVolver= (Button)findViewById(R.id.buttonVolver);

        botonVolver.setOnClickListener( new View.OnClickListener() {
            public void onClick(View v) {
                Intent miIntent = new Intent();
                miIntent.putExtra("result", "'Vengo de la pantalla tres'");
                setResult(REQUEST_CODE, miIntent);
                finish();

            }

        });

    }

}
