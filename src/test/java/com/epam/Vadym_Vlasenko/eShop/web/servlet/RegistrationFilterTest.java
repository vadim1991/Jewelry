package com.epam.Vadym_Vlasenko.eShop.web.servlet;

import com.epam.Vadym_Vlasenko.eShop.entity.User;
import com.epam.Vadym_Vlasenko.eShop.entity.registration.RegistrationBean;
import com.epam.Vadym_Vlasenko.eShop.service.User.UserService;
import com.epam.Vadym_Vlasenko.eShop.service.captcha.ICaptchaHandler;
import com.epam.Vadym_Vlasenko.eShop.web.Constants;
import com.epam.Vadym_Vlasenko.eShop.web.filters.RegistrationFilter;
import org.junit.Before;
import org.junit.Test;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.io.IOException;

import static org.mockito.Mockito.mock;
import static org.junit.Assert.*;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

/**
 * Created by swift-seeker-89717 on 20.04.2015.
 */

public class RegistrationFilterTest {

    private static final String EMAIL_ATTRIBUTE = "email";
    private static final String LOGIN_ATTRIBUTE = "login";
    private static final String NAME_ATTRIBUTE = "name";
    private static final String SURNAME_ATTRIBUTE = "surname";
    private static final String PASSWORD_ATTRIBUTE = "password";
    private static final String CAPTCHA_ATTRIBUTE = "captcha";
    private static final String AGE_ATTRIBUTE = "age";
    private static final String CONFIRM_PASSWORD_ATTRIBUTE = "confirm";

    private static final String EMAIL = "vadim@mail.ru";
    private static final String LOGIN = "vadim91";
    private static final String PASSWORD = "vadim1991";
    private static final String CONFIRM_PASSWORD = "vadim1991";
    private static final String NAME = "Vadim";
    private static final String SURNAME = "Vlasenko";
    private static final String CAPTCHA = "qwerty";
    private static final String CAPTCHA_EXPECTED = "qwerty";
    private static final int AGE = 23;

    private static final String POST_METHOD = "post";
    private static final String PAGE = "page";
    private static final String USER_SERVICE = "user_service";
    private static final String CAPTCHA_HANDLER = "captchaHandler";

    private static final String FAILED_EMAIL = "vadim.mail.ru";

    private HttpServletRequest requestMock;
    private HttpServletResponse responseMock;
    private ICaptchaHandler captchaHandlerMock;
    private ServletContext contextMock;
    private ServletConfig configMock;
    private UserService userServiceMock;
    private FilterConfig filterConfigMock;
    private FilterChain filterChainMock;
    private RequestDispatcher requestDispatcherMock;


    @Before
    public void setup() {
        requestMock = mock(HttpServletRequest.class);
        responseMock = mock(HttpServletResponse.class);
        configMock = mock(ServletConfig.class);
        contextMock = mock(ServletContext.class);
        captchaHandlerMock = mock(ICaptchaHandler.class);
        userServiceMock = mock(UserService.class);
        filterConfigMock = mock(FilterConfig.class);
        filterChainMock = mock(FilterChain.class);
        requestDispatcherMock = mock(RequestDispatcher.class);
        initMock();
        initRequestAttribute();
    }

    @Test
    public void testValidRegistrationFormBean() {
        RegistrationBean registrationBean = getRegistrationBean(requestMock);
        assertTrue(registrationBean.isValid());
    }

    @Test
    public void testFailedRegistrationFormBean() {
        when(requestMock.getParameter(EMAIL_ATTRIBUTE)).thenReturn(FAILED_EMAIL);
        RegistrationBean registrationBean = getRegistrationBean(requestMock);
        assertFalse(registrationBean.isValid());
    }

    @Test
    public void testUniqueLogin() {
        when(requestMock.getParameter(EMAIL_ATTRIBUTE)).thenReturn(FAILED_EMAIL);
        when(userServiceMock.getUserByLogin(LOGIN)).thenReturn(new User());
        runFilter();
        verify(captchaHandlerMock).updateCurrentCaptcha(requestMock);
    }

    @Test
    public void testValidRegistrationFilter() {
        runFilter();
        verify(captchaHandlerMock).removeCurrentCaptcha(requestMock);
    }

    @Test
    public void testInvalidRegistrationFilter() {
        when(requestMock.getParameter(EMAIL_ATTRIBUTE)).thenReturn(FAILED_EMAIL);
        runFilter();
        verify(captchaHandlerMock).updateCurrentCaptcha(requestMock);
    }

    private void initRequestAttribute() {
        when(requestMock.getMethod()).thenReturn(POST_METHOD);
        when(requestMock.getParameter(NAME_ATTRIBUTE)).thenReturn(NAME);
        when(requestMock.getParameter(SURNAME_ATTRIBUTE)).thenReturn(SURNAME);
        when(requestMock.getParameter(LOGIN_ATTRIBUTE)).thenReturn(LOGIN);
        when(requestMock.getParameter(AGE_ATTRIBUTE)).thenReturn(String.valueOf(AGE));
        when(requestMock.getParameter(PASSWORD_ATTRIBUTE)).thenReturn(PASSWORD);
        when(requestMock.getParameter(CONFIRM_PASSWORD_ATTRIBUTE)).thenReturn(CONFIRM_PASSWORD);
        when(requestMock.getParameter(EMAIL_ATTRIBUTE)).thenReturn(EMAIL);
        when(requestMock.getParameter(CAPTCHA_ATTRIBUTE)).thenReturn(CAPTCHA);
    }

    private void initMock() {
        when(filterConfigMock.getServletContext()).thenReturn(contextMock);
        when(configMock.getServletContext()).thenReturn(contextMock);
        when(contextMock.getAttribute(USER_SERVICE)).thenReturn(userServiceMock);
        when(contextMock.getAttribute(CAPTCHA_HANDLER)).thenReturn(captchaHandlerMock);
        when(captchaHandlerMock.getExpectedCaptchaValue(requestMock)).thenReturn(CAPTCHA_EXPECTED);
        when(requestMock.getRequestDispatcher(Constants.REGISTRATION_PAGE)).thenReturn(requestDispatcherMock);
    }

    private RegistrationBean getRegistrationBean(HttpServletRequest request) {
        String name = request.getParameter(NAME_ATTRIBUTE);
        String login = request.getParameter(LOGIN_ATTRIBUTE);
        String password = request.getParameter(PASSWORD_ATTRIBUTE);
        String age = request.getParameter(AGE_ATTRIBUTE);
        String surname = request.getParameter(SURNAME_ATTRIBUTE);
        String email = request.getParameter(EMAIL_ATTRIBUTE);
        String confirm = request.getParameter(CONFIRM_PASSWORD_ATTRIBUTE);
        String captchaValue = request.getParameter(CAPTCHA_ATTRIBUTE);
        String actualCaptchaValue = captchaHandlerMock.getExpectedCaptchaValue(request);
        return new RegistrationBean(name, surname, age, login, password, email, confirm, actualCaptchaValue, captchaValue);
    }

    private void runFilter() {
        RegistrationFilter filterRegistration = new RegistrationFilter();
        try {
            filterRegistration.init(filterConfigMock);
            filterRegistration.doFilter(requestMock, responseMock, filterChainMock);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
