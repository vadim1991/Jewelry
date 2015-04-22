package com.epam.Vadym_Vlasenko.eShop.web.listener;

import com.epam.Vadym_Vlasenko.eShop.db.DBConnectionHolder;
import com.epam.Vadym_Vlasenko.eShop.db.dao.*;
import com.epam.Vadym_Vlasenko.eShop.entity.Captcha;
import com.epam.Vadym_Vlasenko.eShop.entity.cart.Cart;
import com.epam.Vadym_Vlasenko.eShop.service.User.UserService;
import com.epam.Vadym_Vlasenko.eShop.service.captcha.*;
import com.epam.Vadym_Vlasenko.eShop.service.cart.CartService;
import com.epam.Vadym_Vlasenko.eShop.service.order.OrderService;
import com.epam.Vadym_Vlasenko.eShop.service.product.ProductService;
import com.epam.Vadym_Vlasenko.eShop.service.security_service.SecurityService;
import com.epam.Vadym_Vlasenko.eShop.service.transaction.TransactionManager;
import com.epam.Vadym_Vlasenko.eShop.web.Constants;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;
import java.io.File;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Created by Вадим on 22.03.2015.
 */
@WebListener
public class ContextListener implements ServletContextListener {

    @Override
    public void contextInitialized(ServletContextEvent servletContextEvent) {
        ServletContext context = servletContextEvent.getServletContext();
        initService(context);
        captchaHandlerInit(context);
    }

    @Override
    public void contextDestroyed(ServletContextEvent servletContextEvent) {

    }

    private void captchaHandlerInit(ServletContext context) {
        Map<String, ICaptchaHandler> captchaHandlerMap = new HashMap<>();
        Map<UUID, Captcha> captchaMap = new ConcurrentHashMap<>();
        captchaHandlerMap.put(Constants.SESSION_HANDLER_TYPE, new SessionCaptchaHandler());
        captchaHandlerMap.put(Constants.COOKIE_HANDLER_TYPE, new CookieCaptchaHandler(captchaMap));
        captchaHandlerMap.put(Constants.REQUEST_HANDLER_TYPE, new RequestCaptchaHandler(captchaMap));
        String handlerType = context.getInitParameter(Constants.CAPTCHA_HANDLER_TYPE);
        ICaptchaHandler captchaHandler = captchaHandlerMap.get(handlerType);
        if (captchaHandler == null) {
            captchaHandler = new SessionCaptchaHandler();
        }
        if (captchaHandler instanceof RequestCaptchaHandler) {
            new CaptchaTimeout(captchaMap, captchaHandler).start();
        }
        context.setAttribute(Constants.CAPTCHA_MAP, captchaMap);
        context.setAttribute(Constants.CAPTCHA_HANDLER, captchaHandler);

    }

    public void initService(ServletContext servletContext) {
        String configParamXml = servletContext.getInitParameter(Constants.XML_SECURITY);
        String securityFileName = servletContext.getRealPath(configParamXml);
        DBConnectionHolder connectionHolder = DBConnectionHolder.getConnectionHolder();
        connectionHolder.setConnectionPoolDataSource();
        TransactionManager tm = new TransactionManager(connectionHolder);
        IProductDAO productDAO = DAOFactory.getInstance().getProductDAO();
        IUserDAO userDAO = DAOFactory.getInstance().getUserDAO();
        IOrderDAO orderDAO = DAOFactory.getInstance().getOrderDAO();
        IOrderInfoDAO orderInfoDAO = DAOFactory.getInstance().getOrderInfoDAO();
        servletContext.setAttribute(Constants.PRODUCT_SERVICE, new ProductService(tm, productDAO));
        servletContext.setAttribute(Constants.CART_SERVICE, new CartService(new Cart()));
        servletContext.setAttribute(Constants.USER_SERVICE, new UserService(userDAO, tm));
        servletContext.setAttribute(Constants.ORDER_SERVICE, new OrderService(tm, orderDAO, orderInfoDAO));
        servletContext.setAttribute(Constants.SECURITY_SERVICE, new SecurityService(securityFileName));
    }

}
