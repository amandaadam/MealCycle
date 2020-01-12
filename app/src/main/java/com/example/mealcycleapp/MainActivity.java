package com.example.mealcycleapp;

import android.Manifest;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.google.android.gms.maps.CameraUpdate;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.karumi.dexter.Dexter;
import com.karumi.dexter.PermissionToken;
import com.karumi.dexter.listener.PermissionDeniedResponse;
import com.karumi.dexter.listener.PermissionGrantedResponse;
import com.karumi.dexter.listener.PermissionRequest;
import com.karumi.dexter.listener.single.PermissionListener;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.FragmentActivity;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import static androidx.navigation.ui.NavigationUI.*;

public class MainActivity extends FragmentActivity implements OnMapReadyCallback {

    GoogleMap map;

    private Button btnGrant;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

       /* if (ContextCompat.checkSelfPermission(MainActivity.this, Manifest.permission.ACCESS_FINE_LOCATION == PackageManager.PERMISSION_GRANTED)) {
            finish();
            return;
        }

        btnGrant=findViewById(R.id.btn_grant);
        btnGrant.setOnClickListener(new View.OnClickListener()){
            @Override

            public void onClick(View v){
                Dexter.withActivity(MainActivity.this).withPermission(Manifest.permission.ACCESS_FINE_LOCATION)
                        .withListener(new PermissionListener() {
                            @Override
                            public void onPermissionGranted(PermissionGrantedResponse response) {

                            }

                            @Override
                            public void onPermissionDenied(PermissionDeniedResponse response) {
                                if(response.isPermanentlyDenied()){
                                    if(response.isPermanentlyDenied()){
                                        AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
                                        builder.setTitle("Error").setMessage("Uh Oh! Looks like something went wrong!")
                                    }
                                }

                            }

                            @Override
                            public void onPermissionRationaleShouldBeShown(PermissionRequest permission, PermissionToken token) {
                                token.continuePermissionRequest();

                            }
                        }).check();

            }

        };
*/

        SupportMapFragment mapFragment= (SupportMapFragment) getSupportFragmentManager().findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);

    }


    @Override
    public void onMapReady(GoogleMap googleMap) {
        map= googleMap;

        LatLng London= new LatLng(42.988472, -81.249750);
        map.addMarker(new MarkerOptions().position(London).title("London"));
        map.moveCamera(CameraUpdateFactory.newLatLng(London));

    }
}
