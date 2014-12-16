package com.example.mati.spinnerfigurasgeoobjetos;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;


public class SpinnerFigurasGeoObjetos extends Activity {
    public Spinner miSpinner;
    public static int COD_RESPUESTA=0;
    public static String PARCEL_KEY="com.example.mati.spinnerFigurasgeoobjetos";


    public Figura[] figura =
            new Figura[]{
                    new Circulo(),
                    new Rectangulo(),
                    new Cuadrado()

            };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_spinner_figuras_geo_objetos);

        miSpinner = (Spinner) findViewById(R.id.spinner);
        miSpinner.setBackgroundColor(Color.argb(127,255,255,0));

        AdaptadorFigura miAdaptador = new AdaptadorFigura(this);
        miSpinner.setAdapter(miAdaptador);

        miSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {

            public void onItemSelected(AdapterView arg0, View arg1, int position, long id) {

               // tipoClick=figura[position].getTipo();

                switch(position){
                    case 0:
                        Circulo c=new Circulo();
                        c.setRadio(33.0);
                        Intent miIntent= new Intent(SpinnerFigurasGeoObjetos.this, PantallaDos.class);
                        Bundle miBundle=new Bundle();
                        miBundle.putParcelable(PARCEL_KEY, c);
                        miIntent.putExtras(miBundle);
                        startActivityForResult(miIntent,COD_RESPUESTA);
                        break;
                    case 1:

                        break;

                    case 2:

                        break;

                    case 3:


                        break;
                    case 4:


                        break;
                }

            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });


    }



    class AdaptadorFigura extends ArrayAdapter<Figura> {
        public Activity miActividad;

        public AdaptadorFigura(Activity laActividad){
            super(laActividad, R.layout.spinner_contenido, figura);
            this.miActividad=laActividad;
        }

        public View getDropDownView(int position, View convertView, ViewGroup parent){
            View vistaDesplegada=getView(position, convertView, parent);
            return vistaDesplegada;
        }

        public View getView(int position, View convertView, ViewGroup parent){
            View item=convertView;
            ViewHolder holder;

            if(item==null) {

                LayoutInflater inflater = miActividad.getLayoutInflater();
                item = inflater.inflate(R.layout.spinner_contenido, null);

                holder = new ViewHolder();

                holder.tipo = (TextView) item.findViewById(R.id.campoTipo);


                item.setTag(holder);
            }else{
                holder=(ViewHolder)item.getTag();
            }

            holder.tipo.setText(figura[position].getTipo());

            return item;
        }
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.spinner_figuras_geo_objetos, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
