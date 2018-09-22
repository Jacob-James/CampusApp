package campus.ajns.com.campussse;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.davemorrissey.labs.subscaleview.ImageSource;
import com.davemorrissey.labs.subscaleview.SubsamplingScaleImageView;

public class FirstFloorActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_first_floor);

        SubsamplingScaleImageView imageView = (SubsamplingScaleImageView)findViewById(R.id.first_floor);
        imageView.setImage(ImageSource.resource(R.drawable.first_floor1));

    }
}
