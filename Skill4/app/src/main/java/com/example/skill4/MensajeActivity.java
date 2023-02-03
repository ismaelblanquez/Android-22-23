package com.example.skill4;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class MensajeActivity extends AppCompatActivity {
    TextView msj;
    Spinner spinnerScreen2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mensaje);

        msj = (TextView) findViewById(R.id.txtNombreMensaje);
        spinnerScreen2 = (Spinner) findViewById(R.id.spinnerScreen2);

        ArrayList<String> spinnerScreenList = new ArrayList<String>();
        spinnerScreenList.add("Seleccion");
        spinnerScreenList.add("Lunes");
        spinnerScreenList.add("Martes");
        spinnerScreenList.add("Miercoles");
        spinnerScreenList.add("Jueves");
        spinnerScreenList.add("Viernes");
        spinnerScreenList.add("Sabado");
        spinnerScreenList.add("Domingo");
        Bundle miBundle = this.getIntent().getExtras();

        ArrayAdapter<CharSequence> adapter = new ArrayAdapter(this,
                android.R.layout.simple_spinner_item,spinnerScreenList);
        spinnerScreen2.setAdapter(adapter);

        spinnerScreen2.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(parent.getContext(), "Seleccionado" + parent.getItemAtPosition(position).toString(), Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
        if(miBundle!=null){
            String nombre = miBundle.getString("nombre");
            msj.setText("Bienvenido: " + nombre);


        }

    }
    public void onclick(View view){
        finish();
    }

}