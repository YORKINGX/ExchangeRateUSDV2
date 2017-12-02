package com.administrador.ratechangeusd.activities.activities;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.format.DateFormat;
import android.util.Log;
import android.widget.LinearLayout;
import android.widget.Toast;

import static android.content.ContentValues.TAG;
import static com.administrador.ratechangeusd.activities.service.constans.ClasConstans.*;
import com.administrador.ratechangeusd.R;
import com.administrador.ratechangeusd.activities.adapters.RatesCoinAdapter;
import com.administrador.ratechangeusd.activities.database.dbHistoryChangeRate;
import com.administrador.ratechangeusd.activities.model.CoordenatesXYClass;
import com.administrador.ratechangeusd.activities.model.DetailCoinClass;
import com.administrador.ratechangeusd.activities.model.RateCoinsBase;
import com.administrador.ratechangeusd.activities.model.RatesUsd;
import com.administrador.ratechangeusd.activities.service.ServiceManager;
import com.administrador.ratechangeusd.activities.service.callback.CallBackChangeRates;
import com.administrador.ratechangeusd.activities.service.servicemodel.ServiceModelClass;
import com.facebook.stetho.Stetho;
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
import com.juang.jplot.PlotPlanitoXY;

import io.realm.DynamicRealm;
import io.realm.Realm;
import io.realm.RealmConfiguration;
import io.realm.RealmMigration;
import io.realm.RealmResults;

public class DetailCoinActivity extends BaseActivity {

    String simbol = "JBY";
    String coinSymbols;
    String containerValue;
    String rates = "rates";
    int contadorDates = 0;
    String baseCoin;
    String value;
    String changeFechRates;
    Double castRate;
    ArrayList <String> arrayDates = new ArrayList<>();
    ArrayList <Float> arrayXDates = new ArrayList<>();
    ArrayList <Float> arrayYDates = new ArrayList<>();
    ArrayList <Double> datesCoin = new ArrayList<>();
    ArrayList <DetailCoinClass> detailCoin = new ArrayList<DetailCoinClass>();
    ArrayList <CoordenatesXYClass> arrayXY = new ArrayList<>();
    float X,Y;

    Context context;
    private static final String TAG = "MyApplication";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Realm.init(this);
        RealmConfiguration realmConfiguration = new RealmConfiguration.Builder()
                .name("CoinHistory")
                .schemaVersion(1)
                .build();
                Realm.setDefaultConfiguration(realmConfiguration);

        ServiceModelClass serviceModel = new ServiceModelClass(Realm.getDefaultInstance());
        serviceModel.CreateHistoryCoin(3,"BGP","2017-09-27","1","5");
        serviceModel.getHistoryCoin();


        dbHistoryChangeRate dbCoinHistory = new dbHistoryChangeRate();
        setContentView(R.layout.activity_main2);
        context=this;


         //pantalla= (LinearLayout) (findViewById(R.id.pantalla));
        Bundle datos = this.getIntent().getExtras();

        arrayDates = datesOfInquiries();
        arrayXDates = datesXOfInquiries(arrayDates);

            coinSymbols = datos.getString("CoinKilick").substring(0,3);

         for (int i = 0; i < arrayDates.size(); i++) {

                detailOfCoin(arrayDates.get(i).toString(), VALUE_COIN_BASE, coinSymbols);

            }

        for (int i = 0; i < arrayXDates.size(); i++){

              arrayXDates.get(i);

         }

      //  plot = new PlotPlanitoXY(context,"Titulo principal del grafico","titulo eje x","titulo eje y");
        //  plot.SetSerie1(X,Y,"graph 1",5,true);// el 5 es el tamaño de punto "true" es para unir los puntos

        //plot.SetHD(true); //ajustamos la calidad hd que suaviza bordes del grafico. por default esta desactivado
        // plot.SetTouch(true);// activa el touch sobre el grafico no es necesario colocarlo ya que por default esta activado
        //pantalla.addView(plot);
    }

    public void detailOfCoin(String dates, String base, String symbols){

        ServiceManager.getCoinRatesUsddetail(new CallBackChangeRates() {
            @Override
            public void onSuccess(JsonObject ListCoinRates) {


                JsonObject jsonObject = ListCoinRates;
                Float valueY;
                Gson gson = new Gson();
                for (Map.Entry<String,JsonElement> entry : jsonObject.entrySet()){
                    DetailCoinClass mRatesCoin = new DetailCoinClass();
                    containerValue = entry.getKey();

                    if (containerValue.equals(LABEL_COIN_BASE)){baseCoin = entry.getValue().toString();}
                    if (containerValue.equals(LABEL_DATE_CHANGE)){changeFechRates = entry.getValue().toString();}
                    if (containerValue.equals(VALUE_CONTAINER_COIN)){

                        DetailCoinClass objDetalCoin = new DetailCoinClass();
                        CoordenatesXYClass objCoordXY = new CoordenatesXYClass();
                        value = entry.getValue().toString();
                        datesCoin.add(stringNumeric(value));
                        objDetalCoin.setRateCoin(stringNumeric(value));
                        valueY = stringNumeric(value).floatValue();
                        arrayYDates.add(valueY);

                        Y = valueY.floatValue();
                        X = arrayXDates.get(contadorDates).floatValue();
                        objCoordXY.setX(X);
                        objCoordXY.setY(Y);
                        arrayXY.add(objCoordXY);
                        objDetalCoin.setDateChange(arrayDates.get(contadorDates).toString());
                        contadorDates ++;
                        //detailCoin.add(objDetalCoin);

                    }
                }

            }

            @Override
            public void onError(String msgError, int indError) {

            // Toast.makeText(MainActivity2.this,msgError,Toast.LENGTH_LONG).show();

            }
        },dates,base,symbols);


    }
}



