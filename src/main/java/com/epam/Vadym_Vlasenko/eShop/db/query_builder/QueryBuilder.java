package com.epam.Vadym_Vlasenko.eShop.db.query_builder;

import com.epam.Vadym_Vlasenko.eShop.db.SortType;

/**
 * Created by swift-seeker-89717 on 13.04.2015.
 */
public class QueryBuilder {

    private StringBuilder baseQuery;

    private static final String WHERE = "WHERE";
    private static final String LIKE = "LIKE";
    private static final String FROM = "FROM";
    private static final String SELECT = "SELECT SQL_CALC_FOUND_ROWS";
    private static final String LIMIT = "LIMIT";
    private static final String ALL = "*";
    private static final String SPACE = " ";
    private static final String COMMA = ",";
    private static final String AND = "AND";
    private static final String ORDER = "ORDER BY";
    private static final String BETWEEN = "BETWEEN";
    private static final String SEMICOLON = ";";
    private static final String EQUALS = "=";

    public QueryBuilder() {
        this.baseQuery = new StringBuilder();
    }

    public QueryBuilder select() {
        baseQuery.append(SELECT).append(SPACE);
        return this;
    }

    public QueryBuilder orderBy(String sortType) {
        baseQuery.append(ORDER).append(SPACE).append(SortType.choose(sortType)).append(SPACE);
        return this;
    }

    public QueryBuilder all() {
        baseQuery.append(ALL)
                .append(SPACE);
        return this;
    }

    public QueryBuilder from(String tableName) {
        baseQuery.append(FROM)
                .append(SPACE)
                .append(tableName)
                .append(SPACE);
        return this;
    }

    public QueryBuilder where() {
        baseQuery.append(WHERE)
                .append(SPACE);
        return this;
    }

    public QueryBuilder whereParameter(String nameColumn, String parameter) {
        baseQuery.append(nameColumn)
                .append(EQUALS)
                .append(parameter)
                .append(SPACE);
        return this;
    }

    public QueryBuilder and() {
        baseQuery.append(AND)
                .append(SPACE);
        return this;
    }

    public QueryBuilder between(String nameColumn, String minParameter, String maxParameter) {
        baseQuery.append(nameColumn)
                .append(SPACE)
                .append(BETWEEN)
                .append(SPACE)
                .append(minParameter)
                .append(SPACE)
                .append(AND)
                .append(SPACE)
                .append(maxParameter)
                .append(SPACE);
        return this;
    }

    public QueryBuilder end() {
        baseQuery.append(SEMICOLON);
        return this;
    }

    public QueryBuilder limit(int positionFrom, int productOnPage) {
        baseQuery.append(LIMIT)
                .append(SPACE)
                .append(positionFrom)
                .append(COMMA)
                .append(productOnPage)
                .append(SPACE);
        return this;
    }

    public String toString() {
        return baseQuery.toString();
    }

}
