package com.example.android.githubsearch;

import android.content.Context;
import android.support.annotation.Nullable;
import android.support.v4.content.AsyncTaskLoader;
import android.util.Log;

import com.example.android.githubsearch.utils.NetworkUtils;

import java.io.IOException;

public class GitHubSearchLoader extends AsyncTaskLoader<String> {

    private final static String TAG = GitHubSearchLoader.class.getSimpleName();

    private String mSearchResultsJSON;
    private String mURL;

    GitHubSearchLoader(Context context, String url) {
        super(context);
        mURL = url;
    }

    @Override
    protected void onStartLoading() {
        if (mURL != null) {
            if (mSearchResultsJSON != null) {
                Log.d(TAG, "loader returning cached results");
                deliverResult(mSearchResultsJSON);
            } else {
                forceLoad();
            }
        }
    }

    @Nullable
    @Override
    public String loadInBackground() {
        if (mURL != null) {
            Log.d(TAG, "loading results from GitHub with URL: " + mURL);
            String results = null;
            try {
                results = NetworkUtils.doHTTPGet(mURL);
            } catch (IOException e) {
                e.printStackTrace();
            }
            return results;
        } else {
            return null;
        }
    }

    @Override
    public void deliverResult(@Nullable String data) {
        mSearchResultsJSON = data;
        super.deliverResult(data);
    }
}
