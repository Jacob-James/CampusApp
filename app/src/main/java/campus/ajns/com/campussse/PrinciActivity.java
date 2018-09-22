package campus.ajns.com.campussse;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Color;
import android.location.Location;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.FragmentActivity;
import android.os.Bundle;
import android.view.View;

import com.google.android.gms.location.FusedLocationProviderClient;
import com.google.android.gms.location.LocationServices;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.Dash;
import com.google.android.gms.maps.model.Dot;
import com.google.android.gms.maps.model.Gap;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.LatLngBounds;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.android.gms.maps.model.PatternItem;
import com.google.android.gms.maps.model.Polyline;
import com.google.android.gms.maps.model.PolylineOptions;
import com.google.android.gms.tasks.OnSuccessListener;

import java.util.Arrays;
import java.util.List;

public class PrinciActivity extends FragmentActivity implements OnMapReadyCallback {

    private GoogleMap mMap,princimap,officemap;
    private FusedLocationProviderClient mFusedLocationClient;
    private Boolean mLocationPermissionsGranted = false;
    double lat, lon;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_princi);

        getPermissions();
//        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
//        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
//                .findFragmentById(R.id.map);
//        mapFragment.getMapAsync(this);
    }

    public void getPermissions() {
        String[] permissions = {Manifest.permission.ACCESS_FINE_LOCATION, Manifest.permission.ACCESS_COARSE_LOCATION};
        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(this, permissions, 1234);
        } else {
            mLocationPermissionsGranted = true;
            initMap();
        }
    }

    public void initMap() {
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);

