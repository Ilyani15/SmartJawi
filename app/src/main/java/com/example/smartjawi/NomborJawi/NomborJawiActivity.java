package com.example.smartjawi.NomborJawi;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentTransaction;
import androidx.viewpager2.widget.ViewPager2;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

import com.example.smartjawi.Fragments.BelajarFragment;
import com.example.smartjawi.R;

import java.util.ArrayList;

public class NomborJawiActivity extends AppCompatActivity {

    ViewPager2 viewPager2nombor;
    ArrayList<VPItemNomborJawi> vpItemNomborJawiArrayList;
    private MediaPlayer mediaPlayerNombor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nombor_jawi);

        viewPager2nombor = findViewById(R.id.vpJawiNum);
        int[] imagesNombor = {R.drawable.gambar_satu, R.drawable.gambar_dua, R.drawable.gambar_tiga, R.drawable.gambar_empat, R.drawable.gambar_lima, R.drawable.gambar_enam, R.drawable.gambar_tujuh, R.drawable.gambar_lapan, R.drawable.gambar_sembilan, R.drawable.gambar_sepuluh};
        String[] headingNombor = {"SATU", "DUA", "TIGA", "EMPAT", "LIMA", "ENAM", "TUJUH", "LAPAN", "SEMBILAN", "SEPULUH"};

        vpItemNomborJawiArrayList = new ArrayList<>();
        for (int i = 0; i < imagesNombor.length ; i++){
            VPItemNomborJawi itemNomborJawi = new VPItemNomborJawi(imagesNombor[i], headingNombor[i]);
            vpItemNomborJawiArrayList.add(itemNomborJawi);
        }
        VPAdapterNomborJawi vpAdapterNomborJawi = new VPAdapterNomborJawi(vpItemNomborJawiArrayList);
        viewPager2nombor.setAdapter(vpAdapterNomborJawi);
        viewPager2nombor.setClipToPadding(false);
        viewPager2nombor.setClipChildren(false);
        viewPager2nombor.setOffscreenPageLimit(2);
        viewPager2nombor.getChildAt(0).setOverScrollMode(View.OVER_SCROLL_NEVER);

        // for next prev btn
        ImageButton nextbtnJawiNum = (ImageButton) findViewById(R.id.nextbtn_NoJawi);
        nextbtnJawiNum.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                viewPager2nombor.setCurrentItem(getItemJawiNum(+1), true);
            }
        });
        ImageButton prevbtnJawiNum = (ImageButton) findViewById(R.id.prevbtn_NoJawi);
        prevbtnJawiNum.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                viewPager2nombor.setCurrentItem(getItemJawiNum(-1), true);
            }
        });

        // for home button
        ImageButton homebtnNombor = findViewById(R.id.homebtn_nombor);
        homebtnNombor.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Navigate to BelajarFragment when home button is clicked
                navigateToBelajarFragment();
            }
        });
        // Initialize MediaPlayer with the audio file for the first number
        mediaPlayerNombor = MediaPlayer.create(this, R.raw.nombor_satu);
    }
    private int getItemJawiNum(int i) {
        return viewPager2nombor.getCurrentItem() +i;
    }

    private void navigateToBelajarFragment() {
        FragmentTransaction transaction_Nombor = getSupportFragmentManager().beginTransaction();
        transaction_Nombor.replace(R.id.fragment_nombor, new BelajarFragment());
        transaction_Nombor.addToBackStack(null);
        transaction_Nombor.commit();
    }
    // Method to handle Speak button click
    public void onSpeakButtonClick(View view) {
        // Get the current item index from the ViewPager
        int currentItem = viewPager2nombor.getCurrentItem();

        // Get the corresponding audio resource ID for the current alphabet
        int Nombor_audioResourceId = getAudioResourceIdFor_nombor(currentItem);

        // Play the audio for the current alphabet
        playAudio_nombor(Nombor_audioResourceId);
    }
    private int getAudioResourceIdFor_nombor(int position) {
        String[] Nombor_AudioFiles = {
                "nombor_satu", "nombor_dua", "nombor_tiga", "nombor_empat", "nombor_lima",
                "nombor_enam", "nombor_tujuh", "nombor_lapan", "nombor_sembilan", "nombor_sepuluh",
        };

        // Get the resource name for the current alphabet
        String resourceName_nombor = Nombor_AudioFiles[position];

        // Get the corresponding audio resource ID
        int Nombor_audioResourceId = getResources().getIdentifier(resourceName_nombor, "raw", getPackageName());

        // Check for resource not found
        if (Nombor_audioResourceId == 0) {
            // Handle the case where the resource is not found
            // You might want to log a warning or display an error message
        }
        return Nombor_audioResourceId;
    }
    private void playAudio_nombor(int Nombor_audioResourceId) {
        // Release the previous MediaPlayer resources if any
        if (mediaPlayerNombor != null) {
            mediaPlayerNombor.release();
        }
        // Create and start a new MediaPlayer with the specified audio resource
        mediaPlayerNombor = MediaPlayer.create(this, Nombor_audioResourceId);
        mediaPlayerNombor.start();
    }
    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (mediaPlayerNombor != null) {
            mediaPlayerNombor.release();
            mediaPlayerNombor = null;
        }
    }
}