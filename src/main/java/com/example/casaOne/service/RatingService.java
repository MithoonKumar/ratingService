package com.example.casaOne.service;

import com.example.casaOne.constants.AppConstants;
import com.example.casaOne.model.Rating;
import com.example.casaOne.repository.RatingRepoInterface;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class RatingService {

    private Logger logger = LoggerFactory.getLogger(RatingService.class.getName());
    private RatingRepoInterface ratingRepo;

    @Autowired
    public RatingService(RatingRepoInterface ratingRepo) {
        this.ratingRepo = ratingRepo;
    }

    public void addRating(Map<String, Object> objectMap) throws Exception {
        Rating rating;
        try {
            Integer furnitureId = (Integer) objectMap.get(AppConstants.FURNITURE_ID);
            String comment = (String) objectMap.get(AppConstants.COMMENT);
            String imageUrl = (String) objectMap.get(AppConstants.IMAGE_URL);
            Integer starRating = (Integer) objectMap.get(AppConstants.STAR_RATING);
            Integer userId = (Integer) objectMap.get(AppConstants.USER_ID);
            rating = new Rating(furnitureId, userId, comment, imageUrl, starRating);
        } catch (Exception e) {
            this.logger.error("Error while parsing request body");
            throw new Exception(e);
        }
        try {
            this.ratingRepo.addRating(rating);
        } catch (Exception e) {
            this.logger.error("Error while adding rating to the repository");
            throw new Exception(e);
        }
    }

    public  List<HashMap<String, Double>>  getRatings(Integer furnitureId) throws Exception {
        List<HashMap<String, Double>> ratingsList;
        try {
             ratingsList = this.ratingRepo.getRatings(furnitureId);
        } catch (Exception e) {
            this.logger.error("Error while fetching ratings from database");
            throw new Exception(e);
        }
        Double overAllRatingNumerator = 0.0, overAllRatingDenominator = 0.0;
        for (Map<String, Double> ele: ratingsList) {
            overAllRatingNumerator += (ele.get(AppConstants.STAR_RATING) * ele.get(AppConstants.COUNT));
            overAllRatingDenominator += (ele.get(AppConstants.COUNT));
        }
        HashMap<String, Double> overAllRating = new HashMap<>();
        if (overAllRatingDenominator == 0.0) {
            overAllRating.put(AppConstants.OVERALL_RATING, 0.0);
        } else {
            overAllRating.put(AppConstants.OVERALL_RATING, overAllRatingNumerator/overAllRatingDenominator);
        }
        ratingsList.add(overAllRating);
        return ratingsList;
    }
}
