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
import com.fedemcode.uruguaysevacuna.login.UserLoginRequest;
import com.fedemcode.uruguaysevacuna.login.UserLoginResponse;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class LoginActivity extends AppCompatActivity {

    Button botonnoregistro;
    Button botonconfirmar;
    EditText editTextname, edPassword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        botonnoregistro=(Button)findViewById(R.id.botonnoregistro);

        botonconfirmar = findViewById(R.id.botonconfirmar);
        editTextname = findViewById(R.id.editTextname);
        edPassword = findViewById(R.id.edPassword);

        botonnoregistro.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent i=new Intent(LoginActivity.this, Registro.class);
                startActivity(i);
            }
        });

        botonconfirmar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if(TextUtils.isEmpty(editTextname.getText().toString()) || TextUtils.isEmpty(edPassword.getText().toString())){
                    Toast.makeText(LoginActivity.this,"Usuario y/o Contraseña Requerida",Toast.LENGTH_LONG).show();
                }else{
                   login();
                }

            }
        });
    }

    public void login(){
        UserLoginRequest userLoginRequest = new UserLoginRequest();
        userLoginRequest.setUserName(editTextname.getText().toString());
        userLoginRequest.setPassword(edPassword.getText().toString());

        Call<UserLoginResponse> loginResponseCall = ApiClient.getUserInterface().userLogin(userLoginRequest);
        loginResponseCall.enqueue(new Callback<UserLoginResponse>() {
            @Override
            public void onResponse(Call<UserLoginResponse> call, Response<UserLoginResponse> response) {
                if(response.isSuccessful()){
                    Toast.makeText(LoginActivity.this,"Ingreso Correcto",Toast.LENGTH_LONG).show();

                    Intent i=new Intent(LoginActivity.this, HomeActivity.class);
                    startActivity(i);

                }else{
                    Toast.makeText(LoginActivity.this,"Ups!!! Algo salio mal",Toast.LENGTH_LONG).show();
                }
            }

            @Override
            public void onFailure(Call<UserLoginResponse> call, Throwable t) {
                Toast.makeText(LoginActivity.this,"Error "+t.getLocalizedMessage(),Toast.LENGTH_LONG).show();
            }
        });
    }
}