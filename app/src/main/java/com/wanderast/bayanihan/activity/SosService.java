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

    LocationManager locationManager;
    Double longitude, latitude;

    public SosService() {
        super("SosService");
    }

    @Override
    protected void onHandleIntent(@Nullable Intent intent) {

        Log.v("Service", "Running");

        GpsLocator gps = new GpsLocator();

        locationManager = (LocationManager) this.getSystemService(Context.LOCATION_SERVICE);

        try {
            locationManager.requestLocationUpdates(LocationManager.GPS_PROVIDER, 0, 0, gps);
            locationManager.removeUpdates(gps);
        } catch (SecurityException e) {
            e.printStackTrace();
        }

    }

    public class GpsLocator implements LocationListener {

        @Override
        public void onLocationChanged(Location location) {
            setLocation(location.getLongitude(), location.getLatitude());
            Log.v("Longitude", longitude.toString());
            Log.v("Latitude", latitude.toString());
        }

        @Override
        public void onStatusChanged(String provider, int status, Bundle extras) {

        }

        @Override
        public void onProviderEnabled(String provider) {

        }

        @Override
        public void onProviderDisabled(String provider) {

        }
    }

    public void setLocation(Double lon, Double lat) {
        longitude = lon;
        latitude = lat;
    }

}
