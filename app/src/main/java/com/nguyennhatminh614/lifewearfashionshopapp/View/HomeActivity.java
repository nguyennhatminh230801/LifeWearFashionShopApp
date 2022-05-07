package com.nguyennhatminh614.lifewearfashionshopapp.View;

import android.os.Bundle;
import android.view.MenuItem;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.nguyennhatminh614.lifewearfashionshopapp.R;
import com.nguyennhatminh614.lifewearfashionshopapp.View.home_activity_tab_screen.ContactFragment;
import com.nguyennhatminh614.lifewearfashionshopapp.View.home_activity_tab_screen.FavoriteFragment;
import com.nguyennhatminh614.lifewearfashionshopapp.View.home_activity_tab_screen.HomeFragment;
import com.nguyennhatminh614.lifewearfashionshopapp.View.home_activity_tab_screen.ShoppingFragment;
import com.nguyennhatminh614.lifewearfashionshopapp.View.home_activity_tab_screen.UserProfileFragment;
import com.nguyennhatminh614.lifewearfashionshopapp.databinding.ActivityHomeBinding;

public class HomeActivity extends AppCompatActivity {

    BottomNavigationView navView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        navView = findViewById(R.id.nav_view);
        loadFragment(new HomeFragment());

        navView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()){
                    case R.id.navigation_contact:
                        loadFragment(new ContactFragment());
                        return true;
                    case R.id.navigation_home:
                        loadFragment(new HomeFragment());
                        return true;
                    case R.id.navigation_favorite:
                        loadFragment(new FavoriteFragment());
                        return true;
                    case R.id.navigation_shopping:
                        loadFragment(new ShoppingFragment());
                        return true;
                    case R.id.navigation_user_profile:
                        loadFragment(new UserProfileFragment());
                        return true;
                }

                return false;
            }
        });
    }

    private void loadFragment(Fragment fragment) {
        // load Fragment
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.nav_host_fragment_activity_home, fragment);
        transaction.addToBackStack(null);
        transaction.commit();
    }
}