package com.wanderast.bayanihan.activity;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.telephony.SmsManager;
import android.widget.Toast;

public class SmsActivity extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {
        SmsManager sm = SmsManager.getDefault();
        sm.sendTextMessage("21586514", null, "-165 144", null, null);
        Toast toast = Toast.makeText(context, "Message Sent!", Toast.LENGTH_LONG);
        toast.show();

    }
}
