package com.example.musicsd;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.os.Bundle;
import android.util.Log;

import com.ismaeldivita.chipnavigation.ChipNavigationBar;

public class bottomNav extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bottom_nav);
        ChipNavigationBar bottomNav;
        bottomNav=findViewById(R.id.but_nav);
        if(savedInstanceState==null)
        {
            bottomNav.setItemSelected(R.id.home,true);
           HomeFragment homeFragment=new HomeFragment();
            getSupportFragmentManager().beginTransaction()
                    .replace(R.id.fragment_container,homeFragment)
                    .commit();
        }
        bottomNav.setOnItemSelectedListener(new ChipNavigationBar.OnItemSelectedListener() {
            @Override
            public void onItemSelected(int i) {
                Fragment fragment=null;
              switch (i){
                  case R.id.home:
                      fragment=new HomeFragment();
                      break;
                  case R.id.liked:
                      fragment=new LikedFragment();
                      break;
                  case R.id.search:
                      fragment=new SearchFragment();
                      break;
                  case R.id.profile:
                      fragment=new ProfileFragment();
                      break;
              }
              if(fragment!=null)
              {

                  getSupportFragmentManager().beginTransaction()
                          .replace(R.id.fragment_container,fragment)
                          .commit();


              }
              else
              {
                  Log.e("XXXXXXXXXXXXXXXxx","XXXXXXXXXXXXXXXXXXXXXXXX");
              }

            }
        });

    }
}