package com.epam.Vadym_Vlasenko.eShop.db;

/**
 * Created by swift-seeker-89717 on 13.04.2015.
 */
public enum SortType {

    PRICE_ASC, PRICE_DESC;

    public static String choose(String sortType) {
        String result = null;
        switch (sortType) {
            case "1":
                result = "price ASC";
                break;
            case "2":
                result = "price DESC";
                break;
        }
        return result;
    }

}
