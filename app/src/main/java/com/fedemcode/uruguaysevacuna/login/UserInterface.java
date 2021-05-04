package com.fedemcode.uruguaysevacuna.login;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;

public interface UserInterface {

    @POST("api/v1/Auth/Login/")
    Call<UserLoginResponse> userLogin(@Body UserLoginRequest userLoginRequest);

    @POST("api/Users/CreateUser/")
    Call<UserCreateResponse> userCreate(@Body UserCreateRequest userCreateRequest);

    @GET("/api/Vaccinations/")
    Call<List<TableVacResponse>> getVacunatorios();

}
