package com.example.android.githubsearch.data;

import android.app.Application;
import android.content.Context;
import android.os.AsyncTask;

public class GitHubRepoRepository {
    private GitHubRepoDao mGitHubRepoDao;

    public GitHubRepoRepository(Application application) {
        AppDatabase db = AppDatabase.getDatabase(application);
        mGitHubRepoDao = db.gitHubRepoDao();
    }

    public void insertGitHubRepo(GitHubRepo repo) {
        new InsertAsyncTask(mGitHubRepoDao).execute(repo);
    }

    public void deleteGitHubRepo(GitHubRepo repo) {
        new DeleteAsyncTask(mGitHubRepoDao).execute(repo);
    }

    private static class InsertAsyncTask extends AsyncTask<GitHubRepo, Void, Void> {
        private GitHubRepoDao mAsyncTaskDao;
        InsertAsyncTask(GitHubRepoDao dao) {
            mAsyncTaskDao = dao;
        }

        @Override
        protected Void doInBackground(GitHubRepo... gitHubRepos) {
            mAsyncTaskDao.insert(gitHubRepos[0]);
            return null;
        }
    }

    private static class DeleteAsyncTask extends AsyncTask<GitHubRepo, Void, Void> {
        private GitHubRepoDao mAsyncTaskDao;
        DeleteAsyncTask(GitHubRepoDao dao) {
            mAsyncTaskDao = dao;
        }

        @Override
        protected Void doInBackground(GitHubRepo... gitHubRepos) {
            mAsyncTaskDao.delete(gitHubRepos[0]);
            return null;
        }
    }
}
