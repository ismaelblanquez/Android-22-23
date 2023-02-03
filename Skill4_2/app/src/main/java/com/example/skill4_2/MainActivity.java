package com.example.skill4_2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    ListView listaDias;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listaDias = (ListView) findViewById(R.id.listViewId);

        //Proceso con ArrayList
        ArrayList<String> spinnerScreenList = new ArrayList<String>();
        spinnerScreenList.add("Seleccion");
        spinnerScreenList.add("Lunes");
        spinnerScreenList.add("Martes");
        spinnerScreenList.add("Miercoles");
        spinnerScreenList.add("Jueves");
        spinnerScreenList.add("Viernes");
        spinnerScreenList.add("Sabado");
        spinnerScreenList.add("Domingo");

        ArrayAdapter<CharSequence> adapter = new ArrayAdapter(this,
                android.R.layout.simple_list_item_1,spinnerScreenList);



        listaDias.setAdapter(adapter);
        listaDias.setOnItemClickListener(new AdapterView.OnItemClickListener(){
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id){
                Toast.makeText(parent.getContext(), "Has seleccionado: " + parent.getItemAtPosition(position).toString(), Toast.LENGTH_SHORT).show();
            }
        });
    }

}