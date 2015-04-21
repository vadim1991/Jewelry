package com.epam.Vadym_Vlasenko.eShop.service.captcha;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.awt.image.BufferedImage;
import java.io.IOException;

/**
 * Created by swift-seeker-89717 on 17.04.2015.
 */
public interface ICaptchaHandler {

    void init(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException;

    void saveCaptchaParameters(HttpServletRequest request, HttpServletResponse response, String captchaContent);

    String getExpectedCaptchaValue(HttpServletRequest request);

    void removeCurrentCaptcha(HttpServletRequest request);

    void updateCurrentCaptcha(HttpServletRequest request);

    String generateCaptchaString();

    BufferedImage createCaptchaImage(String captchaChars);
}
