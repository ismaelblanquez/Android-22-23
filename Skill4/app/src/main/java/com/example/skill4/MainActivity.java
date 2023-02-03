package com.example.skill4;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    EditText campoNombre;
    TextView edtNombre;
    Spinner comboDias;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //Log Messages.
        Log.i("info", "Valor Información");
        Log.d("Debug", "Valor Debug");
        Log.w("Warning", "Valor Warning");
        Log.e("Error", "Valor Error");
        Log.v("Verbose", "Valor Verbose");

        campoNombre = (EditText) findViewById(R.id.edtText);
        edtNombre = (TextView) findViewById(R.id.edtNombre);
        comboDias = (Spinner) findViewById(R.id.comboDias);

        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.combo_Dias, android.R.layout.simple_spinner_item);
        comboDias.setAdapter(adapter);

        comboDias.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(parent.getContext(), "Seleccionado" + parent.getItemAtPosition(position).toString(), Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
    }


    public void evento(View view){
        switch (view.getId()){
            case R.id.btnIngresar:
                String nombre = campoNombre.getText().toString();
                edtNombre.setText("Bienvenido: " + nombre);

                Toast.makeText(this, "El nombre es: " + nombre, Toast.LENGTH_SHORT).show();

                break;

            case R.id.btnEnviar:
                Intent miIntent = new Intent(MainActivity.this, MensajeActivity.class);
                Bundle miBundle = new Bundle();
                miBundle.putString("nombre", campoNombre.getText().toString());
                miIntent.putExtras(miBundle);
                startActivity(miIntent);
                break;
        }
    }
}