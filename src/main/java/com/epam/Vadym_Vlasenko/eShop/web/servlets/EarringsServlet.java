package com.epam.Vadym_Vlasenko.eShop.web.servlets;

import com.epam.Vadym_Vlasenko.eShop.entity.Criteria;
import com.epam.Vadym_Vlasenko.eShop.entity.Product;
import com.epam.Vadym_Vlasenko.eShop.service.product.IProductService;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * Created by swift-seeker-89717 on 10.04.2015.
 */
@WebServlet("/earrings")
public class EarringsServlet extends HttpServlet {

    private IProductService productService;

    private static final String EARRINGS_ATTRIBUTE = "products";
    private static final String CURRENT_PAGE_ATTRIBUTE = "currentPage";
    private static final String PAGE_PARAMETER = "page";
    private static final String MIN_PRICE_PARAMETER = "minPrice";
    private static final String MAX_PRICE_PARAMETER = "maxPrice";
    private static final String MIN_WEIGHT_PARAMETER = "minWeight";
    private static final String MAX_WEIGHT_PARAMETER = "maxWeight";
    private static final String INSERT_PARAMETER = "insert";
    private static final String MATERIAL_PARAMETER = "material";
    private static final String PRODUCT_ON_PAGE_PARAMETER = "productOnPage";
    private static final String SORT_TYPE_PARAMETER = "sortType";

    @Override
    public void init(ServletConfig config) throws ServletException {
        ServletContext context = config.getServletContext();
        productService = (IProductService) context.getAttribute(Constants.PRODUCT_SERVICE);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPost(req, resp);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int page = 1;
        int records = 5;
        String pageValue = req.getParameter(PAGE_PARAMETER);
        if (pageValue != null) {
            page = Integer.parseInt(pageValue);
        }
        int countProduct = productService.getCountOfProduct(Constants.EARRINGS_CATEGORY);
        int noOfPages = (int) Math.ceil(countProduct * 1.0 / records);
        Criteria criteria = getCriteria(req, resp);
        criteria.setPositionFrom((page - 1) * records);
        criteria.setProductOnPage(records);
        List<Product> products = productService.getProductsByCriteria(criteria);
        if (products == null) {
            req.getRequestDispatcher(Constants.BED_REQUEST_PAGE).forward(req, resp);
            return;
        }
        req.setAttribute(EARRINGS_ATTRIBUTE, products);
        req.setAttribute("noOfPages", noOfPages);
        req.setAttribute(CURRENT_PAGE_ATTRIBUTE, page);
        req.getRequestDispatcher(Constants.EARRINGS_PAGE).forward(req, resp);
    }

    private Criteria getCriteria(HttpServletRequest request, HttpServletResponse response) {
        Criteria criteria = new Criteria();
        criteria.setIdCategory(Constants.EARRINGS_CATEGORY);
        criteria.setMaxPrice(request.getParameter(MAX_PRICE_PARAMETER));
        criteria.setMinPrice(request.getParameter(MIN_PRICE_PARAMETER));
        criteria.setMinWeight(request.getParameter(MIN_WEIGHT_PARAMETER));
        criteria.setMaxWeight(request.getParameter(MAX_WEIGHT_PARAMETER));
        criteria.setInsertId(request.getParameter(INSERT_PARAMETER));
        criteria.setMaterialId(request.getParameter(MATERIAL_PARAMETER));
        criteria.setSortType(request.getParameter(SORT_TYPE_PARAMETER));
        return criteria;
    }
}
