package com.epam.Vadym_Vlasenko.eShop.db.query_builder;

import com.epam.Vadym_Vlasenko.eShop.db.query_builder.QueryBuilder;
import com.epam.Vadym_Vlasenko.eShop.entity.Criteria;

/**
 * Created by swift-seeker-89717 on 13.04.2015.
 */
public class QueryCreator {

    private static final String CATEGORY_FIELD = "category";
    private static final String PRICE_FIELD = "price";
    private static final String INSERT_FIELD = "insert_id";
    private static final String MATERIAL_FIELD = "material";
    private static final String WEIGHT_FIELD = "weight";

    public String where(String tableName, String nameColumn, String parameter) {
        QueryBuilder queryBuilder = new QueryBuilder();
        queryBuilder.select().all().from(tableName).where().whereParameter(nameColumn, parameter).end();
        return queryBuilder.toString();
    }

    public String buildCriteria(Criteria criteria, String tableName) {
        QueryBuilder queryBuilder = new QueryBuilder();
        queryBuilder.select().all().from(tableName);
        queryBuilder.where();
        if (criteria.getIdCategory() != 0) {
            String idCategory = String.valueOf(criteria.getIdCategory());
            queryBuilder.whereParameter(CATEGORY_FIELD, idCategory);
        }
        if (criteria.getMaxPrice() != null || criteria.getMinPrice() != null) {
            queryBuilder.and().between(PRICE_FIELD, criteria.getMinPrice(), criteria.getMaxPrice());
        }
        if (criteria.getMaxWeight() != null || criteria.getMinPrice() != null) {
            String minWeight = criteria.getMinWeight();
            String maxWeight = criteria.getMaxWeight();
            queryBuilder.and().between(WEIGHT_FIELD, minWeight, maxWeight);
        }
        if (criteria.getInsertId() != null) {
            queryBuilder.and().whereParameter(INSERT_FIELD, criteria.getInsertId());
        }
        if (criteria.getMaterialId() != null) {
            queryBuilder.and().whereParameter(MATERIAL_FIELD, criteria.getMaterialId());
        }
        queryBuilder.limit(criteria.getPositionFrom(), criteria.getProductOnPage()).end();
        return queryBuilder.toString();
    }

}
