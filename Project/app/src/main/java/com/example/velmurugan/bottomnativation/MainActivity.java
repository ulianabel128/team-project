package com.example.velmurugan.bottomnativation;

import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;

public class MainActivity extends AppCompatActivity {

    private ActionBar toolbar;
    private BottomNavigationView bottomNavigationView;
    private String[] menus ={"Уроки","Тестирование","Прогресс"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        toolbar = getSupportActionBar();
        bottomNavigationView = (BottomNavigationView) findViewById(R.id.bottom_navigationview);
        bottomNavigationView.setOnNavigationItemSelectedListener(navigationItemSelectedListener);

        toolbar.setTitle(menus[0]);
        loadFragment(new LatestFragment());
    }

    private BottomNavigationView.OnNavigationItemSelectedListener navigationItemSelectedListener = new BottomNavigationView.OnNavigationItemSelectedListener() {
        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {

            Fragment fragment;
            switch (item.getItemId()){
                case R.id.item1:
                    fragment = new LatestFragment();
                    toolbar.setTitle(menus[0]);
                    loadFragment(fragment);
                    return true;
                case R.id.item2:
                    toolbar.setTitle(menus[1]);
                    fragment = new FavoriteFragment();
                    loadFragment(fragment);
                    return true;
                case R.id.item4:
                    toolbar.setTitle(menus[2]);
                    fragment = new AccountFragment();
                    loadFragment(fragment);
                    return true;
            }
            return false;
        };
    };

    private void loadFragment(Fragment fragment){
        FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
        fragmentTransaction.replace(R.id.frame_layout,fragment);
        fragmentTransaction.commit();
    }

}
