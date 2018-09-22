package campus.ajns.com.campussse;

import android.Manifest;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.location.Location;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.google.android.gms.location.FusedLocationProviderClient;
import com.google.android.gms.location.LocationServices;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapView;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.LatLngBounds;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.android.gms.tasks.OnSuccessListener;


public class GroundFragment extends Fragment implements OnMapReadyCallback {

    private MapView mapView;
    private GoogleMap mMap;


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_ground, container, false);
        mapView=view.findViewById(R.id.mapground);
        mapView.onCreate(savedInstanceState);
        mapView.onResume();
        mapView.getMapAsync(this);
        return view;


    }


    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;


        LatLng office = new LatLng(13.021080, 74.793089);
        mMap.addMarker(new MarkerOptions().position(office)
                .title("Office"));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(office));
        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom((office),18));


        LatLng princi = new LatLng(13.021147, 74.792830);
        mMap.addMarker(new MarkerOptions().position(princi)
                .title("Principal's Chamber"));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(princi));
        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom((princi),18));



        LatLng room001 = new LatLng(13.021369, 74.793320);
        googleMap.addMarker(new MarkerOptions().position(room001)
                .title("ROOM 001"));
        googleMap.moveCamera(CameraUpdateFactory.newLatLng(room001));
        googleMap.moveCamera(CameraUpdateFactory.newLatLngZoom((room001),18));

        LatLng room002 = new LatLng(13.021174, 74.793252);
        googleMap.addMarker(new MarkerOptions().position(room002)
                .title("ROOM 002"));
        googleMap.moveCamera(CameraUpdateFactory.newLatLng(room002));
        googleMap.moveCamera(CameraUpdateFactory.newLatLngZoom((room002),18));


        LatLng room003 = new LatLng(13.021203,74.793544);
        googleMap.addMarker(new MarkerOptions().position(room003)
                .title("ROOM 003"));
        googleMap.moveCamera(CameraUpdateFactory.newLatLng(room003));
        googleMap.moveCamera(CameraUpdateFactory.newLatLngZoom((room003),18));




    }

}