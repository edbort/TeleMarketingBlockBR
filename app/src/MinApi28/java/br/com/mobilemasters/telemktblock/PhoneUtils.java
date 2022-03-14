package br.com.mobilemasters.telemktblock;

import android.annotation.SuppressLint;
import android.content.Context;
import android.telecom.TelecomManager;

public class PhoneUtils {

    @SuppressLint("MissingPermission")
    public static void endCall(Context context) throws Exception {
        TelecomManager telecomManager = (TelecomManager) context.getSystemService(Context.TELECOM_SERVICE);
        telecomManager.endCall();
    }

}