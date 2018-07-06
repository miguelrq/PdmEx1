package com.example.miguel.appexamen1.news.view;

import android.content.Context;

import com.example.miguel.appexamen1.news.model.scheme.News;

public interface INews {
    void onArticleResult(News news,Boolean result, int code);
    Context getNewsContext();
}
