package com.epam.Vadym_Vlasenko.eShop.service.captcha;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.Random;

/**
 * Created by swift-seeker-89717 on 17.04.2015.
 */
public abstract class GenericCaptchaHandler implements ICaptchaHandler {


    public String generateCaptchaString() {
        Random random = new Random();
        int length = 7 + (Math.abs(random.nextInt()) % 3);
        StringBuilder captchaStringBuffer = new StringBuilder();
        for (int i = 0; i < length; i++) {
            int baseCharNumber = Math.abs(random.nextInt()) % 62;
            int charNumber;
            if (baseCharNumber < 26) {
                charNumber = 65 + baseCharNumber;
            } else if (baseCharNumber < 52) {
                charNumber = 97 + (baseCharNumber - 26);
            } else {
                charNumber = 48 + (baseCharNumber - 52);
            }
            captchaStringBuffer.append((char) charNumber);
        }
        return captchaStringBuffer.toString();
    }

    /**
     * Creates {@code BufferedImage} of captcha
     *
     * @param captchaContent content of Captcha
     * @return image
     */
    public BufferedImage createCaptchaImage(String captchaContent) {
        BufferedImage image = new BufferedImage(200, 40, BufferedImage.TYPE_INT_RGB);
        Graphics2D graphics = image.createGraphics();
        Font font = new Font("Comic Sans MS", Font.BOLD, 30);
        graphics.setFont(font);
        RenderingHints rh = new RenderingHints(
                RenderingHints.KEY_ANTIALIASING,
                RenderingHints.VALUE_ANTIALIAS_ON);

        rh.put(RenderingHints.KEY_RENDERING,
                RenderingHints.VALUE_RENDER_QUALITY);

        graphics.setRenderingHints(rh);
        GradientPaint gradientPaint = new GradientPaint(10, 5, Color.BLACK, 20, 10, Color.LIGHT_GRAY, true);
        graphics.setPaint(gradientPaint);
        graphics.fillRect(0, 0, 200, 40);
        graphics.setColor(Color.DARK_GRAY);
        graphics.drawString(captchaContent, 5, 30);
        graphics.dispose();
        return image;
    }
}
