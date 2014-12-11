package com.example.juandiegoariasmartin.menuallthings;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.SubMenu;
import android.view.View;
import android.widget.TextView;


public class MenuAllThings extends Activity {
    private static final int MNU_OPC1 = 1;
    private static final int MNU_OPC2 = 2;
    private static final int MNU_OPC3 = 3;
    private static final int SMNU_OPC1=31;
    private static final int SMNU_OPC2=32;

    TextView labelMensaje;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu_all_things);

        labelMensaje=(TextView)findViewById(R.id.labelMensaje);

        //Menu contextual
        registerForContextMenu(labelMensaje);

    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        menu.add(Menu.NONE, MNU_OPC1, Menu.NONE, "Opcion1")
                .setIcon(android.R.drawable.ic_menu_preferences);
        menu.add(Menu.NONE, MNU_OPC2, Menu.NONE, "Opcion2")
                .setIcon(android.R.drawable.ic_menu_compass);
        SubMenu smnu = menu.addSubMenu(Menu.NONE, MNU_OPC3, Menu.NONE, "Opcion3").setIcon(android.R.drawable.ic_menu_agenda);
            smnu.add(Menu.NONE, SMNU_OPC1, Menu.NONE, "Opcion 3.1");
            smnu.add(Menu.NONE, SMNU_OPC2, Menu.NONE, "Opcion 3.2");

        //Infla el menu de iconos que esta en xml
        getMenuInflater().inflate(R.menu.menu_menu_all_things, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case MNU_OPC1:
                labelMensaje.setText("Opcion 1 pulsada!");
                return true;
            case MNU_OPC2:
                labelMensaje.setText("Opcion 2 pulsada!");;
                return true;
            case MNU_OPC3:
                labelMensaje.setText("Opcion 3 pulsada!");;
                return true;
            case SMNU_OPC1:
                labelMensaje.setText("Opcion 3.1 pulsada!");;
                return true;
            case SMNU_OPC2:
                labelMensaje.setText("Opcion 3.2 pulsada!");;
                return true;
            //Menu de iconos
            case R.id.menu_new:
                Log.i("ActionBar", "Nuevo!");
                labelMensaje.setText("Nuevo");;
                return true;
            case R.id.menu_save:
                Log.i("ActionBar", "Guardar!");;
                labelMensaje.setText("Guardar");;
                return true;

            default:
                return super.onOptionsItemSelected(item);
        }

    }
    //Menu contextual
    @Override
    public void onCreateContextMenu(ContextMenu menu, View v,
                                    ContextMenu.ContextMenuInfo menuInfo)
    {
        super.onCreateContextMenu(menu, v, menuInfo);

        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_contextual, menu);
    }

    @Override
    public boolean onContextItemSelected(MenuItem item) {

        switch (item.getItemId()) {
            case R.id.CtxLblOpc1:
                labelMensaje.setText("Menu contextual: Opcion 1 pulsada!");
                return true;
            case R.id.CtxLblOpc2:
                labelMensaje.setText("Menu contextual: Opcion 2 pulsada!");
                return true;
            default:
                return super.onContextItemSelected(item);
        }
    }
}
