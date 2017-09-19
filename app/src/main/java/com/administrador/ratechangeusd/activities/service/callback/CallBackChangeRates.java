package com.administrador.ratechangeusd.activities.service.callback;

import com.google.gson.JsonObject;

/**
 * Created by Administrador on 20/07/2017.
 */

public interface CallBackChangeRates {

    void onSuccess(JsonObject ListCoinRates);
    void onError(String msgError, int indError);

}
