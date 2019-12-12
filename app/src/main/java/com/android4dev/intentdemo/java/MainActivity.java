package com.android4dev.intentdemo.java;

import android.content.Intent;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.android4dev.intentdemo.R;
import com.android4dev.intentdemo.java.constants.UserDefault;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private EditText editMovieName;
    private EditText editDescription;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
    }

    private void initView() {
        editMovieName = findViewById(R.id.editMovieName);
        editDescription = findViewById(R.id.editDescription);
        Button btnSubmit = findViewById(R.id.btnSubmit);
        btnSubmit.setOnClickListener(this);
    }

    private void sendSingleData() {
        startActivity(DisplayActivity.getIntent(this, editMovieName.getText().toString()
                , editDescription.getText().toString()));
    }

    private void sendDataWithModelClass() {
        MovieModel movieModel = new MovieModel();
        movieModel.setDescription(editDescription.getText().toString().trim());
        movieModel.setMovieName(editMovieName.getText().toString().trim());
        startActivity(DisplayActivity.getIntent(this, movieModel));
    }

    private void sendDataWithResult() {
        MovieModel movieModel = new MovieModel();
        movieModel.setDescription(editDescription.getText().toString().trim());
        movieModel.setMovieName(editMovieName.getText().toString().trim());
        startActivityForResult(DisplayActivity.getIntent(this, movieModel), UserDefault.MOVIE_RESULT);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btnSubmit: {
                sendSingleData();
                break;
            }
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == UserDefault.MOVIE_RESULT && resultCode == UserDefault.MOVIE_RESULT) {
            if (data != null) {
                Toast.makeText(this, "Movie Name= " + data.getStringExtra(UserDefault.MOVIE_NAME), Toast.LENGTH_SHORT).show();
            }
        }
    }
}
