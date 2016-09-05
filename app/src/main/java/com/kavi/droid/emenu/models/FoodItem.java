package com.kavi.droid.emenu.models;

/**
 * Created by kavi707 on 8/6/16.
 * @author Kavimal Wijewardana <kavi707@gmail.com>
 */
public class FoodItem {

    private String id;
    private String name;
    private String description;
    private int rating;
    private String categoryId;
    private String option; // VEG/CHICKEN/FISH
    private Price itemPrices;
    private String thumbImgUrlOne;
    private String thumbImgUrlTwo;
    private String imgUrl;
    private boolean isSelected;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    public String getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(String categoryId) {
        this.categoryId = categoryId;
    }

    public String getOption() {
        return option;
    }

    public void setOption(String option) {
        this.option = option;
    }

    public Price getItemPrices() {
        return itemPrices;
    }

    public void setItemPrices(Price itemPrices) {
        this.itemPrices = itemPrices;
    }

    public String getThumbImgUrlOne() {
        return thumbImgUrlOne;
    }

    public void setThumbImgUrlOne(String thumbImgUrlOne) {
        this.thumbImgUrlOne = thumbImgUrlOne;
    }

    public String getThumbImgUrlTwo() {
        return thumbImgUrlTwo;
    }

    public void setThumbImgUrlTwo(String thumbImgUrlTwo) {
        this.thumbImgUrlTwo = thumbImgUrlTwo;
    }

    public String getImgUrl() {
        return imgUrl;
    }

    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl;
    }

    public boolean isSelected() {
        return isSelected;
    }

    public void setSelected(boolean selected) {
        isSelected = selected;
    }
}
