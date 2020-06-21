package com.example.casaOne.model;

public class Rating {
    private Integer furnitureId;
    private Integer userId;
    private String comment;
    private String imageUrl;
    private Integer starRating;


    public Rating(Integer furnitureId, Integer userId, String comment, String imageUrl, Integer starRating) {
        this.furnitureId = furnitureId;
        this.userId = userId;
        this.comment = comment;
        this.imageUrl = imageUrl;
        this.starRating = starRating;
    }

    public Integer getUserId() {
        return userId;
    }

    public Integer getFurnitureId() {
        return furnitureId;
    }

    public Integer getStarRating() {
        return starRating;
    }

    public String getComment() {
        return comment;
    }

    public String getImageUrl() {
        return imageUrl;
    }
}
