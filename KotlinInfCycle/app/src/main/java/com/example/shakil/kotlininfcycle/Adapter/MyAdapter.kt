package com.example.shakil.kotlininfcycle.Adapter

import android.content.Context
import android.support.design.widget.FloatingActionButton
import android.support.v4.view.PagerAdapter
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import com.example.shakil.kotlininfcycle.Model.Movie
import com.example.shakil.kotlininfcycle.R

class MyAdapter (internal var context: Context, internal var movieList:List<Movie>): PagerAdapter() {
    override fun isViewFromObject(p0: View, p1: Any): Boolean {
        return p0 == p1
    }

    override fun getCount(): Int {
        return movieList.size
    }

    override fun destroyItem(container: ViewGroup, position: Int, `object`: Any) {
        container.removeView(`object` as View)
    }

    override fun instantiateItem(container: ViewGroup, position: Int): Any {
        //Inflate view
        val view = LayoutInflater.from(context).inflate(R.layout.card_item, container, false)

        //View
        val movie_image = view.findViewById<View>(R.id.movie_image) as ImageView
        val movie_title = view.findViewById<View>(R.id.movie_title) as TextView
        val movie_description = view.findViewById<View>(R.id.movie_description) as TextView
        val btn_fav = view.findViewById<View>(R.id.btn_fav) as FloatingActionButton

        //Set Data
        movie_image.setImageResource(movieList[position].image)
        movie_title.text = movieList[position].name
        movie_description.text = movieList[position].description

        view.setOnClickListener(View.OnClickListener {
            //Click to view, here you can add startActivity
            //I just use Toast
            Toast.makeText(context, "" + movieList[position].name, Toast.LENGTH_SHORT).show()
        })

        btn_fav.setOnClickListener(View.OnClickListener {
            Toast.makeText(
                context,
                "Button clicked ! Your Favorite film",
                Toast.LENGTH_SHORT
            ).show()
        })

        container.addView(view)
        return view
    }
}