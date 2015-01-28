package com.example.juandiegoariasmartin.spinnerfigurasgeometricas;

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
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;



public class SpinnerFigurasGeometricas extends Activity{

    public Spinner miSpinner;
    public static boolean isFirst=true;

    public EditText colIni,filIni,colFin,filFin,etRadio;
    public TextView textViewRadio,textViewColIni,textViewFilIni,textViewColFin,textViewFilFin;
    public Button dibujar;
    public String tipoClick;
    public String stRadio,stColIni,stFilIni,stColFin,stFilFin;


    public Figuras[] figuras =
            new Figuras[]{
                    new Figuras("Seleccione..."),
                    new Figuras("Circulo con clase"),
                    new Figuras("Circulo parseable"),
                    new Figuras("Circulo"),
                    new Figuras("Rectangulo")
            };

    public Circulo circulo;
    public CirculoParceable circuloParceable;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_spinner_figuras_geometricas);

        miSpinner = (Spinner) findViewById(R.id.spinner);
        miSpinner.setBackgroundColor(Color.argb(127,255,255,0));

        colIni=(EditText) findViewById(R.id.etColIni);
        textViewColIni=(TextView) findViewById(R.id.textViewColIni);
        colIni.setVisibility(View.INVISIBLE);
        textViewColIni.setVisibility(View.INVISIBLE);

        filIni=(EditText) findViewById(R.id.etFilIni);
        textViewFilIni=(TextView) findViewById(R.id.textViewFilIni);
        filIni.setVisibility(View.INVISIBLE);
        textViewFilIni.setVisibility(View.INVISIBLE);

        colFin=(EditText) findViewById(R.id.etColFin);
        textViewColFin=(TextView) findViewById(R.id.textViewColFin);
        colFin.setVisibility(View.INVISIBLE);
        textViewColFin.setVisibility(View.INVISIBLE);

        filFin=(EditText) findViewById(R.id.etFilFin);
        textViewFilFin=(TextView) findViewById(R.id.textViewFilFin);
        filFin.setVisibility(View.INVISIBLE);
        textViewFilFin.setVisibility(View.INVISIBLE);

        //Recojo los datos del circulo
        etRadio=(EditText) findViewById(R.id.etRadio);
        textViewRadio=(TextView) findViewById(R.id.textViewRadio);
        etRadio.setVisibility(View.INVISIBLE);
        textViewRadio.setVisibility(View.INVISIBLE);

        AdaptadorFigura miAdaptador = new AdaptadorFigura(this);
        miSpinner.setAdapter(miAdaptador);

        dibujar=(Button) findViewById(R.id.buttonDibujar);
        dibujar.setBackgroundColor(Color.parseColor("#33B5E5"));
        dibujar.setVisibility(View.INVISIBLE);


        miSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {

            public void onItemSelected(AdapterView arg0, View arg1, int position, long id) {

                tipoClick=figuras[position].getTipo();

                switch(position){
                    case 0:
                        invisibleRectangulo();
                        invisibleCirculo();
                        dibujar.setVisibility(View.INVISIBLE);
                        break;
                    case 1:
                       showToast("Entro en el case de circulo con clases: "+tipoClick);

                        dibujar.setVisibility(View.VISIBLE);
                        //Pongo visibles el ingreso de datos del circulo
                        visibleCirculo();

                        //Oculto el ingreso de datos del rectangulo
                        invisibleRectangulo();

                        dibujar.setOnClickListener(new View.OnClickListener() {
                            public void onClick(View v) {

                                stRadio=etRadio.getText().toString();

                                showToast("Click en el boton dibujar: ");
                                showToast("tipoClick: "+tipoClick);
                                showToast("stRadio: "+stRadio);

                                circulo=new Circulo(stRadio);
                                pasoPantallaCirculoConClase(tipoClick);

                            }
                        });
                        break;

                    case 2:
                        showToast("Entro en el case de circulo con clases parseable: "+tipoClick);
                        dibujar.setVisibility(View.VISIBLE);
                        //Pongo visibles el ingreso de datos del circulo
                        visibleCirculo();

                        //Oculto el ingreso de datos del rectangulo
                        invisibleRectangulo();

                        dibujar.setOnClickListener(new View.OnClickListener() {
                            public void onClick(View v) {

                                stRadio=etRadio.getText().toString();
                                showToast("Click en el boton dibujar: ");
                                showToast("tipoClick: "+tipoClick);

                                showToast("stRadio: "+stRadio);
                                pasoPantallaCirculoParseable(tipoClick);

                            }
                        });
                        break;

                    case 3:

                        showToast("Entro en el case de circulo: "+tipoClick);
                        dibujar.setVisibility(View.VISIBLE);
                        //Pongo visibles el ingreso de datos del circulo
                        visibleCirculo();

                        //Oculto el ingreso de datos del rectangulo
                        invisibleRectangulo();

                        dibujar.setOnClickListener(new View.OnClickListener() {
                            public void onClick(View v) {

                                stRadio=etRadio.getText().toString();
                                showToast("Click en el boton dibujar: ");
                                showToast("tipoClick: "+tipoClick);
                                showToast("stRadio: "+stRadio);
                                pasoPantallaCirculo(tipoClick, stRadio);

                            }
                        });
                            break;
                        case 4:
                            dibujar.setVisibility(View.VISIBLE);
                            showToast("Entro en el case de rectangulo: "+tipoClick);

                            //Muestro el ingreso de datos del rectangulo
                            visibleRectangulo();

                            //Oculto el ingreso de datos de Circulo
                            invisibleCirculo();

                            dibujar.setOnClickListener(new View.OnClickListener() {
                                public void onClick(View v) {

                                    stColIni=colIni.getText().toString();
                                    stFilIni=filIni.getText().toString();
                                    stColFin=colFin.getText().toString();
                                    stFilFin=filFin.getText().toString();
                                    showToast("Click en el boton rectangulo: ");
                                    showToast("tipoClick: "+tipoClick);
                                    pasoPantallaRectangulo(tipoClick, stColIni, stFilIni, stColFin, stFilFin);

                                    }
                                });

                            break;
                        }

                }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
    }


    public void invisibleCirculo(){
        etRadio.setVisibility(View.INVISIBLE);
        textViewRadio.setVisibility(View.INVISIBLE);
    }

    public void visibleCirculo(){
        etRadio.setVisibility(View.VISIBLE);
        textViewRadio.setVisibility(View.VISIBLE);
    }

    public void invisibleRectangulo(){
        textViewColIni.setVisibility(View.INVISIBLE);
        colIni.setVisibility(View.INVISIBLE);
        textViewFilIni.setVisibility(View.INVISIBLE);
        filIni.setVisibility(View.INVISIBLE);
        textViewColFin.setVisibility(View.INVISIBLE);
        colFin.setVisibility(View.INVISIBLE);
        textViewFilFin.setVisibility(View.INVISIBLE);
        filFin.setVisibility(View.INVISIBLE);

    }
    public void visibleRectangulo(){
        textViewColIni.setVisibility(View.VISIBLE);
        colIni.setVisibility(View.VISIBLE);
        textViewFilIni.setVisibility(View.VISIBLE);
        filIni.setVisibility(View.VISIBLE);
        textViewColFin.setVisibility(View.VISIBLE);
        colFin.setVisibility(View.VISIBLE);
        textViewFilFin.setVisibility(View.VISIBLE);
        filFin.setVisibility(View.VISIBLE);
    }

    public void showToast(String text) {
        Toast.makeText(this, text, Toast.LENGTH_SHORT).show();
    }

    public void pasoPantallaRectangulo(String tipoClick,String stColIni,String stFilIni, String stColFin, String stFilFin){

        //if(isFirst){
          //  isFirst=false;
        //}else{
            Intent miIntent = new Intent(SpinnerFigurasGeometricas.this, PantallaDos.class);
            Bundle miBundle = new Bundle();
            miBundle.putString("seleccionTipo", tipoClick);
            miBundle.putString("rectanguloColIni", stColIni);
            miBundle.putString("rectanguloFilIni", stFilIni);
            miBundle.putString("rectanguloColFin", stColFin);
            miBundle.putString("rectanguloFilFin", stFilFin);
            miBundle.putString("seleccionTipo", tipoClick);
            miIntent.putExtras(miBundle);
            startActivity(miIntent);

       //}
    }

    public void pasoPantallaCirculo(String tipoClick,String stRadio){

        Intent miIntent = new Intent(SpinnerFigurasGeometricas.this, PantallaDos.class);
        Bundle miBundle = new Bundle();
        miBundle.putString("seleccionTipo", tipoClick);
        miBundle.putString("circuloRadio", stRadio);

        miBundle.putString("seleccionTipo", tipoClick);
        miIntent.putExtras(miBundle);

        startActivity(miIntent);
    }

    public void pasoPantallaCirculoConClase(String tipoClick){

        Intent miIntent = new Intent(SpinnerFigurasGeometricas.this, PantallaDos.class);

        miIntent.putExtra("getClaseCirculo", circulo.getRadio());
        miIntent.putExtra("seleccionTipo", tipoClick);

        startActivity(miIntent);

    }

    public void pasoPantallaCirculoParseable(String tipoClick){


        circuloParceable = new CirculoParceable();
        circuloParceable.radio = stRadio;

        Intent miIntent = new Intent(SpinnerFigurasGeometricas.this, PantallaDos.class);

        miIntent.putExtra("circuloParceable", circuloParceable);
        miIntent.putExtra("seleccionTipo", tipoClick);

        startActivity(miIntent);


    }

    class AdaptadorFigura extends ArrayAdapter<Figuras> {
        public Activity miActividad;

        public AdaptadorFigura(Activity laActividad){
            super(laActividad, R.layout.spinner_contenido, figuras);
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

            holder.tipo.setText(figuras[position].getTipo());

            return item;
        }
    }





}
