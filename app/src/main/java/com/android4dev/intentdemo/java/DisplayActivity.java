package com.android4dev.intentdemo.java;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import com.android4dev.intentdemo.R;
import com.android4dev.intentdemo.java.constants.UserDefault;

public class DisplayActivity extends AppCompatActivity {

    private TextView textMovieName, textDescription;

    static Intent getIntent(Context context, String movieName, String description) {
        Intent intent = new Intent(context, DisplayActivity.class);
        intent.putExtra(UserDefault.MOVIE_NAME, movieName);
        intent.putExtra(UserDefault.DESCRIPTION, description);
        return intent;
    }

    static Intent getIntent(Context context, MovieModel movieModel) {
        Intent intent = new Intent(context, DisplayActivity.class);
        intent.putExtra(UserDefault.MOVIE_DATA, movieModel);
        return intent;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display);

        initView();
    }

    private void initView() {
        textMovieName = findViewById(R.id.textMovieName);
        textDescription = findViewById(R.id.textDescription);

        if (getIntent().getExtras() != null) {
            textMovieName.setText(getIntent().getStringExtra(UserDefault.MOVIE_NAME));
            textDescription.setText(getIntent().getStringExtra(UserDefault.DESCRIPTION));

            MovieModel movieModel = (MovieModel) getIntent().getSerializableExtra(UserDefault.MOVIE_DATA);
            if (movieModel != null) {
                textMovieName.setText(movieModel.getMovieName());
                textDescription.setText(movieModel.getDescription());

            }
        }
    }

    @Override
    public void onBackPressed() {
        Intent intent = new Intent();
        intent.putExtra(UserDefault.MOVIE_NAME, textMovieName.getText().toString());
        intent.putExtra(UserDefault.DESCRIPTION, textDescription.getText().toString());
        setResult(UserDefault.MOVIE_RESULT, intent);
        finish();
    }
}
