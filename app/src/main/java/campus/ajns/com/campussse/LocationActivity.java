package campus.ajns.com.campussse;

import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class LocationActivity extends AppCompatActivity {
    private static final String URL_EVENTS = "http://192.168.43.177/project_su/Locations.php";

  //  a list to store all the locations
    List<Location> locationList;
//    //the recyclerview
    RecyclerView recyclerView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_location);
        //getting the recyclerview from xml
        recyclerView = findViewById(R.id.location_recycler);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
//
//        //initializing the productlist
//       locationList = new ArrayList<>();
//
//
//        //this method will fetch and parse json
//        //to display it in recyclerview
//        loadLocations();
    }
//
//
//    private void loadLocations() {
//
//        /*
//         * Creating a String Request
//         * The request type is GET defined by first parameter
//         * The URL is defined in the second parameter
//         * Then we have a Response Listener and a Error Listener
//         * In response listener we will get the JSON response as a String
//         * */
//        StringRequest stringRequest = new StringRequest(Request.Method.GET, URL_EVENTS,
//                new Response.Listener<String>() {
//                    @Override
//                    public void onResponse(String response) {
//                        try {
//                            //converting the string to json array object
//                            JSONArray array = new JSONArray(response);
//
//                            //traversing through all the object
//                            for (int i = 0; i < array.length(); i++) {
//
//                                //getting events object from json array
//                                JSONObject event = array.getJSONObject(i);
//
//                                //adding the events to events list
//                                locationList.add(new Location(
//                                        event.getString("locname")
//
//
//
//                                ));
//                            }
//
//                            //creating adapter object and setting it to recyclerview
//                            LocationAdapter adapter = new LocationAdapter(LocationActivity.this, locationList);
//                            recyclerView.setAdapter(adapter);
//                        } catch (JSONException e) {
//                            e.printStackTrace();
//                        }
//                    }
//                },
//                new Response.ErrorListener() {
//                    @Override
//                    public void onErrorResponse(VolleyError error) {
//
//                    }
//                });
//
//        //adding our stringrequest to queue
//        Volley.newRequestQueue(this).add(stringRequest);
//
//
//    }

}
