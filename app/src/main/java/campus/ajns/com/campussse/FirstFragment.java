package campus.ajns.com.campussse;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapView;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;


public class FirstFragment extends Fragment implements OnMapReadyCallback {
    private MapView mapView;
    private GoogleMap mMap;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.fragment_first,container,false);
        mapView=view.findViewById(R.id.mapfirst);
        mapView.onCreate(savedInstanceState);
        mapView.onResume();
        mapView.getMapAsync(this);
        return view;
    }

    @Override
    public void onMapReady(GoogleMap googleMap) {

        mMap = googleMap;

        LatLng room101 = new LatLng(13.021415, 74.793315);
        mMap.addMarker(new MarkerOptions().position(room101)
                .title("ROOM 101"));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(room101));
        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom((room101),18));

        LatLng room102 = new LatLng(13.021144,74.793229);
        mMap.addMarker(new MarkerOptions().position(room102)
                .title("ROOM 102"));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(room102));
        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom((room102),18));

        LatLng room103 = new LatLng(13.021200, 74.793443);
        mMap.addMarker(new MarkerOptions().position(room103)
                .title("ROOM 103"));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(room103));
        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom((room103),18));

        LatLng room104 = new LatLng(13.021130,74.793781);
        mMap.addMarker(new MarkerOptions().position(room104)
                .title("ROOM 104"));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(room104));
        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom((room104),18));

        LatLng room105 = new LatLng(13.021146, 74.793913);
        mMap.addMarker(new MarkerOptions().position(room105)
                .title("ROOM 105"));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(room105));
        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom((room105),18));

        LatLng phylab = new LatLng(13.021183,74.794011);
        mMap.addMarker(new MarkerOptions().position(phylab)
                .title("PHYSICS LAB"));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(phylab));
        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom((phylab),18));

        LatLng audi = new LatLng(13.021324,74.793891);
        mMap.addMarker(new MarkerOptions().position(audi)
                .title("AUDITORIUM"));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(audi));
        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom((audi),18));

        LatLng cslab = new LatLng(13.021366, 74.793134);
        mMap.addMarker(new MarkerOptions().position(cslab)
                .title("CS LAB"));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(cslab));
        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom((cslab),18));

        LatLng placement_cell = new LatLng(13.021324,74.793661);
        mMap.addMarker(new MarkerOptions().position(placement_cell)
                .title("PLACEMENT CELL"));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(placement_cell));
        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom((placement_cell),18));


    }
}
