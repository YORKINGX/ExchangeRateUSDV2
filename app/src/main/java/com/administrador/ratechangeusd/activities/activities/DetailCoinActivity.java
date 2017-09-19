package com.administrador.ratechangeusd.activities.activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.format.DateFormat;
import android.widget.Toast;
import static com.administrador.ratechangeusd.activities.service.constans.ClasConstans.*;
import com.administrador.ratechangeusd.R;
import com.administrador.ratechangeusd.activities.adapters.RatesCoinAdapter;
import com.administrador.ratechangeusd.activities.model.DetailCoinClass;
import com.administrador.ratechangeusd.activities.model.RateCoinsBase;
import com.administrador.ratechangeusd.activities.model.RatesUsd;
import com.administrador.ratechangeusd.activities.service.ServiceManager;
import com.administrador.ratechangeusd.activities.service.callback.CallBackChangeRates;
import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Map;

import static com.administrador.ratechangeusd.activities.service.constans.ClasConstans.DESCRIPTION_COIN_BRL;
import static com.administrador.ratechangeusd.activities.service.constans.ClasConstans.DESCRIPTION_COIN_EUR;
import static com.administrador.ratechangeusd.activities.service.constans.ClasConstans.DESCRIPTION_COIN_GBP;
import static com.administrador.ratechangeusd.activities.service.constans.ClasConstans.DESCRIPTION_COIN_JPY;
import static com.administrador.ratechangeusd.activities.service.constans.ClasConstans.FLAG_COIN_BRL;
import static com.administrador.ratechangeusd.activities.service.constans.ClasConstans.FLAG_COIN_EUR;
import static com.administrador.ratechangeusd.activities.service.constans.ClasConstans.FLAG_COIN_GBP;
import static com.administrador.ratechangeusd.activities.service.constans.ClasConstans.FLAG_COIN_JPY;
import static com.administrador.ratechangeusd.activities.service.constans.ClasConstans.GET_URL_ENDPOIN;
import static com.administrador.ratechangeusd.activities.service.constans.ClasConstans.LABEL_COIN_BASE;
import static com.administrador.ratechangeusd.activities.service.constans.ClasConstans.LABEL_DATE_CHANGE;
import static com.administrador.ratechangeusd.activities.service.constans.ClasConstans.SIMBOL_BRL_COIN;
import static com.administrador.ratechangeusd.activities.service.constans.ClasConstans.SIMBOL_EUR_COIN;
import static com.administrador.ratechangeusd.activities.service.constans.ClasConstans.SIMBOL_GPB_COIN;
import static com.administrador.ratechangeusd.activities.service.constans.ClasConstans.SIMBOL_JPY_COIN;
import static com.administrador.ratechangeusd.activities.service.constans.ClasConstans.VALUE_CONTAINER_COIN;

public class DetailCoinActivity extends BaseActivity {

    String simbol = "JBY";
    String containerValue;
    String rates = "rates";
    String baseCoin;
    String changeFechRates;
    Double castRate;
    ArrayList <String> dates = new ArrayList<>();
    ArrayList <DetailCoinClass> dates1 = new ArrayList<DetailCoinClass>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        //GET_URL_ENDPOIN

       dates = datesOfInquiries();



       /// GET_SERVICE = dates.get(1).toString()+ GET_URL_ENDPOIN + simbol;


        detailOfCoin();

    }

    public void  detailOfCoin(){

        ServiceManager.getCoinRatesUsddetail(new CallBackChangeRates() {
            @Override
            public void onSuccess(JsonObject ListCoinRates) {

                JsonObject jsonObject = ListCoinRates;
                Gson gson = new Gson();
                for (Map.Entry<String,JsonElement> entry : jsonObject.entrySet()){
                    RatesUsd mRatesCoin = new RatesUsd();
                    containerValue = entry.getKey();

                    if (containerValue.equals(LABEL_COIN_BASE)){baseCoin = entry.getValue().toString();}
                    if (containerValue.equals(LABEL_DATE_CHANGE)){changeFechRates = entry.getValue().toString();}
                    if (containerValue.equals(VALUE_CONTAINER_COIN)){
                        // String date = (DateFormat.format("dd-MM-yyyy", new java.util.Date()).toString());
                        mRatesCoin = gson.fromJson(entry.getValue(), RatesUsd.class);

                     /*   mObjRateCoinsBase = new RateCoinsBase();
                        mObjRateCoinsBase.setIdImagen(FLAG_COIN_BRL);
                        castRate = mRatesCoin.getBRL()* rateActual;
                        mObjRateCoinsBase.setRateCoin(castRate);
                        mObjRateCoinsBase.setSimbolCoin(SIMBOL_BRL_COIN);
                        mObjRateCoinsBase.setDesCoin(DESCRIPTION_COIN_BRL);
                        mRateCoinBase.add(mObjRateCoinsBase);*/
                    }
                }

                //RatesCoinAdapter mAdapterCoin = new RatesCoinAdapter(getApplicationContext(),mRateCoinBase);
                //view_reciler.setAdapter(mAdapterCoin);
                //rateActual = 1;

            }

            @Override
            public void onError(String msgError, int indError) {

             //   Toast.makeText(MainActivity2.this,msgError,Toast.LENGTH_LONG).show();

            }
        },"2017-06-03","USD","GBP");


    }


}


