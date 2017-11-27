package com.pax.coolweather.util;

import android.annotation.SuppressLint;
import android.content.Context;
import android.widget.Toast;

/**
 * @author ligq
 */
public class ToastUtil {
    private static Toast mToast;

    @SuppressLint("ShowToast")
    public static void showToast(Context context, String msg) {
        if (mToast == null) {
            mToast = Toast.makeText(context, msg, Toast.LENGTH_SHORT);
        }
        mToast.show();
    }
}
