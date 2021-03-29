package com.example.laboratorio1_activities;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {


     ListView listView;
     ArrayList<String> productos;
    EditText editText,editText2,editText3;

    TextView textView5;
    int j=0;
    int total = 0,restante=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        productos = new ArrayList<String>();
        listView = (ListView) findViewById(R.id.listaProducto);
        editText = (EditText) findViewById(R.id.edt_productosCantidad);
        editText2 =(EditText) findViewById(R.id.edt_precioProducto);
        editText3 = (EditText) findViewById(R.id.edt_cantidadDinero);
        textView5 = (TextView) findViewById(R.id.textView5);

        Button aumentarPrecio = ( Button) findViewById(R.id.button2);
        aumentarPrecio.setOnClickListener((new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String Cantidad = editText.getText().toString();

                String precio = editText2.getText().toString();
                total = total + Integer.parseInt(precio);

                int  DineroTotal = Integer.parseInt(editText3.getText().toString());

                if ((total - Integer.parseInt(precio))  >=DineroTotal ){

                    do {
                        productos.add(String.valueOf(precio));
                        ArrayAdapter<String> adapter = new ArrayAdapter<String>(getApplicationContext(), android.R.layout.simple_list_item_1,productos);

                        listView.setAdapter(adapter);
                        textView5.setText(String.valueOf(restante));
                        j++;

                    } while (j < Integer.parseInt(Cantidad));
                }
                else{
                    j++;
                    restante = j;
                    productos.add(String.valueOf(precio));
                    ArrayAdapter<String> adapter = new ArrayAdapter<String>(getApplicationContext(), android.R.layout.simple_list_item_1,productos);
                    Toast.makeText(getBaseContext(),DineroTotal+ "- " + total +" - "+restante,Toast.LENGTH_LONG).show();
                    listView.setAdapter(adapter);


                }

                editText2.setText(null);
            }
        }));

    }

}