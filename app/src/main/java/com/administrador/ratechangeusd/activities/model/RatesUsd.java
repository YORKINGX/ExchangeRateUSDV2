package com.administrador.ratechangeusd.activities.model;

/**
 * Created by Administrador on 20/07/2017.
 */

public class RatesUsd {

    private double BRL;
    private double GBP;
    private double JPY;
    private double EUR;

    public RatesUsd() {
    }

    public RatesUsd(double BRL, double GBP, double JPY, double EUR) {
        this.BRL = BRL;
        this.GBP = GBP;
        this.JPY = JPY;
        this.EUR = EUR;
    }

    public double getBRL() {
        return BRL;
    }

    public void setBRL(double BRL) {
        this.BRL = BRL;
    }

    public double getGBP() {
        return GBP;
    }

    public void setGBP(double GBP) {
        this.GBP = GBP;
    }

    public double getJPY() {
        return JPY;
    }

    public void setJPY(double JPY) {
        this.JPY = JPY;
    }

    public double getEUR() {
        return EUR;
    }

    public void setEUR(double EUR) {
        this.EUR = EUR;
    }
}
