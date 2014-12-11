package com.example.juandiegoariasmartin.calculadora10;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.media.Image;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;


public class Calculadora10 extends Activity {
    private EditText numero1;
    private EditText numero2;
    private Button   calcular;
    private Button   borrar;
    private TextView textViewResultado;
    private EditText resultado;
    private RadioButton rbSumar,rbRestar;
    private CheckBox chkBoxImagen;
    private ImageView imagen;
    private ImageView imagenNegativo;
    private ImageView imagenPositivo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calculadora10);



        numero1= (EditText)findViewById(R.id.eTnumeroUno);

        numero2= (EditText)findViewById(R.id.eTnumeroDos);
        rbSumar=(RadioButton)findViewById(R.id.rbSumar);
        rbRestar=(RadioButton)findViewById(R.id.rbRestar);
        chkBoxImagen=(CheckBox)findViewById(R.id.chkBoxImagen);
        imagen=(ImageView)findViewById(R.id.imageView);
        imagenNegativo=(ImageView)findViewById(R.id.imageViewNegativo);
        imagenPositivo=(ImageView)findViewById(R.id.imageViewPositivo);
        calcular= (Button)findViewById(R.id.btnCalcular);
        borrar= (Button)findViewById(R.id.btnBorrar);
        textViewResultado =(TextView)findViewById(R.id.textViewResultado);
        resultado= (EditText)findViewById(R.id.eTresultado);

        numero1.setText("");
        numero2.setText("");
        resultado.setText("");
        imagen.setVisibility(View.INVISIBLE);
        imagenNegativo.setVisibility(View.INVISIBLE);
        imagenPositivo.setVisibility(View.INVISIBLE);

        calcular.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {


                try {

                    Numero n=new Numero();

                    String stNum1=numero1.getText().toString();
                    int num1=Integer.parseInt(stNum1);


                    String stNum2=numero2.getText().toString();
                    int num2=Integer.parseInt(stNum2);
                    
                    String res="";

                    if (rbSumar.isChecked()==true) {
                        //int suma = num1 + num2;

                        res=String.valueOf(n.sumando(num1,num2));

                        //res=String.valueOf(suma);
                        resultado.setTextColor(Color.BLUE);
                        textViewResultado.setTextColor(Color.BLUE);
                        imagenPositivo.setVisibility(View.VISIBLE);

                    }
                    if (rbRestar.isChecked()==true) {
                         //int resta = num1 - num2;
                         res=String.valueOf(n.restando(num1,num2));

                         boolean siEsPositivoResultado=Integer.parseInt(res)>0;
                         if(siEsPositivoResultado){
                            resultado.setTextColor(Color.BLUE);
                            textViewResultado.setTextColor(Color.BLUE);
                            imagenPositivo.setVisibility(View.VISIBLE);
                         }else {
                            textViewResultado.setTextColor(Color.RED);
                            resultado.setTextColor(Color.RED);
                            imagenPositivo.setVisibility(View.INVISIBLE);
                            imagenNegativo.setVisibility(View.VISIBLE);
                         }

                         //res=String.valueOf(resta);
                    }




                    resultado.setText(res);

                } catch(NumberFormatException nfe) {
                    System.out.println("No se puede convertir " + nfe);
                }

                Intent miIntent = new Intent(Calculadora10.this, PantallaDos.class);

                Bundle miBundle=new Bundle();
                String envioResultado="" + resultado.getText();
                miBundle.putString("TEXTO", envioResultado);
                miIntent.putExtras(miBundle);
                startActivity(miIntent);
            }
        });

        borrar.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                numero1.setText("");
                numero2.setText("");
                rbSumar.setChecked(false);
                rbRestar.setChecked(false);
                textViewResultado.setTextColor(Color.BLACK);
                resultado.setText("");
                chkBoxImagen.setChecked(false);
                imagenPositivo.setVisibility(View.INVISIBLE);
                imagenNegativo.setVisibility(View.INVISIBLE);

            }
        });

        chkBoxImagen.setOnCheckedChangeListener(new CheckBox.OnCheckedChangeListener() {
                    public void onCheckedChanged(CompoundButton buttonView,boolean isChecked) {
                        if (isChecked) {
                            chkBoxImagen.setText("Imagen marcado!");
                            imagen.setVisibility(View.VISIBLE);
                            //imagenPositivo.setVisibility(View.VISIBLE);
                            //imagenNegativo.setVisibility(View.VISIBLE);
                        }
                        else {
                            chkBoxImagen.setText("Imagen desmarcado!");
                            imagen.setVisibility(View.INVISIBLE);
                            //imagenPositivo.setVisibility(View.INVISIBLE);
                            //imagenNegativo.setVisibility(View.INVISIBLE);
                        }
                    }
        });

    }

}
