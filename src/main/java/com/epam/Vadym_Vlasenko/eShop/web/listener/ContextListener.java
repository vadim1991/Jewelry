package com.epam.Vadym_Vlasenko.eShop.web.listener;

import com.epam.Vadym_Vlasenko.eShop.db.DBConnection;
import com.epam.Vadym_Vlasenko.eShop.db.dao.DAOFactory;
import com.epam.Vadym_Vlasenko.eShop.db.dao.IProductDAO;
import com.epam.Vadym_Vlasenko.eShop.service.product.IProductService;
import com.epam.Vadym_Vlasenko.eShop.service.product.ProductService;
import com.epam.Vadym_Vlasenko.eShop.service.transaction.TransactionManager;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

/**
 * Created by Вадим on 22.03.2015.
 */
@WebListener
public class ContextListener implements ServletContextListener {

    private static final String PRODUCT_SERVICE = "product_service";

    @Override
    public void contextInitialized(ServletContextEvent servletContextEvent) {
        ServletContext context = servletContextEvent.getServletContext();
        initService(context);
        System.out.println("initial context");
    }

    @Override
    public void contextDestroyed(ServletContextEvent servletContextEvent) {

    }

    public void initService(ServletContext servletContext) {
        TransactionManager tm = new TransactionManager(DBConnection.getConnectionHolder());
        IProductDAO productDAO = DAOFactory.getInstance().getProductDAO();
        servletContext.setAttribute(PRODUCT_SERVICE, new ProductService(tm, productDAO));
    }

}
