package com.example.casaOne.repository;

import com.example.casaOne.model.Rating;

import java.util.HashMap;
import java.util.List;

public interface RatingRepoInterface {

    void addRating(Rating rating);

    List<HashMap<String, Double>> getRatings(Integer furnitureId);

}
