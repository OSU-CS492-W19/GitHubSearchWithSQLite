package com.example.android.githubsearch.data;

import java.io.Serializable;

public class GitHubRepo implements Serializable {
    public String full_name;
    public String description;
    public String html_url;
    public int stargazers_count;
}
