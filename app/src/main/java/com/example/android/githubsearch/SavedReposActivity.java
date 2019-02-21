package com.example.android.githubsearch;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.example.android.githubsearch.data.GitHubRepo;
import com.example.android.githubsearch.utils.GitHubUtils;

public class SavedReposActivity extends AppCompatActivity implements GitHubSearchAdapter.OnSearchItemClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_saved_search_results);

        RecyclerView savedReposRV = findViewById(R.id.rv_saved_repos);
        savedReposRV.setLayoutManager(new LinearLayoutManager(this));
        savedReposRV.setHasFixedSize(true);

        GitHubSearchAdapter adapter = new GitHubSearchAdapter(this);
        savedReposRV.setAdapter(adapter);
    }

    @Override
    public void onSearchItemClick(GitHubRepo repo) {
        Intent intent = new Intent(this, RepoDetailActivity.class);
        intent.putExtra(GitHubUtils.EXTRA_GITHUB_REPO, repo);
        startActivity(intent);
    }
}
