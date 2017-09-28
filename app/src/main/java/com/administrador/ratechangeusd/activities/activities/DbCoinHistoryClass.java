package com.administrador.ratechangeusd.activities.activities;

import android.app.Application;
import android.content.Context;
import android.util.Log;

import com.facebook.stetho.Stetho;

import io.realm.DynamicRealm;
import io.realm.Realm;
import io.realm.RealmConfiguration;
import io.realm.RealmMigration;

import static android.content.ContentValues.TAG;


/**
 * Created by Administrador on 27/09/2017.
 */



public class DbCoinHistoryClass extends Application {

    Context context = this;
    public void onCreate() {
        super.onCreate();
   /*     Stetho.initialize(
                Stetho.newInitializerBuilder(this)
                        .enableDumpapp(Stetho.defaultDumperPluginsProvider(this))
                       // .enableWebKitInspector(RealmInspectorModulesProvider.builder(this).build())
                        .build());

        Log.i(TAG, "onCreate: Realm Object");

        RealmConfiguration realmConfiguration = new RealmConfiguration.Builder(this).build()
                .name(Realm.DEFAULT_REALM_NAME)
                .schemaVersion(0)
                .deleteRealmIfMigrationNeeded()
                .build();
        Realm.setDefaultConfiguration(realmConfiguration);*/
        Realm.init(this);

    }

    }




