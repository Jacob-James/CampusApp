package campus.ajns.com.campussse;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.webkit.WebView;

public class TechYuvaActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tech_yuva);

        WebView wv= new WebView(this);
        setContentView(wv);
        wv.loadUrl("http://www.techyuva.in/");
    }
}
