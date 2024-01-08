package com.example.smartjawi.WarnaSection;

        import android.media.MediaPlayer;
        import android.os.Bundle;
        import android.view.View;
        import android.widget.ImageButton;

        import androidx.appcompat.app.AppCompatActivity;
        import androidx.fragment.app.FragmentTransaction;
        import androidx.viewpager2.widget.ViewPager2;

        import com.example.smartjawi.Fragments.BelajarFragment;
        import com.example.smartjawi.R;

        import java.util.ArrayList;

public class WarnaActivity extends AppCompatActivity {

    ViewPager2 viewPager2hijaiyah;
    ArrayList<VPItemWarna> viewPagerItemWarnaArrayList;
    private MediaPlayer mediaPlayerHijaiyah;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hijaiyah);

        viewPager2hijaiyah = findViewById(R.id.vpHijaiyah);
        int[] imagesHijaiyah = {R.drawable.yellow, R.drawable.green, R.drawable.blue, R.drawable.red, R.drawable.grey, R.drawable.gold, R.drawable.black, R.drawable.white, R.drawable.brown, R.drawable.pink, R.drawable.oren, R.drawable.purple};
        String[] headingHijaiyah = {"کونيڠ", "هيجاو", ""};


        viewPagerItemWarnaArrayList = new ArrayList<>();
        for (int i = 0; i < imagesHijaiyah.length; i++) {
            VPItemWarna viewPagerItemHijaiyah = new VPItemWarna(imagesHijaiyah[i], headingHijaiyah[i]);
            viewPagerItemWarnaArrayList.add(viewPagerItemHijaiyah);
        }

        VPAdapterWarna vpAdapterWarna = new VPAdapterWarna(viewPagerItemWarnaArrayList);
        viewPager2hijaiyah.setAdapter(vpAdapterWarna);
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
                "huruf_alif", "huruf_ba", "huruf_ta", "huruf_tsa", "huruf_jim", "huruf_haa",
                "huruf_kho", "huruf_dal", "huruf_dzal", "huruf_ro", "huruf_zai", "huruf_sin",
                "huruf_shin", "huruf_sod", "huruf_dho", "huruf_to", "huruf_zo", "huruf_ain",
                "huruf_ghain", "huruf_fa", "huruf_qof", "huruf_kaf", "huruf_lam", "huruf_mim",
                "huruf_nun", "huruf_wau", "huruf_ha", "huruf_lam_alif", "huruf_hamzah", "huruf_ya"
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
