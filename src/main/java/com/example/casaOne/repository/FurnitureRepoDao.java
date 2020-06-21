package com.example.casaOne.repository;

import com.example.casaOne.model.Furniture;
import com.example.casaOne.sqlQuery.Queries;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;

@Repository
public class FurnitureRepoDao extends JdbcDaoSupport implements FurnitureRepoInterface {

    private DataSource dataSource;

    @Autowired
    public FurnitureRepoDao(DataSource dataSource) {
        this.dataSource = dataSource;
        setDataSource(dataSource);
    }

    public void addFurniture(Furniture furniture) {
        String sql = Queries.addFurnitureSql;
        getJdbcTemplate().update(sql, new Object[]{
                furniture.getFurnitureId(), furniture.getCategory(), furniture.getImageUrl(), furniture.getDetails()
        });
    }

}
