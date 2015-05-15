package com.epam.Vadym_Vlasenko.eShop.web.filters;

import com.epam.Vadym_Vlasenko.eShop.entity.registration.RegistrationBean;
import com.epam.Vadym_Vlasenko.eShop.service.User.UserService;
import com.epam.Vadym_Vlasenko.eShop.service.captcha.ICaptchaHandler;
import com.epam.Vadym_Vlasenko.eShop.web.Constants;
import org.apache.log4j.Logger;

import javax.servlet.*;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import java.io.IOException;
import java.util.Enumeration;
import java.util.UUID;

/**
 * Created by swift-seeker-89717 on 09.04.2015.
 */
@WebFilter(urlPatterns = "/registration")
@MultipartConfig
public class RegistrationFilter implements Filter {

    private static final Logger LOG = Logger.getLogger(RegistrationFilter.class);

    private static final String MAP_ATTRIBUTE = "errors";
    private static final String LOGIN_EXISTS_ATTRIBUTE = "loginError";
    private static final String LOGIN_EXISTS_MESSAGE = "Пользователь с таким логином уже существует";
    private static final String USER_ATTRIBUTE = "user";
    private static final String FORM_ATTRIBUTE = "form";
    private static final String POST_REQUEST = "post";

    private static final String FILE_UPLOAD_ATTRIBUTE = "files";
    private static final String EMAIL_ATTRIBUTE = "email";
    private static final String LOGIN_ATTRIBUTE = "login";
    private static final String NAME_ATTRIBUTE = "name";
    private static final String SURNAME_ATTRIBUTE = "surname";
    private static final String PASSWORD_ATTRIBUTE = "password";
    private static final String AGE_ATTRIBUTE = "age";
    private static final String CONFIRM_PASSWORD_ATTRIBUTE = "confirm";

    private static final String JPG_TYPE = ".jpg";
    private static final String IMAGE_PATH_IN_WEB = "\\images\\avatar\\";
    private static final String IMAGE_PATH = "/images/avatar/";
    private static final String DEFAULT_IMAGE_PATH = "\\images\\avatar\\unknown-person.png";

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
        if (POST_REQUEST.equalsIgnoreCase(request.getMethod())) {
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

    private String readJPGFile(HttpServletRequest request) throws ServletException, IOException {
        Part filePart = request.getPart(FILE_UPLOAD_ATTRIBUTE);
        String fileName = DEFAULT_IMAGE_PATH;
        if (filePart != null) {
            if (filePart.getSize() > 0) {
                fileName = UUID.randomUUID().toString() + JPG_TYPE;
                String fullFilePath = request.getServletContext().getRealPath(IMAGE_PATH + fileName);
                filePart.write(fullFilePath);
                fileName = IMAGE_PATH_IN_WEB + fileName;
            }
        }
        return fileName;
    }

    private RegistrationBean getRegistrationBean(HttpServletRequest request) throws ServletException, IOException {
        RegistrationBean registrationBean = new RegistrationBean();
        registrationBean.setAvatarPath(readJPGFile(request));
        registrationBean.setName(request.getParameter(NAME_ATTRIBUTE));
        registrationBean.setLogin(request.getParameter(LOGIN_ATTRIBUTE));
        registrationBean.setPassword(request.getParameter(PASSWORD_ATTRIBUTE));
        registrationBean.setAge(request.getParameter(AGE_ATTRIBUTE));
        registrationBean.setSurname(request.getParameter(SURNAME_ATTRIBUTE));
        registrationBean.setEmail(request.getParameter(EMAIL_ATTRIBUTE));
        registrationBean.setConfirmPassword(request.getParameter(CONFIRM_PASSWORD_ATTRIBUTE));
        registrationBean.setCaptcha(request.getParameter(Constants.CURRENT_CAPTCHA_VALUE));
        registrationBean.setCurrentCaptcha(captchaHandler.getExpectedCaptchaValue(request));
        return registrationBean;
    }
}
