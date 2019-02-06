package com.example.shakil.androidinfcycle.MyAdapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.view.PagerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.shakil.androidinfcycle.Model.Movie;
import com.example.shakil.androidinfcycle.R;

import java.util.List;

public class MyAdapter extends PagerAdapter {

    Context context;
    List<Movie> movieList;

    public MyAdapter(Context context, List<Movie> movieList) {
        this.context = context;
        this.movieList = movieList;
    }

    @Override
    public int getCount() {
        return movieList.size();
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object o) {
        return view.equals(o);
    }

    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
        container.removeView((View) object);
    }

    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, final int position) {
        //Inflate view
        View view = LayoutInflater.from(context).inflate(R.layout.card_item, container, false);

        //View
        ImageView movie_image = view.findViewById(R.id.movie_image);
        TextView movie_title = view.findViewById(R.id.movie_title);
        TextView movie_description = view.findViewById(R.id.movie_description);
        FloatingActionButton btn_fav = view.findViewById(R.id.btn_fav);

        //Set Data
        movie_image.setImageResource(movieList.get(position).getImage());
        movie_title.setText(movieList.get(position).getName());
        movie_description.setText(movieList.get(position).getDescription());

        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Click to view, here you can add startActivity
                //I just use Toast
                Toast.makeText(context, "" + movieList.get(position).getName(), Toast.LENGTH_SHORT).show();
            }
        });

        btn_fav.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(context, "Button clicked ! Your Favorite film", Toast.LENGTH_SHORT).show();
            }
        });

        container.addView(view);
        return view;
    }
}
