package com.example.assigment_ph40777.Model;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.DELETE;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Path;

public interface API_Server {
    String DOMAIN = "http://10.24.25.255:3000";

    @GET("api")
    Call<List<MotorModel>> getMotors();

    @POST("api/motor")
    Call<MotorModel> addFruit(@Body MotorModel fruitModel);

    @PUT("api/motor/{id}")
    Call<MotorModel> updateFruit(@Path("id") String id, @Body MotorModel fruitModel);

    @DELETE("/api/motor/{id}")
    Call<Void> deleteFruit(@Path("id") String id);
}
