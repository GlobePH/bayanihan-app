package com.wanderast.bayanihan.activity;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.location.Location;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.content.LocalBroadcastManager;
import android.telephony.SmsManager;
import android.widget.Toast;

public class SmsActivity extends BroadcastReceiver {

    Double longitude, latitude;
    Intent gintent;

    @Override
    public void onReceive(Context context, Intent intent) {

        LocalBroadcastManager.getInstance(context).registerReceiver(
                mMessageReceiver, new IntentFilter("GPSLocationUpdates"));

        gintent = new Intent(context, SosService.class);
        context.startService(gintent);

    }

    private BroadcastReceiver mMessageReceiver = new BroadcastReceiver() {
        @Override
        public void onReceive(Context context, Intent intent) {
            // Get extra data included in the Intent
            String message = intent.getStringExtra("Status");
            Bundle b = intent.getBundleExtra("Location");
            Location lastKnownLoc = (Location) b.getParcelable("Location");
            if (lastKnownLoc != null) {
                latitude = lastKnownLoc.getLatitude();
                longitude = lastKnownLoc.getLongitude();

                SmsManager sm = SmsManager.getDefault();
                sm.sendTextMessage("21586514", null, latitude + " " + longitude, null, null);
                Toast toast = Toast.makeText(context, "Message Sent!", Toast.LENGTH_LONG);
//                Toast toast = Toast.makeText(context, "longitude: " + longitude, Toast.LENGTH_LONG);
                toast.show();
                context.stopService(gintent);
            }
        }
    };


}
