package com.example.viewpager;

import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    //VIEWPAGER
    //1.Add the appropriate ViewPager widget to the Activity's layout
    //2.Make a Fragment to display text, and an image. In the XML
    //3.Update the fragment to show the TextView and the ImageView
    //4.Create a class that extends from FragmentPagerAdapter

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        List<Fragment> fragmentList = new ArrayList<>();

        fragmentList.add(BlankFragment.newInstance("Mercury", "https://www.go-astronomy.com/images/planets/planet-mercury.jpg"));
        fragmentList.add(BlankFragment.newInstance("Venus", "https://surrealsciencestuff.files.wordpress.com/2014/09/planets3.jpg"));
        fragmentList.add(BlankFragment.newInstance("Earth", "https://cdn.britannica.com/700x450/25/160325-004-AD594C66.jpg"));
        fragmentList.add(BlankFragment.newInstance("Mars", "https://d.ibtimes.co.uk/en/full/403889/planet-mars.jpg"));
        fragmentList.add(BlankFragment.newInstance("Jupiter", "https://www.cool2bkids.com/wp-content/uploads/2014/05/Jupiter-Picture.jpg"));
        fragmentList.add(BlankFragment.newInstance("Saturn", "https://www.yourdictionary.com/images/definitions/lg/8616.saturn.jpg"));
        fragmentList.add(BlankFragment.newInstance("Uranus", "https://www.startrekdb.se/astronomi/bilder/uranus2.jpg"));
        fragmentList.add(BlankFragment.newInstance("Neptune", "https://upload.wikimedia.org/wikipedia/commons/thumb/5/56/Neptune_Full.jpg/1200px-Neptune_Full.jpg"));

        ViewPager viewPager = findViewById(R.id.mainActivity_viewPager);
        viewPager.setAdapter(new ViewPagerAdapter(getSupportFragmentManager(), fragmentList));

    }
}
