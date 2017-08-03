package com.example.android.popularmovies.utilities;

import android.content.Context;

import com.example.android.popularmovies.data.MovieModel;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/**
 * Created by lsitec101.macedo on 31/07/17.
 */

public final class OpenMovieJsonUtils {

    public static String[] getMovieFromJson (Context context, String movieJsonStr) throws JSONException {
        String[] parsedMovieData = null;

        JSONObject movieJson = new JSONObject(movieJsonStr);

        JSONArray movieArray = movieJson.getJSONArray("results");

        parsedMovieData = new String[movieArray.length()];

        for (int i = 0; i < movieArray.length(); i++) {
            String poster_path;

            /* Get the JSON object representing the day */
            JSONObject movie = movieArray.getJSONObject(i);

//            poster_path = movieArray.getJSONObject(i).getString("poster_path");

            MovieModel movieGet = new MovieModel();
            movieGet.setPoster_path(movieArray.getJSONObject(i).getString("poster_path"));
            movieGet.setTitle(movieArray.getJSONObject(i).getString("title"));
            movieGet.setOverview(movieArray.getJSONObject(i).getString("overview"));
            movieGet.setRelease_date(movieArray.getJSONObject(i).getString("release_date"));
            movieGet.setVote_average(movieArray.getJSONObject(i).getString("vote_average"));


//            parsedMovieData[i] = movieGet.toString();
            parsedMovieData[i] = movieGet.getPoster_path() + " - " + movieGet.getTitle() + " - " + movieGet.getOverview() + " - " + movieGet.getRelease_date() + " - " + movieGet.getVote_average();
//            parsedMovieData[i] = poster_path;

        }
        return parsedMovieData;


    }

}
