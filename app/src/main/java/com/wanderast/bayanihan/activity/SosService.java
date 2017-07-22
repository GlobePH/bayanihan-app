package com.wanderast.bayanihan.activity;

import android.app.IntentService;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import android.renderscript.Double2;
import android.support.annotation.Nullable;
import android.util.Log;

public class SosService extends IntentService {

    Double longitude, latitude;

    GpsLocator locationListener;

    LocationManager locationManager;

    Location location = null;

    public SosService() {
        super("SosService");
    }

    @Override
    protected void onHandleIntent(@Nullable Intent intent) {

        Log.v("Service", "Running");

        locationListener = new GpsLocator();
        locationManager = (LocationManager) this.getSystemService(Context.LOCATION_SERVICE);

        while(location == null) {
            getLocation();
        }

        Log.d("END:", "fin");

    }

    public void setLocation(Location location) {
        if(location != null && location.getAccuracy() < 20) {
            longitude = location.getLongitude();
            latitude = location.getLatitude();
            return;
        }
        getLocation();
    }

     public class GpsLocator implements LocationListener {
        public void onLocationChanged(Location location) {
            // Called when a new location is found by the network location provider.
            setLocation(location);
        }

        public void onStatusChanged(String provider, int status, Bundle extras) { Log.d("asdasdss", "asdasd"); }

        public void onProviderEnabled(String provider) { Log.d("asdasdss", "asdasd"); }

        public void onProviderDisabled(String provider) { Log.d("asdasdss", "asdasd"); }
    }

    public void getLocation() {

        try {
            locationManager.requestLocationUpdates(LocationManager.GPS_PROVIDER, 1000, 1, locationListener);
            location = locationManager.getLastKnownLocation(LocationManager.GPS_PROVIDER);
        } catch (SecurityException e) {
            e.printStackTrace();
        }
    }
}
