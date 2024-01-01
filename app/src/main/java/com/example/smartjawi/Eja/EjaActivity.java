package com.example.smartjawi.Eja;

import android.animation.ValueAnimator;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.PowerManager;
import android.preference.PreferenceManager;
import android.view.View;
import android.view.animation.LinearInterpolator;
import android.widget.Button;
import android.widget.RelativeLayout;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import com.example.smartjawi.Eja.utils.CheckBgEja;
import com.example.smartjawi.Fragments.GameFragment;
import com.example.smartjawi.R;


public class EjaActivity extends AppCompatActivity {

    private Button gameButton;
    public static String PACKAGE_NAME;
    SharedPreferences sp;
    SharedPreferences.Editor ed;
    RelativeLayout bgnim, bgnim2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        PACKAGE_NAME = getApplicationContext().getPackageName();
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_eja);

        sp = PreferenceManager.getDefaultSharedPreferences(getApplicationContext());
        ed = sp.edit();
        boolean initmusic = sp.getBoolean("initmusic", false);
        if (!initmusic) {
            ed.putBoolean("initmusic", true);
            ed.putBoolean("play", true);
            ed.commit();
        }
        boolean backgroundMusic = sp.getBoolean("play",false);
        if (backgroundMusic ) {
            Intent svc = new Intent(this, BgSoundService.class);
            startService(svc);
        } else {
            stopService(new Intent(this, BgSoundService.class));
        }

        gameButton = findViewById(R.id.btn_play);
        gameButton.setOnClickListener(view -> {
            Intent intentnew = new Intent(this, QuestionEjaActivity.class);
            startActivity(intentnew);
        });
        gameButton = findViewById(R.id.btn_quit);
        gameButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Create a new instance of your fragment
                GameFragment fragment = new GameFragment();
                // Get the FragmentManager
                FragmentManager fragmentManager = getSupportFragmentManager();
                // Begin a transaction to replace the container with the fragment
                FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
                fragmentTransaction.replace(R.id.containerGame, fragment);
                fragmentTransaction.commit();

            }
        });


        bgnim = (RelativeLayout) findViewById(R.id.bganimation);
        bgnim2 = (RelativeLayout) findViewById(R.id.bganimation2);

        final ValueAnimator animator = ValueAnimator.ofFloat(0.0f, 0.5f);
        animator.setRepeatCount(ValueAnimator.INFINITE);
        animator.setInterpolator(new LinearInterpolator());
        animator.setDuration(900L);
        animator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator animation) {
                final float progress = (float) animation.getAnimatedValue();
                final float width = bgnim.getWidth();
                final float translationX = width * progress;
                bgnim.setTranslationX(translationX);
                bgnim2.setTranslationX(translationX - width);
            }
        });
        animator.start();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        stopService(new Intent(getApplicationContext(), BgSoundService.class));
    }
    @Override
    public void onStop() {
        super.onStop();
        if(CheckBgEja.appInBackground(this) ){
            stopService(new Intent(getApplicationContext(), BgSoundService.class));
        }
        else{
            PowerManager kgMgr = (PowerManager) getSystemService(Context.POWER_SERVICE);
            boolean showing = kgMgr.isScreenOn();
            if(!showing){
                stopService(new Intent(getApplicationContext(), BgSoundService.class));
            }
        }
    }
    @Override
    public void onPause() {
        super.onPause();
        if(CheckBgEja.appInBackground(this) ){
            stopService(new Intent(getApplicationContext(), BgSoundService.class));
        }
        else{
            PowerManager kgMgr = (PowerManager) getSystemService(Context.POWER_SERVICE);
            boolean showing = kgMgr.isScreenOn();
            if(!showing){
                stopService(new Intent(getApplicationContext(), BgSoundService.class));
            }
        }
    }
    @Override
    public void onResume() {
        super.onResume();
    }
    @Override
    public void onStart() {
        super.onStart();
        // preferences
        sp = PreferenceManager.getDefaultSharedPreferences(getApplicationContext());
        ed = sp.edit();
        boolean backgroundMusic = sp.getBoolean("play",false);

        if (backgroundMusic ) {

            Intent svc=new Intent(this, BgSoundService.class);
            startService(svc);
        }
    }
}