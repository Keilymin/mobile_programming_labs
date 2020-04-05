package com.example.lab5_3;

import androidx.appcompat.app.AppCompatActivity;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.provider.Settings;
import android.util.Log;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    //Приемник состояния батареи
    private final BroadcastReceiver batteryRec = new BroadcastReceiver() {

        @Override
        public void onReceive(Context c, Intent intent) {

            if (intent.getAction().equals("android.intent.action.BATTERY_LOW")) {

                startBatteryDialog();
            }
        }
    };
    //приемник нажатия кнопки камеры
    private final BroadcastReceiver cameraRec = new BroadcastReceiver() {

        @Override
        public void onReceive(Context c, Intent intent) {

                startCameraDialog();

        }
    };
    //приемник режима в самолете
    private final BroadcastReceiver airplanemodeRec = new BroadcastReceiver() {

        @Override
        public void onReceive(Context c, Intent intent) {


                boolean isAirplaneModeOn = intent.getBooleanExtra("state", false);
                Log.e("e","WW");

                startAirplaneModeDialog(isAirplaneModeOn);

        }
    };
    //диалог для низкого заряда батареи
    private void startBatteryDialog() {
        BatteryDialog dialog = new BatteryDialog();
        dialog.show(getSupportFragmentManager(),"dlgBattery");
    }
    //диалог для кнопки камеры
    private void startCameraDialog() {
        CameraDialog dialog = new CameraDialog();
        dialog.show(getSupportFragmentManager(),"dlgCamera");
    }
    //диалог для режима в самолете
    private void startAirplaneModeDialog(boolean isAirplaneModeOn) {
        AirplaneModeDialog dialog = new AirplaneModeDialog(isAirplaneModeOn);
        dialog.show(getSupportFragmentManager(),"dlgAirplane");
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    @Override
    protected void onStart() {
        super.onStart();
        //регистрация приемников
        IntentFilter ifilter = new IntentFilter(Intent.ACTION_BATTERY_LOW);
        Intent batteryStatus = registerReceiver(batteryRec, ifilter);
        IntentFilter ifilter1 = new IntentFilter(Intent.ACTION_CAMERA_BUTTON);
        Intent cameraStatus = registerReceiver(cameraRec, ifilter1);
        IntentFilter ifilter2 = new IntentFilter(Intent.ACTION_AIRPLANE_MODE_CHANGED);
        Intent airplanemodeStatus = registerReceiver(airplanemodeRec, ifilter2);
    }

    @Override
    protected void onStop() {
        super.onStop();
//отключение приемников
        if (batteryRec != null)
            unregisterReceiver(batteryRec);
        if (cameraRec != null)
            unregisterReceiver(cameraRec);
        if (airplanemodeRec != null)
            unregisterReceiver(airplanemodeRec);
    }
}

