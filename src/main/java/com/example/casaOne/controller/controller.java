package com.example.casaOne.controller;

import com.example.casaOne.service.FurnitureService;
import com.example.casaOne.service.RatingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class controller {

    private FurnitureService furnitureService;
    private RatingService ratingService;

    @Autowired
    public controller(FurnitureService furnitureService, RatingService ratingService) {
        this.furnitureService = furnitureService;
        this.ratingService = ratingService;
    }

    @RequestMapping(method = RequestMethod.POST, value = "/furnitures")
    public void addFurniture(@RequestBody Map<String, Object> body, HttpServletRequest request, HttpServletResponse httpServletResponse) {
        try {
            this.furnitureService.addFurniture(body);
            httpServletResponse.setStatus(HttpServletResponse.SC_CREATED);
        } catch (Exception e) {
            httpServletResponse.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
        }
    }

    @RequestMapping(method = RequestMethod.POST, value = "/ratings")
    public void addRating(@RequestBody Map<String, Object> body, HttpServletRequest request, HttpServletResponse httpServletResponse) {
        try {
            this.ratingService.addRating(body);
            httpServletResponse.setStatus(HttpServletResponse.SC_CREATED);
        } catch (Exception e) {
            httpServletResponse.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
        }
    }

    @RequestMapping(method = RequestMethod.GET, value = "/ratings")
    @ResponseBody
    public List<HashMap<String, Double>> getRatings(@RequestParam Integer furnitureId, HttpServletRequest request, HttpServletResponse httpServletResponse) {
        try {
            return this.ratingService.getRatings(furnitureId);
        } catch (Exception e) {
            httpServletResponse.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
            return new ArrayList<>();
        }
    }


}
