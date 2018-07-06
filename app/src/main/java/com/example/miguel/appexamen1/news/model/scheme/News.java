package com.example.miguel.appexamen1.news.model.scheme;

import org.json.JSONObject;

import java.sql.Timestamp;

public class News {
    private String title;
    private String content;
    private Timestamp createdAt;
    private Integer comments;
    private Integer visualizations;
    private Integer likes;

    public News(){}

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Timestamp getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Timestamp createdAt) {
        this.createdAt = createdAt;
    }

    public Integer getComments() {
        return comments;
    }

    public void setComments(Integer comments) {
        this.comments = comments;
    }

    public Integer getVisualizations() {
        return visualizations;
    }

    public void setVisualizations(Integer visualizations) {
        this.visualizations = visualizations;
    }

    public Integer getLikes() {
        return likes;
    }

    public void setLikes(Integer likes) {
        this.likes = likes;
    }

    public static News jsonToObject(JSONObject jsonObject) {
        News news = new News();
        news.setTitle(jsonObject.optString("title"));
        news.setContent(jsonObject.optString("content"));
        news.setCreatedAt(new Timestamp(jsonObject.optLong("created")));
        news.setComments(jsonObject.optInt("comments"));
        news.setVisualizations(jsonObject.optInt("visualizations"));
        news.setLikes(jsonObject.optInt("likes"));
        return news;
    }
}
