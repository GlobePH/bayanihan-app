package com.wanderast.bayanihan.activity;

import android.app.IntentService;
import android.content.Intent;
import android.support.annotation.Nullable;
import android.util.Log;

public class SosService extends IntentService {

    public SosService(){
        super("SosService");
    }

    @Override
    protected void onHandleIntent(@Nullable Intent intent) {

        Log.d("SOS SERVICE:", "Started");

    }
}
