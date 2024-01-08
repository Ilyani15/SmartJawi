package com.example.smartjawi.Game.MG;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.res.ColorStateList;
import android.graphics.Color;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.os.Handler;
import android.view.MotionEvent;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.smartjawi.R;
import com.google.firebase.FirebaseApp;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

import java.util.Arrays;
import java.util.Collections;
import java.util.Locale;

public class Mg_Game_Buah extends AppCompatActivity {


    TextView textViewCountDown, moves;
    ImageView iv_11, iv_12, iv_13, iv_14, iv_21, iv_22, iv_23, iv_24, iv_31, iv_32, iv_33, iv_34,iv_41, iv_42, iv_43, iv_44, close, refresh;

    //actual images
    int img101, img102, img103, img104, img105, img106,img107,img108, img201, img202, img203, img204, img205, img206, img207, img208;

    Integer[] cardsArray = {101, 102, 103, 104, 105, 106,107,108, 201, 202, 203, 204, 205, 206,207,208};

    private static final long COUNTDOWN_IN_MILLIS = 120000;
    private long timeLeftInMillis;
    private CountDownTimer countDownTimer;
    private int currentLevel = 1;
    private ColorStateList textColorDefaultCd;




    int firstCard, secondCard;
    int clickedFirst, clickedSecond;
    int cardNumber = 1;
    int moveCount = 0;

    int result = 0;

    ImageButton btn_music;
    private boolean isResume;
    Animation scaleUp,scaleDown, animation;

