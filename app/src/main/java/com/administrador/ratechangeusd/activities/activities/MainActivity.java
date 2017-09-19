package com.administrador.ratechangeusd.activities.activities;

import android.icu.text.DecimalFormat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.InputType;
import android.text.format.DateFormat;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import com.administrador.ratechangeusd.R;
import com.administrador.ratechangeusd.activities.adapters.RatesCoinAdapter;
import com.administrador.ratechangeusd.activities.model.RateCoinsBase;
import com.administrador.ratechangeusd.activities.model.RatesUsd;
import com.administrador.ratechangeusd.activities.service.ServiceManager;
import com.administrador.ratechangeusd.activities.service.callback.CallBackChangeRates;
import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;

import java.util.ArrayList;
import java.util.Map;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

import static android.R.attr.id;
import static com.administrador.ratechangeusd.activities.service.constans.ClasConstans.*;
import static java.lang.Double.parseDouble;
import static java.lang.Double.valueOf;

public class MainActivity extends BaseActivity {

    RecyclerView view_reciler;
    ArrayList<RatesUsd> mArrayListRatesCoin = new ArrayList<RatesUsd>();
    ArrayList<RateCoinsBase> mRateCoinBase = new ArrayList<RateCoinsBase>();
    RateCoinsBase mObjRateCoinsBase;

    @BindView(R.id.inputmountchange) EditText inputChnge;
    @BindView(R.id.SearchButton) ImageButton SearchButton;

    String containerValue;
    String rates = "rates";
    String baseCoin;
    String changeFechRates;
    Double castRate;

    double rateActual;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        String date = (DateFormat.format("yyyy-MM-dd", new java.util.Date()).toString());
        rateActual = 1;

        eventos(rateActual);
    }


    public void eventos (double calculte_rate){
        view_reciler =(RecyclerView) findViewById(R.id.recyclerCoin);
        LinearLayoutManager my_lienarlayout = new LinearLayoutManager(this);
        my_lienarlayout.setOrientation(LinearLayoutManager.VERTICAL);
        inputChnge.clearFocus();
        view_reciler.setLayoutManager(my_lienarlayout);

        ServiceManager.getCoinRatesUsd(new CallBackChangeRates() {
            @Override
            public void onSuccess(JsonObject ListCoinRates) {
                mRateCoinBase.clear();
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

                        mObjRateCoinsBase = new RateCoinsBase();

                        mObjRateCoinsBase.setIdImagen(FLAG_COIN_GBP);
                        castRate = mRatesCoin.getGBP()* rateActual;
                        mObjRateCoinsBase.setRateCoin(castRate);
                        mObjRateCoinsBase.setSimbolCoin(SIMBOL_GPB_COIN);
                        mObjRateCoinsBase.setDesCoin(DESCRIPTION_COIN_GBP);
                        //mObjRateCoinsBase.setChgUnid();
                        mRateCoinBase.add(mObjRateCoinsBase);

                        mObjRateCoinsBase = new RateCoinsBase();
                        mObjRateCoinsBase.setIdImagen(FLAG_COIN_EUR);
                        castRate = mRatesCoin.getEUR()* rateActual;
                        mObjRateCoinsBase.setRateCoin(castRate);
                        mObjRateCoinsBase.setSimbolCoin(SIMBOL_EUR_COIN);
                        mObjRateCoinsBase.setDesCoin(DESCRIPTION_COIN_EUR);
                        mRateCoinBase.add(mObjRateCoinsBase);

                        mObjRateCoinsBase = new RateCoinsBase();
                        mObjRateCoinsBase.setIdImagen(FLAG_COIN_JPY);
                        castRate = mRatesCoin.getJPY()* rateActual;
                        mObjRateCoinsBase.setRateCoin(castRate);
                        mObjRateCoinsBase.setSimbolCoin(SIMBOL_JPY_COIN);
                        mObjRateCoinsBase.setDesCoin(DESCRIPTION_COIN_JPY);
                        mRateCoinBase.add(mObjRateCoinsBase);

                        mObjRateCoinsBase = new RateCoinsBase();
                        mObjRateCoinsBase.setIdImagen(FLAG_COIN_BRL);
                        castRate = mRatesCoin.getBRL()* rateActual;
                        mObjRateCoinsBase.setRateCoin(castRate);
                        mObjRateCoinsBase.setSimbolCoin(SIMBOL_BRL_COIN);
                        mObjRateCoinsBase.setDesCoin(DESCRIPTION_COIN_BRL);
                        mRateCoinBase.add(mObjRateCoinsBase);
                    }
                }

                RatesCoinAdapter mAdapterCoin = new RatesCoinAdapter(getApplicationContext(),mRateCoinBase);
                view_reciler.setAdapter(mAdapterCoin);
                rateActual = 1;

            }

            @Override
            public void onError(String msgError, int indError) {

                Toast.makeText(MainActivity.this,msgError,Toast.LENGTH_LONG).show();

            }
        });

    }

    @OnClick (R.id.SearchButton)
    protected  void btn_SearchButton(){
        try {
            rateActual = Integer.parseInt(inputChnge.getText().toString());
            eventos(rateActual);
        }catch(NumberFormatException nfe) {
            rateActual = 1;
            eventos(rateActual);
        }


    }






}
