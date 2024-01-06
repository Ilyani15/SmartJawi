package com.example.smartjawi.Game.Cw;

import static java.lang.Integer.parseInt;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Canvas;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.smartjawi.Fragments.GameFragment;
import com.example.smartjawi.R;

public class Cw_haiwan extends AppCompatActivity {


        //full screen 1 of 3
        private Canvas canvas;
        private View decorView;
        //

        SharedPreferences sp;
        String textinput;

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_cw_haiwan);

            final MediaPlayer note1 = MediaPlayer.create(Cw_haiwan.this, R.raw.note1);
            final MediaPlayer note2 = MediaPlayer.create(Cw_haiwan.this, R.raw.note2);
            final MediaPlayer note3 = MediaPlayer.create(Cw_haiwan.this, R.raw.note3);
            final MediaPlayer note4 = MediaPlayer.create(Cw_haiwan.this, R.raw.note4);
            final MediaPlayer note5 = MediaPlayer.create(Cw_haiwan.this, R.raw.note5);
            final MediaPlayer note6 = MediaPlayer.create(Cw_haiwan.this, R.raw.note6);
            final MediaPlayer note7 = MediaPlayer.create(Cw_haiwan.this, R.raw.note7);
            final MediaPlayer note8 = MediaPlayer.create(Cw_haiwan.this, R.raw.note8);
            final MediaPlayer note9 = MediaPlayer.create(Cw_haiwan.this, R.raw.note9);
            final MediaPlayer bingo1 = MediaPlayer.create(Cw_haiwan.this, R.raw.bingo1);


            final TextView choice1 = (TextView) findViewById(R.id.textView);
            final TextView choice2 = (TextView) findViewById(R.id.textView1);
            final TextView choice3 = (TextView) findViewById(R.id.textView2);
            final TextView choice4 = (TextView) findViewById(R.id.textView3);
            final TextView choice5 = (TextView) findViewById(R.id.textView4);
            final TextView choice6 = (TextView) findViewById(R.id.name);
            final TextView choice7 = (TextView) findViewById(R.id.textView7);
            final TextView choice8 = (TextView) findViewById(R.id.textView8);
            final TextView choice9 = (TextView) findViewById(R.id.textView9);
            final TextView choice10 = (TextView) findViewById(R.id.textView10);
            final TextView choice11 = (TextView) findViewById(R.id.textView11);

            final ImageView dustbin = (ImageView) findViewById(R.id.imageView23);

            //Letters at boxes
            final TextView textView12 = (TextView) findViewById(R.id.textView12);
            final TextView textView13 = (TextView) findViewById(R.id.textView13);
            final TextView textView14 = (TextView) findViewById(R.id.textView14);
            final TextView textView15 = (TextView) findViewById(R.id.textView15);
            final TextView textView16 = (TextView) findViewById(R.id.textView16);
            final TextView textView17 = (TextView) findViewById(R.id.textView17);
            final TextView textView19 = (TextView) findViewById(R.id.textView19);
            final TextView textView20 = (TextView) findViewById(R.id.textView20);
            final TextView textView21 = (TextView) findViewById(R.id.textView21);
            final TextView textView22 = (TextView) findViewById(R.id.textView22);
            final TextView textView24 = (TextView) findViewById(R.id.textView24);
            final TextView textView25 = (TextView) findViewById(R.id.textView25);

            final TextView textView18 = (TextView) findViewById(R.id.textView18);

            final TextView input = (TextView) findViewById(R.id.textView5);

            final String inputs;

            sp = getSharedPreferences("MyUserPrefs", Context.MODE_PRIVATE);
            SharedPreferences.Editor editor = sp.edit();
            editor.putString("textinput", "");
            editor.apply();

            //s:sounds effects reset
            editor.putString("soundinput", "1");
            editor.apply();
            //e:sounds effects reset

            //s:lock score for those answered [1]
            editor.putString("lockscore1", "");
            editor.apply();

            editor.putString("lockscore2", "");
            editor.apply();

            editor.putString("lockscore3", "");
            editor.apply();

            editor.putString("lockscore4", "");
            editor.apply();

            //e:lock score for those answered [1]


