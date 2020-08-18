package com.example.comgooglemapsexample;

import androidx.fragment.app.FragmentActivity;

import android.os.Bundle;

import com.google.android.gms.maps.CameraUpdate;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

public class MapsActivity extends FragmentActivity implements OnMapReadyCallback {

    private GoogleMap mMap;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps);
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
    }

    /**
     * Manipulates the map once available.
     * This callback is triggered when the map is ready to be used.
     * This is where we can add markers or lines, add listeners or move the camera. In this case,
     * we just add a marker near Sydney, Australia.
     * If Google Play services is not installed on the device, the user will be prompted to install
     * it inside the SupportMapFragment. This method will only be triggered once the user has
     * installed Google Play services and returned to the app.
     */
    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;
// 37.147797, 38.784484
        // Add a marker in Sydney and move the camera
        LatLng balikliGol = new LatLng(37.147797, 38.784484);

        mMap.addMarker(new MarkerOptions().position(balikliGol).title("Balıklı Göl"));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(balikliGol));

        //36.859014, 39.030925

        mMap.addMarker(new MarkerOptions()
                .position(new LatLng(36.859014,39.030925))
                .title("Harran")
                .snippet("Harran Kalesi"));
        mMap.animateCamera(CameraUpdateFactory.newLatLngZoom(balikliGol,12));

        mMap.getUiSettings().setMyLocationButtonEnabled(true); // konum gösterme butonu
        mMap.getUiSettings().setCompassEnabled(true); // pusula göster
        mMap.getUiSettings().setZoomControlsEnabled(true); // zoom buttonu

        mMap.setMapType(GoogleMap.MAP_TYPE_HYBRID); // hibrit görünümü set edildi

        mMap.setTrafficEnabled(true); // trafik durumu aktif edildi

    }
}