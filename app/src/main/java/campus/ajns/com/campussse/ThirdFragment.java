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


public class ThirdFragment extends Fragment implements OnMapReadyCallback {
    private MapView mapView;
    private GoogleMap mMap;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.fragment_third,container,false);
        mapView=view.findViewById(R.id.mapthird);
        mapView.onCreate(savedInstanceState);
        mapView.onResume();
        mapView.getMapAsync(this);

        return view;
    }

    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap=googleMap;

        LatLng room202 = new LatLng(13.021144,74.793229);
        mMap.addMarker(new MarkerOptions().position(room202)
                .title("ROOM 302"));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(room202));
        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom((room202),18));



        LatLng room206 = new LatLng(13.021192, 74.792825);
        mMap.addMarker(new MarkerOptions().position(room206)
                .title("ROOM 306"));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(room206));
        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom((room206),18));

        LatLng room207 = new LatLng(13.021069, 74.792832);
        mMap.addMarker(new MarkerOptions().position(room207)
                .title("ROOM 307"));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(room207));
        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom((room207),18));

        LatLng tech = new LatLng(13.021149, 74.793303);
        mMap.addMarker(new MarkerOptions().position(room207)
                .title("TECHTRONICS LAB"));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(room207));
        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom((room207),18));

        LatLng room204 = new LatLng(13.021130,74.793781);
        mMap.addMarker(new MarkerOptions().position(room204)
                .title("ROOM 304"));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(room204));
        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom((room204),18));

        LatLng room205 = new LatLng(13.021146, 74.793913);
        mMap.addMarker(new MarkerOptions().position(room205)
                .title("ROOM 305"));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(room205));
        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom((room205),18));
    }
}
