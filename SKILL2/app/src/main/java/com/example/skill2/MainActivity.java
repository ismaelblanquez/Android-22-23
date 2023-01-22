package com.example.skill2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    Button btn1, btn2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btn1 = (Button) findViewById(R.id.cancelar);
        btn2 = (Button) findViewById(R.id.ingresar);
        Toast.makeText(getApplicationContext(),"Toast de prueba", Toast.LENGTH_LONG).show();
        btn1.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
            Toast.makeText(getApplicationContext(),"Cancelar",Toast.LENGTH_LONG).show();
            }
        });
        btn2.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                Toast.makeText(getApplicationContext(),"Ingresar",Toast.LENGTH_LONG).show();
            }
        });
    }
}