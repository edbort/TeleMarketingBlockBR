package br.com.mobilemasters.telemktblock;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.telephony.TelephonyManager;
import android.widget.Toast;

public class IncomingCallReceiver extends BroadcastReceiver {

    @Override
    public void onReceive(Context context, Intent intent) {
        try {
            String state = intent.getStringExtra(TelephonyManager.EXTRA_STATE);
            String number = intent.getExtras().getString(TelephonyManager.EXTRA_INCOMING_NUMBER);

            if (state.equalsIgnoreCase(TelephonyManager.EXTRA_STATE_RINGING)) {
                Toast.makeText(context, "2 Recebendo ligação de " + number, Toast.LENGTH_SHORT).show();

                TelephonyManager tm = (TelephonyManager) context.getSystemService(Context.TELEPHONY_SERVICE);
                PhoneUtils.endCall(context);

                /*
                if (number.startsWith("0303")) {
                    Toast.makeText(context, "Telemarketing ligando... Número: " + number, Toast.LENGTH_SHORT).show();
                    endCall(tm);
                } else {
                    Toast.makeText(context, "Ring " + number, Toast.LENGTH_SHORT).show();
                }
                 */
            }

            if (state.equalsIgnoreCase(TelephonyManager.EXTRA_STATE_OFFHOOK)) {
                Toast.makeText(context, "Answered " + number, Toast.LENGTH_SHORT).show();
            }

            if (state.equalsIgnoreCase(TelephonyManager.EXTRA_STATE_IDLE)) {
                Toast.makeText(context, "Idle " + number, Toast.LENGTH_SHORT).show();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}