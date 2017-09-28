package com.administrador.ratechangeusd.activities.database;

import io.realm.RealmObject;
import io.realm.annotations.Index;
import io.realm.annotations.PrimaryKey;

/**
 * Created by Administrador on 26/09/2017.
 */

public class dbHistoryChangeRate extends RealmObject {

    public static final String ID = "id";
    public static final String COIN = "Coin";
    public static final String DATE = "Date";
    public static final String COORDX = "coordX";
    public static final String COORDY = "coordY";

    @PrimaryKey  @Index
    private long id;

    private String Coin;
    private String Date;
    private float coordX;
    private float coordY;

    public static String getID() {
        return ID;
    }

    public static String getCOIN() {
        return COIN;
    }

    public static String getDATE() {
        return DATE;
    }

    public static String getCOORDX() {
        return COORDX;
    }

    public static String getCOORDY() {
        return COORDY;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getCoin() {
        return Coin;
    }

    public void setCoin(String coin) {
        Coin = coin;
    }

    public String getDate() {
        return Date;
    }

    public void setDate(String date) {
        Date = date;
    }

    public float getCoordX() {
        return coordX;
    }

    public void setCoordX(float coordX) {
        this.coordX = coordX;
    }

    public float getCoordY() {
        return coordY;
    }

    public void setCoordY(float coordY) {
        this.coordY = coordY;
    }
}
