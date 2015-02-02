package com.example.juandiegoariasmartin.enviopaquetes3;

import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;

/**
 * Created by juandiegoariasmartin on 29/1/15.
 */
public class PantallaDos extends Activity {
    private TextView zonaDestinoRecibido,continenteDestinoRecibido,precioDestinoRecibido,pesoDestinoRecibido,tarifaTipoDestinoRecibido,boxCajaDestinoRecibido,boxDedicatoriaDestinoRecibido;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.pantalla_dos);

        zonaDestinoRecibido= (TextView)findViewById(R.id.tvZonaDestinoRecibido);
        continenteDestinoRecibido= (TextView)findViewById(R.id.tvcontinenteDestinoRecibido);
        precioDestinoRecibido= (TextView)findViewById(R.id.tvprecioDestinoRecibido);
        pesoDestinoRecibido= (TextView)findViewById(R.id.tvpesoDestinoRecibido);
        tarifaTipoDestinoRecibido=(TextView)findViewById(R.id.tvtarifaTipoDestinoRecibido);
        boxCajaDestinoRecibido=(TextView)findViewById(R.id.tvBoxCajaDestinoRecibido);
        boxDedicatoriaDestinoRecibido=(TextView)findViewById(R.id.tvBoxDedicatoriaDestinoRecibido);

        Bundle miBundleRecoger = getIntent().getExtras();
        zonaDestinoRecibido.setText(miBundleRecoger.getString("zonaDestino"));
        continenteDestinoRecibido.setText(miBundleRecoger.getString("continenteDestino"));
        precioDestinoRecibido.setText(miBundleRecoger.getString("precioDestino"));
        pesoDestinoRecibido.setText(miBundleRecoger.getString("pesoDestino"));
        tarifaTipoDestinoRecibido.setText(miBundleRecoger.getString("tarifaTipoDestino"));
        boxCajaDestinoRecibido.setText(miBundleRecoger.getString("boxCajaDestino"));
        boxDedicatoriaDestinoRecibido.setText(miBundleRecoger.getString("boxDedicatoriaDestino"));
    }
}
