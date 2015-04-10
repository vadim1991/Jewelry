package com.epam.Vadym_Vlasenko.eShop.web.listener;

import com.epam.Vadym_Vlasenko.eShop.db.DBConnection;
import com.epam.Vadym_Vlasenko.eShop.db.dao.DAOFactory;
import com.epam.Vadym_Vlasenko.eShop.db.dao.IProductDAO;
import com.epam.Vadym_Vlasenko.eShop.db.dao.IUserDAO;
import com.epam.Vadym_Vlasenko.eShop.entity.cart.Cart;
import com.epam.Vadym_Vlasenko.eShop.service.User.UserService;
import com.epam.Vadym_Vlasenko.eShop.service.cart.CartService;
import com.epam.Vadym_Vlasenko.eShop.service.product.ProductService;
import com.epam.Vadym_Vlasenko.eShop.service.transaction.TransactionManager;
import com.epam.Vadym_Vlasenko.eShop.web.servlets.Constants;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

/**
 * Created by Вадим on 22.03.2015.
 */
@WebListener
public class ContextListener implements ServletContextListener {

    @Override
    public void contextInitialized(ServletContextEvent servletContextEvent) {
        ServletContext context = servletContextEvent.getServletContext();
        initService(context);
    }

    @Override
    public void contextDestroyed(ServletContextEvent servletContextEvent) {

    }

    public void initService(ServletContext servletContext) {
        TransactionManager tm = new TransactionManager(DBConnection.getConnectionHolder());
        IProductDAO productDAO = DAOFactory.getInstance().getProductDAO();
        IUserDAO userDAO = (IUserDAO) DAOFactory.getInstance().getUserDAO();
        servletContext.setAttribute(Constants.PRODUCT_SERVICE, new ProductService(tm, productDAO));
        servletContext.setAttribute(Constants.CART_SERVICE, new CartService(new Cart()));
        servletContext.setAttribute(Constants.USER_SERVICE, new UserService(userDAO, tm));
    }

}
