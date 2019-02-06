package com.example.shakil.androidinfcycle;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.shakil.androidinfcycle.Model.Movie;
import com.example.shakil.androidinfcycle.MyAdapter.MyAdapter;
import com.gigamole.infinitecycleviewpager.HorizontalInfiniteCycleViewPager;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    HorizontalInfiniteCycleViewPager viewPager;
    List<Movie> movieList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initData();
        viewPager = findViewById(R.id.view_pager);
        MyAdapter adapter = new MyAdapter(this, movieList);
        viewPager.setAdapter(adapter);
    }

    private void initData() {
        movieList.add(new Movie("A Q U A M A N", getString(R.string.long_text), R.drawable.aquamanposter));
        movieList.add(new Movie("BUMBLE BEE", getString(R.string.long_text), R.drawable.bumblebee));
        movieList.add(new Movie("JOHN WICK", getString(R.string.long_text), R.drawable.john_wick));
    }
}
