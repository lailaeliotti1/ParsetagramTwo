package com.example.parstagram;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import android.os.Bundle;
import android.view.MenuItem;

import com.example.parstagram.compose.ComposeFragment;
import com.example.parstagram.newsfeed.FeedFragment;
import com.example.parstagram.profile.ProfileFragment;
import com.example.parstagram.models.User;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.parse.ParseUser;

public class MainActivity extends AppCompatActivity {

    public static final String TAG = "Main Activity";
    final FragmentManager fragmentManager = getSupportFragmentManager();
    public BottomNavigationView bottomNavigationView;
    FeedFragment feedFragment = new FeedFragment();
    ComposeFragment composeFragment = new ComposeFragment();
    ProfileFragment profileFragment = new ProfileFragment();


    public void goToProfileTab(User user){
        profileFragment.user = user;
        bottomNavigationView.setSelectedItemId(R.id.action_profile);
    }




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        setContentView(R.layout.activity_main);
        // Lookup the swipe container view


        // initialize the array that will hold posts and create a PostsAdapter


        bottomNavigationView = findViewById(R.id.bottomNavigation);



        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                Fragment fragment = null;
                switch (menuItem.getItemId()) {
                    case R.id.action_home:
                        fragment = feedFragment;
                        break;
                    case R.id.action_compose:
                        fragment = composeFragment;
                        break;
                    case R.id.action_profile:
                        profileFragment.user = (User) ParseUser.getCurrentUser();
                        fragment = profileFragment;
                    default:

                        break;
                }
                fragmentManager.beginTransaction().replace(R.id.flContainer, fragment).commit();
                return true;
            }
        });

        //Sets the default fragment
        bottomNavigationView.setSelectedItemId(R.id.action_compose);






    }





}