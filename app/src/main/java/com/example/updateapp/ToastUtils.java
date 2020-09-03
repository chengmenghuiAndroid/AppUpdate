package com.example.updateapp;

import android.content.Context;
import android.widget.Toast;

class ToastUtils {

    public static void shortToast(Context context, String s) {
        Toast.makeText(context, s, Toast.LENGTH_SHORT).show();
    }
}
