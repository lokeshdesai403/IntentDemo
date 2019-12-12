package com.android4dev.intentdemo.kotlin

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.android4dev.intentdemo.R
import com.android4dev.intentdemo.kotlin.constants.UserDefault.Companion.DESCRIPTION
import com.android4dev.intentdemo.kotlin.constants.UserDefault.Companion.MOVIE_DATA
import com.android4dev.intentdemo.kotlin.constants.UserDefault.Companion.MOVIE_NAME
import kotlinx.android.synthetic.main.activity_display.*

class DisplayActivity : AppCompatActivity() {

    companion object {
        fun getIntent(context: Context, movieName: String, description: String): Intent {
            val intent = Intent(context, DisplayActivity::class.java)
            intent.putExtra(MOVIE_NAME, movieName)
            intent.putExtra(DESCRIPTION, description)
            return intent
        }

        fun getIntent(context: Context, movieModel: MovieModel): Intent {
            val intent = Intent(context, DisplayActivity::class.java)
            intent.putExtra(MOVIE_DATA, movieModel)
            return intent
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_display)
        intent.extras?.let { bundle ->
            //textMovieName.text = bundle.getString(MOVIE_NAME)
            //textDescription.text = bundle.getString(DESCRIPTION)

            val movieModel: MovieModel = bundle.getSerializable(MOVIE_DATA) as MovieModel
            movieModel?.let { movie ->
                textMovieName.text = movieModel.movieName
                textDescription.text = movieModel.description
            }
        }
    }
}