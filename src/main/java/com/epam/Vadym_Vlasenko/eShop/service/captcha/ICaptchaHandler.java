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
    public void init(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException;

    public void saveCaptchaParameters(HttpServletRequest request, HttpServletResponse response, String captchaContent);

    public String getExpectedCaptchaValue(HttpServletRequest request);

    public void removeCurrentCaptcha(HttpServletRequest request);

    public void updateCurrentCaptcha(HttpServletRequest request);

    public String generateCaptchaString();

    public BufferedImage createCaptchaImage(String captchaChars);
}
