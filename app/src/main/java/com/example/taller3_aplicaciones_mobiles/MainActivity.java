package com.example.taller3_aplicaciones_mobiles;

import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.fragment.app.FragmentContainerView;

import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.GoogleApiAvailability;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MapStyleOptions;
import com.google.android.gms.maps.model.MarkerOptions;

public class MainActivity extends AppCompatActivity implements OnMapReadyCallback {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager().findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);

        ConnectivityManager connectivityManager = (ConnectivityManager) getSystemService(CONNECTIVITY_SERVICE);
        NetworkInfo networkInfo = connectivityManager.getActiveNetworkInfo();
        boolean isConnected = networkInfo != null && networkInfo.isConnected();

        FragmentContainerView fcv = findViewById(R.id.map);
        AppCompatImageView img_backup = findViewById(R.id.img_backup);

        if (!isConnected) {
            fcv.setVisibility(View.GONE);
            img_backup.setVisibility(View.VISIBLE);
        }

        GoogleApiAvailability api = GoogleApiAvailability.getInstance();
        int resultCode = api.isGooglePlayServicesAvailable(this);

        if (resultCode != ConnectionResult.SUCCESS) {
            fcv.setVisibility(View.GONE);
            img_backup.setVisibility(View.VISIBLE);
        }

        Button btn_next = findViewById(R.id.btn_next);

        btn_next.setOnClickListener(v -> startActivity(new Intent(this, FormActivity.class)));
    }

    @Override
    public void onMapReady(@NonNull GoogleMap googleMap) {

        googleMap.setMinZoomPreference(13f);
        googleMap.setMaxZoomPreference(18f);

        MapStyleOptions style = MapStyleOptions.loadRawResourceStyle(this, R.raw.map_night);
        googleMap.setMapStyle(style);

        LatLng uniagustiniana = new LatLng(4.6531925, -74.1452101);
        googleMap.addMarker(new MarkerOptions()
                .position(uniagustiniana)
                .title("Universitaria Agustiniana")
                .snippet("\t\t   Uniagustiniana"));

        googleMap.moveCamera(CameraUpdateFactory.newLatLngZoom(uniagustiniana, 17f));
    }
}