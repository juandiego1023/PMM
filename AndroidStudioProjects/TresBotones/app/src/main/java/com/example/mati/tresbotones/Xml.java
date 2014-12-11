package com.example.mati.tresbotones;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

/**
 * Created by mati on 24/10/14.
 */
public class Xml extends Activity{
    @Override
    protected void onCreate(Bundle savedInstanceState){

        super.onCreate(savedInstanceState);
        setContentView(R.layout.xml);

        final Button botonVolver= (Button)findViewById(R.id.buttonVolver);

        botonVolver.setOnClickListener( new View.OnClickListener(){
            public void onClick(View v){
                Intent vueltaIntent= new Intent();
                setResult(RESULT_OK, vueltaIntent);
                finish();

            }

        });
    }




}


