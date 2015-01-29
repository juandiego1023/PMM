package com.example.juandiegoariasmartin.enviospaquetes2;

import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;

/**
 * Created by juandiegoariasmartin on 29/1/15.
 */
public class PantallaDos extends Activity {
    private TextView zonaDestinoRecibido,continenteDestinoRecibido,precioDestinoRecibido,pesoDestinoRecibido;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.pantalla_dos);

        zonaDestinoRecibido= (TextView)findViewById(R.id.tvZonaDestinoRecibido);
        continenteDestinoRecibido= (TextView)findViewById(R.id.tvcontinenteDestinoRecibido);
        precioDestinoRecibido= (TextView)findViewById(R.id.tvprecioDestinoRecibido);
        pesoDestinoRecibido= (TextView)findViewById(R.id.tvpesoDestinoRecibido);

        Bundle miBundleRecoger = getIntent().getExtras();
        zonaDestinoRecibido.setText(miBundleRecoger.getString("zonaDestino"));
        continenteDestinoRecibido.setText(miBundleRecoger.getString("continenteDestino"));
        precioDestinoRecibido.setText(miBundleRecoger.getString("precioDestino"));
        pesoDestinoRecibido.setText(miBundleRecoger.getString("pesoDestino"));
    }
}
