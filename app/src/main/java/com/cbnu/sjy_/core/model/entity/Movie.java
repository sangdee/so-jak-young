package com.cbnu.sjy_.core.model.entity;

import com.cbnu.sjy_.base.model.BaseEntity;

/**
 * @author : Sangji Lee
 * @when : 2019-11-22 오전 12:31
 * @homepage : https://github.com/sangji11
 */
public class Movie extends BaseEntity {
    private int id;
    private String name;
    private String directors;
    private String companys;
    private String story;
    private String imageUrl;
    private int like;
    private boolean screening;

    public Movie(){

    }

    public int getLike() {
        return like;
    }

    public void setLike(int like) {
        this.like = like;
    }

    public boolean getScreening() {
        return screening;
    }

    public void setScreening(boolean screening) {
        this.screening = screening;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDirectors() {
        return directors;
    }

    public void setDirectors(String directors) {
        this.directors = directors;
    }

    public String getCompanys() {
        return companys;
    }

    public void setCompanys(String companys) {
        this.companys = companys;
    }

    public String getStory() {
        return story;
    }

    public void setStory(String story) {
        this.story = story;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }
}
