package com.example.casaOne.service;

import com.example.casaOne.constants.AppConstants;
import com.example.casaOne.model.Furniture;
import com.example.casaOne.repository.FurnitureRepoInterface;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.Map;

@Service
public class FurnitureService {

    private Logger logger = LoggerFactory.getLogger(FurnitureService.class.getName());

    private FurnitureRepoInterface furnitureDao;

    @Autowired
    public FurnitureService(FurnitureRepoInterface furnitureDao) {
        this.furnitureDao = furnitureDao;
    }

    public void addFurniture(Map<String, Object> body) throws Exception {
        Integer furnitureId;
        String category, imageUrl, details;
        try {
            furnitureId = (Integer) body.get(AppConstants.FURNITURE_ID);
            category = (String) body.get(AppConstants.CATEGORY);
            imageUrl = (String) body.get(AppConstants.IMAGE_URL);
            details = (String) body.get(AppConstants.DETAILS);
        } catch (Exception e) {
            logger.error("Error while parsing request body into furniture object");
            throw new Exception(e);
        }
        Furniture furniture = new Furniture(furnitureId, category, imageUrl, details);
        try {
            this.furnitureDao.addFurniture(furniture);
        } catch (Exception e) {
            logger.error("Error while adding furniture to the table");
            throw new Exception(e);
        }
    }

}
