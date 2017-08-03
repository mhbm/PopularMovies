package com.example.android.popularmovies;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.android.popularmovies.data.MovieModel;
import com.squareup.picasso.Picasso;

/**
 * Created by lsitec101.macedo on 01/08/17.
 */

public class MovieDetailActivity  extends AppCompatActivity{

    private String mMovieTitle;
    private String mMovieOverview;
    private String mMoviePostPath;
    private String mMovieVoteAverage;
    private String mMovieDate;

    private TextView mTitleDisplay;
    private TextView mOverviewDisplay;
    private ImageView mImageDisplay;
    private TextView mRatingDisplay;
    private TextView mReleaseDate;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_movie_detail);

        mTitleDisplay = (TextView) findViewById(R.id.tv_movie_title);
        mOverviewDisplay = (TextView) findViewById(R.id.tv_movie_overview);
        mImageDisplay = (ImageView) findViewById(R.id.iv_movie_image);
        mRatingDisplay = (TextView) findViewById(R.id.tv_movie_vote_average);
        mReleaseDate = (TextView) findViewById(R.id.tv_movie_release_date);

        Intent intentThatStartedThisActivity = getIntent();

        if (intentThatStartedThisActivity != null) {

                MovieModel movie = (MovieModel) intentThatStartedThisActivity.getSerializableExtra("MovieModel");
                mMovieTitle = movie.getTitle();
                mMovieOverview =  movie.getOverview();
                mMoviePostPath = movie.getPoster_path();
                mMovieVoteAverage = movie.getVote_average();
                mMovieDate = movie.getRelease_date();

                mTitleDisplay.setText(mMovieTitle);
                mOverviewDisplay.setText(mMovieOverview);
                Picasso.with(this).load(movie.takeUrlImage()).into(mImageDisplay);
                mRatingDisplay.setText(mMovieVoteAverage);
                mReleaseDate.setText(mMovieDate);



        }


    }


}

