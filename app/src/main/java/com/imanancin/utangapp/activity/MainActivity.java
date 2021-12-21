package com.imanancin.utangapp.activity;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.content.Intent;
import android.os.Bundle;
import android.service.controls.actions.FloatAction;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.navigation.NavigationBarView;
import com.imanancin.utangapp.R;
import com.imanancin.utangapp.fragment.DipinjamFragment;
import com.imanancin.utangapp.fragment.MeminjamFragment;

public class MainActivity extends AppCompatActivity {

    private String TAG = "Fragment";
    BottomNavigationView bottomNavigation;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // BottomNavigation  untuk berfindah antar fragments
        bottomNavigation = findViewById(R.id.bottom_navigation);
        // Fragment dgn replace() berarti fragment akan diganti setiap di klik
        getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, new DipinjamFragment()).commit();

        // FAB
        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this, TambahActivity.class));
            }
        });

        // apabila item dalam BottomNav diklik maka akn mentrtigger fragment
        bottomNavigation.setOnItemSelectedListener(new NavigationBarView.OnItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {

                Fragment selectedFragment = null;

                switch (item.getItemId()){
                    case R.id.dipinjam:
                        selectedFragment = new DipinjamFragment();
                        Log.d(TAG, "Dipinjam Fragment selected");
                        break;
                    case R.id.meminjam:
                        selectedFragment = new MeminjamFragment();
                        Log.d(TAG, "Meminjam Fragment selected");
                        break;
                }

                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, selectedFragment).commit();

                return true;
            }
        });
    }

    public void setActionBarTitle(String title){
        getActionBar().setTitle(title);
    }
}