package com.epam.Vadym_Vlasenko.eShop.web.filters;

import com.epam.Vadym_Vlasenko.eShop.entity.registration.RegistrationBean;
import com.epam.Vadym_Vlasenko.eShop.service.User.UserService;
import com.epam.Vadym_Vlasenko.eShop.service.captcha.ICaptchaHandler;
import com.epam.Vadym_Vlasenko.eShop.web.Constants;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by swift-seeker-89717 on 09.04.2015.
 */
@WebFilter(urlPatterns = "/registration")
public class FilterRegistration implements Filter {

    private static final String MAP_ATTRIBUTE = "errors";
    private static final String LOGIN_EXISTS_ATTRIBUTE = "loginError";
    private static final String LOGIN_EXISTS_MESSAGE = "Пользователь с таким логином уже существует";
    private static final String USER_ATTRIBUTE = "user";
    private static final String FORM_ATTRIBUTE = "form";
    private static final String POST_REQUEST = "post";

    private static final String EMAIL_ATTRIBUTE = "email";
    private static final String LOGIN_ATTRIBUTE = "login";
    private static final String NAME_ATTRIBUTE = "name";
    private static final String SURNAME_ATTRIBUTE = "surname";
    private static final String PASSWORD_ATTRIBUTE = "password";
    private static final String CAPTCHA_ATTRIBUTE = "captcha";
    private static final String AGE_ATTRIBUTE = "age";
    private static final String CONFIRM_PASSWORD_ATTRIBUTE = "confirm";

    private UserService userService;
    private ICaptchaHandler captchaHandler;

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        ServletContext context = filterConfig.getServletContext();
        userService = (UserService) context.getAttribute(Constants.USER_SERVICE);
        captchaHandler = (ICaptchaHandler) context.getAttribute(Constants.CAPTCHA_HANDLER);
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        if (request.getMethod().equalsIgnoreCase(POST_REQUEST)) {
            RegistrationBean registrationBean = getRegistrationBean(request);
            if (!registrationBean.isValid()) {
                captchaHandler.updateCurrentCaptcha(request);
                captchaHandler.init(request, (HttpServletResponse) servletResponse);
                request.setAttribute(MAP_ATTRIBUTE, registrationBean.getErrors());
                request.setAttribute(FORM_ATTRIBUTE, registrationBean);
                RequestDispatcher requestDispatcher = request.getRequestDispatcher(Constants.REGISTRATION_PAGE);
                requestDispatcher.forward(request, servletResponse);
                return;
            }
            if (userService.getUserByLogin(registrationBean.getLogin()) != null) {
                captchaHandler.updateCurrentCaptcha(request);
                captchaHandler.init(request, (HttpServletResponse) servletResponse);
                request.setAttribute(LOGIN_EXISTS_ATTRIBUTE, LOGIN_EXISTS_MESSAGE);
                request.setAttribute(FORM_ATTRIBUTE, registrationBean);
                request.getRequestDispatcher(Constants.REGISTRATION_PAGE).forward(request, servletResponse);
                return;
            }
            captchaHandler.removeCurrentCaptcha(request);
            request.setAttribute(USER_ATTRIBUTE, registrationBean.getUser());
        }
        filterChain.doFilter(servletRequest, servletResponse);
    }

    @Override
    public void destroy() {

    }

    private RegistrationBean getRegistrationBean(HttpServletRequest request) {
        String name = request.getParameter(NAME_ATTRIBUTE);
        String login = request.getParameter(LOGIN_ATTRIBUTE);
        String password = request.getParameter(PASSWORD_ATTRIBUTE);
        String age = request.getParameter(AGE_ATTRIBUTE);
        String surname = request.getParameter(SURNAME_ATTRIBUTE);
        String email = request.getParameter(EMAIL_ATTRIBUTE);
        String confirm = request.getParameter(CONFIRM_PASSWORD_ATTRIBUTE);
        String captchaValue = request.getParameter(Constants.CURRENT_CAPTCHA_VALUE);
        String actualCaptchaValue = captchaHandler.getExpectedCaptchaValue(request);
        System.out.println(captchaValue);
        System.out.println(actualCaptchaValue);
        return new RegistrationBean(name, surname, age, login, password, email, confirm, actualCaptchaValue, captchaValue);
    }
}
