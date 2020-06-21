package com.example.casaOne.model;

public class Furniture {
    private Integer furnitureId;
    private String category;
    private  String imageUrl;
    private String details;

    public Furniture(Integer furnitureId, String category, String imageUrl, String details) {
        this.furnitureId = furnitureId;
        this.category = category;
        this.imageUrl = imageUrl;
        this.details = details;
    }

    public Integer getFurnitureId() {
        return furnitureId;
    }

    public String getCategory() {
        return category;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public String getDetails() {
        return details;
    }
}
