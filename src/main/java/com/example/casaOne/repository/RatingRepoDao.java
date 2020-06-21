package com.example.casaOne.repository;

import com.example.casaOne.model.Rating;
import com.example.casaOne.sqlQuery.Queries;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class RatingRepoDao extends JdbcDaoSupport implements RatingRepoInterface{

    private DataSource dataSource;

    @Autowired
    public RatingRepoDao(DataSource dataSource) {
        this.dataSource = dataSource;
        setDataSource(dataSource);
    }

    public void addRating(Rating rating) {
        String sql = Queries.addRatingSql;
        getJdbcTemplate().update(sql, new Object[]{
                rating.getFurnitureId(), rating.getUserId(), rating.getComment(), rating.getImageUrl(), rating.getStarRating()
        });
    }

    public List<HashMap<String, Double>> getRatings(Integer furnitureId) {
        String sql = Queries.getRatingsSql;
        List<Map<String ,Object>> rows = getJdbcTemplate().queryForList(sql, new Object[]{furnitureId});
        List<HashMap<String, Double>> ratingsCountList = new ArrayList<>();
        for(Map<String, Object> row:rows){
            HashMap<String, Double> ratingMap =  new HashMap<>();
            for (Map.Entry<String, Object> entry: row.entrySet()) {
                Double val = Double.parseDouble(entry.getValue().toString());
                ratingMap.put(entry.getKey(), val);
            }
            ratingsCountList.add(ratingMap);
        }
        return ratingsCountList;
    }
}
