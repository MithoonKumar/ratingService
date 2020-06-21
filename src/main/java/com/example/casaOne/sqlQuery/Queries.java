package com.example.casaOne.sqlQuery;

public class Queries {
    public static String addFurnitureSql = "insert into furniture (furnitureId, category, imageUrl, details) values(?, ?, ?, ?)";
    public static String addRatingSql = "insert into rating (furnitureId, userId, comment, imageUrl, starRating) values(?, ?, ?, ?, ?)";
    public static String getRatingsSql = "select count(*) as count, starRating from rating where furnitureId = ? group by starRating order by starRating";
}
