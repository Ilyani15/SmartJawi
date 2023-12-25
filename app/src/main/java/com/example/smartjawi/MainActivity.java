package com.example.smartjawi;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.widget.Toast;

import com.etebarian.meowbottomnavigation.MeowBottomNavigation;
import com.example.smartjawi.Fragments.BelajarFragment;
import com.example.smartjawi.Fragments.GameFragment;
import com.example.smartjawi.Fragments.HomeFragment;
import com.example.smartjawi.Fragments.ProfileFragment;
import com.example.smartjawi.Fragments.QuizFragment;

import kotlin.Unit;
import kotlin.jvm.functions.Function1;

public class MainActivity extends AppCompatActivity {

    private MeowBottomNavigation meowBottomNavigation;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        meowBottomNavigation = findViewById(R.id.meow_Bottom_Navigation);
        replace(new HomeFragment()); // for default fragment
        meowBottomNavigation.show(1, true);

        meowBottomNavigation.add(new MeowBottomNavigation.Model(1, R.drawable.ic_baseline_home_24));
        meowBottomNavigation.add(new MeowBottomNavigation.Model(2, R.drawable.ic_baseline_book_24));
        meowBottomNavigation.add(new MeowBottomNavigation.Model(3, R.drawable.ic_baseline_draw_24));
        meowBottomNavigation.add(new MeowBottomNavigation.Model(4, R.drawable.ic_baseline_castle_24));
        meowBottomNavigation.add(new MeowBottomNavigation.Model(5, R.drawable.ic_baseline_person_24));

        meowBottomNavigation.setOnClickMenuListener(new Function1<MeowBottomNavigation.Model, Unit>() {
            @Override
            public Unit invoke(MeowBottomNavigation.Model model) {
                switch (model.getId()) {
                    case 1:
                        replace(new HomeFragment());
                        break;
                    case 2:
                        replace(new BelajarFragment());
                        break;
                    case 3:
                        replace(new QuizFragment());
                    case 4:
                        replace(new GameFragment());
                        break;
                    case 5:
                        replace(new ProfileFragment());
                        break;
                } return null;
            }
        });
        // if user repeat click item menu
        meowBottomNavigation.setOnReselectListener(new Function1<MeowBottomNavigation.Model, Unit>() {
            @Override
            public Unit invoke(MeowBottomNavigation.Model model) {
                Toast.makeText(MainActivity.this, "anda sudah berada di sini!", Toast.LENGTH_SHORT).show();
                return null;
            }
        });
    }

    private void replace(Fragment fragment) {
        FragmentTransaction meowTransaction = getSupportFragmentManager().beginTransaction();
        meowTransaction.replace(R.id.frame_main, fragment);
        meowTransaction.commit();
    }
}