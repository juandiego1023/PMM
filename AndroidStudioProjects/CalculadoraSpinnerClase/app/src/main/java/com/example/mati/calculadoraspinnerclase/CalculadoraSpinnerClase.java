package com.example.mati.calculadoraspinnerclase;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;


public class CalculadoraSpinnerClase extends Activity {
    private EditText numeroUno;
    private EditText numeroDos;
    private EditText resultado;

    public Spinner miSpinner;

    private Button calcular,borrar;

    public String tipoOperando;

    public Operandos[] operandos =
            new Operandos[]{
                    new Operandos("Seleccione..."),
                    new Operandos("Sumar"),
                    new Operandos("Restar")
            };



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calculadora_spinner_clase);

        numeroUno= (EditText)findViewById(R.id.eTnumeroUno);
        numeroDos= (EditText)findViewById(R.id.eTnumeroDos);

        miSpinner = (Spinner) findViewById(R.id.spinner);
        miSpinner.setBackgroundColor(Color.argb(127, 255, 255, 0));

        calcular= (Button)findViewById(R.id.buttonCalcular);
        calcular.setBackgroundColor(Color.argb(71,71,225,0));

        borrar= (Button)findViewById(R.id.buttonBorrar);
        borrar.setBackgroundColor(Color.argb(60,225,225,0));

        resultado= (EditText)findViewById(R.id.eTresultado);

        AdaptadorFigura miAdaptador = new AdaptadorFigura(this);
        miSpinner.setAdapter(miAdaptador);

        borrar.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                numeroUno.setText("");
                numeroDos.setText("");
                resultado.setText("");


            }
        });

        miSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {

            public void onItemSelected(AdapterView arg0, View arg1, int position, long id) {

                tipoOperando=operandos[position].getOperando();

                switch(position){
                    case 0:

                        break;
                    case 1:

                       calcular.setOnClickListener(new View.OnClickListener() {
                            public void onClick(View v) {

                                String stNum1=numeroUno.getText().toString();
                                int num1=Integer.parseInt(stNum1);


                                String stNum2=numeroDos.getText().toString();
                                int num2=Integer.parseInt(stNum2);

                                int intRes=num1+num2;

                                String StringRes=String.valueOf(intRes);

                                resultado.setText(StringRes);

                                pasoPantalla(stNum1,stNum2,StringRes,tipoOperando);

                            }
                        });
                        break;

                    case 2:
                        calcular.setOnClickListener(new View.OnClickListener() {
                            public void onClick(View v) {

                                String stNum1=numeroUno.getText().toString();
                                int num1=Integer.parseInt(stNum1);


                                String stNum2=numeroDos.getText().toString();
                                int num2=Integer.parseInt(stNum2);

                                int intRes=num1-num2;

                                String StringRes=String.valueOf(intRes);

                                resultado.setText(StringRes);

                                pasoPantalla(stNum1,stNum2,StringRes,tipoOperando);

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



    public void pasoPantalla(String stNum1,String stNum2, String StringRes, String tipoOperando){

        Intent miIntent = new Intent(CalculadoraSpinnerClase.this, PantallaDos.class);
        Bundle miBundle = new Bundle();

        miBundle.putString("numeroUno", stNum1);
        miBundle.putString("numeroDos", stNum2);
        miBundle.putString("resultado", StringRes);
        miBundle.putString("tipoOperando", tipoOperando);

        miIntent.putExtras(miBundle);

        startActivity(miIntent);
    }



    class AdaptadorFigura extends ArrayAdapter<Operandos> {
        public Activity miActividad;

        public AdaptadorFigura(Activity laActividad){
            super(laActividad, R.layout.spinner_contenido, operandos);
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

                holder.operando = (TextView) item.findViewById(R.id.campoTipo);



                item.setTag(holder);
            }else{
                holder=(ViewHolder)item.getTag();
            }

            holder.operando.setText(operandos[position].getOperando());

            return item;
        }
    }







}
