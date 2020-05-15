package com.example.mica.Model;

public class Intern {

    private String company,job,imgurl;
    private int review;
    private float rating;
    private String drawableResources;
    private String description;

    public Intern() {
    }

    public Intern(String drawableResources) {
        this.drawableResources = drawableResources;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Intern(String company, String job, String imgurl, int review, float rating, String drawableResources,String desc) {
        this.company = company;
        this.job = job;
        this.imgurl = imgurl;
        this.review = review;
        this.rating = rating;
        this.description=desc;
        this.drawableResources = drawableResources;
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
        return drawableResources;
    }

    public void setDrawableResources(String drawableResources) {
        this.drawableResources = drawableResources;
    }
}