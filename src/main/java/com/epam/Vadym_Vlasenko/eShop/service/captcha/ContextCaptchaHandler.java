package com.epam.Vadym_Vlasenko.eShop.service.captcha;

import com.epam.Vadym_Vlasenko.eShop.entity.Captcha;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Map;
import java.util.UUID;

/**
 * Created by swift-seeker-89717 on 17.04.2015.
 */
public abstract class ContextCaptchaHandler extends GenericCaptchaHandler {

    protected Map<UUID, Captcha> captchaMap;

    protected ContextCaptchaHandler(Map<UUID, Captcha> captchaMap) {
        this.captchaMap = captchaMap;
    }

    @Override
    public void init(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        saveCaptchaID(request, response, generateCaptchaID());
    }

    @Override
    public void saveCaptchaParameters(HttpServletRequest request, HttpServletResponse response, String captchaContent) {
        Captcha captcha = captchaMap.get(getCaptchaID(request));
        captcha.setContent(captchaContent);
    }

    protected UUID generateCaptchaID() {
        return UUID.randomUUID();
    }

    abstract protected UUID getCaptchaID(HttpServletRequest request);

    abstract protected void saveCaptchaID(HttpServletRequest request, HttpServletResponse response, UUID captchaID);
}
