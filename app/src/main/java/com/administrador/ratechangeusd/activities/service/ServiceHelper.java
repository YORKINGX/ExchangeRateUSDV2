package com.administrador.ratechangeusd.activities.service;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import com.administrador.ratechangeusd.activities.service.constans.ClasConstans;
/**
 * Created by Administrador on 03/06/2017.
 */

public class ServiceHelper {
    private ServiceInterface serviceInterface;
    private Retrofit mRetrofit;
    public static ServiceHelper mInstance;

    public ServiceHelper() {

        Gson gson = new GsonBuilder()
                .setLenient()
                .create();

        mRetrofit = new Retrofit.Builder()
                .addConverterFactory(GsonConverterFactory.create(gson))
                .baseUrl(ClasConstans.URL_BASE)
                .build();
        serviceInterface = mRetrofit.create(ServiceInterface.class);

    }


    public static ServiceInterface getInstance(){
        if(mInstance == null)
            mInstance = new ServiceHelper();
        return mInstance.serviceInterface;
    }
}
