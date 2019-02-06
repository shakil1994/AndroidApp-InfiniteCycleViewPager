package com.example.shakil.kotlininfcycle

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.example.shakil.kotlininfcycle.Adapter.MyAdapter
import com.example.shakil.kotlininfcycle.Model.Movie
import kotlinx.android.synthetic.main.activity_main.*
import java.util.ArrayList

class MainActivity : AppCompatActivity() {

    internal var movieList: MutableList<Movie> = ArrayList<Movie>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        initData()
        val adapter = MyAdapter(this@MainActivity, movieList)
        view_pager.adapter = adapter
    }

    private fun initData() {
        movieList.add(Movie("A Q U A M A N", getString(R.string.long_text), R.drawable.aquamanposter))
        movieList.add(Movie("BUMBLE BEE", getString(R.string.long_text), R.drawable.bumblebee))
        movieList.add(Movie("JOHN WICK", getString(R.string.long_text), R.drawable.john_wick))
        movieList.add(Movie("C H R I S T M A S 1", getString(R.string.long_text), R.drawable.christmas1))
        movieList.add(Movie("C H R I S T M A S 2", getString(R.string.long_text), R.drawable.christmas2))
        movieList.add(Movie("C H R I S T M A S 3", getString(R.string.long_text), R.drawable.christmas3))
        movieList.add(Movie("C H R I S T M A S 4", getString(R.string.long_text), R.drawable.christmas4))
    }
}
