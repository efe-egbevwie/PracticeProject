package com.efe.leaderboard.Utils;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetroFitClient {

    private static Retrofit retrofit;
    public static Retrofit retrofit2;
    private static final String BASE_API_URL = "https://gadsapi.herokuapp.com/";
    private static final String POST_URL = "https://docs.google.com/forms/d/e/";


    public static Retrofit getDataInstance() {
        if (retrofit == null) {
            retrofit = new retrofit2.Retrofit.Builder()
                    .baseUrl(BASE_API_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }

        return retrofit;
    }

    public static Retrofit postInstance() {

        if (retrofit2 == null) {
            retrofit2 = new retrofit2.Retrofit.Builder()
                    .baseUrl(POST_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }

        return retrofit2;

    }
}
