package campus.ajns.com.campussse;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.os.Handler;
import android.view.MotionEvent;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;

public class Splash_Activity extends AppCompatActivity {

   ImageView ig;
   Animation a;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_);
         ig=(ImageView)findViewById(R.id.logo);
         a= AnimationUtils.loadAnimation(getApplicationContext(),R.anim.splash_screen);
         ig.startAnimation(a);
         ig.postDelayed(new Runnable(){
             @Override
             public void run() {
                  Intent i= new Intent(Splash_Activity.this,MainActivity.class);
                  i.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                  startActivity(i);
                  finish();


             }
         },1000);



    }



}