    private FirebaseAuth mAuth;
    /*private DatabaseReference reference;
    DataSnapshot dataSnapshot;*/



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mg_game_buah);
        textViewCountDown = findViewById(R.id.time_bar_text);
        close = findViewById(R.id.close);
        refresh = findViewById(R.id.refresh);
        final MediaPlayer mediaPlayer = MediaPlayer.create(this,R.raw.flip_sound);
        final MediaPlayer match = MediaPlayer.create(this,R.raw.match);
        final MediaPlayer click = MediaPlayer.create(this,R.raw.click);
        scaleUp = AnimationUtils.loadAnimation(this,R.anim.scale_up);
        scaleDown = AnimationUtils.loadAnimation(this,R.anim.scale_down);
        textColorDefaultCd = textViewCountDown.getTextColors();
        timeLeftInMillis = COUNTDOWN_IN_MILLIS;
        moves = findViewById(R.id.moves);
        mAuth = FirebaseAuth.getInstance();
        FirebaseApp.initializeApp(this);

        close.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {


                if(motionEvent.getAction()==MotionEvent.ACTION_DOWN){
                    click.start();
                    close.startAnimation(scaleUp);


                } else if (motionEvent.getAction()==MotionEvent.ACTION_UP) {
                    close.startAnimation(scaleDown);
                }
                startActivity(new Intent(getApplicationContext(), FirstMG.class));

                return true;
            }
        });


        refresh.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getApplicationContext(), Mg_Game_Buah.class) );

            }
        });




        //start activity
        setTag();
        frontOfCardResources();
        startCountDown();
        //shuffle the images
        Collections.shuffle(Arrays.asList(cardsArray));




        iv_11.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int theCard = Integer.parseInt((String) view.getTag());

                mediaPlayer.start();
                doStuff(iv_11, theCard);

            }
        });

        iv_12.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                int theCard = Integer.parseInt((String) view.getTag());
                mediaPlayer.start();
                doStuff(iv_12, theCard);
            }
        });

        iv_13.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int theCard = Integer.parseInt((String) view.getTag());
                mediaPlayer.start();
                doStuff(iv_13, theCard);
            }
        });

        iv_14.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int theCard = Integer.parseInt((String) view.getTag());
                mediaPlayer.start();
                doStuff(iv_14, theCard);
            }
        });

        iv_21.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int theCard = Integer.parseInt((String) view.getTag());
                mediaPlayer.start();
                doStuff(iv_21, theCard);
            }
        });

        iv_22.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int theCard = Integer.parseInt((String) view.getTag());
                mediaPlayer.start();
                doStuff(iv_22, theCard);
            }
        });

        iv_23.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int theCard = Integer.parseInt((String) view.getTag());
                mediaPlayer.start();
                doStuff(iv_23, theCard);
            }
        });

        iv_24.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int theCard = Integer.parseInt((String) view.getTag());
                mediaPlayer.start();
                doStuff(iv_24, theCard);
            }
        });

        iv_31.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int theCard = Integer.parseInt((String) view.getTag());
                mediaPlayer.start();
                doStuff(iv_31, theCard);
            }
        });

        iv_32.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int theCard = Integer.parseInt((String) view.getTag());
                mediaPlayer.start();
                doStuff(iv_32, theCard);
            }
        });

        iv_33.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int theCard = Integer.parseInt((String) view.getTag());
                mediaPlayer.start();
                doStuff(iv_33, theCard);
            }
        });

        iv_34.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int theCard = Integer.parseInt((String) view.getTag());
                mediaPlayer.start();
                doStuff(iv_34, theCard);
            }
        });

        iv_41.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int theCard = Integer.parseInt((String) view.getTag());
                mediaPlayer.start();
                doStuff(iv_41, theCard);
            }
        });

        iv_42.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int theCard = Integer.parseInt((String) view.getTag());
                mediaPlayer.start();
                doStuff(iv_42, theCard);
            }
        });

        iv_43.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int theCard = Integer.parseInt((String) view.getTag());
                mediaPlayer.start();
                doStuff(iv_43, theCard);
            }
        });

        iv_44.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int theCard = Integer.parseInt((String) view.getTag());
                mediaPlayer.start();
                doStuff(iv_44, theCard);
            }
        });
    }

    private void  doStuff(ImageView iv, int card){

        //set the correct image to the imageView
        if (cardsArray[card] == 101) {
            iv.setImageResource(img101);
        } else if (cardsArray[card] == 102) {
            iv.setImageResource(img102);
        } else if (cardsArray[card] == 103) {
            iv.setImageResource(img103);
        } else if (cardsArray[card] == 104) {
            iv.setImageResource(img104);
        } else if (cardsArray[card] == 105) {
            iv.setImageResource(img105);
        } else if (cardsArray[card] == 106) {
            iv.setImageResource(img106);
        } else if (cardsArray[card] == 107) {
            iv.setImageResource(img107);
        } else if (cardsArray[card] == 108) {
            iv.setImageResource(img108);
        } else if (cardsArray[card] == 201) {
            iv.setImageResource(img201);
        } else if (cardsArray[card] == 202) {
            iv.setImageResource(img202);
        } else if (cardsArray[card] == 203) {
            iv.setImageResource(img203);
        } else if (cardsArray[card] == 204) {
            iv.setImageResource(img204);
        } else if (cardsArray[card] == 205) {
            iv.setImageResource(img205);
        } else if (cardsArray[card] == 206) {
            iv.setImageResource(img206);
        } else if (cardsArray[card] == 207) {
            iv.setImageResource(img207);
        } else if (cardsArray[card] == 208) {
            iv.setImageResource(img208);
        }
        //check which image is selected and save it to temporary variable
        if(cardNumber == 1){
            firstCard = cardsArray[card];
            if(firstCard > 200) {
                firstCard = firstCard - 100;
            }
            cardNumber = 2;
            clickedFirst = card;

            iv.setEnabled(false);
        } else if (cardNumber == 2) {

            secondCard = cardsArray[card];
            if(secondCard > 200) {
                secondCard = secondCard - 100;
            }
            cardNumber = 1;
            clickedSecond = card;

            iv_11.setEnabled(false);
            iv_12.setEnabled(false);
            iv_13.setEnabled(false);
            iv_14.setEnabled(false);

            iv_21.setEnabled(false);
            iv_22.setEnabled(false);
            iv_23.setEnabled(false);
            iv_24.setEnabled(false);

            iv_31.setEnabled(false);
            iv_32.setEnabled(false);
            iv_33.setEnabled(false);
            iv_34.setEnabled(false);

            iv_41.setEnabled(false);
            iv_42.setEnabled(false);
            iv_43.setEnabled(false);
            iv_44.setEnabled(false);

            Handler handler = new Handler();
            handler.postDelayed(new Runnable() {
                @Override
                public void run() {
                    //check if the selected images are equal
                    calculate();
                }
            }, 1000);
        }

    }


    @SuppressLint("SetTextI18n")
    private void calculate() {

        final MediaPlayer match = MediaPlayer.create(this,R.raw.match);
        animation = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.horizontal_shake);
        //if images are equal, remove them
        if (firstCard == secondCard) {
            match.start();
            if (clickedFirst == 0) {
                iv_11.setAnimation(animation);
                iv_11.setVisibility(View.INVISIBLE);
            } else if (clickedFirst == 1) {
                iv_12.setAnimation(animation);
                iv_12.setVisibility(View.INVISIBLE);
            } else if (clickedFirst == 2) {
                iv_13.setAnimation(animation);
                iv_13.setVisibility(View.INVISIBLE);
            } else if (clickedFirst == 3) {
                iv_14.setAnimation(animation);
                iv_14.setVisibility(View.INVISIBLE);
            } else if (clickedFirst == 4) {
                iv_21.setAnimation(animation);
                iv_21.setVisibility(View.INVISIBLE);
            } else if (clickedFirst == 5) {
                iv_22.setAnimation(animation);
                iv_22.setVisibility(View.INVISIBLE);
            } else if (clickedFirst == 6) {
                iv_23.setAnimation(animation);
                iv_23.setVisibility(View.INVISIBLE);
            } else if (clickedFirst == 7) {
                iv_24.setAnimation(animation);
                iv_24.setVisibility(View.INVISIBLE);
            } else if (clickedFirst == 8) {
                iv_31.setAnimation(animation);
                iv_31.setVisibility(View.INVISIBLE);
            } else if (clickedFirst == 9) {
                iv_32.setAnimation(animation);
                iv_32.setVisibility(View.INVISIBLE);
            } else if (clickedFirst == 10) {
                iv_33.setAnimation(animation);
                iv_33.setVisibility(View.INVISIBLE);
            } else if (clickedFirst == 11) {
                iv_34.setAnimation(animation);
                iv_34.setVisibility(View.INVISIBLE);
            } else if (clickedFirst == 12) {
                iv_41.setAnimation(animation);
                iv_41.setVisibility(View.INVISIBLE);
            } else if (clickedFirst == 13) {
                iv_42.setAnimation(animation);
                iv_42.setVisibility(View.INVISIBLE);
            } else if (clickedFirst == 14) {
                iv_43.setAnimation(animation);
                iv_43.setVisibility(View.INVISIBLE);
            } else if (clickedFirst == 15) {
                iv_44.setAnimation(animation);
                iv_44.setVisibility(View.INVISIBLE);
            }

            if (clickedSecond == 0) {
                iv_11.setAnimation(animation);
                iv_11.setVisibility(View.INVISIBLE);
            } else if (clickedSecond == 1) {
                iv_12.setAnimation(animation);
                iv_12.setVisibility(View.INVISIBLE);
            } else if (clickedSecond == 2) {
                iv_13.setAnimation(animation);
                iv_13.setVisibility(View.INVISIBLE);
            } else if (clickedSecond == 3) {
                iv_14.setAnimation(animation);
                iv_14.setVisibility(View.INVISIBLE);
            } else if (clickedSecond == 4) {
                iv_21.setAnimation(animation);
                iv_21.setVisibility(View.INVISIBLE);
            } else if (clickedSecond == 5) {
                iv_22.setAnimation(animation);
                iv_22.setVisibility(View.INVISIBLE);
            } else if (clickedSecond == 6) {
                iv_23.setAnimation(animation);
                iv_23.setVisibility(View.INVISIBLE);
            } else if (clickedSecond == 7) {
                iv_24.setAnimation(animation);
                iv_24.setVisibility(View.INVISIBLE);
            } else if (clickedSecond == 8) {
                iv_31.setAnimation(animation);
                iv_31.setVisibility(View.INVISIBLE);
            } else if (clickedSecond == 9) {
                iv_32.setAnimation(animation);
                iv_32.setVisibility(View.INVISIBLE);
            } else if (clickedSecond == 10) {
                iv_33.setAnimation(animation);
                iv_33.setVisibility(View.INVISIBLE);
            } else if (clickedSecond == 11) {
                iv_34.setAnimation(animation);
                iv_34.setVisibility(View.INVISIBLE);
            } else if (clickedSecond == 12) {
                iv_41.setAnimation(animation);
                iv_41.setVisibility(View.INVISIBLE);
            } else if (clickedSecond == 13) {
                iv_42.setAnimation(animation);
                iv_42.setVisibility(View.INVISIBLE);
            } else if (clickedSecond == 14) {
                iv_43.setAnimation(animation);
                iv_43.setVisibility(View.INVISIBLE);
            } else if (clickedSecond == 15) {
                iv_44.setAnimation(animation);
                iv_44.setVisibility(View.INVISIBLE);
            }

            moveCount ++;
            moves.setText("Moves:" + moveCount);
        } else {

            moveCount ++;
            moves.setText("Moves:" + moveCount);

            iv_11.setImageResource(R.drawable.starter);
            iv_12.setImageResource(R.drawable.starter);
            iv_13.setImageResource(R.drawable.starter);
            iv_14.setImageResource(R.drawable.starter);

            iv_21.setImageResource(R.drawable.starter);
            iv_22.setImageResource(R.drawable.starter);
            iv_23.setImageResource(R.drawable.starter);
            iv_24.setImageResource(R.drawable.starter);

            iv_31.setImageResource(R.drawable.starter);
            iv_32.setImageResource(R.drawable.starter);
            iv_33.setImageResource(R.drawable.starter);
            iv_34.setImageResource(R.drawable.starter);

            iv_41.setImageResource(R.drawable.starter);
            iv_42.setImageResource(R.drawable.starter);
            iv_43.setImageResource(R.drawable.starter);
            iv_44.setImageResource(R.drawable.starter);


        }

        iv_11.setEnabled(true);
        iv_12.setEnabled(true);
        iv_13.setEnabled(true);
        iv_14.setEnabled(true);

        iv_21.setEnabled(true);
        iv_22.setEnabled(true);
        iv_23.setEnabled(true);
        iv_24.setEnabled(true);

        iv_31.setEnabled(true);
        iv_32.setEnabled(true);
        iv_33.setEnabled(true);
        iv_34.setEnabled(true);

        iv_41.setEnabled(true);
        iv_42.setEnabled(true);
        iv_43.setEnabled(true);
        iv_44.setEnabled(true);

        //check if the game is over
        checkEnd();

        if (iv_11.getVisibility() == View.INVISIBLE &&
                iv_12.getVisibility() == View.INVISIBLE &&
                iv_13.getVisibility() == View.INVISIBLE &&
                iv_14.getVisibility() == View.INVISIBLE &&

                iv_21.getVisibility() == View.INVISIBLE &&
                iv_22.getVisibility() == View.INVISIBLE &&
                iv_23.getVisibility() == View.INVISIBLE &&
                iv_24.getVisibility() == View.INVISIBLE &&

                iv_31.getVisibility() == View.INVISIBLE &&
                iv_32.getVisibility() == View.INVISIBLE &&
                iv_33.getVisibility() == View.INVISIBLE &&
                iv_34.getVisibility() == View.INVISIBLE &&

                iv_41.getVisibility() == View.INVISIBLE &&
                iv_42.getVisibility() == View.INVISIBLE &&
                iv_43.getVisibility() == View.INVISIBLE &&
                iv_44.getVisibility() == View.INVISIBLE) {

            // Calculate the remaining time in seconds
            long remainingSeconds = timeLeftInMillis / 1000;

            // Update Kad Mudah based on conditions
            if (remainingSeconds >= 60 && moveCount <= 25) {
                //updateKadMudah(3);
                result = result + 100;
            } else if (remainingSeconds >= 45  && moveCount <= 35) {
                //updateKadMudah(2);
                result = result + 75;
            } else if (remainingSeconds >= 30 && moveCount <= 45) {
                //updateKadMudah(1);
                result = result + 50;
            } else if (remainingSeconds >= 15 && moveCount <= 55) {
                //updateKadMudah(1);
                result = result + 25;
            } else if (remainingSeconds >= 0 && moveCount <= 70) {
                result = result + 0;
            }
        }
    }


    // Method to update "Kad Mudah" in the Firebase database
    /*private void updateKadMudah(int value) {
        FirebaseUser currentUser = mAuth.getCurrentUser();
        if (currentUser != null) {
            DatabaseReference reference = FirebaseDatabase.getInstance().getReference("Pengguna")
                    .child(currentUser.getUid())
                    .child("Kad Mudah");

            // Update the value in the database
            reference.setValue(value);
        }

    }*/
    private void  checkEnd(){
        if(iv_11.getVisibility() == View.INVISIBLE &&
                iv_12.getVisibility() == View.INVISIBLE &&
                iv_13.getVisibility() == View.INVISIBLE &&
                iv_14.getVisibility() == View.INVISIBLE &&

                iv_21.getVisibility() == View.INVISIBLE &&
                iv_22.getVisibility() == View.INVISIBLE &&
                iv_23.getVisibility() == View.INVISIBLE &&
                iv_24.getVisibility() == View.INVISIBLE &&

                iv_31.getVisibility() == View.INVISIBLE &&
                iv_32.getVisibility() == View.INVISIBLE &&
                iv_33.getVisibility() == View.INVISIBLE &&
                iv_34.getVisibility() == View.INVISIBLE &&

                iv_41.getVisibility() == View.INVISIBLE &&
                iv_42.getVisibility() == View.INVISIBLE &&
                iv_43.getVisibility() == View.INVISIBLE &&
                iv_44.getVisibility() == View.INVISIBLE){

            countDownTimer.cancel();

            AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(Mg_Game_Buah.this);
            alertDialogBuilder
                    .setMessage("Tahniah" )
                    .setCancelable(false)
                    .setPositiveButton("View Result", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialogInterface, int i) {
                            Intent intent = new Intent(getApplicationContext(), Mg_Result_Warna.class);
                            intent.putExtra("RA", result);
                            startActivity(intent);
                            finish();
                        }
                    })
                    .setNegativeButton("New Game", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialogInterface, int i) {
                            Intent intent = new Intent(getApplicationContext(), Mg_Game_Buah.class);
                            startActivity(intent);
                            finish();
                        }
                    });
            AlertDialog alertDialog = alertDialogBuilder.create();
            alertDialog.show();
        }
    }
    private void frontOfCardResources(){
        img101 = R.drawable.mg_anggur1;
        img102 = R.drawable.mg_epal1;
        img103 = R.drawable.mg_ceri1;
        img104 = R.drawable.mg_jagung1;
        img105 = R.drawable.mg_labu1;
        img106 = R.drawable.mg_nenas1;
        img107 = R.drawable.mg_oren1;
        img108 = R.drawable.mg_mangga1;

        img201 = R.drawable.mg_anggur2;
        img202 = R.drawable.mg_epal2;
        img203 = R.drawable.mg_ceri2;
        img204 = R.drawable.mg_jagung2;
        img205 = R.drawable.mg_labu2;
        img206 = R.drawable.mg_nenas2;
        img207 = R.drawable.mg_oren2;
        img208 = R.drawable.mg_mangga2;


    }

    private void startCountDown() {
        countDownTimer = new CountDownTimer(timeLeftInMillis, 1000) {
            @Override
            public void onTick(long millisUntilFinished) {
                timeLeftInMillis = millisUntilFinished;
                updateCountDownText();
            }

            @Override
            public void onFinish() {
                timeLeftInMillis = 0;
                updateCountDownText();
                AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(Mg_Game_Buah.this);
                alertDialogBuilder
                        .setMessage("Anda Kalah. Jangan berputus Asa. Cuba Lagi\n" )
                        .setCancelable(false)
                        .setPositiveButton("NEW", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                Intent intent = new Intent(getApplicationContext(), Mg_Game_Buah.class);
                                startActivity(intent);
                                finish();
                            }
                        })
                        .setNegativeButton("EXIT", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                Intent intent = new Intent(getApplicationContext(), FirstMG.class);
                                startActivity(intent);
                                finish();
                            }
                        });
                AlertDialog alertDialog = alertDialogBuilder.create();
                alertDialog.show();
            }
        }.start();
    }

    private void updateCountDownText(){


        int minutes = (int) (timeLeftInMillis/1000)/60;
        int seconds = (int) (timeLeftInMillis/1000)%60;

        String timeFormatted = String.format(Locale.getDefault(), "%02d:%02d", minutes, seconds);

        textViewCountDown.setText(timeFormatted);


        if (timeLeftInMillis < 15000) {
            textViewCountDown.setTextColor(Color.RED);
            textViewCountDown.setTextSize(25);
        }


    }
    protected void onDestroy(){
        super.onDestroy();
        if(countDownTimer!= null){
            countDownTimer.cancel();
        }
    }

    private void setTag(){
        iv_11 = (ImageView) findViewById(R.id.iv_11);
        iv_12 = (ImageView) findViewById(R.id.iv_12);
        iv_13 = (ImageView) findViewById(R.id.iv_13);
        iv_14 = (ImageView) findViewById(R.id.iv_14);

        iv_21 = (ImageView) findViewById(R.id.iv_21);
        iv_22 = (ImageView) findViewById(R.id.iv_22);
        iv_23 = (ImageView) findViewById(R.id.iv_23);
        iv_24 = (ImageView) findViewById(R.id.iv_24);

        iv_31 = (ImageView) findViewById(R.id.iv_31);
        iv_32 = (ImageView) findViewById(R.id.iv_32);
        iv_33 = (ImageView) findViewById(R.id.iv_33);
        iv_34 = (ImageView) findViewById(R.id.iv_34);

        iv_41 = (ImageView) findViewById(R.id.iv_41);
        iv_42 = (ImageView) findViewById(R.id.iv_42);
        iv_43 = (ImageView) findViewById(R.id.iv_43);
        iv_44 = (ImageView) findViewById(R.id.iv_44);


        iv_11.setTag("0");
        iv_12.setTag("1");
        iv_13.setTag("2");
        iv_14.setTag("3");

        iv_21.setTag("4");
        iv_22.setTag("5");
        iv_23.setTag("6");
        iv_24.setTag("7");

        iv_31.setTag("8");
        iv_32.setTag("9");
        iv_33.setTag("10");
        iv_34.setTag("11");

        iv_41.setTag("12");
        iv_42.setTag("13");
        iv_43.setTag("14");
        iv_44.setTag("15");

    }



}