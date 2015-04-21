package com.epam.Vadym_Vlasenko.eShop.service.captcha;

import com.epam.Vadym_Vlasenko.eShop.entity.Captcha;
import com.epam.Vadym_Vlasenko.eShop.web.Constants;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Date;
import java.util.Map;
import java.util.UUID;

/**
 * Created by swift-seeker-89717 on 19.04.2015.
 */
public class RequestCaptchaHandler extends ContextCaptchaHandler {
    public RequestCaptchaHandler(Map<UUID, Captcha> captchaMap) {
        super(captchaMap);
    }

    @Override
    public String getExpectedCaptchaValue(HttpServletRequest request) {
        Map<UUID, Captcha> captchaMap = (Map) request.getServletContext().getAttribute(Constants.CAPTCHA_MAP);
        UUID id = getCaptchaID(request);
        String captchaValue = "";
        if (id != null) {
            Captcha captcha = captchaMap.get(id);
            if (captcha != null) {
                captchaValue = captcha.getContent();
            }
        }
        return captchaValue;
    }

    @Override
    public void removeCurrentCaptcha(HttpServletRequest request) {
        captchaMap.remove(getCaptchaID(request));
    }

    @Override
    public void updateCurrentCaptcha(HttpServletRequest request) {
        captchaMap.remove(getCaptchaID(request));
        Captcha captcha = new Captcha();
        captcha.setDateCreated(new Date());
        captcha.setContent(generateCaptchaString());
        captcha.setUuid(UUID.randomUUID());
        request.setAttribute(Constants.CAPTCHA_ID, captcha.getUuid());
    }

    protected UUID getCaptchaID(HttpServletRequest request) {
        return UUID.fromString(request.getParameter(Constants.CAPTCHA_ID));
    }

    protected void saveCaptchaID(HttpServletRequest request, HttpServletResponse response, UUID captchaID) {
        Captcha captcha = new Captcha();
        captcha.setUuid(captchaID);
        captcha.setDateCreated(new Date());
        captcha.setContent(generateCaptchaString());
        captchaMap.put(captchaID, captcha);
        request.setAttribute(Constants.CAPTCHA_ID, captchaID);
    }
}

