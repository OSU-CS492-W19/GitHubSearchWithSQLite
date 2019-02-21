package com.example.android.githubsearch.data;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;

@Dao
public interface GitHubRepoDao {
    @Insert
    void insert(GitHubRepo repo);

    @Delete
    void delete(GitHubRepo repo);
}
