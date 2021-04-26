package com.fedemcode.uruguaysevacuna;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Registro extends AppCompatActivity {

    Button btnSignUp;
    EditText edDate, edUserName,edName, editPassword, edApellido;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registro);

        btnSignUp = findViewById(R.id.btnSignUp);
        edUserName = findViewById(R.id.edUserName);
        edName = findViewById(R.id.edName);
        edDate = findViewById(R.id.edDate);
        editPassword = findViewById(R.id.editPassword);
        edApellido = findViewById(R.id.edApellido);


        btnSignUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if(TextUtils.isEmpty(edName.getText().toString()) || TextUtils.isEmpty(editPassword.getText().toString()) || TextUtils.isEmpty(edUserName.getText().toString()) || TextUtils.isEmpty(edApellido.getText().toString()) || TextUtils.isEmpty(edDate.getText().toString())){
                    Toast.makeText(Registro.this,"Todos los campos son requeridos",Toast.LENGTH_LONG).show();
                }else{

                }

            }
        });
    }
}