package campus.ajns.com.campussse;

import android.graphics.Color;
import android.support.v4.app.FragmentActivity;
import android.os.Bundle;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.Dash;
import com.google.android.gms.maps.model.Dot;
import com.google.android.gms.maps.model.Gap;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.android.gms.maps.model.PatternItem;
import com.google.android.gms.maps.model.Polyline;
import com.google.android.gms.maps.model.PolylineOptions;

import java.util.Arrays;
import java.util.List;

public class OfficeActivity extends FragmentActivity implements OnMapReadyCallback {

    private GoogleMap mMap,princimap,officemap;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_office);
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
    }

    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;
        princimap=googleMap;
        officemap=googleMap;

        LatLng office = new LatLng(13.021080, 74.793089);
        officemap.addMarker(new MarkerOptions().position(office)
                .title("Office"));
        officemap.moveCamera(CameraUpdateFactory.newLatLng(office));
        officemap.moveCamera(CameraUpdateFactory.newLatLngZoom((office),18));



        LatLng princi = new LatLng(13.021147, 74.792830);
        princimap.addMarker(new MarkerOptions().position(princi)
                .title("Principal's Chamber"));
        princimap.moveCamera(CameraUpdateFactory.newLatLng(princi));
        princimap.moveCamera(CameraUpdateFactory.newLatLngZoom((princi),18));
        LatLng room001 = new LatLng(13.021369, 74.793320);


        googleMap.addMarker(new MarkerOptions().position(room001)
                .title("ROOM 001"));
        googleMap.moveCamera(CameraUpdateFactory.newLatLng(room001));
        googleMap.moveCamera(CameraUpdateFactory.newLatLngZoom((room001),18));

        LatLng room002 = new LatLng(13.021125, 74.793223);
        googleMap.addMarker(new MarkerOptions().position(room002)
                .title("ROOM 002"));
        googleMap.moveCamera(CameraUpdateFactory.newLatLng(room002));
        googleMap.moveCamera(CameraUpdateFactory.newLatLngZoom((room002),18));


        LatLng room003 = new LatLng(13.021261, 74.793536);
        googleMap.addMarker(new MarkerOptions().position(room003)
                .title("ROOM 003"));
        googleMap.moveCamera(CameraUpdateFactory.newLatLng(room003));
        googleMap.moveCamera(CameraUpdateFactory.newLatLngZoom((room003),18));


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
        List<PatternItem> pattern = Arrays.<PatternItem>asList(
                new Dot(), new Gap(20), new Dash(30), new Gap(20));
        o_to_p.setPattern(pattern);



        //Path to OFFICE
        Polyline office_to_001 = mMap.addPolyline(new PolylineOptions()
                .add(   new LatLng(13.021088, 74.793056),
                        new LatLng(13.021269, 74.793029),
                        new LatLng(13.021286, 74.793214),
                        new LatLng(13.021306, 74.793287),
                        new LatLng(13.021369, 74.793320))
                .width(15)
                .color(Color.BLUE));
        office_to_001.setPattern(pattern);






    }
}
