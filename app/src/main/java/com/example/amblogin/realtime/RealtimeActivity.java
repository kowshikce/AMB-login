package com.example.amblogin.realtime;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.Manifest;
import android.content.Context;
import android.content.pm.PackageManager;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.View;

import com.example.amblogin.R;
import com.example.amblogin.service.ApiService;
import com.example.amblogin.service.Resp;
import com.github.nkzawa.socketio.client.IO;
import com.github.nkzawa.socketio.client.Socket;
import com.google.gson.Gson;

import java.net.URISyntaxException;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class RealtimeActivity extends AppCompatActivity {

    private LocationManager locationManager;
    private Context context;

    private Socket socket;
    public static final String TAG = "p";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_realtime);

        try{
            socket = IO.socket("http://192.168.1.104:3000/");
            Log.i(TAG, String.valueOf(socket == null));
        }catch (URISyntaxException e){
            Log.i(TAG, "error", e);
        }

        socket.connect();

        Call<Resp> call = ApiService.getMainservice().getResp();
        call.enqueue(new Callback<Resp>() {
            @Override
            public void onResponse(Call<Resp> call, Response<Resp> response) {
                if(response.isSuccessful()){
                    socket.emit("gps", "hi");
                    Log.i(TAG, "successful");
                }else{
                    Log.i(TAG, "unsuccessful");
                }
            }

            @Override
            public void onFailure(Call<Resp> call, Throwable t) {
                Log.i(TAG, "failure"+ t);
            }
        });


        context = getApplicationContext();
        locationManager = (LocationManager) context.getSystemService(Context.LOCATION_SERVICE);
        configureButton();
    }

    private void configureButton()
    {

                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                    if (checkSelfPermission(Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && checkSelfPermission(Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
                        requestPermissions(new String[]{Manifest.permission.ACCESS_COARSE_LOCATION,Manifest.permission.ACCESS_FINE_LOCATION,
                                Manifest.permission.INTERNET},10);
                        return;
                    }
                    else {
                        locationManager.requestLocationUpdates(LocationManager.GPS_PROVIDER, 1000, 2, listener);
                    }
                }


    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        switch (requestCode)
        {
            case 10:
                if(grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED)
                {
                    configureButton();
                }
                return;
        }
    }


    private LocationListener listener = new LocationListener() {
        @Override
        public void onLocationChanged(Location location) {
            String data = String.format("%s - %s - %s - %s", location.getLatitude(), location.getLongitude(), location.getSpeed(), location.getAltitude());
            socket.emit("gps", data);
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
    };




}
