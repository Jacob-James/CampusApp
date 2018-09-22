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


public class SecondFragment extends Fragment implements OnMapReadyCallback {
    private MapView mapView;
    private GoogleMap mMap;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.fragment_second,container,false);
        mapView=view.findViewById(R.id.mapsecond);
        mapView.onCreate(savedInstanceState);
        mapView.onResume();
        mapView.getMapAsync(this);
        return view;
    }


    @Override
    public void onMapReady(GoogleMap googleMap) {
       mMap=googleMap;

        LatLng room201 = new LatLng(13.021415, 74.793315);
        mMap.addMarker(new MarkerOptions().position(room201)
                .title("ROOM 201"));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(room201));
        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom((room201),18));

        LatLng room202 = new LatLng(13.021144,74.793229);
        mMap.addMarker(new MarkerOptions().position(room202)
                .title("ROOM 202"));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(room202));
        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom((room202),18));

        LatLng room203 = new LatLng(13.021200, 74.793443);
        mMap.addMarker(new MarkerOptions().position(room203)
                .title("ROOM 203"));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(room203));
        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom((room203),18));

        LatLng room204 = new LatLng(13.021130,74.793781);
        mMap.addMarker(new MarkerOptions().position(room204)
                .title("ROOM 204"));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(room204));
        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom((room204),18));

        LatLng room205 = new LatLng(13.021146, 74.793913);
        mMap.addMarker(new MarkerOptions().position(room205)
                .title("ROOM 205"));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(room205));
        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom((room205),18));


        LatLng room206 = new LatLng(13.021192, 74.792825);
        mMap.addMarker(new MarkerOptions().position(room206)
                .title("ROOM 206"));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(room206));
        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom((room206),18));

        LatLng room207 = new LatLng(13.021069, 74.792832);
        mMap.addMarker(new MarkerOptions().position(room207)
                .title("ROOM 207"));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(room207));
        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom((room207),18));

        LatLng cslab = new LatLng(13.021366, 74.793134);
        mMap.addMarker(new MarkerOptions().position(cslab)
                .title("CS LAB"));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(cslab));
        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom((cslab),18));


    }
}
