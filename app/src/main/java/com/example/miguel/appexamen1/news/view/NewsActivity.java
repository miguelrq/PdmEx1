package com.example.miguel.appexamen1.news.view;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.TextView;

import com.example.miguel.appexamen1.R;
import com.example.miguel.appexamen1.news.model.scheme.News;
import com.example.miguel.appexamen1.news.presenter.INewsPresenter;
import com.example.miguel.appexamen1.news.presenter.NewsPresenter;

public class NewsActivity extends AppCompatActivity implements INews{

    INewsPresenter newsPresenter;
    private TextView title;
    private TextView content;
    private TextView comments;
    private TextView visualizations;
    private TextView likes;
    private TextView createdAt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_news);

        title = findViewById(R.id.text_title);
        content = findViewById(R.id.text_content);
        comments = findViewById(R.id.text_comments);
        visualizations = findViewById(R.id.text_visualizations);
        likes = findViewById(R.id.text_likes);
        createdAt = findViewById(R.id.text_createdAt);

        newsPresenter = new NewsPresenter(this);
        newsPresenter.loadArticle();
    }

    @Override
    public void onArticleResult(News news, Boolean result, int code) {
        if (result) {
            title.setText(news.getTitle());
            content.setText(news.getContent());
            visualizations.setText(news.getVisualizations().toString());
            likes.setText(news.getLikes().toString());
            comments.setText(news.getComments().toString());
        }
    }

    @Override
    public Context getNewsContext() {
        return getApplicationContext();
    }
}
