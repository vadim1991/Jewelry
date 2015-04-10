package com.epam.Vadym_Vlasenko.eShop.service.captcha;


import nl.captcha.Captcha;
import nl.captcha.backgrounds.GradiatedBackgroundProducer;
import nl.captcha.text.renderer.DefaultWordRenderer;

import java.awt.*;

import java.util.*;
import java.util.List;

/**
 * Created by swift-seeker-89717 on 08.04.2015.
 */
public class GenerateCaptcha {

    public Captcha generateCaptcha() {

        List<Color> colors = new ArrayList<Color>();
        colors.add(Color.black);
        colors.add(Color.red);

        List<Font> fonts = new ArrayList<Font>();
        fonts.add(new Font("Arial", Font.ITALIC, 40));

        Captcha captcha = new Captcha.Builder(120, 50)
                .addText(new DefaultWordRenderer(colors, fonts))
                .addBackground(new GradiatedBackgroundProducer(Color.white, Color.white))
                .gimp()
                .addBorder()
                .build();
        return captcha;
    }

}
