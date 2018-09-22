package campus.ajns.com.campussse;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;

import com.davemorrissey.labs.subscaleview.ImageSource;
import com.davemorrissey.labs.subscaleview.SubsamplingScaleImageView;
import com.github.chrisbanes.photoview.PhotoView;
import com.github.chrisbanes.photoview.PhotoViewAttacher;

public class GroundFloorActivity extends AppCompatActivity {




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ground_floor);
        SubsamplingScaleImageView imageView = (SubsamplingScaleImageView)findViewById(R.id.ground);
        imageView.setImage(ImageSource.resource(R.drawable.ground_floor));

        //mattacher.update();
    }
}
