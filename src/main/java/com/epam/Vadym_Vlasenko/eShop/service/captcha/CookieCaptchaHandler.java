package com.epam.Vadym_Vlasenko.eShop.service.captcha;

import com.epam.Vadym_Vlasenko.eShop.entity.Captcha;
import com.epam.Vadym_Vlasenko.eShop.web.servlets.Constants;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Date;
import java.util.Map;
import java.util.UUID;

/**
 * Created by swift-seeker-89717 on 17.04.2015.
 */
public class CookieCaptchaHandler extends ContextCaptchaHandler {

    protected CookieCaptchaHandler(Map<UUID, Captcha> captchaMap) {
        super(captchaMap);
    }

    @Override
    protected UUID getCaptchaID(HttpServletRequest request) {
        for (Cookie cookie : request.getCookies()) {
            if (cookie.getName().equals(Constants.CAPTCHA_ID)) {
                return UUID.fromString(cookie.getValue());
            }
        }
        return null;
    }

    @Override
    protected void saveCaptchaID(HttpServletRequest request, HttpServletResponse response, UUID captchaID) {
        Captcha captcha = new Captcha();
        captcha.setUuid(captchaID);
        captcha.setDateCreated(new Date());
        captcha.setContent(generateCaptchaString());
        captchaMap.put(captchaID, captcha);
        response.addCookie(new Cookie(Constants.CAPTCHA_ID, captcha.getUuid().toString()));
    }

    @Override
    public String getExpectedCaptchaValue(HttpServletRequest request) {
        return captchaMap.get(getCaptchaID(request)).getContent();
    }

    @Override
    public void removeCurrentCaptcha(HttpServletRequest request) {
        captchaMap.remove(getCaptchaID(request));
    }

    @Override
    public void updateCurrentCaptcha(HttpServletRequest request) {
        UUID id = getCaptchaID(request);
        Captcha captcha = captchaMap.get(id);
        captcha.setContent(generateCaptchaString());
        captchaMap.put(id, captcha);
    }
}
