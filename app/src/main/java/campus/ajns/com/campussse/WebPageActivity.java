package campus.ajns.com.campussse;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.webkit.WebView;

public class WebPageActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_web_page);

        WebView wv= new WebView(this);
        setContentView(wv);
        wv.loadUrl("http://srinivasgroup.com/srinivas-school-of-engineering/");
    }
}
