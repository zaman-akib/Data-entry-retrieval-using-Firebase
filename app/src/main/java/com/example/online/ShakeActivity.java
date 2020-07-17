package com.example.online;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import android.Manifest;
import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Color;
import android.hardware.SensorManager;
import android.net.Uri;
import android.os.Bundle;
import android.telephony.PhoneStateListener;
import android.telephony.TelephonyManager;
import android.util.Log;
import com.squareup.seismic.ShakeDetector;

public class ShakeActivity extends AppCompatActivity implements ShakeDetector.Listener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shake);
        setTitle("Shake Sensor Test");

        SensorManager SM=(SensorManager)getSystemService(SENSOR_SERVICE);
        ShakeDetector SD=new ShakeDetector(this);
        SD.start(SM);
    }

    @SuppressLint("MissingPermission")
    @Override
    public void hearShake() {
        Intent intent = new Intent(Intent.ACTION_CALL);
        intent.setData(Uri.parse("tel:999"));
        startActivity(intent);
    }
}
