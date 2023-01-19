package com.example.mvc_netflix_1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.mvc_netflix_1.controller.StudentController;
import com.example.mvc_netflix_1.model.StudentWS;
import com.example.mvc_netflix_1.model.pojo.Student;

public class MainActivity extends AppCompatActivity {
    private StudentController controller;
    private MainActivity view;
    private StudentWS model;

    EditText editName;
    EditText editPassword;
    Button buttonSubmit;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //CARGAR VIEW
        view = this;
        // CARGAR MODEL
        // MODEL + VIEW
        controller = new StudentController(model, view);
        //CASO DE USO -> OBTENER ESTUDIANTE
        controller.getStudent();

        editName = (EditText) findViewById(R.id.editName);
        editPassword = (EditText) findViewById(R.id.editPassword);
        buttonSubmit = (Button) findViewById(R.id.buttonSubmit);
        buttonSubmit.setOnClickListener(new View.OnClickListener() {
            Student student;

            @Override
            public void onClick(View v) {
                editName.setText(student.getName());
                editPassword.setText(student.getSurname());
            }
        });


    }
}