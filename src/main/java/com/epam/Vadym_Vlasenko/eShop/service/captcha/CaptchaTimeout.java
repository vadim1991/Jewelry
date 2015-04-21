package com.epam.Vadym_Vlasenko.eShop.service.captcha;

import com.epam.Vadym_Vlasenko.eShop.entity.Captcha;
import com.epam.Vadym_Vlasenko.eShop.web.Constants;

import java.util.Date;
import java.util.Map;
import java.util.UUID;

/**
 * Created by swift-seeker-89717 on 19.04.2015.
 */
public class CaptchaTimeout extends Thread {

    private Map<UUID, Captcha> captchaMap;
    private ICaptchaHandler captchaHandler;

    public CaptchaTimeout(Map<UUID, Captcha> captchaMap, ICaptchaHandler captchaHandler) {
        this.captchaMap = captchaMap;
        this.captchaHandler = captchaHandler;
        this.setDaemon(true);
    }

    @Override
    public void run() {
        while (true) {
            for (Map.Entry entry : captchaMap.entrySet()) {
                if (isCaptchaExpired(Constants.CAPTCHA_TIMEOUT, (Captcha) entry.getValue())) {
                    // captchaMap.get(entry.getKey()).setContent(captchaHandler.generateCaptchaString());
                    captchaMap.remove(entry.getKey());
                }
            }
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    private boolean isCaptchaExpired(long timeout, Captcha captcha) {
        long deltaTime = new Date().getTime() - captcha.getDateCreated().getTime();
        return deltaTime > timeout;
    }
}
