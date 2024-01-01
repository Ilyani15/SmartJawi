package com.example.smartjawi.Eja;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.media.MediaPlayer;
import android.net.ConnectivityManager;
import android.os.Build;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.DragEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;


import com.example.smartjawi.Eja.utils.Constant;
import com.example.smartjawi.R;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.concurrent.TimeUnit;

public class QuestionEjaActivity extends Activity implements View.OnTouchListener, View.OnDragListener {
    String[] questListEja;
    static int scoreEja, heartsEja;
    int qidEja = 0;
    String[] perfect_position_array_eja;
    String currentQ_Eja;
    String currentA_Eja;
    TextView timesEja, scoredEja;
    ImageView imgQuestionEja;
    public static Context contextstatEja;
    public static ProgressDialog pDialog_Eja;
    int widthEja;
    private float originalX = 0;
    private float originalY = 0;
    LinearLayout ans_eja_layout;
    LinearLayout placeholder_eja_LL;
    DisplayMetrics displayMetricsEja;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_question_eja);

        displayMetricsEja = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(displayMetricsEja);

        questListEja = Constant.imageQuestions;
        currentQ_Eja = Constant.imageQuestions[qidEja];
        currentA_Eja = Constant.questionsAnswers[qidEja];

        imgQuestionEja = (ImageView) findViewById(R.id.imgQuestionEja);
        scoredEja = (TextView) findViewById(R.id.scoreEja);
        scoreEja = 0;
        heartsEja = Constant.number_of_hearts;
        setHearts(heartsEja);
        timesEja = (TextView) findViewById(R.id.timerEja);

        setQuestionView();
        timesEja.setText("00:00:60");

        CounterClass timer = new CounterClass(Constant.time_inseconds * 1000, 1000);
        timer.start();
        getSharedPreferences("PREFERENCE", MODE_PRIVATE).edit().putBoolean("firstrun", true).apply();
        getSharedPreferences("PREFERENCE", MODE_PRIVATE).edit().putBoolean("firstrunhearts", true).apply();

        contextstatEja = QuestionEjaActivity.this;
        pDialog_Eja = new ProgressDialog(QuestionEjaActivity.this);
        pDialog_Eja.setCanceledOnTouchOutside(false);
        pDialog_Eja.setCancelable(false);
    }//oncreate

    public static int getMyValue() {
        return scoreEja;
    }
    public void getAnswer(String AnswerString) {
        if (AnswerString.equals("win")) {
            ans_eja_layout.removeAllViews();
            placeholder_eja_LL.removeAllViews();
            scoreEja++;
            scoredEja.setText(getString(R.string.score_eja) + " " + scoreEja);
        }
        if (qidEja < Constant.imageQuestions.length) {
            currentQ_Eja = Constant.imageQuestions[qidEja];
            currentA_Eja = Constant.questionsAnswers[qidEja];
            setQuestionView();
        } else {
            Intent intent = new Intent(QuestionEjaActivity.this, wonEja.class);
            Bundle b = new Bundle();
            b.putInt("score", scoreEja);
            intent.putExtras(b);
            startActivity(intent);
            finish();
        }
    }
    @TargetApi(Build.VERSION_CODES.GINGERBREAD)
    @SuppressLint("NewApi")
    public class CounterClass extends CountDownTimer {
        public CounterClass(long millisInFuture, long countDownInterval) {
            super(millisInFuture, countDownInterval);
        }
        @Override
        public void onFinish() {
            if (((ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE)).getActiveNetworkInfo() != null) {
                boolean firstrun = getSharedPreferences("PREFERENCE", MODE_PRIVATE).getBoolean("firstrun", true);
                if (firstrun) {
                    getSharedPreferences("PREFERENCE", MODE_PRIVATE)
                            .edit()
                            .putBoolean("firstrun", false).apply();
                    pDialog_Eja.setMessage(getString(R.string.loading));

                    if (!((Activity) QuestionEjaActivity.this).isFinishing()) {goToResultActivity();}
                }
            }
        }
        private void goToResultActivity() {
            Intent intent = new Intent(QuestionEjaActivity.this, ResultEjaActivity.class);
            Bundle b = new Bundle();
            b.putInt("score", scoreEja);
            intent.putExtras(b);
            startActivity(intent);
            finish();
        }
        @Override
        public void onTick(long millisUntilFinished) {
            long millis = millisUntilFinished;
            String hms = String.format("%02d:%02d:%02d", TimeUnit.MILLISECONDS.toHours(millis),
                    TimeUnit.MILLISECONDS.toMinutes(millis)
                            - TimeUnit.HOURS.toMinutes(TimeUnit.MILLISECONDS
                            .toHours(millis)),
                    TimeUnit.MILLISECONDS.toSeconds(millis)
                            - TimeUnit.MINUTES.toSeconds(TimeUnit.MILLISECONDS
                            .toMinutes(millis)));
            System.out.println(hms);
            timesEja.setText(hms);
        }
    }
    public void setHearts(int nhearts) {
        final LinearLayout linear_hearts = (LinearLayout) findViewById(R.id.linear_hearts_eja);
        linear_hearts.removeAllViews();
        int total_hearts = Constant.number_of_hearts;
        for (int i = 1; i <= total_hearts; i++) {
            ImageView iv = new ImageView(getApplicationContext());
            if (i <= nhearts) {
                iv.setImageDrawable(getDrawable(R.drawable.hearts));
            } else {
                iv.setImageDrawable(getDrawable(R.drawable.hearts_empty));
            }
            LinearLayout.LayoutParams lp = new LinearLayout.LayoutParams(80, 80);
            iv.setLayoutParams(lp);
            linear_hearts.addView(iv);
        }
    }
    private void setQuestionView() {
        perfect_position_array_eja = new String[currentA_Eja.length()];
        if (currentA_Eja.length() < 7) {
            widthEja = displayMetricsEja.widthPixels / 7;
        } else {
            widthEja = displayMetricsEja.widthPixels / currentA_Eja.length();
        }
        imgQuestionEja.setImageDrawable(getDrawable(this.getResources().getIdentifier(currentQ_Eja, "drawable", this.getPackageName())));
        final LinearLayout answers_linearLayout = (LinearLayout) findViewById(R.id.answers_eja_LL);
        ans_eja_layout = (LinearLayout) findViewById(R.id.answer_eja_layout);
        answers_linearLayout.setOnDragListener(this);

        ImageView[] imageArray = new ImageView[currentA_Eja.length()];

        for (int i = 0; i < currentA_Eja.length(); i++) {
            ImageView iv = new ImageView(getApplicationContext());
            iv.setId(i);
            iv.setImageDrawable(getDrawable(this.getResources().getIdentifier(currentA_Eja.charAt(i) + "", "drawable", this.getPackageName())));
            LinearLayout.LayoutParams lp = new LinearLayout.LayoutParams(widthEja, widthEja);
            iv.setLayoutParams(lp);
            iv.setOnTouchListener(this);
            iv.setOnDragListener(this);
            imageArray[i] = iv;
            // perfect_position_array[i]=currentA.charAt(i)+","+iv.getId()*width;
            int iddd = 9999;
            int idd = iv.getId() + iddd;
            perfect_position_array_eja[i] = currentA_Eja.charAt(i) + "," + idd;
        }

        shuffleArray(imageArray);
        for (int i = 0; i < imageArray.length; i++) {
            ans_eja_layout.addView(imageArray[i]);
        }
        placeholder_eja_LL = (LinearLayout) findViewById(R.id.placeholder_eja_LL);
        for (int i = 0; i < currentA_Eja.length(); i++) {
            LinearLayout ln = new LinearLayout(getApplicationContext());
            ln.setBackground(getDrawable(R.drawable.placeholder));
            ln.setId(9999 + i);
            LinearLayout.LayoutParams lp = new LinearLayout.LayoutParams(widthEja, widthEja);
            ln.setLayoutParams(lp);
            ln.setOnDragListener(this);
            placeholder_eja_LL.addView(ln);
        }
        qidEja++;
    }
    static void shuffleArray(ImageView[] arr) {
        Random rnd = new Random();
        for (int i = arr.length - 1; i > 0; i--) {
            int index = rnd.nextInt(i + 1);
            // Swap
            ImageView a = arr[index];
            arr[index] = arr[i];
            arr[i] = a;
        }
    }
    public boolean onTouch(View view, MotionEvent motionEvent) {
        if (motionEvent.getAction() == MotionEvent.ACTION_DOWN) {
            originalX = motionEvent.getX();
            originalY = motionEvent.getY();
            int id = view.getId();
            View.DragShadowBuilder shadowBuilder = new View.DragShadowBuilder(view);
            view.startDrag(null, shadowBuilder, view, 0);
            // view.setVisibility(View.INVISIBLE);
            return true;
        } else {
            return false;
        }
    }
    @SuppressLint("ResourceType")
    @Override
    public boolean onDrag(View layoutview, DragEvent dragevent) {

        View vvv = (View) dragevent.getLocalState();
        int img_id = vvv.getId();
        int perfect_position = img_id * widthEja;

        int action = dragevent.getAction();
        View view = (View) dragevent.getLocalState();

        switch (action) {
            case DragEvent.ACTION_DRAG_STARTED:
                view.setVisibility(View.INVISIBLE);
                break;
            case DragEvent.ACTION_DRAG_ENTERED:
                Log.d("perfect_position_array", "arr: " + Arrays.toString(perfect_position_array_eja));
                Log.d("perfect_position_array", "arr: " + layoutview.getId() + "");

                if (Arrays.asList(perfect_position_array_eja).contains(currentA_Eja.charAt(img_id) + "," + (int) layoutview.getId())
                        && (layoutview.getId() >= 9999 && layoutview.getId() <= (9999 + currentA_Eja.length()))) {
                    layoutview.setBackground(getDrawable(R.drawable.placeholder_true));
                } else if (!Arrays.asList(perfect_position_array_eja).contains(currentA_Eja.charAt(img_id) + "," + (int) layoutview.getId())
                        && (layoutview.getId() >= 9999 && layoutview.getId() <= (9999 + currentA_Eja.length()))) {
                    layoutview.setBackground(getDrawable(R.drawable.placeholder_wrong));
                }
                break;
            case DragEvent.ACTION_DRAG_EXITED:
                if ((layoutview.getId() >= 9999 && layoutview.getId() <= (9999 + currentA_Eja.length()))) {
                    layoutview.setBackground(getDrawable(R.drawable.placeholder));
                }
                break;
            case DragEvent.ACTION_DROP:
                if ((layoutview.getId() >= 9999 && layoutview.getId() <= (9999 + currentA_Eja.length()))) {
                    layoutview.setBackground(getDrawable(R.drawable.placeholder));
                }

                int childCount = ((ViewGroup) ans_eja_layout).getChildCount();
                ViewGroup owner = (ViewGroup) view.getParent();
                if (Arrays.asList(perfect_position_array_eja).contains(currentA_Eja.charAt(img_id) + "," + (int) layoutview.getId())
                        && (layoutview.getId() >= 9999 && layoutview.getId() <= (9999 + currentA_Eja.length()))) {
                    List<String> list = new ArrayList<String>(Arrays.asList(perfect_position_array_eja));
                    list.remove(currentA_Eja.charAt(img_id) + "," + (int) layoutview.getId());
                    perfect_position_array_eja = list.toArray(new String[0]);

                    owner.removeView(view);
                    LinearLayout container = (LinearLayout) layoutview;
                    container.addView(view);
                    if (container.getId() >= 9999) {
                        view.setOnTouchListener(null);
                        owner.setOnDragListener(null);
                    }
                    MediaPlayer player = MediaPlayer.create(this, R.raw.correct);
                    player.setVolume(100, 100);
                    player.start();
                } else {
                    heartsEja--;
                    if (heartsEja > 0) {
                        MediaPlayer player = MediaPlayer.create(this, R.raw.wrong);
                        player.setVolume(100, 100);
                        player.start();
                        setHearts(heartsEja);
                    } else {
                        Intent intent = new Intent(QuestionEjaActivity.this, ResultEjaActivity.class);
                        Bundle b = new Bundle();
                        b.putInt("score", scoreEja);
                        intent.putExtras(b);
                        startActivity(intent);
                        finish();
                    }//else hearts =0
                }
                if (childCount == 1) {
                    ImageView iv = new ImageView(getApplicationContext());
                    iv.setImageDrawable(getResources().getDrawable(R.drawable.tahniah));
                    LinearLayout.LayoutParams lp = new LinearLayout.LayoutParams(widthEja, widthEja);
                    iv.setLayoutParams(lp);
                    iv.setOnTouchListener(this);
                    iv.setOnDragListener(this);
                    ans_eja_layout.addView(iv);
                    getAnswer("win");
                }
                break;
            case DragEvent.ACTION_DRAG_ENDED:
                // view.setVisibility(View.VISIBLE);
                view.post(new Runnable() {
                    @Override
                    public void run() {
                        view.setVisibility(View.VISIBLE);
                    }
                });
                break;
            default:
                break;
        } return true;
    }
}