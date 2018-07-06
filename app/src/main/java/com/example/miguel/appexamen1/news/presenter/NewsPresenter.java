package com.example.miguel.appexamen1.news.presenter;

import com.androidnetworking.error.ANError;
import com.androidnetworking.interfaces.JSONObjectRequestListener;
import com.example.miguel.appexamen1.news.model.api.NewsManager;
import com.example.miguel.appexamen1.news.model.scheme.News;
import com.example.miguel.appexamen1.news.view.INews;

import org.json.JSONException;
import org.json.JSONObject;

public class NewsPresenter implements INewsPresenter {

    INews newsView;

    public NewsPresenter(INews newsView) {this.newsView = newsView;}

    @Override
    public void loadArticle() {
        NewsManager.
                getInstance(newsView.getNewsContext()).
                loadArticle(new JSONObjectRequestListener() {
                    @Override
                    public void onResponse(JSONObject response) {
                        News news = new News();
                        try {
                            news = News.jsonToObject(response.getJSONObject("payload"));
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }

                        newsView.onArticleResult(news,true,200);
                    }

                    @Override
                    public void onError(ANError anError) {
                        newsView.onArticleResult(null,false,500);
                    }
                });
        ;
    }
}
