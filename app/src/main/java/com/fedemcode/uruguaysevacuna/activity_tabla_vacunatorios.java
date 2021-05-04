package com.fedemcode.uruguaysevacuna;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

import com.fedemcode.uruguaysevacuna.login.ApiClient;
import com.fedemcode.uruguaysevacuna.login.TableVacResponse;
import com.fedemcode.uruguaysevacuna.login.UserCreateResponse;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class activity_tabla_vacunatorios extends AppCompatActivity {


    private TextView ejemplo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        ejemplo = findViewById(R.id.ejemplo);
        getVacunatorios();
    }



    private void getVacunatorios(){


        Call<List<TableVacResponse>> tableVacResponseCall = ApiClient.getUserInterface().getVacunatorios();

        tableVacResponseCall.enqueue(new Callback<List<TableVacResponse>>() {
            @Override
            public void onResponse(Call<List<TableVacResponse>> call, Response<List<TableVacResponse>> response) {
                if (!response.isSuccessful()) {
                    ejemplo.setText("Codigo: " + response.code());
                    return;
                }

                List<TableVacResponse> vacunatorios = response.body();

                for (TableVacResponse vac : vacunatorios) {
                    String content = "";
                    content += "userId:" + vac.getId() + "\n";
                    content += "userId:" + vac.getNombreVacunatorio() + "\n";
                    content += "userId:" + vac.getDepartamento() + "\n";
                    content += "userId:" + vac.getBarrio() + "\n";
                    content += "userId:" + vac.getCoordenadas() + "\n";
                    content += "userId:" + vac.getDireccion() + "\n\n";

                    ejemplo.append(content);
                }

            }

            @Override
            public void onFailure(Call<List<TableVacResponse>> call, Throwable t) {
                ejemplo.setText("SE FUE TODO A LA MIERDA");
            }


        });
    }


}