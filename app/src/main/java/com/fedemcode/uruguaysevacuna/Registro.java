package com.fedemcode.uruguaysevacuna;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.fedemcode.uruguaysevacuna.login.ApiClient;
import com.fedemcode.uruguaysevacuna.login.UserCreateRequest;
import com.fedemcode.uruguaysevacuna.login.UserCreateResponse;
import com.fedemcode.uruguaysevacuna.login.UserLoginRequest;
import com.fedemcode.uruguaysevacuna.login.UserLoginResponse;

import java.util.Date;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Registro extends AppCompatActivity {

    Button btnAceptar;
    EditText edUserName,edName, edPassword, edApellido;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registro);

        btnAceptar = findViewById(R.id.btnCrear);
        edUserName = findViewById(R.id.edUserName);
        edName = findViewById(R.id.edName);
        edPassword = findViewById(R.id.edPassword);
        edApellido = findViewById(R.id.edApellido);


        btnAceptar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if(TextUtils.isEmpty(edName.getText().toString()) || TextUtils.isEmpty(edPassword.getText().toString()) || TextUtils.isEmpty(edUserName.getText().toString()) || TextUtils.isEmpty(edApellido.getText().toString())){
                    Toast.makeText(Registro.this,"Todos los campos son requeridos",Toast.LENGTH_LONG).show();
                }else{
                        create();
                }

            }
        });
    }



    public void create(){

        UserCreateRequest userCreateRequest = new UserCreateRequest();
        userCreateRequest.setName(edName.getText().toString());
        userCreateRequest.setLastName(edApellido.getText().toString());
        userCreateRequest.setUserName(edUserName.getText().toString());
        userCreateRequest.setPassword(edPassword.getText().toString());

        Call<UserCreateResponse> createResponseCall = ApiClient.getUserInterface().userCreate(userCreateRequest);
        createResponseCall.enqueue(new Callback<UserCreateResponse>() {
            @Override
            public void onResponse(Call<UserCreateResponse> call, Response<UserCreateResponse> response) {
                if(response.isSuccessful()){
                    Toast.makeText(Registro.this,"Usuario creado sastifactoriamente!!!",Toast.LENGTH_LONG).show();

                    Intent i=new Intent(Registro.this, LoginActivity.class);
                    startActivity(i);

                }else{
                    Toast.makeText(Registro.this,"Ups!!! Algo salio mal",Toast.LENGTH_LONG).show();
                }
            }

            @Override
            public void onFailure(Call<UserCreateResponse> call, Throwable t) {

            }
        });




    }
}