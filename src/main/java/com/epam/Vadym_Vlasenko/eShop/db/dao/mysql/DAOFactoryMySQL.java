package com.epam.Vadym_Vlasenko.eShop.db.dao.mysql;

import com.epam.Vadym_Vlasenko.eShop.db.dao.DAOFactory;
import com.epam.Vadym_Vlasenko.eShop.db.dao.IProductDAO;

/**
 * Created by Вадим on 22.03.2015.
 */
public class DAOFactoryMySQL extends DAOFactory {
    @Override
    public IProductDAO getProductDAO() {
        return new ProductDaoMySQL();
    }
}
