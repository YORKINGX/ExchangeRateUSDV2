package com.administrador.ratechangeusd.activities.model;

/**
 * Created by Administrador on 22/07/2017.
 */

public class RateCoinsBase {

    private int idImagen;
    private String simbolCoin;
    private Double rateCoin;
    private String desCoin;
    private String chgUnid;

    public RateCoinsBase() {
    }

    public RateCoinsBase(int idImagen, String simbolCoin, Double rateCoin, String desCoin, String chgUnid) {
        this.idImagen = idImagen;
        this.simbolCoin = simbolCoin;
        this.rateCoin = rateCoin;
        this.desCoin = desCoin;
        this.chgUnid = chgUnid;
    }

    public int getIdImagen() {
        return idImagen;
    }

    public void setIdImagen(int idImagen) {
        this.idImagen = idImagen;
    }

    public String getSimbolCoin() {
        return simbolCoin;
    }

    public void setSimbolCoin(String simbolCoin) {
        this.simbolCoin = simbolCoin;
    }

    public Double getRateCoin() {
        return rateCoin;
    }

    public void setRateCoin(Double rateCoin) {
        this.rateCoin = rateCoin;
    }

    public String getDesCoin() {
        return desCoin;
    }

    public void setDesCoin(String desCoin) {
        this.desCoin = desCoin;
    }

    public String getChgUnid() {
        return chgUnid;
    }

    public void setChgUnid(String chgUnid) {
        this.chgUnid = chgUnid;
    }
}
