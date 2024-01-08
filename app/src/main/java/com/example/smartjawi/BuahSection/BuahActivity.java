package com.example.smartjawi.BuahSection;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentTransaction;
import androidx.viewpager2.widget.ViewPager2;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

import com.example.smartjawi.Fragments.BelajarFragment;
import com.example.smartjawi.HaiwanSection.VPAdapterHaiwan;
import com.example.smartjawi.HaiwanSection.VPItemHaiwan;
import com.example.smartjawi.R;

import java.util.ArrayList;

public class BuahActivity extends AppCompatActivity {

    ViewPager2 viewPager2hijaiyah;
    ArrayList<VPItemHaiwan> viewPagerItemWarnaArrayList;
    private MediaPlayer mediaPlayerHijaiyah;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hijaiyah);

        viewPager2hijaiyah = findViewById(R.id.vpHijaiyah);
        int[] imagesHijaiyah = {R.drawable.dragonfruit, R.drawable.corn, R.drawable.cherries, R.drawable.banana, R.drawable.apple, R.drawable.orange, R.drawable.mango, R.drawable.kiwi, R.drawable.grapes, R.drawable.durian, R.drawable.cabbage, R.drawable.bellpepper, R.drawable.watermelon, R.drawable.strawberry, R.drawable.pineapple, R.drawable.potato, R.drawable.pea, R.drawable.garlic, R.drawable.eggplant, R.drawable.carrot, R.drawable.tomato, R.drawable.spinach, R.drawable.pumpkin};
        String[] headingHijaiyah = {"بواە ناݢ", "جاݢوڠ", "بواە ", "بواە ڤيسڠ", "بواە ايڤل", "بواە اورين", "بواە مڠݢا","بواە کيوي", "بواە اڠݢور","بواە دورين","سايور کوبيس","لادا بسر","بواە تمبيکاي","بواە ستروبيري","بواە نانس","اوبي کنتڠ","کاچڠ هيجاو","باواڠ ڤوتيه","تروڠ","لوبق ميرە","بواە توماتو","سايور ساوي","بواە لابو"};


        viewPagerItemWarnaArrayList = new ArrayList<>();
        for (int i = 0; i < imagesHijaiyah.length; i++) {
            VPItemHaiwan viewPagerItemHijaiyah = new VPItemHaiwan(imagesHijaiyah[i], headingHijaiyah[i]);
            viewPagerItemWarnaArrayList.add(viewPagerItemHijaiyah);
        }

        VPAdapterHaiwan VPAdapterHaiwan = new VPAdapterHaiwan(viewPagerItemWarnaArrayList);
        viewPager2hijaiyah.setAdapter(VPAdapterHaiwan);
        viewPager2hijaiyah.setClipToPadding(false);
        viewPager2hijaiyah.setClipChildren(false);
        viewPager2hijaiyah.setOffscreenPageLimit(2);
        viewPager2hijaiyah.getChildAt(0).setOverScrollMode(View.OVER_SCROLL_NEVER);

        // for home button
        ImageButton homebtnHijaiyah = findViewById(R.id.homebtn_HJ);
        homebtnHijaiyah.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Navigate to BelajarFragment when home button is clicked
                navigateToBelajarFragment();
            }
        });
        // for next previous btn
        ImageButton nextbtnHijaiyah = (ImageButton) findViewById(R.id.nextbtn_HJ);
        nextbtnHijaiyah.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                viewPager2hijaiyah.setCurrentItem(getItemHijaiyah(+1), true);
            }
        });
        ImageButton prevbtnHijaiyah = (ImageButton) findViewById(R.id.prevbtn_HJ);
        prevbtnHijaiyah.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                viewPager2hijaiyah.setCurrentItem(getItemHijaiyah(-1), true);
            }
        });

        // Initialize MediaPlayer with the audio file for the first alphabet
        mediaPlayerHijaiyah = MediaPlayer.create(this, R.raw.huruf_alif);
    }
    private int getItemHijaiyah(int i) {
        return viewPager2hijaiyah.getCurrentItem() +i;
    }
    private void navigateToBelajarFragment() {
        FragmentTransaction transactionHJ = getSupportFragmentManager().beginTransaction();
        transactionHJ.replace(R.id.fragment_HJ, new BelajarFragment());
        transactionHJ.addToBackStack(null);
        transactionHJ.commit();
    }

    // Method to handle Speak button click
    public void onSpeakButtonClick(View view) {
        // Get the current item index from the ViewPager
        int currentItem = viewPager2hijaiyah.getCurrentItem();

        // Get the corresponding audio resource ID for the current alphabet
        int HJaudioResourceId = getAudioResourceIdForHJ(currentItem);

        // Play the audio for the current alphabet
        playAudio_HJ(HJaudioResourceId);
    }
    private int getAudioResourceIdForHJ(int position) {
        String[] HJAudioFiles = {
                "buah_naga", "jagung", "buah_ceri", "buah_pisang", "buah_epal", "buah_oren", "buah_mangga", "kiwi", "buah_anggur", "buah_durian", "sayur_kubis", "lada_besar", "buah_tembikai", "buah_strawberi", "buah_nenas", "ubi_kentang", "kacang_hijau", "bawang_putih", "terung", "lobak_merah", "buah_tomato", "sayur_sawi", "buah_labu",
        };

        // Get the resource name for the current alphabet
        String resourceNameHJ = HJAudioFiles[position];

        // Get the corresponding audio resource ID
        int HJaudioResourceId = getResources().getIdentifier(resourceNameHJ, "raw", getPackageName());

        // Check for resource not found
        if (HJaudioResourceId == 0) {
            // Handle the case where the resource is not found
            // You might want to log a warning or display an error message
        }
        return HJaudioResourceId;
    }
    private void playAudio_HJ(int HJaudioResourceId) {
        // Release the previous MediaPlayer resources if any
        if (mediaPlayerHijaiyah != null) {
            mediaPlayerHijaiyah.release();
        }
        // Create and start a new MediaPlayer with the specified audio resource
        mediaPlayerHijaiyah = MediaPlayer.create(this, HJaudioResourceId);
        mediaPlayerHijaiyah.start();
    }
    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (mediaPlayerHijaiyah != null) {
            mediaPlayerHijaiyah.release();
            mediaPlayerHijaiyah = null;
        }
    }
}
