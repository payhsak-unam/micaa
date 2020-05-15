package com.example.mica.Model;

import android.graphics.Bitmap;

public class Job {

    private String company,job,imgurl;
    private int review;
    private float rating;
    private String drawableResources;
    private String description;
    private String date1;
    private String date2;

    public Job() {
    }

    public Job(String drawableResources) {
        this.drawableResources = drawableResources;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Job(String company, String job, String imgurl, int review, float rating, String drawableResources,String desc,String date1,String date2) {
        this.company = company;
        this.job = job;
        this.imgurl = imgurl;
        this.review = review;
        this.rating = rating;
        this.description=desc;
        this.drawableResources = drawableResources;
        this.date1=date1;
        this.date2=date2;
    }

    public String getDate1() {
        return date1;
    }

    public void setDate1(String date1) {
        this.date1 = date1;
    }

    public String getDate2() {
        return date2;
    }

    public void setDate2(String date2) {
        this.date2 = date2;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public String getJob() {
        return job;
    }

    public void setJob(String job) {
        this.job = job;
    }

    public String getImgurl() {
        return imgurl;
    }

    public void setImgurl(String imgurl) {
        this.imgurl = imgurl;
    }

    public int getReview() {
        return review;
    }

    public void setReview(int review) {
        this.review = review;
    }

    public float getRating() {
        return rating;
    }

    public void setRating(float rating) {
        this.rating = rating;
    }

    public String getDrawableResources() {
        return this.drawableResources;
    }

    public void setDrawableResources(String drawableResources) {
        this.drawableResources = drawableResources;
    }
}
