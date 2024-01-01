package com.example.smartjawi.Eja;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.widget.TextView;

import com.example.smartjawi.R;


public class wonEja extends Activity {

    TextView tvSkor_Eja;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_won_eja);
        tvSkor_Eja = (TextView) findViewById(R.id.tvSkor_Eja);
        Bundle b = getIntent().getExtras();
        int y = b.getInt("score");
        tvSkor_Eja.setText("JUMLAH MARKAH: " + y);

        MediaPlayer player = MediaPlayer.create(this, R.raw.win);
        player.setVolume(100, 100);
        player.start();
    }
}