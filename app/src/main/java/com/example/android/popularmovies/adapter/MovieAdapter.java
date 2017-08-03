package com.example.android.popularmovies.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.example.android.popularmovies.R;
import com.example.android.popularmovies.data.MovieModel;
import com.squareup.picasso.Picasso;

/**
 * Created by lsitec101.macedo on 31/07/17.
 */

public class MovieAdapter extends RecyclerView.Adapter<MovieAdapter.MovieAdapterViewHolder> {

    private static final String LOG_TAG = MovieAdapter.class.getSimpleName();

    private static final String BASE_URL = "http://image.tmdb.org/t/p/";

    private static final String SIZE_IMAGE = "w185/";
    private final MovieAdapterOnClickHandler mClickHandler;
    private MovieModel[] mMovieList;
    private Context mContext;


    public MovieAdapter(MovieAdapterOnClickHandler clickHandler) {
        mClickHandler = clickHandler;
    }

    @Override
    public MovieAdapterViewHolder onCreateViewHolder(ViewGroup viewGroup, int viewType) {
        mContext = viewGroup.getContext();
        int layoutIdForListItem = R.layout.movie_list_item;
        LayoutInflater inflater = LayoutInflater.from(mContext);
        boolean shouldAttachToParentImmediately = false;
        View view = inflater.inflate(layoutIdForListItem, viewGroup, shouldAttachToParentImmediately);
        return new MovieAdapterViewHolder(view);
    }

    @Override
    public void onBindViewHolder(MovieAdapterViewHolder holder, int position) {

        MovieModel movieClicked = mMovieList[position];
//        String URLPicasso = BASE_URL + SIZE_IMAGE + "/" + movieClicked.getPoster_path();

        Picasso.with(mContext).load(movieClicked.takeUrlImage()).into(holder.mImageView);
//        mMovieList[position].setPoster_path(URLPicasso);


    }

    @Override
    public int getItemCount() {

        if (null == mMovieList) {
            return 0;
        } else {
            return mMovieList.length;
        }
    }

    public MovieModel[] getMovieList() {
        return mMovieList;
    }

    public void setMovieList(MovieModel[] movie) {
        mMovieList = movie;
        notifyDataSetChanged();
    }

    public interface MovieAdapterOnClickHandler {
        public void onClick(MovieModel movie);
    }

    public class MovieAdapterViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        public final ImageView mImageView;

        public MovieAdapterViewHolder(View view) {
            super(view);
            mImageView = (ImageView) view.findViewById(R.id.iv_movie);

            view.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {
            int adapterPosition = getAdapterPosition();
            MovieModel movieClicked = mMovieList[adapterPosition];
            mClickHandler.onClick(movieClicked);
        }


    }


}