package com.administrador.ratechangeusd.activities.service.constans;

import com.administrador.ratechangeusd.R;

/**
 * Created by Administrador on 15/07/2017.
 */

public class ClasConstans {
    public static String Conectar;
    public final static int MILLIS_SECUND = 1000;
    public final static int MINUTES_BASE = 60;
    public final static String INITIAL_VALUE_TIMER = "00:00:000";
    public final static String COLOR_STATE_PAUSE = "#FF0000";
    public final static String COLOR_STATE_START = "#00FF00";
    public final static String COLOR_STATE_STOP = "#FFFFFF";
    public static final String URL_BASE = "https://api.fixer.io/";
    public  static final String GET_ENDPOIN = "latest?base=USD&symbols= GBP,EUR,JPY,BRL";
    public  static final String GET_SERVICE ="2017-06-03?base=USD&symbols=GBP";
    public static String GET_URL_ENDPOIN = "?base=USD&symbols=";
    public static final String LABEL_COIN_BASE = "base";
    public static final String LABEL_DATE_CHANGE = "date";
    public static final String VALUE_CONTAINER_COIN = "rates";
    public static final int FLAG_COIN_GBP = R.drawable.ic_uk_flag;
    public static final int FLAG_COIN_EUR = R.drawable.ic_eu_flag;
    public static final int FLAG_COIN_JPY = R.drawable.ic_jp_flag;
    public static final int FLAG_COIN_BRL = R.drawable.ic_br_flag;
    public static final String SIMBOL_GPB_COIN = "£:";
    public static final String SIMBOL_EUR_COIN = "€:";
    public static final String SIMBOL_JPY_COIN = "¥:";
    public static final String SIMBOL_BRL_COIN = "R$:";

    public static final String DESCRIPTION_COIN_GBP = "GPB Libra del Reino Unido";
    public static final String DESCRIPTION_COIN_EUR = "EUR Euro de Europa";
    public static final String DESCRIPTION_COIN_JPY = "JPY Jen de Japon";
    public static final String DESCRIPTION_COIN_BRL = "BRL Real Brasileño";







}
