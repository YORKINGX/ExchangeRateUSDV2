package com.administrador.ratechangeusd.activities.utils;

import android.content.Context;
import android.graphics.Typeface;

import java.util.Hashtable;

/**
 * Created by Administrador on 10/07/2017.
 */

public class FontCahe {
    private static Hashtable<String, Typeface> fontCache = new Hashtable<String, Typeface>();

    public static Typeface get(String name, Context context) {
        if (name != null && context != null) {
            Typeface tf = fontCache.get(name);

            if (tf == null) {
                try {
                    tf = Typeface.createFromAsset(context.getAssets(), name);
                } catch (Exception e) {
                    e.printStackTrace();
                    return null;
                }
                fontCache.put(name, tf);
            }
            return tf;
        }
        return null;
    }

}
