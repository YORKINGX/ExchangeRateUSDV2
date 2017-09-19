package com.administrador.ratechangeusd.activities.service;

import com.google.gson.JsonObject;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

import static com.administrador.ratechangeusd.activities.service.constans.ClasConstans.GET_ENDPOIN;

/**
 * Created by Administrador on 03/06/2017.
 */

public interface ServiceInterface {


    @GET(GET_ENDPOIN)
    Call<JsonObject> getCoinRates();
/*
    @POST("usuario.json")
    Call<JsonObject> createPeople(@Body PeopleModel person);*/


    @GET("{date}")
    Call<JsonObject> getCoinRatesApart(@Path("date")String date, @Query("base")String base,@Query("symbols") String symbols);



   // https://api.fixer.io/2017-06-03?base=USD&symbols=GBP




}

