package com.example.android.popularmovies.data;

/**
 * Created by lsitec101.macedo on 28/07/17.
 */

public class Person {
    private String profile_path;
    private boolean adult;
    private int id;
    // TODO 2 known_for OneOf
    private String name;
    private float popularity;

    public Person(String profile_path, boolean adult, int id, String name, float popularity) {
        this.profile_path = profile_path;
        this.adult = adult;
        this.id = id;
        this.name = name;
        this.popularity = popularity;
    }

    public String getProfile_path() {
        return profile_path;
    }

    public void setProfile_path(String profile_path) {
        this.profile_path = profile_path;
    }

    public boolean isAdult() {
        return adult;
    }

    public void setAdult(boolean adult) {
        this.adult = adult;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public float getPopularity() {
        return popularity;
    }

    public void setPopularity(float popularity) {
        this.popularity = popularity;
    }
}
