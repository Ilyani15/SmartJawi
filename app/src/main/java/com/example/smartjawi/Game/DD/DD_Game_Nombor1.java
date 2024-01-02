package com.example.smartjawi.Game.DD;

import android.content.ClipData;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.Handler;
import android.view.DragEvent;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;

import androidx.appcompat.app.AppCompatActivity;

import com.example.smartjawi.Fragments.GameFragment;
import com.example.smartjawi.R;

public class DD_Game_Nombor1 extends AppCompatActivity {

    LinearLayout target1;
    Button test1;
    ImageView img1,img2,img3,img4;
    MediaPlayer correct;
    int i = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON);
        setContentView(R.layout.activity_dd_nombor1);
        /*boolean useAlternateLayout = true; // Set your condition here

        // Load the appropriate layout
        if (useAlternateLayout) {
            setContentView(R.layout.activity_dd_haiwan);
        } else {
            setContentView(R.layout.activity_dd_haiwan2);
        }*/

        target1 = (LinearLayout) findViewById(R.id.target1);

        test1 = (Button) findViewById(R.id.test1);

        img1 = (ImageView) findViewById(R.id.img1);
        img2 = (ImageView) findViewById(R.id.img2);
        img3 = (ImageView) findViewById(R.id.img3);
        img4 = (ImageView) findViewById(R.id.img4);

        target1.setOnDragListener(dragListener);

        img1.setOnLongClickListener(longclickListener);
        img2.setOnLongClickListener(longclickListener);
        img3.setOnLongClickListener(longclickListener);
        img4.setOnLongClickListener(longclickListener);


        correct = MediaPlayer.create(DD_Game_Nombor1.this, R.raw.correct);

        ImageView close = findViewById(R.id.close);

        close.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(DD_Game_Nombor1.this, GameFragment.class);
                startActivity(intent);
            }
        });

    }

    View.OnLongClickListener longclickListener = new View.OnLongClickListener() {
        @Override
        public boolean onLongClick(View v) {
            ClipData data = ClipData.newPlainText("", "");
            View.DragShadowBuilder myShadowBuilder = new View.DragShadowBuilder(v);
            v.startDrag( data, myShadowBuilder, v,0);
            return true;
        }
    };

    View.OnDragListener dragListener = new View.OnDragListener() {
        @Override
        public boolean onDrag(View v, DragEvent event) {

            int dragEvent = event.getAction();
            final View view = (View) event.getLocalState();

            switch (dragEvent) {
                case DragEvent.ACTION_DRAG_ENTERED:
                    break;

                case DragEvent.ACTION_DRAG_EXITED:
                    break;

                case DragEvent.ACTION_DROP:
                    if (view.getId() == R.id.img1 && v.getId() == R.id.target1) {
                        i++;
                        handleDragDrop(view, R.id.target1);
                    } else if (view.getId() == R.id.img2 && v.getId() == R.id.target1) {
                        handleDragDrop(view, R.id.target1);
                    } else if (view.getId() == R.id.img3 && v.getId() == R.id.target1) {
                        handleDragDrop(view, R.id.target1);
                    } else if (view.getId() == R.id.img4 && v.getId() == R.id.target1) {
                        handleDragDrop(view, R.id.target1);
                    } else {
                        handleDragDropIncorrect();
                    }
                    break;
            }
            return true;
        }
    };

    private void handleDragDrop(View view, int targetId) {
        LinearLayout oldParent = (LinearLayout) view.getParent();
        oldParent.removeView(view);
        LinearLayout newParent = findViewById(targetId);
        test1.setVisibility(View.GONE);
        newParent.addView(view);


        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                if (i == 1) {
                    correct.start();
                }
                Intent intent = new Intent(DD_Game_Nombor1.this, DD_Game_Nombor2.class);
                startActivity(intent);
                finish();
            }
        }, 1000);

    }

    private void handleDragDropIncorrect() {
        MediaPlayer media = MediaPlayer.create(DD_Game_Nombor1.this, R.raw.wrong);
        media.start();
    }
}