//        Toast.makeText(getBaseContext(),"MarkerTask called", Toast.LENGTH_LONG).show();

    }

    public void onNormalMap(View view) {
        mMap.setMapType(GoogleMap.MAP_TYPE_NORMAL);
    }

    public void onSatelliteMap(View view) {
        mMap.setMapType(GoogleMap.MAP_TYPE_SATELLITE);
    }

    public void onTerrainMap(View view) {
        mMap.setMapType(GoogleMap.MAP_TYPE_TERRAIN);
    }


    public void onHybridMap(View view) {
        mMap.setMapType(GoogleMap.MAP_TYPE_HYBRID);
    }


    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;
        princimap=googleMap;
        officemap=googleMap;

        if (mLocationPermissionsGranted) {
            if (ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION)
                    != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(this,
                    Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
                return;
            }
            mFusedLocationClient = LocationServices.getFusedLocationProviderClient(this);
            mFusedLocationClient.getLastLocation().addOnSuccessListener(this, new OnSuccessListener<Location>() {
                @Override
                public void onSuccess(Location location) {
                    // Got last known location. In some rare situations this can be null.
                    if (location != null) {
                        // Logic to handle location object
                        lat = location.getLatitude();
                        lon = location.getLongitude();

                        LatLng curr = new LatLng(lat, lon);
                        // Set a preference for minimum and maximum zoom.
                        mMap.setMinZoomPreference(10.0f);
                        mMap.setMaxZoomPreference(20.0f);



                        // Set the camera to the greatest possible zoom level that includes the bounds


                        mMap.addMarker(new MarkerOptions().position(curr).title("you are here"));
                        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom((curr),20));
                        //Toast.makeText(Map.this, location, Toast.LENGTH_SHORT).show();

                    }
                }
            });

            mMap.setMyLocationEnabled(true);
            //mMap.getUiSettings().setMyLocationButtonEnabled(false);

        }

        LatLng office = new LatLng(13.021080, 74.793089);
        officemap.addMarker(new MarkerOptions().position(office)
                .title("Office")
                .icon(BitmapDescriptorFactory.fromResource(R.drawable.office_icon1)));
        officemap.moveCamera(CameraUpdateFactory.newLatLng(office));
        officemap.moveCamera(CameraUpdateFactory.newLatLngZoom((office),18));



        LatLng princi = new LatLng(13.021147, 74.792830);
        princimap.addMarker(new MarkerOptions().position(princi)
                .title("Principal's Chamber")
                .icon(BitmapDescriptorFactory.fromResource(R.drawable.princi_icon)));
        princimap.moveCamera(CameraUpdateFactory.newLatLng(princi));
        princimap.moveCamera(CameraUpdateFactory.newLatLngZoom((princi),18));


        LatLng room001 = new LatLng(13.021369, 74.793320);
        googleMap.addMarker(new MarkerOptions().position(room001)
                .title("ROOM 001")
                .icon(BitmapDescriptorFactory.fromResource(R.drawable.room_icon)));
        googleMap.moveCamera(CameraUpdateFactory.newLatLng(room001));
        googleMap.moveCamera(CameraUpdateFactory.newLatLngZoom((room001),18));

        LatLng room002 = new LatLng(13.021125, 74.793223);
        googleMap.addMarker(new MarkerOptions().position(room002)
                .title("ROOM 002")
                .icon(BitmapDescriptorFactory.fromResource(R.drawable.room_icon)));
        googleMap.moveCamera(CameraUpdateFactory.newLatLng(room002));
        googleMap.moveCamera(CameraUpdateFactory.newLatLngZoom((room002),18));


        LatLng room003 = new LatLng(13.021261, 74.793536);
        googleMap.addMarker(new MarkerOptions().position(room003)
                .title("ROOM 003")
                .icon(BitmapDescriptorFactory.fromResource(R.drawable.room_icon)));
        googleMap.moveCamera(CameraUpdateFactory.newLatLng(room003));
        googleMap.moveCamera(CameraUpdateFactory.newLatLngZoom((room003),18));
        //Path to OFFICE
        Polyline p_to_o = mMap.addPolyline(new PolylineOptions()
                .add(   new LatLng(13.021147, 74.792830),
                        new LatLng(13.021154, 74.792903),
                        new LatLng(13.021123, 74.792910),
                        new LatLng(13.021125, 74.792932),
                        new LatLng(13.021130, 74.793026),
                        new LatLng(13.021134, 74.793044),
                        new LatLng(13.021080, 74.793089)
                )
                .width(15)
                .color(Color.BLUE));
        List<PatternItem> pattern = Arrays.<PatternItem>asList(
                new Dot(), new Gap(20), new Dash(30), new Gap(20));
        p_to_o.setPattern(pattern);

        //Path to room001
        Polyline p_to_001 = mMap.addPolyline(new PolylineOptions()
                .add(   new LatLng(13.021147, 74.792830),
                        new LatLng(13.021161, 74.792905),
                        new LatLng(13.021253, 74.792895),
                        new LatLng(13.021280, 74.793123),
                        new LatLng(13.021286, 74.793214),
                        new LatLng(13.021306, 74.793287),
                        new LatLng(13.021369, 74.793320)

                )
                .width(15)
                .color(Color.BLUE));
        p_to_001.setPattern(pattern);


        //Path to room002
        Polyline p_to_002 = mMap.addPolyline(new PolylineOptions()
                .add(   new LatLng(13.021147, 74.792830),
                        new LatLng(13.021161, 74.792905),
                        new LatLng(13.021253, 74.792895),
                        new LatLng(13.021280, 74.793123),
                        new LatLng(13.021286, 74.793214),
//                        new LatLng(13.021306, 74.793287),
//                        new LatLng(13.021369, 74.793320),
                        new LatLng(13.021125, 74.793223)

                )
                .width(15)
                .color(Color.BLUE));
        p_to_002.setPattern(pattern);

        //Path to room003
        Polyline p_to_003 = mMap.addPolyline(new PolylineOptions()
                .add(   new LatLng(13.021147, 74.792830),
                        new LatLng(13.021161, 74.792905),
                        new LatLng(13.021253, 74.792895),
                        new LatLng(13.021280, 74.793123),
                        new LatLng(13.021286, 74.793214),
                        new LatLng(13.021306, 74.793287),
                        new LatLng(13.021292, 74.793419),
                        new LatLng(13.021291, 74.793507),
                        new LatLng(13.021261, 74.793536)

                )
                .width(15)
                .color(Color.BLUE));
        p_to_003.setPattern(pattern);



        //PATHS FROM OFFICE TO OTHER

        //Path to princi
        Polyline o_to_p = mMap.addPolyline(new PolylineOptions()
                .add(   new LatLng(13.021147, 74.792830),
                        new LatLng(13.021154, 74.792903),
                        new LatLng(13.021123, 74.792910),
                        new LatLng(13.021125, 74.792932),
                        new LatLng(13.021130, 74.793026),
                        new LatLng(13.021134, 74.793044),
                        new LatLng(13.021080, 74.793089)
                )
                .width(15)
                .color(Color.BLUE));
        List<PatternItem> pattern1 = Arrays.<PatternItem>asList(
                new Dot(), new Gap(20), new Dash(30), new Gap(20));
        o_to_p.setPattern(pattern1);



        //Path to 001
        Polyline office_to_001 = mMap.addPolyline(new PolylineOptions()
                .add(   new LatLng(13.021080, 74.793089),
                        new LatLng(13.021134, 74.793044),
                        new LatLng(13.021269, 74.793029),
                        new LatLng(13.021286, 74.793214),
                        new LatLng(13.021306, 74.793287),
                        new LatLng(13.021369, 74.793320))
                .width(15)
                .color(Color.RED));
        office_to_001.setPattern(pattern1);


        //Path to 002
        Polyline office_to_002 = mMap.addPolyline(new PolylineOptions()
                .add(   new LatLng(13.021080, 74.793089),
                        new LatLng(13.021134, 74.793044),
                        new LatLng(13.021269, 74.793029),
                        new LatLng(13.021286, 74.793214),
                        new LatLng(13.021125, 74.793223)
                      )
                .width(15)
                .color(Color.RED));
        office_to_002.setPattern(pattern1);

        //Path to 003
        Polyline office_to_003 = mMap.addPolyline(new PolylineOptions()
                .add(   new LatLng(13.021080, 74.793089),
                        new LatLng(13.021134, 74.793044),
                        new LatLng(13.021269, 74.793029),
                        new LatLng(13.021286, 74.793214),
                        new LatLng(13.021306, 74.793287),
                        new LatLng(13.021292, 74.793419),
                        new LatLng(13.021291, 74.793507),
                        new LatLng(13.021261, 74.793536)
                )
                .width(15)
                .color(Color.RED));
        office_to_003.setPattern(pattern1);






    }
}
