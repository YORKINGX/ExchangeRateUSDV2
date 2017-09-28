package com.administrador.ratechangeusd.activities.service.servicemodel;

/**
 * Created by Administrador on 28/09/2017.
 */
import com.administrador.ratechangeusd.activities.database.dbHistoryChangeRate;

import io.realm.Realm;
import io.realm.RealmResults;

public class ServiceModelClass {

    private Realm realm;
    public  ServiceModelClass(Realm realm){

        this.realm = realm;
    }

    //Gets Coin History
    public dbHistoryChangeRate [] getHistoryCoin() {

        RealmResults<dbHistoryChangeRate> realmResults = realm.where(dbHistoryChangeRate.class).findAll();

        return  realmResults.toArray(new dbHistoryChangeRate[realmResults.size()]);

    }

    //Update Coin History
    public void updateHistoryCoin (dbHistoryChangeRate objHisCoin){


    }

    //Save Coin History

    public  void CreateHistoryCoin(long id, String Coin, String Date, String coordX, String coordY){

        realm.beginTransaction();
        dbHistoryChangeRate historyChangeRate = realm.createObject(dbHistoryChangeRate.class,id);
        historyChangeRate.setId(1);
        historyChangeRate.setCoin(Coin);
        historyChangeRate.setDate(Date);
        historyChangeRate.setCoordX(Float.valueOf(coordX));
        historyChangeRate.setCoordY(Float.valueOf(coordY));
        realm.commitTransaction();

    }

   public void delteHistoryCoin(long id){

   }

}
