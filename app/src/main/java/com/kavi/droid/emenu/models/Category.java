package com.kavi.droid.emenu.models;

/**
 * Created by kavi707 on 8/6/16.
 * @author Kavimal Wijewardana <kavi707@gmail.com>
 */
public class Category {

    private String id;
    private String categoryName;
    private String categoryImageUrl;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    public String getCategoryImageUrl() {
        return categoryImageUrl;
    }

    public void setCategoryImageUrl(String categoryImageUrl) {
        this.categoryImageUrl = categoryImageUrl;
    }
}
