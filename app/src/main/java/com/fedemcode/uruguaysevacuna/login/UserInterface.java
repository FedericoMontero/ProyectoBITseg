package com.fedemcode.uruguaysevacuna.login;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;

public interface UserInterface {

    @POST("api/v1/Auth/Login/")
    Call<UserLoginResponse> userLogin(@Body UserLoginRequest userLoginRequest);


}
