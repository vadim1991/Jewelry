package com.epam.Vadym_Vlasenko.eShop.web.servlets;

import com.epam.Vadym_Vlasenko.eShop.entity.Criteria;
import com.epam.Vadym_Vlasenko.eShop.entity.criteria.CriteriaResultBean;
import com.epam.Vadym_Vlasenko.eShop.service.product.IProductService;
import com.google.gson.Gson;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by swift-seeker-89717 on 05.04.2015.
 */
@WebServlet("/products")
public class ProductServlet extends HttpServlet {

    private static final String PRODUCT_SERVICE = "product_service";
    private static final int PRODUCT_ON_PAGE = 15;
    private static Criteria criteria;

    private IProductService service;

    @Override
    public void init(ServletConfig config) throws ServletException {
        ServletContext context = config.getServletContext();
        service = (IProductService) context.getAttribute(PRODUCT_SERVICE);
        criteria = new Criteria();
        criteria.setProductOnPage(PRODUCT_ON_PAGE);
        criteria.setPositionFrom(0);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Gson gson = new Gson();
        CriteriaResultBean resultBean = service.getProductsByCriteria(criteria);
        resp.getWriter().write(gson.toJson(resultBean.getProducts()));
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    }

}
