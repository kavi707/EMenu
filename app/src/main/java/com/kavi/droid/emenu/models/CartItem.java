package com.kavi.droid.emenu.models;

/**
 * Created by kavi707 on 8/17/16.
 * @author Kavimal Wijewardana <kavi707@gmail.com>
 */
public class CartItem {

    private String imageUrl;
    private String name;
    private String comments;
    private double amount;
    private int qty;

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getComments() {
        return comments;
    }

    public void setComments(String comments) {
        this.comments = comments;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public int getQty() {
        return qty;
    }

    public void setQty(int qty) {
        this.qty = qty;
    }
}