package campus.ajns.com.campussse;

import android.Manifest;
import android.app.backup.BackupAgent;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Color;
import android.location.Location;
import android.os.AsyncTask;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.FragmentActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.google.android.gms.location.FusedLocationProviderClient;
import com.google.android.gms.location.LocationServices;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapFragment;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.CameraPosition;
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

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

public class MapsActivity extends FragmentActivity implements OnMapReadyCallback {


    private GoogleMap mMap,officemap, princimap;
    private LatLngBounds sse_campus;
    private FusedLocationProviderClient mFusedLocationClient;
    private Boolean mLocationPermissionsGranted = false;
    double lat, lon;

    private  Marker office;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps);
        getPermissions();
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
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
       //new MarkerTask().execute();
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
      officemap=googleMap;
      princimap=googleMap;

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


                         sse_campus = new LatLngBounds(
                                new LatLng(13.020619, 74.790909), new LatLng(13.023238, 74.795260));
                         // Set the camera to the greatest possible zoom level that includes the bounds

                        mMap.moveCamera(CameraUpdateFactory.newLatLngBounds(sse_campus, 0));
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
//        officemap.setOnInfoWindowClickListener(new GoogleMap.OnInfoWindowClickListener() {
//            @Override
//            public void onInfoWindowClick(Marker marker) {
//                Intent OI= new Intent(MapsActivity.this,OfficeActivity.class);
//                  startActivity(OI);
//            }
//        });


        LatLng princi = new LatLng(13.021147, 74.792830);
        princimap.addMarker(new MarkerOptions().position(princi)
                .title("Principal's Chamber")
                .icon(BitmapDescriptorFactory.fromResource(R.drawable.princi_icon)));
        princimap.moveCamera(CameraUpdateFactory.newLatLng(princi));
        princimap.moveCamera(CameraUpdateFactory.newLatLngZoom((princi),18));
        princimap.setOnInfoWindowClickListener(new GoogleMap.OnInfoWindowClickListener() {
            @Override
            public void onInfoWindowClick(Marker marker) {
                Intent intent=new Intent(MapsActivity.this,PrinciActivity.class);
                startActivity(intent);
            }
        });
        LatLng room001 = new LatLng(13.021369, 74.793320);
        googleMap.addMarker(new MarkerOptions().position(room001)
                .title("ROOM 001")
                .icon(BitmapDescriptorFactory.fromResource(R.drawable.room_icon)));
        googleMap.moveCamera(CameraUpdateFactory.newLatLng(room001));
        googleMap.moveCamera(CameraUpdateFactory.newLatLngZoom((room001),18));

        LatLng room002 = new LatLng(13.021174, 74.793252);
        googleMap.addMarker(new MarkerOptions().position(room002)
                .title("ROOM 002")
                .icon(BitmapDescriptorFactory.fromResource(R.drawable.room_icon)));
        googleMap.moveCamera(CameraUpdateFactory.newLatLng(room002));
        googleMap.moveCamera(CameraUpdateFactory.newLatLngZoom((room002),18));


        LatLng room003 = new LatLng(13.021203,74.793544);
        googleMap.addMarker(new MarkerOptions().position(room003)
                .title("ROOM 003")
                .icon(BitmapDescriptorFactory.fromResource(R.drawable.room_icon)));
        googleMap.moveCamera(CameraUpdateFactory.newLatLng(room003));
        googleMap.moveCamera(CameraUpdateFactory.newLatLngZoom((room003),18));




    }



}
// class MarkerTask extends AsyncTask<Void, Void, String> {
//     private GoogleMap mMap;
//    private static final String LOG_TAG = "Campus SSE";
//
//    private static final String SERVICE_URL = "http://192.168.42.242/android/Markers.php";
//
//    // Invoked by execute() method of this object
//    @Override
//    protected String doInBackground(Void... args) {
//
//        HttpURLConnection conn = null;
//        final StringBuilder json = new StringBuilder();
//        try {
//            // Connect to the web service
//            URL url = new URL(SERVICE_URL);
//            conn = (HttpURLConnection) url.openConnection();
//            InputStreamReader in = new InputStreamReader(conn.getInputStream());
//
//            // Read the JSON data into the StringBuilder
//            int read;
//            char[] buff = new char[1024];
//            while ((read = in.read(buff)) != -1) {
//                json.append(buff, 0, read);
//            }
//
//
//
//        } catch (IOException e) {
//            Log.e(LOG_TAG, "Error connecting to service", e);
//            //throw new IOException("Error connecting to service", e); //uncaught
//        } finally {
//            if (conn != null) {
//                conn.disconnect();
//            }
//        }
//
//        return json.toString();
//    }
//
//    // Executed after the complete execution of doInBackground() method
//    @Override
//    protected void onPostExecute(String json) {
//
//        try {
//            // De-serialize the JSON string into an array of city objects
//            JSONArray jsonArray = new JSONArray(json);
//            for (int i = 0; i < jsonArray.length(); i++) {
//                JSONObject jsonObj = jsonArray.getJSONObject(i);
//
//                LatLng latLng = new LatLng(jsonObj.getJSONArray("lat").getDouble(1),
//                        jsonObj.getJSONArray("lng").getDouble(2));
//
//                //move CameraPosition on first result
//                if (i == 0) {
//                    CameraPosition cameraPosition = new CameraPosition.Builder()
//                            .target(latLng).zoom(13).build();
//
//                    mMap.animateCamera(CameraUpdateFactory
//                            .newCameraPosition(cameraPosition));
//                }
//
//                // Create a marker for each city in the JSON data.
//                mMap.addMarker(new MarkerOptions()
//                        .icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_BLUE))
//                        .title(jsonObj.getString("locname"))
////                        .snippet(Integer.toString(jsonObj.getInt("population")))
//                        .position(latLng));
//            }
//        } catch (JSONException e) {
//            Log.e(LOG_TAG, "Error processing JSON", e);
//        }
//
//    }
//}