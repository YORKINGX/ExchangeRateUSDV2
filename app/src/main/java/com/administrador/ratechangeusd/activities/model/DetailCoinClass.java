package com.administrador.ratechangeusd.activities.model;

/**
 * Created by Administrador on 21/08/2017.
 */

public class DetailCoinClass {
    private Double rateCoin;
    private String dateChange;

    public DetailCoinClass() {
    }

    public DetailCoinClass(Double rateCoin, String dateChange) {
        this.rateCoin = rateCoin;
        this.dateChange = dateChange;
    }

    public Double getRateCoin() {
        return rateCoin;
    }

    public void setRateCoin(Double rateCoin) {
        this.rateCoin = rateCoin;
    }

    public String getDateChange() {
        return dateChange;
    }

    public void setDateChange(String dateChange) {
        this.dateChange = dateChange;
    }
}
