package com.bignerdranch.android.clickerquestions;

import android.app.Activity;
import android.content.Context;
import android.widget.TextView;

/**
 * Created by simba on 2/11/15.
 */
public class Utils {

    //gets String from id, EditText extends TextView so you can use this
    //for a text view or an EditText
    public static String getStringFromId(Activity ctx, int rid) {
        TextView v = (TextView) ctx.findViewById(rid);
        if(v == null) {
            throw new NullPointerException("ID not found: " + rid);
        }
        return v.getText().toString();
    }
}
