package campus.ajns.com.campussse;

import android.app.FragmentManager;
import android.app.LauncherActivity;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.animation.Animation;
import android.widget.ImageView;
import android.widget.Toast;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener ,OnMapReadyCallback {


    SupportMapFragment mapFrag;
    GoogleMap map;
    ImageView lg;
    Animation a;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        mapFrag = (SupportMapFragment) getSupportFragmentManager().findFragmentById(R.id.map_fragment);
        mapFrag.getMapAsync(this);




        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        Toast.makeText(getApplicationContext(),
                "Enable GPS and Data for Best UX", Toast.LENGTH_LONG).show();



}

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.ground_floor) {
            Intent intent= new Intent(this,GroundFloorActivity.class);
            startActivity(intent);
        }
        if (id == R.id.first_floor) {
            Intent intent= new Intent(this,FirstFloorActivity.class);
            startActivity(intent);
        }


        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_updates) {
            Intent intent= new Intent(this,UpdateActivity.class);
            startActivity(intent);
        } else if (id == R.id.nav_map) {

            Intent intent= new Intent(this,MapsActivity.class);
            startActivity(intent);
        }  else if (id == R.id.nav_collegeweb) {

            Intent intent = new Intent(this, WebPageActivity.class);
            startActivity(intent);
        }
            else if (id == R.id.nav_techweb) {

                Intent intent= new Intent(this,TechYuvaActivity.class);
                startActivity(intent);

        } else if (id == R.id.nav_locationlist) {

            Intent intent= new Intent(this,LocationListActivity.class);
            startActivity(intent);
            Toast.makeText(getApplicationContext(),
                    "Click the butoons for floor wise locations", Toast.LENGTH_LONG).show();

        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }






    @Override
    public void onMapReady(GoogleMap googleMap) {
//        Toast.makeText(getApplicationContext(),
//                "map is called", Toast.LENGTH_LONG).show();
      googleMap.setMapType(GoogleMap.MAP_TYPE_HYBRID);
        LatLng office = new LatLng(13.021080, 74.793089);
        googleMap.addMarker(new MarkerOptions().position(office)
                .title("Office"));
        googleMap.moveCamera(CameraUpdateFactory.newLatLng(office));
        googleMap.moveCamera(CameraUpdateFactory.newLatLngZoom((office),18));



        LatLng princi = new LatLng(13.021147, 74.792830);
        googleMap.addMarker(new MarkerOptions().position(princi)
                .title("Principal's Chamber"));
        googleMap.moveCamera(CameraUpdateFactory.newLatLng(princi));
        googleMap.moveCamera(CameraUpdateFactory.newLatLngZoom((princi),18));



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

    }
}
