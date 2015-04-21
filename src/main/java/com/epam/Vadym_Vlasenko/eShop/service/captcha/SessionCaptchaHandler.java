package com.epam.Vadym_Vlasenko.eShop.service.captcha;

import com.epam.Vadym_Vlasenko.eShop.web.Constants;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by swift-seeker-89717 on 17.04.2015.
 */
public class SessionCaptchaHandler extends GenericCaptchaHandler {

    @Override
    public void init(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    public void saveCaptchaParameters(HttpServletRequest request, HttpServletResponse response, String captchaContent) {
        request.getSession().setAttribute(Constants.CAPTCHA_CONTENT, captchaContent);
    }

    @Override
    public String getExpectedCaptchaValue(HttpServletRequest request) {
        return (String) request.getSession().getAttribute(Constants.CAPTCHA_CONTENT);
    }

    @Override
    public void removeCurrentCaptcha(HttpServletRequest request) {
        request.getSession().removeAttribute(Constants.CAPTCHA_CONTENT);
    }

    @Override
    public void updateCurrentCaptcha(HttpServletRequest request) {

    }
}
