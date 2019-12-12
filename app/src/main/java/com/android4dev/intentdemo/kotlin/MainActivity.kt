package com.android4dev.intentdemo.kotlin

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import com.android4dev.intentdemo.R
import com.android4dev.intentdemo.kotlin.constants.UserDefault
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), View.OnClickListener {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initView()
    }

    private fun initView() {
        btnSubmit.setOnClickListener(this)
    }

    override fun onClick(clickView: View?) {
        when (clickView?.id) {
            R.id.btnSubmit -> {
                sendDataWithModelClass()
            }
        }
    }

    private fun sendSingleData() {
        startActivity(DisplayActivity.getIntent(this@MainActivity, editMovieName.text.toString().trim()
                , editDescription.text.toString().trim()))
    }

    private fun sendDataWithModelClass() {
        val movieModel = MovieModel(editMovieName.text.toString().trim(),
                editDescription.text.toString().trim())
        startActivity(DisplayActivity.getIntent(this@MainActivity, movieModel))

    }

    private fun sendDataWithResult() {
        val movieModel = MovieModel(editMovieName.text.toString().trim(),
                editDescription.text.toString().trim())
        startActivityForResult(DisplayActivity.getIntent(this, movieModel), UserDefault.MOVIE_RESULT)
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (requestCode == UserDefault.MOVIE_RESULT && resultCode == UserDefault.MOVIE_RESULT) {
            data?.let {it->
                Toast.makeText(this, "Movie Name= " + it.getStringExtra(UserDefault.MOVIE_NAME), Toast.LENGTH_SHORT).show()
            }
        }
    }
}
