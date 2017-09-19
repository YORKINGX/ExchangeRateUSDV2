package com.administrador.ratechangeusd.activities.helpers;

import android.content.Context;
import android.graphics.Typeface;
import android.widget.TextView;

import com.administrador.ratechangeusd.activities.utils.FontCahe;


/**

 * @author Rony Diaz
 * @version %I, %G
 * @since 1.0
 */
public class FontHelper {

    public static void setCustomFont(TextView textview, Context context, String name) {
		if (textview != null && context != null && name != null) {
            Typeface tf = FontCahe.get(name, context);
            if (tf != null) {
                textview.setTypeface(tf);
            }
        }
	}

}