//getscore
            String highscore = sp.getString("highscore", "0");
            String tagnewhighscore = "Score:" + " " + highscore;
            textView18.setText(tagnewhighscore);



            //full screen 2 of 3
            // -> hide status bar
            decorView = getWindow().getDecorView();
            decorView.setOnSystemUiVisibilityChangeListener(new View.OnSystemUiVisibilityChangeListener() {
                @Override
                public void onSystemUiVisibilityChange(int visibility) {
                    if (visibility == 0)
                        decorView.setSystemUiVisibility(hideSystemBars());
                }
            });
            //

            choice1.setOnClickListener(new View.OnClickListener() {
                String textinputsecondary;

                @Override
                //button H
                public void onClick(View view) {
                    textinput = sp.getString("textinput", "");

                    //s:lock score for those answered [2]
                    String lockscore1 = sp.getString("lockscore1", "");
                    String lockscore2 = sp.getString("lockscore2", "");
                    String lockscore3 = sp.getString("lockscore3", "");
                    String lockscore4 = sp.getString("lockscore4", "");
                    //=

                    SharedPreferences.Editor editor = sp.edit();


                    //choice button on click
                    textinputsecondary = textinput + "ي";
                    editor.putString("textinput", textinputsecondary);
                    editor.apply();
                    input.setText(textinputsecondary);
                    if (textinputsecondary.equals("ايم") && !lockscore1.equals("1")) {
                        textView12.setText("ا");
                        textView13.setText("ي");
                        textView14.setText("م");
                        editor.putString("textinput", "");
                        editor.apply();
                        input.setText("");

                        String one = "1";
                        //s:lock score for those answered [3]
                        editor.putString("lockscore1", one);
                        editor.apply();

                        //====

                        // get score
                        String highscore = sp.getString("highscore", "0");
                        int Ihighscore = parseInt(highscore) + 100;
                        String newHighScore = new Integer(Ihighscore).toString();

                        editor.putString("highscore", newHighScore);
                        editor.apply();

                        String tagnewhighscore = "Score:" + " " + newHighScore;

                        textView18.setText(tagnewhighscore);


                        //
                    }
                    else if (textinputsecondary.equals("ايم")) {
                        editor.putString("textinput", "");
                        editor.apply();
                        input.setText("");
                        editor.putString("soundinput", "1");
                        editor.apply();
                    }

                    if (textinputsecondary.equals("لمبو") && !lockscore2.equals("1")) {
                        textView15.setText("ل");
                        textView14.setText("م");
                        textView16.setText("ب");
                        textView17.setText("و");
                        editor.putString("textinput", "");
                        editor.apply();
                        input.setText("");

                        //s:lock score for those answered [4]
                        editor.putString("lockscore2", "1");
                        editor.apply();
                        //====

                        // get score
                        String highscore = sp.getString("highscore", "0");
                        int Ihighscore = parseInt(highscore) + 100;
                        String newHighScore = new Integer(Ihighscore).toString();

                        editor.putString("highscore",newHighScore);
                        editor.apply();

                        String tagnewhighscore = "Score:" + " " + newHighScore;

                        textView18.setText(tagnewhighscore);


                        //


                    }
                    else if (textinputsecondary.equals("لمبو")) {
                        editor.putString("textinput", "");
                        editor.apply();
                        input.setText("");
                        editor.putString("soundinput", "1");
                        editor.apply();

                    }


                    if (textinputsecondary.equals("کودا") && !lockscore3.equals("1")) {
                        textView19.setText("ک");
                        textView17.setText("و");
                        textView20.setText("د");
                        textView21.setText("ا");
                        editor.putString("textinput", "");
                        editor.apply();
                        input.setText("");

                        //s:lock score for those answered [5]
                        editor.putString("lockscore3", "1");
                        editor.apply();
                        //====

                        // get score
                        String highscore = sp.getString("highscore", "0");
                        int Ihighscore = parseInt(highscore) + 100;
                        String newHighScore = new Integer(Ihighscore).toString();

                        editor.putString("highscore",newHighScore);
                        editor.apply();

                        String tagnewhighscore = "Score:" + " " + newHighScore;

                        textView18.setText(tagnewhighscore);


                        //

                    }
                    else if (textinputsecondary.equals("کودا")) {
                        editor.putString("textinput", "");
                        editor.apply();
                        input.setText("");
                        editor.putString("soundinput", "1");
                        editor.apply();

                    }

                    if (textinputsecondary.equals("ݢاجه") && !lockscore4.equals("1")) {
                        textView22.setText("ݢ");
                        textView21.setText("ا");
                        textView24.setText("ج");
                        textView25.setText("ه");
                        editor.putString("textinput", "");
                        editor.apply();
                        input.setText("");

                        //s:lock score for those answered [6]
                        editor.putString("lockscore4", "1");
                        editor.apply();
                        //====

                        // get score
                        String highscore = sp.getString("highscore", "0");
                        int Ihighscore = parseInt(highscore) + 100;
                        String newHighScore = new Integer(Ihighscore).toString();

                        editor.putString("highscore",newHighScore);
                        editor.apply();

                        String tagnewhighscore = "Score:" + " " + newHighScore;

                        textView18.setText(tagnewhighscore);


                        //


                    }
                    else if (textinputsecondary.equals("ݢاجه")) {
                        editor.putString("textinput", "");
                        editor.apply();
                        input.setText("");
                        editor.putString("soundinput", "1");
                        editor.apply();

                    }
//E:choice button on click

                    String soundinput;
                    int soundinputsecondary;

                    //S: Ascending Sounds on click
                    soundinput = sp.getString("soundinput", "1");
                    int soundinput2 = parseInt(soundinput);
                    soundinputsecondary = soundinput2 + 1;
                    String soundinputsecondary2 = new Integer(soundinputsecondary).toString();;

                    editor.putString("soundinput", soundinputsecondary2);
                    editor.apply();

                    if (soundinput2 == 1 && !textinputsecondary.equals("ايم") && !textinputsecondary.equals("لمبو") && !textinputsecondary.equals("کودا") && !textinputsecondary.equals("ݢاجه") ) {
                        //play music
                        note1.start();
                    }
                    else if (soundinput2 == 1) {
                        bingo1.start();
                        editor.putString("soundinput", "1");
                        editor.apply();
                    }

                    if (soundinput2 == 2 && !textinputsecondary.equals("ايم") && !textinputsecondary.equals("لمبو") && !textinputsecondary.equals("کودا") && !textinputsecondary.equals("ݢاجه") ) {
                        //play music
                        note2.start();
                    }
                    else if (soundinput2 == 2) {
                        bingo1.start();
                        editor.putString("soundinput", "1");
                        editor.apply();
                    }

                    if (soundinput2 == 3 && !textinputsecondary.equals("ايم") && !textinputsecondary.equals("لمبو") && !textinputsecondary.equals("کودا") && !textinputsecondary.equals("ݢاجه") ) {
                        //play music
                        note3.start();
                    }
                    else if (soundinput2 == 3) {
                        bingo1.start();
                        editor.putString("soundinput", "1");
                        editor.apply();
                    }

                    if (soundinput2 == 4 && !textinputsecondary.equals("ايم") && !textinputsecondary.equals("لمبو") && !textinputsecondary.equals("کودا") && !textinputsecondary.equals("ݢاجه") ) {
                        //play music
                        note4.start();
                    }
                    else if (soundinput2 == 4) {
                        bingo1.start();
                        editor.putString("soundinput", "1");
                        editor.apply();
                    }

                    if (soundinput2 == 5 && !textinputsecondary.equals("ايم") && !textinputsecondary.equals("لمبو") && !textinputsecondary.equals("کودا") && !textinputsecondary.equals("ݢاجه") ) {
                        //play music
                        note5.start();
                        editor.putString("textinput", "");
                        editor.apply();
                        input.setText("");
                        editor.putString("soundinput", "1");
                        editor.apply();
                    }
                    else if (soundinput2 == 5) {
                        bingo1.start();
                        editor.putString("soundinput", "1");
                        editor.apply();
                        editor.putString("textinput", "");
                        editor.apply();
                        input.setText("");

                    }
                }
            });
            choice2.setOnClickListener(new View.OnClickListener() {
                String textinputsecondary;

                @Override
                //button H
                public void onClick(View view) {
                    textinput = sp.getString("textinput", "");

                    //s:lock score for those answered [2]
                    String lockscore1 = sp.getString("lockscore1", "");
                    String lockscore2 = sp.getString("lockscore2", "");
                    String lockscore3 = sp.getString("lockscore3", "");
                    String lockscore4 = sp.getString("lockscore4", "");
                    //=

                    SharedPreferences.Editor editor = sp.edit();


                    //choice button on click
                    textinputsecondary = textinput + "ل";
                    editor.putString("textinput", textinputsecondary);
                    editor.apply();
                    input.setText(textinputsecondary);
                    if (textinputsecondary.equals("ايم") && !lockscore1.equals("1")) {
                        textView12.setText("ا");
                        textView13.setText("ي");
                        textView14.setText("م");
                        editor.putString("textinput", "");
                        editor.apply();
                        input.setText("");

                        String one = "1";
                        //s:lock score for those answered [3]
                        editor.putString("lockscore1", one);
                        editor.apply();

                        //====

                        // get score
                        String highscore = sp.getString("highscore", "0");
                        int Ihighscore = parseInt(highscore) + 100;
                        String newHighScore = new Integer(Ihighscore).toString();

                        editor.putString("highscore", newHighScore);
                        editor.apply();

                        String tagnewhighscore = "Score:" + " " + newHighScore;

                        textView18.setText(tagnewhighscore);


                        //
                    }
                    else if (textinputsecondary.equals("ايم")) {
                        editor.putString("textinput", "");
                        editor.apply();
                        input.setText("");
                        editor.putString("soundinput", "1");
                        editor.apply();
                    }

                    if (textinputsecondary.equals("لمبو") && !lockscore2.equals("1")) {
                        textView15.setText("ل");
                        textView14.setText("م");
                        textView16.setText("ب");
                        textView17.setText("و");
                        editor.putString("textinput", "");
                        editor.apply();
                        input.setText("");

                        //s:lock score for those answered [4]
                        editor.putString("lockscore2", "1");
                        editor.apply();
                        //====

                        // get score
                        String highscore = sp.getString("highscore", "0");
                        int Ihighscore = parseInt(highscore) + 100;
                        String newHighScore = new Integer(Ihighscore).toString();

                        editor.putString("highscore",newHighScore);
                        editor.apply();

                        String tagnewhighscore = "Score:" + " " + newHighScore;

                        textView18.setText(tagnewhighscore);


                        //


                    }
                    else if (textinputsecondary.equals("لمبو")) {
                        editor.putString("textinput", "");
                        editor.apply();
                        input.setText("");
                        editor.putString("soundinput", "1");
                        editor.apply();

                    }


                    if (textinputsecondary.equals("کودا") && !lockscore3.equals("1")) {
                        textView19.setText("ک");
                        textView17.setText("و");
                        textView20.setText("د");
                        textView21.setText("ا");
                        editor.putString("textinput", "");
                        editor.apply();
                        input.setText("");

                        //s:lock score for those answered [5]
                        editor.putString("lockscore3", "1");
                        editor.apply();
                        //====

                        // get score
                        String highscore = sp.getString("highscore", "0");
                        int Ihighscore = parseInt(highscore) + 100;
                        String newHighScore = new Integer(Ihighscore).toString();

                        editor.putString("highscore",newHighScore);
                        editor.apply();

                        String tagnewhighscore = "Score:" + " " + newHighScore;

                        textView18.setText(tagnewhighscore);


                        //

                    }
                    else if (textinputsecondary.equals("کودا")) {
                        editor.putString("textinput", "");
                        editor.apply();
                        input.setText("");
                        editor.putString("soundinput", "1");
                        editor.apply();

                    }

                    if (textinputsecondary.equals("ݢاجه") && !lockscore4.equals("1")) {
                        textView22.setText("ݢ");
                        textView21.setText("ا");
                        textView24.setText("ج");
                        textView25.setText("ه");
                        editor.putString("textinput", "");
                        editor.apply();
                        input.setText("");

                        //s:lock score for those answered [6]
                        editor.putString("lockscore4", "1");
                        editor.apply();
                        //====

                        // get score
                        String highscore = sp.getString("highscore", "0");
                        int Ihighscore = parseInt(highscore) + 100;
                        String newHighScore = new Integer(Ihighscore).toString();

                        editor.putString("highscore",newHighScore);
                        editor.apply();

                        String tagnewhighscore = "Score:" + " " + newHighScore;

                        textView18.setText(tagnewhighscore);


                        //


                    }
                    else if (textinputsecondary.equals("ݢاجه")) {
                        editor.putString("textinput", "");
                        editor.apply();
                        input.setText("");
                        editor.putString("soundinput", "1");
                        editor.apply();

                    }
//E:choice button on click

                    String soundinput;
                    int soundinputsecondary;

                    //S: Ascending Sounds on click
                    soundinput = sp.getString("soundinput", "1");
                    int soundinput2 = parseInt(soundinput);
                    soundinputsecondary = soundinput2 + 1;
                    String soundinputsecondary2 = new Integer(soundinputsecondary).toString();;

                    editor.putString("soundinput", soundinputsecondary2);
                    editor.apply();

                    if (soundinput2 == 1 && !textinputsecondary.equals("ايم") && !textinputsecondary.equals("لمبو") && !textinputsecondary.equals("کودا") && !textinputsecondary.equals("ݢاجه") ) {
                        //play music
                        note1.start();
                    }
                    else if (soundinput2 == 1) {
                        bingo1.start();
                        editor.putString("soundinput", "1");
                        editor.apply();
                    }

                    if (soundinput2 == 2 && !textinputsecondary.equals("ايم") && !textinputsecondary.equals("لمبو") && !textinputsecondary.equals("کودا") && !textinputsecondary.equals("ݢاجه") ) {
                        //play music
                        note2.start();
                    }
                    else if (soundinput2 == 2) {
                        bingo1.start();
                        editor.putString("soundinput", "1");
                        editor.apply();
                    }

                    if (soundinput2 == 3 && !textinputsecondary.equals("ايم") && !textinputsecondary.equals("لمبو") && !textinputsecondary.equals("کودا") && !textinputsecondary.equals("ݢاجه") ) {
                        //play music
                        note3.start();
                    }
                    else if (soundinput2 == 3) {
                        bingo1.start();
                        editor.putString("soundinput", "1");
                        editor.apply();
                    }

                    if (soundinput2 == 4 && !textinputsecondary.equals("ايم") && !textinputsecondary.equals("لمبو") && !textinputsecondary.equals("کودا") && !textinputsecondary.equals("ݢاجه") ) {
                        //play music
                        note4.start();
                    }
                    else if (soundinput2 == 4) {
                        bingo1.start();
                        editor.putString("soundinput", "1");
                        editor.apply();
                    }

                    if (soundinput2 == 5 && !textinputsecondary.equals("ايم") && !textinputsecondary.equals("لمبو") && !textinputsecondary.equals("کودا") && !textinputsecondary.equals("ݢاجه") ) {
                        //play music
                        note5.start();
                        editor.putString("textinput", "");
                        editor.apply();
                        input.setText("");
                        editor.putString("soundinput", "1");
                        editor.apply();
                    }
                    else if (soundinput2 == 5) {
                        bingo1.start();
                        editor.putString("soundinput", "1");
                        editor.apply();
                        editor.putString("textinput", "");
                        editor.apply();
                        input.setText("");

                    }
                }
            });
            choice3.setOnClickListener(new View.OnClickListener() {
                String textinputsecondary;

                @Override
                //button H
                public void onClick(View view) {
                    textinput = sp.getString("textinput", "");

                    //s:lock score for those answered [2]
                    String lockscore1 = sp.getString("lockscore1", "");
                    String lockscore2 = sp.getString("lockscore2", "");
                    String lockscore3 = sp.getString("lockscore3", "");
                    String lockscore4 = sp.getString("lockscore4", "");
                    //=

                    SharedPreferences.Editor editor = sp.edit();


                    //choice button on click
                    textinputsecondary = textinput + "ب";
                    editor.putString("textinput", textinputsecondary);
                    editor.apply();
                    input.setText(textinputsecondary);
                    if (textinputsecondary.equals("ايم") && !lockscore1.equals("1")) {
                        textView12.setText("ا");
                        textView13.setText("ي");
                        textView14.setText("م");
                        editor.putString("textinput", "");
                        editor.apply();
                        input.setText("");

                        String one = "1";
                        //s:lock score for those answered [3]
                        editor.putString("lockscore1", one);
                        editor.apply();

                        //====

                        // get score
                        String highscore = sp.getString("highscore", "0");
                        int Ihighscore = parseInt(highscore) + 100;
                        String newHighScore = new Integer(Ihighscore).toString();

                        editor.putString("highscore", newHighScore);
                        editor.apply();

                        String tagnewhighscore = "Score:" + " " + newHighScore;

                        textView18.setText(tagnewhighscore);


                        //
                    }
                    else if (textinputsecondary.equals("ايم")) {
                        editor.putString("textinput", "");
                        editor.apply();
                        input.setText("");
                        editor.putString("soundinput", "1");
                        editor.apply();
                    }

                    if (textinputsecondary.equals("لمبو") && !lockscore2.equals("1")) {
                        textView15.setText("ل");
                        textView14.setText("م");
                        textView16.setText("ب");
                        textView17.setText("و");
                        editor.putString("textinput", "");
                        editor.apply();
                        input.setText("");

                        //s:lock score for those answered [4]
                        editor.putString("lockscore2", "1");
                        editor.apply();
                        //====

                        // get score
                        String highscore = sp.getString("highscore", "0");
                        int Ihighscore = parseInt(highscore) + 100;
                        String newHighScore = new Integer(Ihighscore).toString();

                        editor.putString("highscore",newHighScore);
                        editor.apply();

                        String tagnewhighscore = "Score:" + " " + newHighScore;

                        textView18.setText(tagnewhighscore);


                        //


                    }
                    else if (textinputsecondary.equals("لمبو")) {
                        editor.putString("textinput", "");
                        editor.apply();
                        input.setText("");
                        editor.putString("soundinput", "1");
                        editor.apply();

                    }


                    if (textinputsecondary.equals("کودا") && !lockscore3.equals("1")) {
                        textView19.setText("ک");
                        textView17.setText("و");
                        textView20.setText("د");
                        textView21.setText("ا");
                        editor.putString("textinput", "");
                        editor.apply();
                        input.setText("");

                        //s:lock score for those answered [5]
                        editor.putString("lockscore3", "1");
                        editor.apply();
                        //====

                        // get score
                        String highscore = sp.getString("highscore", "0");
                        int Ihighscore = parseInt(highscore) + 100;
                        String newHighScore = new Integer(Ihighscore).toString();

                        editor.putString("highscore",newHighScore);
                        editor.apply();

                        String tagnewhighscore = "Score:" + " " + newHighScore;

                        textView18.setText(tagnewhighscore);


                        //

                    }
                    else if (textinputsecondary.equals("کودا")) {
                        editor.putString("textinput", "");
                        editor.apply();
                        input.setText("");
                        editor.putString("soundinput", "1");
                        editor.apply();

                    }

                    if (textinputsecondary.equals("ݢاجه") && !lockscore4.equals("1")) {
                        textView22.setText("ݢ");
                        textView21.setText("ا");
                        textView24.setText("ج");
                        textView25.setText("ه");
                        editor.putString("textinput", "");
                        editor.apply();
                        input.setText("");

                        //s:lock score for those answered [6]
                        editor.putString("lockscore4", "1");
                        editor.apply();
                        //====

                        // get score
                        String highscore = sp.getString("highscore", "0");
                        int Ihighscore = parseInt(highscore) + 100;
                        String newHighScore = new Integer(Ihighscore).toString();

                        editor.putString("highscore",newHighScore);
                        editor.apply();

                        String tagnewhighscore = "Score:" + " " + newHighScore;

                        textView18.setText(tagnewhighscore);


                        //


                    }
                    else if (textinputsecondary.equals("ݢاجه")) {
                        editor.putString("textinput", "");
                        editor.apply();
                        input.setText("");
                        editor.putString("soundinput", "1");
                        editor.apply();

                    }
//E:choice button on click

                    String soundinput;
                    int soundinputsecondary;

                    //S: Ascending Sounds on click
                    soundinput = sp.getString("soundinput", "1");
                    int soundinput2 = parseInt(soundinput);
                    soundinputsecondary = soundinput2 + 1;
                    String soundinputsecondary2 = new Integer(soundinputsecondary).toString();;

                    editor.putString("soundinput", soundinputsecondary2);
                    editor.apply();

                    if (soundinput2 == 1 && !textinputsecondary.equals("ايم") && !textinputsecondary.equals("لمبو") && !textinputsecondary.equals("کودا") && !textinputsecondary.equals("ݢاجه") ) {
                        //play music
                        note1.start();
                    }
                    else if (soundinput2 == 1) {
                        bingo1.start();
                        editor.putString("soundinput", "1");
                        editor.apply();
                    }

                    if (soundinput2 == 2 && !textinputsecondary.equals("ايم") && !textinputsecondary.equals("لمبو") && !textinputsecondary.equals("کودا") && !textinputsecondary.equals("ݢاجه") ) {
                        //play music
                        note2.start();
                    }
                    else if (soundinput2 == 2) {
                        bingo1.start();
                        editor.putString("soundinput", "1");
                        editor.apply();
                    }

                    if (soundinput2 == 3 && !textinputsecondary.equals("ايم") && !textinputsecondary.equals("لمبو") && !textinputsecondary.equals("کودا") && !textinputsecondary.equals("ݢاجه") ) {
                        //play music
                        note3.start();
                    }
                    else if (soundinput2 == 3) {
                        bingo1.start();
                        editor.putString("soundinput", "1");
                        editor.apply();
                    }

                    if (soundinput2 == 4 && !textinputsecondary.equals("ايم") && !textinputsecondary.equals("لمبو") && !textinputsecondary.equals("کودا") && !textinputsecondary.equals("ݢاجه") ) {
                        //play music
                        note4.start();
                    }
                    else if (soundinput2 == 4) {
                        bingo1.start();
                        editor.putString("soundinput", "1");
                        editor.apply();
                    }

                    if (soundinput2 == 5 && !textinputsecondary.equals("ايم") && !textinputsecondary.equals("لمبو") && !textinputsecondary.equals("کودا") && !textinputsecondary.equals("ݢاجه") ) {
                        //play music
                        note5.start();
                        editor.putString("textinput", "");
                        editor.apply();
                        input.setText("");
                        editor.putString("soundinput", "1");
                        editor.apply();
                    }
                    else if (soundinput2 == 5) {
                        bingo1.start();
                        editor.putString("soundinput", "1");
                        editor.apply();
                        editor.putString("textinput", "");
                        editor.apply();
                        input.setText("");

                    }
                }
            });
            choice4.setOnClickListener(new View.OnClickListener() {
                String textinputsecondary;

                @Override
                //button H
                public void onClick(View view) {
                    textinput = sp.getString("textinput", "");

                    //s:lock score for those answered [2]
                    String lockscore1 = sp.getString("lockscore1", "");
                    String lockscore2 = sp.getString("lockscore2", "");
                    String lockscore3 = sp.getString("lockscore3", "");
                    String lockscore4 = sp.getString("lockscore4", "");
                    //=

                    SharedPreferences.Editor editor = sp.edit();


                    //choice button on click
                    textinputsecondary = textinput + "ج";
                    editor.putString("textinput", textinputsecondary);
                    editor.apply();
                    input.setText(textinputsecondary);
                    if (textinputsecondary.equals("ايم") && !lockscore1.equals("1")) {
                        textView12.setText("ا");
                        textView13.setText("ي");
                        textView14.setText("م");
                        editor.putString("textinput", "");
                        editor.apply();
                        input.setText("");

                        String one = "1";
                        //s:lock score for those answered [3]
                        editor.putString("lockscore1", one);
                        editor.apply();

                        //====

                        // get score
                        String highscore = sp.getString("highscore", "0");
                        int Ihighscore = parseInt(highscore) + 100;
                        String newHighScore = new Integer(Ihighscore).toString();

                        editor.putString("highscore", newHighScore);
                        editor.apply();

                        String tagnewhighscore = "Score:" + " " + newHighScore;

                        textView18.setText(tagnewhighscore);


                        //
                    }
                    else if (textinputsecondary.equals("ايم")) {
                        editor.putString("textinput", "");
                        editor.apply();
                        input.setText("");
                        editor.putString("soundinput", "1");
                        editor.apply();
                    }

                    if (textinputsecondary.equals("لمبو") && !lockscore2.equals("1")) {
                        textView15.setText("ل");
                        textView14.setText("م");
                        textView16.setText("ب");
                        textView17.setText("و");
                        editor.putString("textinput", "");
                        editor.apply();
                        input.setText("");

                        //s:lock score for those answered [4]
                        editor.putString("lockscore2", "1");
                        editor.apply();
                        //====

                        // get score
                        String highscore = sp.getString("highscore", "0");
                        int Ihighscore = parseInt(highscore) + 100;
                        String newHighScore = new Integer(Ihighscore).toString();

                        editor.putString("highscore",newHighScore);
                        editor.apply();

                        String tagnewhighscore = "Score:" + " " + newHighScore;

                        textView18.setText(tagnewhighscore);


                        //


                    }
                    else if (textinputsecondary.equals("لمبو")) {
                        editor.putString("textinput", "");
                        editor.apply();
                        input.setText("");
                        editor.putString("soundinput", "1");
                        editor.apply();

                    }


                    if (textinputsecondary.equals("کودا") && !lockscore3.equals("1")) {
                        textView19.setText("ک");
                        textView17.setText("و");
                        textView20.setText("د");
                        textView21.setText("ا");
                        editor.putString("textinput", "");
                        editor.apply();
                        input.setText("");

                        //s:lock score for those answered [5]
                        editor.putString("lockscore3", "1");
                        editor.apply();
                        //====

                        // get score
                        String highscore = sp.getString("highscore", "0");
                        int Ihighscore = parseInt(highscore) + 100;
                        String newHighScore = new Integer(Ihighscore).toString();

                        editor.putString("highscore",newHighScore);
                        editor.apply();

                        String tagnewhighscore = "Score:" + " " + newHighScore;

                        textView18.setText(tagnewhighscore);


                        //

                    }
                    else if (textinputsecondary.equals("کودا")) {
                        editor.putString("textinput", "");
                        editor.apply();
                        input.setText("");
                        editor.putString("soundinput", "1");
                        editor.apply();

                    }

                    if (textinputsecondary.equals("ݢاجه") && !lockscore4.equals("1")) {
                        textView22.setText("ݢ");
                        textView21.setText("ا");
                        textView24.setText("ج");
                        textView25.setText("ه");
                        editor.putString("textinput", "");
                        editor.apply();
                        input.setText("");

                        //s:lock score for those answered [6]
                        editor.putString("lockscore4", "1");
                        editor.apply();
                        //====

                        // get score
                        String highscore = sp.getString("highscore", "0");
                        int Ihighscore = parseInt(highscore) + 100;
                        String newHighScore = new Integer(Ihighscore).toString();

                        editor.putString("highscore",newHighScore);
                        editor.apply();

                        String tagnewhighscore = "Score:" + " " + newHighScore;

                        textView18.setText(tagnewhighscore);


                        //


                    }
                    else if (textinputsecondary.equals("ݢاجه")) {
                        editor.putString("textinput", "");
                        editor.apply();
                        input.setText("");
                        editor.putString("soundinput", "1");
                        editor.apply();

                    }
//E:choice button on click

                    String soundinput;
                    int soundinputsecondary;

                    //S: Ascending Sounds on click
                    soundinput = sp.getString("soundinput", "1");
                    int soundinput2 = parseInt(soundinput);
                    soundinputsecondary = soundinput2 + 1;
                    String soundinputsecondary2 = new Integer(soundinputsecondary).toString();;

                    editor.putString("soundinput", soundinputsecondary2);
                    editor.apply();

                    if (soundinput2 == 1 && !textinputsecondary.equals("ايم") && !textinputsecondary.equals("لمبو") && !textinputsecondary.equals("کودا") && !textinputsecondary.equals("ݢاجه") ) {
                        //play music
                        note1.start();
                    }
                    else if (soundinput2 == 1) {
                        bingo1.start();
                        editor.putString("soundinput", "1");
                        editor.apply();
                    }

                    if (soundinput2 == 2 && !textinputsecondary.equals("ايم") && !textinputsecondary.equals("لمبو") && !textinputsecondary.equals("کودا") && !textinputsecondary.equals("ݢاجه") ) {
                        //play music
                        note2.start();
                    }
                    else if (soundinput2 == 2) {
                        bingo1.start();
                        editor.putString("soundinput", "1");
                        editor.apply();
                    }

                    if (soundinput2 == 3 && !textinputsecondary.equals("ايم") && !textinputsecondary.equals("لمبو") && !textinputsecondary.equals("کودا") && !textinputsecondary.equals("ݢاجه") ) {
                        //play music
                        note3.start();
                    }
                    else if (soundinput2 == 3) {
                        bingo1.start();
                        editor.putString("soundinput", "1");
                        editor.apply();
                    }

                    if (soundinput2 == 4 && !textinputsecondary.equals("ايم") && !textinputsecondary.equals("لمبو") && !textinputsecondary.equals("کودا") && !textinputsecondary.equals("ݢاجه") ) {
                        //play music
                        note4.start();
                    }
                    else if (soundinput2 == 4) {
                        bingo1.start();
                        editor.putString("soundinput", "1");
                        editor.apply();
                    }

                    if (soundinput2 == 5 && !textinputsecondary.equals("ايم") && !textinputsecondary.equals("لمبو") && !textinputsecondary.equals("کودا") && !textinputsecondary.equals("ݢاجه") ) {
                        //play music
                        note5.start();
                        editor.putString("textinput", "");
                        editor.apply();
                        input.setText("");
                        editor.putString("soundinput", "1");
                        editor.apply();
                    }
                    else if (soundinput2 == 5) {
                        bingo1.start();
                        editor.putString("soundinput", "1");
                        editor.apply();
                        editor.putString("textinput", "");
                        editor.apply();
                        input.setText("");

                    }
                }
            });
            choice5.setOnClickListener(new View.OnClickListener() {
                String textinputsecondary;

                @Override
                //button H
                public void onClick(View view) {
                    textinput = sp.getString("textinput", "");

                    //s:lock score for those answered [2]
                    String lockscore1 = sp.getString("lockscore1", "");
                    String lockscore2 = sp.getString("lockscore2", "");
                    String lockscore3 = sp.getString("lockscore3", "");
                    String lockscore4 = sp.getString("lockscore4", "");
                    //=

                    SharedPreferences.Editor editor = sp.edit();


                    //choice button on click
                    textinputsecondary = textinput + "م";
                    editor.putString("textinput", textinputsecondary);
                    editor.apply();
                    input.setText(textinputsecondary);
                    if (textinputsecondary.equals("ايم") && !lockscore1.equals("1")) {
                        textView12.setText("ا");
                        textView13.setText("ي");
                        textView14.setText("م");
                        editor.putString("textinput", "");
                        editor.apply();
                        input.setText("");

                        String one = "1";
                        //s:lock score for those answered [3]
                        editor.putString("lockscore1", one);
                        editor.apply();

                        //====

                        // get score
                        String highscore = sp.getString("highscore", "0");
                        int Ihighscore = parseInt(highscore) + 100;
                        String newHighScore = new Integer(Ihighscore).toString();

                        editor.putString("highscore", newHighScore);
                        editor.apply();

                        String tagnewhighscore = "Score:" + " " + newHighScore;

                        textView18.setText(tagnewhighscore);


                        //
                    }
                    else if (textinputsecondary.equals("ايم")) {
                        editor.putString("textinput", "");
                        editor.apply();
                        input.setText("");
                        editor.putString("soundinput", "1");
                        editor.apply();
                    }

                    if (textinputsecondary.equals("لمبو") && !lockscore2.equals("1")) {
                        textView15.setText("ل");
                        textView14.setText("م");
                        textView16.setText("ب");
                        textView17.setText("و");
                        editor.putString("textinput", "");
                        editor.apply();
                        input.setText("");

                        //s:lock score for those answered [4]
                        editor.putString("lockscore2", "1");
                        editor.apply();
                        //====

                        // get score
                        String highscore = sp.getString("highscore", "0");
                        int Ihighscore = parseInt(highscore) + 100;
                        String newHighScore = new Integer(Ihighscore).toString();

                        editor.putString("highscore",newHighScore);
                        editor.apply();

                        String tagnewhighscore = "Score:" + " " + newHighScore;

                        textView18.setText(tagnewhighscore);


                        //


                    }
                    else if (textinputsecondary.equals("لمبو")) {
                        editor.putString("textinput", "");
                        editor.apply();
                        input.setText("");
                        editor.putString("soundinput", "1");
                        editor.apply();

                    }


                    if (textinputsecondary.equals("کودا") && !lockscore3.equals("1")) {
                        textView19.setText("ک");
                        textView17.setText("و");
                        textView20.setText("د");
                        textView21.setText("ا");
                        editor.putString("textinput", "");
                        editor.apply();
                        input.setText("");

                        //s:lock score for those answered [5]
                        editor.putString("lockscore3", "1");
                        editor.apply();
                        //====

                        // get score
                        String highscore = sp.getString("highscore", "0");
                        int Ihighscore = parseInt(highscore) + 100;
                        String newHighScore = new Integer(Ihighscore).toString();

                        editor.putString("highscore",newHighScore);
                        editor.apply();

                        String tagnewhighscore = "Score:" + " " + newHighScore;

                        textView18.setText(tagnewhighscore);


                        //

                    }
                    else if (textinputsecondary.equals("کودا")) {
                        editor.putString("textinput", "");
                        editor.apply();
                        input.setText("");
                        editor.putString("soundinput", "1");
                        editor.apply();

                    }

                    if (textinputsecondary.equals("ݢاجه") && !lockscore4.equals("1")) {
                        textView22.setText("ݢ");
                        textView21.setText("ا");
                        textView24.setText("ج");
                        textView25.setText("ه");
                        editor.putString("textinput", "");
                        editor.apply();
                        input.setText("");

                        //s:lock score for those answered [6]
                        editor.putString("lockscore4", "1");
                        editor.apply();
                        //====

                        // get score
                        String highscore = sp.getString("highscore", "0");
                        int Ihighscore = parseInt(highscore) + 100;
                        String newHighScore = new Integer(Ihighscore).toString();

                        editor.putString("highscore",newHighScore);
                        editor.apply();

                        String tagnewhighscore = "Score:" + " " + newHighScore;

                        textView18.setText(tagnewhighscore);


                        //


                    }
                    else if (textinputsecondary.equals("ݢاجه")) {
                        editor.putString("textinput", "");
                        editor.apply();
                        input.setText("");
                        editor.putString("soundinput", "1");
                        editor.apply();

                    }
//E:choice button on click

                    String soundinput;
                    int soundinputsecondary;

                    //S: Ascending Sounds on click
                    soundinput = sp.getString("soundinput", "1");
                    int soundinput2 = parseInt(soundinput);
                    soundinputsecondary = soundinput2 + 1;
                    String soundinputsecondary2 = new Integer(soundinputsecondary).toString();;

                    editor.putString("soundinput", soundinputsecondary2);
                    editor.apply();

                    if (soundinput2 == 1 && !textinputsecondary.equals("ايم") && !textinputsecondary.equals("لمبو") && !textinputsecondary.equals("کودا") && !textinputsecondary.equals("ݢاجه") ) {
                        //play music
                        note1.start();
                    }
                    else if (soundinput2 == 1) {
                        bingo1.start();
                        editor.putString("soundinput", "1");
                        editor.apply();
                    }

                    if (soundinput2 == 2 && !textinputsecondary.equals("ايم") && !textinputsecondary.equals("لمبو") && !textinputsecondary.equals("کودا") && !textinputsecondary.equals("ݢاجه") ) {
                        //play music
                        note2.start();
                    }
                    else if (soundinput2 == 2) {
                        bingo1.start();
                        editor.putString("soundinput", "1");
                        editor.apply();
                    }

                    if (soundinput2 == 3 && !textinputsecondary.equals("ايم") && !textinputsecondary.equals("لمبو") && !textinputsecondary.equals("کودا") && !textinputsecondary.equals("ݢاجه") ) {
                        //play music
                        note3.start();
                    }
                    else if (soundinput2 == 3) {
                        bingo1.start();
                        editor.putString("soundinput", "1");
                        editor.apply();
                    }

                    if (soundinput2 == 4 && !textinputsecondary.equals("ايم") && !textinputsecondary.equals("لمبو") && !textinputsecondary.equals("کودا") && !textinputsecondary.equals("ݢاجه") ) {
                        //play music
                        note4.start();
                    }
                    else if (soundinput2 == 4) {
                        bingo1.start();
                        editor.putString("soundinput", "1");
                        editor.apply();
                    }

                    if (soundinput2 == 5 && !textinputsecondary.equals("ايم") && !textinputsecondary.equals("لمبو") && !textinputsecondary.equals("کودا") && !textinputsecondary.equals("ݢاجه") ) {
                        //play music
                        note5.start();
                        editor.putString("textinput", "");
                        editor.apply();
                        input.setText("");
                        editor.putString("soundinput", "1");
                        editor.apply();
                    }
                    else if (soundinput2 == 5) {
                        bingo1.start();
                        editor.putString("soundinput", "1");
                        editor.apply();
                        editor.putString("textinput", "");
                        editor.apply();
                        input.setText("");

                    }
                }
            });
            choice6.setOnClickListener(new View.OnClickListener() {
                String textinputsecondary;

                @Override
                //button H
                public void onClick(View view) {
                    textinput = sp.getString("textinput", "");

                    //s:lock score for those answered [2]
                    String lockscore1 = sp.getString("lockscore1", "");
                    String lockscore2 = sp.getString("lockscore2", "");
                    String lockscore3 = sp.getString("lockscore3", "");
                    String lockscore4 = sp.getString("lockscore4", "");
                    //=

                    SharedPreferences.Editor editor = sp.edit();


                    //choice button on click
                    textinputsecondary = textinput + "د";
                    editor.putString("textinput", textinputsecondary);
                    editor.apply();
                    input.setText(textinputsecondary);
                    if (textinputsecondary.equals("ايم") && !lockscore1.equals("1")) {
                        textView12.setText("ا");
                        textView13.setText("ي");
                        textView14.setText("م");
                        editor.putString("textinput", "");
                        editor.apply();
                        input.setText("");

                        String one = "1";
                        //s:lock score for those answered [3]
                        editor.putString("lockscore1", one);
                        editor.apply();

                        //====

                        // get score
                        String highscore = sp.getString("highscore", "0");
                        int Ihighscore = parseInt(highscore) + 100;
                        String newHighScore = new Integer(Ihighscore).toString();

                        editor.putString("highscore", newHighScore);
                        editor.apply();

                        String tagnewhighscore = "Score:" + " " + newHighScore;

                        textView18.setText(tagnewhighscore);


                        //
                    }
                    else if (textinputsecondary.equals("ايم")) {
                        editor.putString("textinput", "");
                        editor.apply();
                        input.setText("");
                        editor.putString("soundinput", "1");
                        editor.apply();
                    }

                    if (textinputsecondary.equals("لمبو") && !lockscore2.equals("1")) {
                        textView15.setText("ل");
                        textView14.setText("م");
                        textView16.setText("ب");
                        textView17.setText("و");
                        editor.putString("textinput", "");
                        editor.apply();
                        input.setText("");

                        //s:lock score for those answered [4]
                        editor.putString("lockscore2", "1");
                        editor.apply();
                        //====

                        // get score
                        String highscore = sp.getString("highscore", "0");
                        int Ihighscore = parseInt(highscore) + 100;
                        String newHighScore = new Integer(Ihighscore).toString();

                        editor.putString("highscore",newHighScore);
                        editor.apply();

                        String tagnewhighscore = "Score:" + " " + newHighScore;

                        textView18.setText(tagnewhighscore);


                        //


                    }
                    else if (textinputsecondary.equals("لمبو")) {
                        editor.putString("textinput", "");
                        editor.apply();
                        input.setText("");
                        editor.putString("soundinput", "1");
                        editor.apply();

                    }


                    if (textinputsecondary.equals("کودا") && !lockscore3.equals("1")) {
                        textView19.setText("ک");
                        textView17.setText("و");
                        textView20.setText("د");
                        textView21.setText("ا");
                        editor.putString("textinput", "");
                        editor.apply();
                        input.setText("");

                        //s:lock score for those answered [5]
                        editor.putString("lockscore3", "1");
                        editor.apply();
                        //====

                        // get score
                        String highscore = sp.getString("highscore", "0");
                        int Ihighscore = parseInt(highscore) + 100;
                        String newHighScore = new Integer(Ihighscore).toString();

                        editor.putString("highscore",newHighScore);
                        editor.apply();

                        String tagnewhighscore = "Score:" + " " + newHighScore;

                        textView18.setText(tagnewhighscore);


                        //

                    }
                    else if (textinputsecondary.equals("کودا")) {
                        editor.putString("textinput", "");
                        editor.apply();
                        input.setText("");
                        editor.putString("soundinput", "1");
                        editor.apply();

                    }

                    if (textinputsecondary.equals("ݢاجه") && !lockscore4.equals("1")) {
                        textView22.setText("ݢ");
                        textView21.setText("ا");
                        textView24.setText("ج");
                        textView25.setText("ه");
                        editor.putString("textinput", "");
                        editor.apply();
                        input.setText("");

                        //s:lock score for those answered [6]
                        editor.putString("lockscore4", "1");
                        editor.apply();
                        //====

                        // get score
                        String highscore = sp.getString("highscore", "0");
                        int Ihighscore = parseInt(highscore) + 100;
                        String newHighScore = new Integer(Ihighscore).toString();

                        editor.putString("highscore",newHighScore);
                        editor.apply();

                        String tagnewhighscore = "Score:" + " " + newHighScore;

                        textView18.setText(tagnewhighscore);


                        //


                    }
                    else if (textinputsecondary.equals("ݢاجه")) {
                        editor.putString("textinput", "");
                        editor.apply();
                        input.setText("");
                        editor.putString("soundinput", "1");
                        editor.apply();

                    }
//E:choice button on click

                    String soundinput;
                    int soundinputsecondary;

                    //S: Ascending Sounds on click
                    soundinput = sp.getString("soundinput", "1");
                    int soundinput2 = parseInt(soundinput);
                    soundinputsecondary = soundinput2 + 1;
                    String soundinputsecondary2 = new Integer(soundinputsecondary).toString();;

                    editor.putString("soundinput", soundinputsecondary2);
                    editor.apply();

                    if (soundinput2 == 1 && !textinputsecondary.equals("ايم") && !textinputsecondary.equals("لمبو") && !textinputsecondary.equals("کودا") && !textinputsecondary.equals("ݢاجه") ) {
                        //play music
                        note1.start();
                    }
                    else if (soundinput2 == 1) {
                        bingo1.start();
                        editor.putString("soundinput", "1");
                        editor.apply();
                    }

                    if (soundinput2 == 2 && !textinputsecondary.equals("ايم") && !textinputsecondary.equals("لمبو") && !textinputsecondary.equals("کودا") && !textinputsecondary.equals("ݢاجه") ) {
                        //play music
                        note2.start();
                    }
                    else if (soundinput2 == 2) {
                        bingo1.start();
                        editor.putString("soundinput", "1");
                        editor.apply();
                    }

                    if (soundinput2 == 3 && !textinputsecondary.equals("ايم") && !textinputsecondary.equals("لمبو") && !textinputsecondary.equals("کودا") && !textinputsecondary.equals("ݢاجه") ) {
                        //play music
                        note3.start();
                    }
                    else if (soundinput2 == 3) {
                        bingo1.start();
                        editor.putString("soundinput", "1");
                        editor.apply();
                    }

                    if (soundinput2 == 4 && !textinputsecondary.equals("ايم") && !textinputsecondary.equals("لمبو") && !textinputsecondary.equals("کودا") && !textinputsecondary.equals("ݢاجه") ) {
                        //play music
                        note4.start();
                    }
                    else if (soundinput2 == 4) {
                        bingo1.start();
                        editor.putString("soundinput", "1");
                        editor.apply();
                    }

                    if (soundinput2 == 5 && !textinputsecondary.equals("ايم") && !textinputsecondary.equals("لمبو") && !textinputsecondary.equals("کودا") && !textinputsecondary.equals("ݢاجه") ) {
                        //play music
                        note5.start();
                        editor.putString("textinput", "");
                        editor.apply();
                        input.setText("");
                        editor.putString("soundinput", "1");
                        editor.apply();
                    }
                    else if (soundinput2 == 5) {
                        bingo1.start();
                        editor.putString("soundinput", "1");
                        editor.apply();
                        editor.putString("textinput", "");
                        editor.apply();
                        input.setText("");

                    }
                }
            });
            choice7.setOnClickListener(new View.OnClickListener() {
                String textinputsecondary;

                @Override
                //button H
                public void onClick(View view) {
                    textinput = sp.getString("textinput", "");

                    //s:lock score for those answered [2]
                    String lockscore1 = sp.getString("lockscore1", "");
                    String lockscore2 = sp.getString("lockscore2", "");
                    String lockscore3 = sp.getString("lockscore3", "");
                    String lockscore4 = sp.getString("lockscore4", "");
                    //=

                    SharedPreferences.Editor editor = sp.edit();


                    //choice button on click
                    textinputsecondary = textinput + "ݢ";
                    editor.putString("textinput", textinputsecondary);
                    editor.apply();
                    input.setText(textinputsecondary);
                    if (textinputsecondary.equals("ايم") && !lockscore1.equals("1")) {
                        textView12.setText("ا");
                        textView13.setText("ي");
                        textView14.setText("م");
                        editor.putString("textinput", "");
                        editor.apply();
                        input.setText("");

                        String one = "1";
                        //s:lock score for those answered [3]
                        editor.putString("lockscore1", one);
                        editor.apply();

                        //====

                        // get score
                        String highscore = sp.getString("highscore", "0");
                        int Ihighscore = parseInt(highscore) + 100;
                        String newHighScore = new Integer(Ihighscore).toString();

                        editor.putString("highscore", newHighScore);
                        editor.apply();

                        String tagnewhighscore = "Score:" + " " + newHighScore;

                        textView18.setText(tagnewhighscore);


                        //
                    }
                    else if (textinputsecondary.equals("ايم")) {
                        editor.putString("textinput", "");
                        editor.apply();
                        input.setText("");
                        editor.putString("soundinput", "1");
                        editor.apply();
                    }

                    if (textinputsecondary.equals("لمبو") && !lockscore2.equals("1")) {
                        textView15.setText("ل");
                        textView14.setText("م");
                        textView16.setText("ب");
                        textView17.setText("و");
                        editor.putString("textinput", "");
                        editor.apply();
                        input.setText("");

                        //s:lock score for those answered [4]
                        editor.putString("lockscore2", "1");
                        editor.apply();
                        //====

                        // get score
                        String highscore = sp.getString("highscore", "0");
                        int Ihighscore = parseInt(highscore) + 100;
                        String newHighScore = new Integer(Ihighscore).toString();

                        editor.putString("highscore",newHighScore);
                        editor.apply();

                        String tagnewhighscore = "Score:" + " " + newHighScore;

                        textView18.setText(tagnewhighscore);


                        //


                    }
                    else if (textinputsecondary.equals("لمبو")) {
                        editor.putString("textinput", "");
                        editor.apply();
                        input.setText("");
                        editor.putString("soundinput", "1");
                        editor.apply();

                    }


                    if (textinputsecondary.equals("کودا") && !lockscore3.equals("1")) {
                        textView19.setText("ک");
                        textView17.setText("و");
                        textView20.setText("د");
                        textView21.setText("ا");
                        editor.putString("textinput", "");
                        editor.apply();
                        input.setText("");

                        //s:lock score for those answered [5]
                        editor.putString("lockscore3", "1");
                        editor.apply();
                        //====

                        // get score
                        String highscore = sp.getString("highscore", "0");
                        int Ihighscore = parseInt(highscore) + 100;
                        String newHighScore = new Integer(Ihighscore).toString();

                        editor.putString("highscore",newHighScore);
                        editor.apply();

                        String tagnewhighscore = "Score:" + " " + newHighScore;

                        textView18.setText(tagnewhighscore);


                        //

                    }
                    else if (textinputsecondary.equals("کودا")) {
                        editor.putString("textinput", "");
                        editor.apply();
                        input.setText("");
                        editor.putString("soundinput", "1");
                        editor.apply();

                    }

                    if (textinputsecondary.equals("ݢاجه") && !lockscore4.equals("1")) {
                        textView22.setText("ݢ");
                        textView21.setText("ا");
                        textView24.setText("ج");
                        textView25.setText("ه");
                        editor.putString("textinput", "");
                        editor.apply();
                        input.setText("");

                        //s:lock score for those answered [6]
                        editor.putString("lockscore4", "1");
                        editor.apply();
                        //====

                        // get score
                        String highscore = sp.getString("highscore", "0");
                        int Ihighscore = parseInt(highscore) + 100;
                        String newHighScore = new Integer(Ihighscore).toString();

                        editor.putString("highscore",newHighScore);
                        editor.apply();

                        String tagnewhighscore = "Score:" + " " + newHighScore;

                        textView18.setText(tagnewhighscore);


                        //


                    }
                    else if (textinputsecondary.equals("ݢاجه")) {
                        editor.putString("textinput", "");
                        editor.apply();
                        input.setText("");
                        editor.putString("soundinput", "1");
                        editor.apply();

                    }
//E:choice button on click

                    String soundinput;
                    int soundinputsecondary;

                    //S: Ascending Sounds on click
                    soundinput = sp.getString("soundinput", "1");
                    int soundinput2 = parseInt(soundinput);
                    soundinputsecondary = soundinput2 + 1;
                    String soundinputsecondary2 = new Integer(soundinputsecondary).toString();;

                    editor.putString("soundinput", soundinputsecondary2);
                    editor.apply();

                    if (soundinput2 == 1 && !textinputsecondary.equals("ايم") && !textinputsecondary.equals("لمبو") && !textinputsecondary.equals("کودا") && !textinputsecondary.equals("ݢاجه") ) {
                        //play music
                        note1.start();
                    }
                    else if (soundinput2 == 1) {
                        bingo1.start();
                        editor.putString("soundinput", "1");
                        editor.apply();
                    }

                    if (soundinput2 == 2 && !textinputsecondary.equals("ايم") && !textinputsecondary.equals("لمبو") && !textinputsecondary.equals("کودا") && !textinputsecondary.equals("ݢاجه") ) {
                        //play music
                        note2.start();
                    }
                    else if (soundinput2 == 2) {
                        bingo1.start();
                        editor.putString("soundinput", "1");
                        editor.apply();
                    }

                    if (soundinput2 == 3 && !textinputsecondary.equals("ايم") && !textinputsecondary.equals("لمبو") && !textinputsecondary.equals("کودا") && !textinputsecondary.equals("ݢاجه") ) {
                        //play music
                        note3.start();
                    }
                    else if (soundinput2 == 3) {
                        bingo1.start();
                        editor.putString("soundinput", "1");
                        editor.apply();
                    }

                    if (soundinput2 == 4 && !textinputsecondary.equals("ايم") && !textinputsecondary.equals("لمبو") && !textinputsecondary.equals("کودا") && !textinputsecondary.equals("ݢاجه") ) {
                        //play music
                        note4.start();
                    }
                    else if (soundinput2 == 4) {
                        bingo1.start();
                        editor.putString("soundinput", "1");
                        editor.apply();
                    }

                    if (soundinput2 == 5 && !textinputsecondary.equals("ايم") && !textinputsecondary.equals("لمبو") && !textinputsecondary.equals("کودا") && !textinputsecondary.equals("ݢاجه") ) {
                        //play music
                        note5.start();
                        editor.putString("textinput", "");
                        editor.apply();
                        input.setText("");
                        editor.putString("soundinput", "1");
                        editor.apply();
                    }
                    else if (soundinput2 == 5) {
                        bingo1.start();
                        editor.putString("soundinput", "1");
                        editor.apply();
                        editor.putString("textinput", "");
                        editor.apply();
                        input.setText("");

                    }
                }
            });
            choice8.setOnClickListener(new View.OnClickListener() {
                String textinputsecondary;

                @Override
                //button H
                public void onClick(View view) {
                    textinput = sp.getString("textinput", "");

                    //s:lock score for those answered [2]
                    String lockscore1 = sp.getString("lockscore1", "");
                    String lockscore2 = sp.getString("lockscore2", "");
                    String lockscore3 = sp.getString("lockscore3", "");
                    String lockscore4 = sp.getString("lockscore4", "");
                    //=

                    SharedPreferences.Editor editor = sp.edit();


                    //choice button on click
                    textinputsecondary = textinput + "ە";
                    editor.putString("textinput", textinputsecondary);
                    editor.apply();
                    input.setText(textinputsecondary);
                    if (textinputsecondary.equals("ايم") && !lockscore1.equals("1")) {
                        textView12.setText("ا");
                        textView13.setText("ي");
                        textView14.setText("م");
                        editor.putString("textinput", "");
                        editor.apply();
                        input.setText("");

                        String one = "1";
                        //s:lock score for those answered [3]
                        editor.putString("lockscore1", one);
                        editor.apply();

                        //====

                        // get score
                        String highscore = sp.getString("highscore", "0");
                        int Ihighscore = parseInt(highscore) + 100;
                        String newHighScore = new Integer(Ihighscore).toString();

                        editor.putString("highscore", newHighScore);
                        editor.apply();

                        String tagnewhighscore = "Score:" + " " + newHighScore;

                        textView18.setText(tagnewhighscore);


                        //
                    }
                    else if (textinputsecondary.equals("ايم")) {
                        editor.putString("textinput", "");
                        editor.apply();
                        input.setText("");
                        editor.putString("soundinput", "1");
                        editor.apply();
                    }

                    if (textinputsecondary.equals("لمبو") && !lockscore2.equals("1")) {
                        textView15.setText("ل");
                        textView14.setText("م");
                        textView16.setText("ب");
                        textView17.setText("و");
                        editor.putString("textinput", "");
                        editor.apply();
                        input.setText("");

                        //s:lock score for those answered [4]
                        editor.putString("lockscore2", "1");
                        editor.apply();
                        //====

                        // get score
                        String highscore = sp.getString("highscore", "0");
                        int Ihighscore = parseInt(highscore) + 100;
                        String newHighScore = new Integer(Ihighscore).toString();

                        editor.putString("highscore",newHighScore);
                        editor.apply();

                        String tagnewhighscore = "Score:" + " " + newHighScore;

                        textView18.setText(tagnewhighscore);


                        //


                    }
                    else if (textinputsecondary.equals("لمبو")) {
                        editor.putString("textinput", "");
                        editor.apply();
                        input.setText("");
                        editor.putString("soundinput", "1");
                        editor.apply();

                    }


                    if (textinputsecondary.equals("کودا") && !lockscore3.equals("1")) {
                        textView19.setText("ک");
                        textView17.setText("و");
                        textView20.setText("د");
                        textView21.setText("ا");
                        editor.putString("textinput", "");
                        editor.apply();
                        input.setText("");

                        //s:lock score for those answered [5]
                        editor.putString("lockscore3", "1");
                        editor.apply();
                        //====

                        // get score
                        String highscore = sp.getString("highscore", "0");
                        int Ihighscore = parseInt(highscore) + 100;
                        String newHighScore = new Integer(Ihighscore).toString();

                        editor.putString("highscore",newHighScore);
                        editor.apply();

                        String tagnewhighscore = "Score:" + " " + newHighScore;

                        textView18.setText(tagnewhighscore);


                        //

                    }
                    else if (textinputsecondary.equals("کودا")) {
                        editor.putString("textinput", "");
                        editor.apply();
                        input.setText("");
                        editor.putString("soundinput", "1");
                        editor.apply();

                    }

                    if (textinputsecondary.equals("ݢاجه") && !lockscore4.equals("1")) {
                        textView22.setText("ݢ");
                        textView21.setText("ا");
                        textView24.setText("ج");
                        textView25.setText("ه");
                        editor.putString("textinput", "");
                        editor.apply();
                        input.setText("");

                        //s:lock score for those answered [6]
                        editor.putString("lockscore4", "1");
                        editor.apply();
                        //====

                        // get score
                        String highscore = sp.getString("highscore", "0");
                        int Ihighscore = parseInt(highscore) + 100;
                        String newHighScore = new Integer(Ihighscore).toString();

                        editor.putString("highscore",newHighScore);
                        editor.apply();

                        String tagnewhighscore = "Score:" + " " + newHighScore;

                        textView18.setText(tagnewhighscore);


                        //


                    }
                    else if (textinputsecondary.equals("ݢاجه")) {
                        editor.putString("textinput", "");
                        editor.apply();
                        input.setText("");
                        editor.putString("soundinput", "1");
                        editor.apply();

                    }
//E:choice button on click

                    String soundinput;
                    int soundinputsecondary;

                    //S: Ascending Sounds on click
                    soundinput = sp.getString("soundinput", "1");
                    int soundinput2 = parseInt(soundinput);
                    soundinputsecondary = soundinput2 + 1;
                    String soundinputsecondary2 = new Integer(soundinputsecondary).toString();;

                    editor.putString("soundinput", soundinputsecondary2);
                    editor.apply();

                    if (soundinput2 == 1 && !textinputsecondary.equals("ايم") && !textinputsecondary.equals("لمبو") && !textinputsecondary.equals("کودا") && !textinputsecondary.equals("ݢاجه") ) {
                        //play music
                        note1.start();
                    }
                    else if (soundinput2 == 1) {
                        bingo1.start();
                        editor.putString("soundinput", "1");
                        editor.apply();
                    }

                    if (soundinput2 == 2 && !textinputsecondary.equals("ايم") && !textinputsecondary.equals("لمبو") && !textinputsecondary.equals("کودا") && !textinputsecondary.equals("ݢاجه") ) {
                        //play music
                        note2.start();
                    }
                    else if (soundinput2 == 2) {
                        bingo1.start();
                        editor.putString("soundinput", "1");
                        editor.apply();
                    }

                    if (soundinput2 == 3 && !textinputsecondary.equals("ايم") && !textinputsecondary.equals("لمبو") && !textinputsecondary.equals("کودا") && !textinputsecondary.equals("ݢاجه") ) {
                        //play music
                        note3.start();
                    }
                    else if (soundinput2 == 3) {
                        bingo1.start();
                        editor.putString("soundinput", "1");
                        editor.apply();
                    }

                    if (soundinput2 == 4 && !textinputsecondary.equals("ايم") && !textinputsecondary.equals("لمبو") && !textinputsecondary.equals("کودا") && !textinputsecondary.equals("ݢاجه") ) {
                        //play music
                        note4.start();
                    }
                    else if (soundinput2 == 4) {
                        bingo1.start();
                        editor.putString("soundinput", "1");
                        editor.apply();
                    }

                    if (soundinput2 == 5 && !textinputsecondary.equals("ايم") && !textinputsecondary.equals("لمبو") && !textinputsecondary.equals("کودا") && !textinputsecondary.equals("ݢاجه") ) {
                        //play music
                        note5.start();
                        editor.putString("textinput", "");
                        editor.apply();
                        input.setText("");
                        editor.putString("soundinput", "1");
                        editor.apply();
                    }
                    else if (soundinput2 == 5) {
                        bingo1.start();
                        editor.putString("soundinput", "1");
                        editor.apply();
                        editor.putString("textinput", "");
                        editor.apply();
                        input.setText("");

                    }
                }
            });
            choice9.setOnClickListener(new View.OnClickListener() {
                String textinputsecondary;

                @Override
                //button H
                public void onClick(View view) {
                    textinput = sp.getString("textinput", "");

                    //s:lock score for those answered [2]
                    String lockscore1 = sp.getString("lockscore1", "");
                    String lockscore2 = sp.getString("lockscore2", "");
                    String lockscore3 = sp.getString("lockscore3", "");
                    String lockscore4 = sp.getString("lockscore4", "");
                    //=

                    SharedPreferences.Editor editor = sp.edit();


                    //choice button on click
                    textinputsecondary = textinput + "و";
                    editor.putString("textinput", textinputsecondary);
                    editor.apply();
                    input.setText(textinputsecondary);
                    if (textinputsecondary.equals("ايم") && !lockscore1.equals("1")) {
                        textView12.setText("ا");
                        textView13.setText("ي");
                        textView14.setText("م");
                        editor.putString("textinput", "");
                        editor.apply();
                        input.setText("");

                        String one = "1";
                        //s:lock score for those answered [3]
                        editor.putString("lockscore1", one);
                        editor.apply();

                        //====

                        // get score
                        String highscore = sp.getString("highscore", "0");
                        int Ihighscore = parseInt(highscore) + 100;
                        String newHighScore = new Integer(Ihighscore).toString();

                        editor.putString("highscore", newHighScore);
                        editor.apply();

                        String tagnewhighscore = "Score:" + " " + newHighScore;

                        textView18.setText(tagnewhighscore);


                        //
                    }
                    else if (textinputsecondary.equals("ايم")) {
                        editor.putString("textinput", "");
                        editor.apply();
                        input.setText("");
                        editor.putString("soundinput", "1");
                        editor.apply();
                    }

                    if (textinputsecondary.equals("لمبو") && !lockscore2.equals("1")) {
                        textView15.setText("ل");
                        textView14.setText("م");
                        textView16.setText("ب");
                        textView17.setText("و");
                        editor.putString("textinput", "");
                        editor.apply();
                        input.setText("");

                        //s:lock score for those answered [4]
                        editor.putString("lockscore2", "1");
                        editor.apply();
                        //====

                        // get score
                        String highscore = sp.getString("highscore", "0");
                        int Ihighscore = parseInt(highscore) + 100;
                        String newHighScore = new Integer(Ihighscore).toString();

                        editor.putString("highscore",newHighScore);
                        editor.apply();

                        String tagnewhighscore = "Score:" + " " + newHighScore;

                        textView18.setText(tagnewhighscore);


                        //


                    }
                    else if (textinputsecondary.equals("لمبو")) {
                        editor.putString("textinput", "");
                        editor.apply();
                        input.setText("");
                        editor.putString("soundinput", "1");
                        editor.apply();

                    }


                    if (textinputsecondary.equals("کودا") && !lockscore3.equals("1")) {
                        textView19.setText("ک");
                        textView17.setText("و");
                        textView20.setText("د");
                        textView21.setText("ا");
                        editor.putString("textinput", "");
                        editor.apply();
                        input.setText("");

                        //s:lock score for those answered [5]
                        editor.putString("lockscore3", "1");
                        editor.apply();
                        //====

                        // get score
                        String highscore = sp.getString("highscore", "0");
                        int Ihighscore = parseInt(highscore) + 100;
                        String newHighScore = new Integer(Ihighscore).toString();

                        editor.putString("highscore",newHighScore);
                        editor.apply();

                        String tagnewhighscore = "Score:" + " " + newHighScore;

                        textView18.setText(tagnewhighscore);


                        //

                    }
                    else if (textinputsecondary.equals("کودا")) {
                        editor.putString("textinput", "");
                        editor.apply();
                        input.setText("");
                        editor.putString("soundinput", "1");
                        editor.apply();

                    }

                    if (textinputsecondary.equals("ݢاجه") && !lockscore4.equals("1")) {
                        textView22.setText("ݢ");
                        textView21.setText("ا");
                        textView24.setText("ج");
                        textView25.setText("ه");
                        editor.putString("textinput", "");
                        editor.apply();
                        input.setText("");

                        //s:lock score for those answered [6]
                        editor.putString("lockscore4", "1");
                        editor.apply();
                        //====

                        // get score
                        String highscore = sp.getString("highscore", "0");
                        int Ihighscore = parseInt(highscore) + 100;
                        String newHighScore = new Integer(Ihighscore).toString();

                        editor.putString("highscore",newHighScore);
                        editor.apply();

                        String tagnewhighscore = "Score:" + " " + newHighScore;

                        textView18.setText(tagnewhighscore);


                        //


                    }
                    else if (textinputsecondary.equals("ݢاجه")) {
                        editor.putString("textinput", "");
                        editor.apply();
                        input.setText("");
                        editor.putString("soundinput", "1");
                        editor.apply();

                    }
//E:choice button on click

                    String soundinput;
                    int soundinputsecondary;

                    //S: Ascending Sounds on click
                    soundinput = sp.getString("soundinput", "1");
                    int soundinput2 = parseInt(soundinput);
                    soundinputsecondary = soundinput2 + 1;
                    String soundinputsecondary2 = new Integer(soundinputsecondary).toString();;

                    editor.putString("soundinput", soundinputsecondary2);
                    editor.apply();

                    if (soundinput2 == 1 && !textinputsecondary.equals("ايم") && !textinputsecondary.equals("لمبو") && !textinputsecondary.equals("کودا") && !textinputsecondary.equals("ݢاجه") ) {
                        //play music
                        note1.start();
                    }
                    else if (soundinput2 == 1) {
                        bingo1.start();
                        editor.putString("soundinput", "1");
                        editor.apply();
                    }

                    if (soundinput2 == 2 && !textinputsecondary.equals("ايم") && !textinputsecondary.equals("لمبو") && !textinputsecondary.equals("کودا") && !textinputsecondary.equals("ݢاجه") ) {
                        //play music
                        note2.start();
                    }
                    else if (soundinput2 == 2) {
                        bingo1.start();
                        editor.putString("soundinput", "1");
                        editor.apply();
                    }

                    if (soundinput2 == 3 && !textinputsecondary.equals("ايم") && !textinputsecondary.equals("لمبو") && !textinputsecondary.equals("کودا") && !textinputsecondary.equals("ݢاجه") ) {
                        //play music
                        note3.start();
                    }
                    else if (soundinput2 == 3) {
                        bingo1.start();
                        editor.putString("soundinput", "1");
                        editor.apply();
                    }

                    if (soundinput2 == 4 && !textinputsecondary.equals("ايم") && !textinputsecondary.equals("لمبو") && !textinputsecondary.equals("کودا") && !textinputsecondary.equals("ݢاجه") ) {
                        //play music
                        note4.start();
                    }
                    else if (soundinput2 == 4) {
                        bingo1.start();
                        editor.putString("soundinput", "1");
                        editor.apply();
                    }

                    if (soundinput2 == 5 && !textinputsecondary.equals("ايم") && !textinputsecondary.equals("لمبو") && !textinputsecondary.equals("کودا") && !textinputsecondary.equals("ݢاجه") ) {
                        //play music
                        note5.start();
                        editor.putString("textinput", "");
                        editor.apply();
                        input.setText("");
                        editor.putString("soundinput", "1");
                        editor.apply();
                    }
                    else if (soundinput2 == 5) {
                        bingo1.start();
                        editor.putString("soundinput", "1");
                        editor.apply();
                        editor.putString("textinput", "");
                        editor.apply();
                        input.setText("");

                    }
                }
            });
            choice10.setOnClickListener(new View.OnClickListener() {
                String textinputsecondary;

                @Override
                //button H
                public void onClick(View view) {
                    textinput = sp.getString("textinput", "");

                    //s:lock score for those answered [2]
                    String lockscore1 = sp.getString("lockscore1", "");
                    String lockscore2 = sp.getString("lockscore2", "");
                    String lockscore3 = sp.getString("lockscore3", "");
                    String lockscore4 = sp.getString("lockscore4", "");
                    //=

                    SharedPreferences.Editor editor = sp.edit();


                    //choice button on click
                    textinputsecondary = textinput + "ا";
                    editor.putString("textinput", textinputsecondary);
                    editor.apply();
                    input.setText(textinputsecondary);
                    if (textinputsecondary.equals("ايم") && !lockscore1.equals("1")) {
                        textView12.setText("ا");
                        textView13.setText("ي");
                        textView14.setText("م");
                        editor.putString("textinput", "");
                        editor.apply();
                        input.setText("");

                        String one = "1";
                        //s:lock score for those answered [3]
                        editor.putString("lockscore1", one);
                        editor.apply();

                        //====

                        // get score
                        String highscore = sp.getString("highscore", "0");
                        int Ihighscore = parseInt(highscore) + 100;
                        String newHighScore = new Integer(Ihighscore).toString();

                        editor.putString("highscore", newHighScore);
                        editor.apply();

                        String tagnewhighscore = "Score:" + " " + newHighScore;

                        textView18.setText(tagnewhighscore);


                        //
                    }
                    else if (textinputsecondary.equals("ايم")) {
                        editor.putString("textinput", "");
                        editor.apply();
                        input.setText("");
                        editor.putString("soundinput", "1");
                        editor.apply();
                    }

                    if (textinputsecondary.equals("لمبو") && !lockscore2.equals("1")) {
                        textView15.setText("ل");
                        textView14.setText("م");
                        textView16.setText("ب");
                        textView17.setText("و");
                        editor.putString("textinput", "");
                        editor.apply();
                        input.setText("");

                        //s:lock score for those answered [4]
                        editor.putString("lockscore2", "1");
                        editor.apply();
                        //====

                        // get score
                        String highscore = sp.getString("highscore", "0");
                        int Ihighscore = parseInt(highscore) + 100;
                        String newHighScore = new Integer(Ihighscore).toString();

                        editor.putString("highscore",newHighScore);
                        editor.apply();

                        String tagnewhighscore = "Score:" + " " + newHighScore;

                        textView18.setText(tagnewhighscore);


                        //


                    }
                    else if (textinputsecondary.equals("لمبو")) {
                        editor.putString("textinput", "");
                        editor.apply();
                        input.setText("");
                        editor.putString("soundinput", "1");
                        editor.apply();

                    }


                    if (textinputsecondary.equals("کودا") && !lockscore3.equals("1")) {
                        textView19.setText("ک");
                        textView17.setText("و");
                        textView20.setText("د");
                        textView21.setText("ا");
                        editor.putString("textinput", "");
                        editor.apply();
                        input.setText("");

                        //s:lock score for those answered [5]
                        editor.putString("lockscore3", "1");
                        editor.apply();
                        //====

                        // get score
                        String highscore = sp.getString("highscore", "0");
                        int Ihighscore = parseInt(highscore) + 100;
                        String newHighScore = new Integer(Ihighscore).toString();

                        editor.putString("highscore",newHighScore);
                        editor.apply();

                        String tagnewhighscore = "Score:" + " " + newHighScore;

                        textView18.setText(tagnewhighscore);


                        //

                    }
                    else if (textinputsecondary.equals("کودا")) {
                        editor.putString("textinput", "");
                        editor.apply();
                        input.setText("");
                        editor.putString("soundinput", "1");
                        editor.apply();

                    }

                    if (textinputsecondary.equals("ݢاجه") && !lockscore4.equals("1")) {
                        textView22.setText("ݢ");
                        textView21.setText("ا");
                        textView24.setText("ج");
                        textView25.setText("ه");
                        editor.putString("textinput", "");
                        editor.apply();
                        input.setText("");

                        //s:lock score for those answered [6]
                        editor.putString("lockscore4", "1");
                        editor.apply();
                        //====

                        // get score
                        String highscore = sp.getString("highscore", "0");
                        int Ihighscore = parseInt(highscore) + 100;
                        String newHighScore = new Integer(Ihighscore).toString();

                        editor.putString("highscore",newHighScore);
                        editor.apply();

                        String tagnewhighscore = "Score:" + " " + newHighScore;

                        textView18.setText(tagnewhighscore);


                        //


                    }
                    else if (textinputsecondary.equals("ݢاجه")) {
                        editor.putString("textinput", "");
                        editor.apply();
                        input.setText("");
                        editor.putString("soundinput", "1");
                        editor.apply();

                    }
//E:choice button on click

                    String soundinput;
                    int soundinputsecondary;

                    //S: Ascending Sounds on click
                    soundinput = sp.getString("soundinput", "1");
                    int soundinput2 = parseInt(soundinput);
                    soundinputsecondary = soundinput2 + 1;
                    String soundinputsecondary2 = new Integer(soundinputsecondary).toString();;

                    editor.putString("soundinput", soundinputsecondary2);
                    editor.apply();

                    if (soundinput2 == 1 && !textinputsecondary.equals("ايم") && !textinputsecondary.equals("لمبو") && !textinputsecondary.equals("کودا") && !textinputsecondary.equals("ݢاجه") ) {
                        //play music
                        note1.start();
                    }
                    else if (soundinput2 == 1) {
                        bingo1.start();
                        editor.putString("soundinput", "1");
                        editor.apply();
                    }

                    if (soundinput2 == 2 && !textinputsecondary.equals("ايم") && !textinputsecondary.equals("لمبو") && !textinputsecondary.equals("کودا") && !textinputsecondary.equals("ݢاجه") ) {
                        //play music
                        note2.start();
                    }
                    else if (soundinput2 == 2) {
                        bingo1.start();
                        editor.putString("soundinput", "1");
                        editor.apply();
                    }

                    if (soundinput2 == 3 && !textinputsecondary.equals("ايم") && !textinputsecondary.equals("لمبو") && !textinputsecondary.equals("کودا") && !textinputsecondary.equals("ݢاجه") ) {
                        //play music
                        note3.start();
                    }
                    else if (soundinput2 == 3) {
                        bingo1.start();
                        editor.putString("soundinput", "1");
                        editor.apply();
                    }

                    if (soundinput2 == 4 && !textinputsecondary.equals("ايم") && !textinputsecondary.equals("لمبو") && !textinputsecondary.equals("کودا") && !textinputsecondary.equals("ݢاجه") ) {
                        //play music
                        note4.start();
                    }
                    else if (soundinput2 == 4) {
                        bingo1.start();
                        editor.putString("soundinput", "1");
                        editor.apply();
                    }

                    if (soundinput2 == 5 && !textinputsecondary.equals("ايم") && !textinputsecondary.equals("لمبو") && !textinputsecondary.equals("کودا") && !textinputsecondary.equals("ݢاجه") ) {
                        //play music
                        note5.start();
                        editor.putString("textinput", "");
                        editor.apply();
                        input.setText("");
                        editor.putString("soundinput", "1");
                        editor.apply();
                    }
                    else if (soundinput2 == 5) {
                        bingo1.start();
                        editor.putString("soundinput", "1");
                        editor.apply();
                        editor.putString("textinput", "");
                        editor.apply();
                        input.setText("");

                    }
                }
            });
            choice11.setOnClickListener(new View.OnClickListener() {
                String textinputsecondary;

                @Override
                //button H
                public void onClick(View view) {
                    textinput = sp.getString("textinput", "");

                    //s:lock score for those answered [2]
                    String lockscore1 = sp.getString("lockscore1", "");
                    String lockscore2 = sp.getString("lockscore2", "");
                    String lockscore3 = sp.getString("lockscore3", "");
                    String lockscore4 = sp.getString("lockscore4", "");
                    //=

                    SharedPreferences.Editor editor = sp.edit();


                    //choice button on click
                    textinputsecondary = textinput + "ک";
                    editor.putString("textinput", textinputsecondary);
                    editor.apply();
                    input.setText(textinputsecondary);
                    if (textinputsecondary.equals("ايم") && !lockscore1.equals("1")) {
                        textView12.setText("ا");
                        textView13.setText("ي");
                        textView14.setText("م");
                        editor.putString("textinput", "");
                        editor.apply();
                        input.setText("");

                        String one = "1";
                        //s:lock score for those answered [3]
                        editor.putString("lockscore1", one);
                        editor.apply();

                        //====

                        // get score
                        String highscore = sp.getString("highscore", "0");
                        int Ihighscore = parseInt(highscore) + 100;
                        String newHighScore = new Integer(Ihighscore).toString();

                        editor.putString("highscore", newHighScore);
                        editor.apply();

                        String tagnewhighscore = "Score:" + " " + newHighScore;

                        textView18.setText(tagnewhighscore);


                        //
                    }
                    else if (textinputsecondary.equals("ايم")) {
                        editor.putString("textinput", "");
                        editor.apply();
                        input.setText("");
                        editor.putString("soundinput", "1");
                        editor.apply();
                    }

                    if (textinputsecondary.equals("لمبو") && !lockscore2.equals("1")) {
                        textView15.setText("ل");
                        textView14.setText("م");
                        textView16.setText("ب");
                        textView17.setText("و");
                        editor.putString("textinput", "");
                        editor.apply();
                        input.setText("");

                        //s:lock score for those answered [4]
                        editor.putString("lockscore2", "1");
                        editor.apply();
                        //====

                        // get score
                        String highscore = sp.getString("highscore", "0");
                        int Ihighscore = parseInt(highscore) + 100;
                        String newHighScore = new Integer(Ihighscore).toString();

                        editor.putString("highscore",newHighScore);
                        editor.apply();

                        String tagnewhighscore = "Score:" + " " + newHighScore;

                        textView18.setText(tagnewhighscore);


                        //


                    }
                    else if (textinputsecondary.equals("لمبو")) {
                        editor.putString("textinput", "");
                        editor.apply();
                        input.setText("");
                        editor.putString("soundinput", "1");
                        editor.apply();

                    }


                    if (textinputsecondary.equals("کودا") && !lockscore3.equals("1")) {
                        textView19.setText("ک");
                        textView17.setText("و");
                        textView20.setText("د");
                        textView21.setText("ا");
                        editor.putString("textinput", "");
                        editor.apply();
                        input.setText("");

                        //s:lock score for those answered [5]
                        editor.putString("lockscore3", "1");
                        editor.apply();
                        //====

                        // get score
                        String highscore = sp.getString("highscore", "0");
                        int Ihighscore = parseInt(highscore) + 100;
                        String newHighScore = new Integer(Ihighscore).toString();

                        editor.putString("highscore",newHighScore);
                        editor.apply();

                        String tagnewhighscore = "Score:" + " " + newHighScore;

                        textView18.setText(tagnewhighscore);


                        //

                    }
                    else if (textinputsecondary.equals("کودا")) {
                        editor.putString("textinput", "");
                        editor.apply();
                        input.setText("");
                        editor.putString("soundinput", "1");
                        editor.apply();

                    }

                    if (textinputsecondary.equals("ݢاجه") && !lockscore4.equals("1")) {
                        textView22.setText("ݢ");
                        textView21.setText("ا");
                        textView24.setText("ج");
                        textView25.setText("ه");
                        editor.putString("textinput", "");
                        editor.apply();
                        input.setText("");

                        //s:lock score for those answered [6]
                        editor.putString("lockscore4", "1");
                        editor.apply();
                        //====

                        // get score
                        String highscore = sp.getString("highscore", "0");
                        int Ihighscore = parseInt(highscore) + 100;
                        String newHighScore = new Integer(Ihighscore).toString();

                        editor.putString("highscore",newHighScore);
                        editor.apply();

                        String tagnewhighscore = "Score:" + " " + newHighScore;

                        textView18.setText(tagnewhighscore);


                        //


                    }
                    else if (textinputsecondary.equals("ݢاجه")) {
                        editor.putString("textinput", "");
                        editor.apply();
                        input.setText("");
                        editor.putString("soundinput", "1");
                        editor.apply();

                    }
//E:choice button on click

                    String soundinput;
                    int soundinputsecondary;

                    //S: Ascending Sounds on click
                    soundinput = sp.getString("soundinput", "1");
                    int soundinput2 = parseInt(soundinput);
                    soundinputsecondary = soundinput2 + 1;
                    String soundinputsecondary2 = new Integer(soundinputsecondary).toString();;

                    editor.putString("soundinput", soundinputsecondary2);
                    editor.apply();

                    if (soundinput2 == 1 && !textinputsecondary.equals("ايم") && !textinputsecondary.equals("لمبو") && !textinputsecondary.equals("کودا") && !textinputsecondary.equals("ݢاجه") ) {
                        //play music
                        note1.start();
                    }
                    else if (soundinput2 == 1) {
                        bingo1.start();
                        editor.putString("soundinput", "1");
                        editor.apply();
                    }

                    if (soundinput2 == 2 && !textinputsecondary.equals("ايم") && !textinputsecondary.equals("لمبو") && !textinputsecondary.equals("کودا") && !textinputsecondary.equals("ݢاجه") ) {
                        //play music
                        note2.start();
                    }
                    else if (soundinput2 == 2) {
                        bingo1.start();
                        editor.putString("soundinput", "1");
                        editor.apply();
                    }

                    if (soundinput2 == 3 && !textinputsecondary.equals("ايم") && !textinputsecondary.equals("لمبو") && !textinputsecondary.equals("کودا") && !textinputsecondary.equals("ݢاجه") ) {
                        //play music
                        note3.start();
                    }
                    else if (soundinput2 == 3) {
                        bingo1.start();
                        editor.putString("soundinput", "1");
                        editor.apply();
                    }

                    if (soundinput2 == 4 && !textinputsecondary.equals("ايم") && !textinputsecondary.equals("لمبو") && !textinputsecondary.equals("کودا") && !textinputsecondary.equals("ݢاجه") ) {
                        //play music
                        note4.start();
                    }
                    else if (soundinput2 == 4) {
                        bingo1.start();
                        editor.putString("soundinput", "1");
                        editor.apply();
                    }

                    if (soundinput2 == 5 && !textinputsecondary.equals("ايم") && !textinputsecondary.equals("لمبو") && !textinputsecondary.equals("کودا") && !textinputsecondary.equals("ݢاجه") ) {
                        //play music
                        note5.start();
                        editor.putString("textinput", "");
                        editor.apply();
                        input.setText("");
                        editor.putString("soundinput", "1");
                        editor.apply();
                    }
                    else if (soundinput2 == 5) {
                        bingo1.start();
                        editor.putString("soundinput", "1");
                        editor.apply();
                        editor.putString("textinput", "");
                        editor.apply();
                        input.setText("");

                    }
                }
            });


            dustbin.setOnClickListener(new View.OnClickListener() {
                String textinputsecondary;

                @Override
                //button Dustbin
                public void onClick(View view) {
                    textinput = "";
                    SharedPreferences.Editor editor = sp.edit();
                    textinputsecondary = textinput;
                    editor.putString("textinput", textinputsecondary);
                    editor.apply();
                    input.setText(textinputsecondary);

                    //s:sounds effects reset
                    editor.putString("soundinput", "1");
                    editor.apply();
                    //e:sounds effects reset

                }
            });

            ImageView close = findViewById(R.id.imageViewClose);

            close.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(Cw_haiwan.this, GameFragment.class);
                    startActivity(intent);
                }
            });

            ImageView next = findViewById(R.id.imageViewNext);

            next.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(Cw_haiwan.this, GameFragment.class);
                    startActivity(intent);
                }
            });


        }

        //full screen 3 of 3
        @Override
        public void onWindowFocusChanged(boolean hasFocus) {
            super.onWindowFocusChanged(hasFocus);
            if (hasFocus) {
                decorView.setSystemUiVisibility(hideSystemBars());
            }
        }

        private int hideSystemBars() {
            return View.SYSTEM_UI_FLAG_LAYOUT_STABLE
                    |View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY
                    |View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
                    |View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION
                    |View.SYSTEM_UI_FLAG_FULLSCREEN
                    |View.SYSTEM_UI_FLAG_HIDE_NAVIGATION;
        }
        //
    }