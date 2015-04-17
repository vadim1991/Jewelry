package com.epam.Vadym_Vlasenko.eShop.web.servlets;

import com.epam.Vadym_Vlasenko.eShop.service.captcha.GenerateCaptcha;

import javax.imageio.ImageIO;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Random;

/**
 * Created by swift-seeker-89717 on 08.04.2015.
 */
@WebServlet("/captcha")
public class CaptchaServlet extends HttpServlet {
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
        GradientPaint gradientPaint = new GradientPaint(10, 5, Color.BLUE, 20, 10, Color.LIGHT_GRAY, true);
        graphics.setPaint(gradientPaint);
        graphics.fillRect(0, 0, 200, 40);
        graphics.setColor(new Color(255, 153, 0));
        graphics.drawString(captchaContent, 5, 30);
        graphics.dispose();
        return image;
    }

    protected void processRequest(HttpServletRequest request,
                                  HttpServletResponse response)
            throws ServletException, IOException {

        int width = 150;
        int height = 50;

        char data[][] = {
                {'z', 'e', 't', 'c', 'o', 'd', 'e'},
                {'l', 'i', 'n', 'u', 'x'},
                {'f', 'r', 'e', 'e', 'b', 's', 'd'},
                {'u', 'b', 'u', 'n', 't', 'u'},
                {'j', 'e', 'e'}
        };


        BufferedImage bufferedImage = new BufferedImage(width, height,
                BufferedImage.TYPE_INT_RGB);

        Graphics2D g2d = bufferedImage.createGraphics();

        Font font = new Font("Georgia", Font.BOLD, 18);
        g2d.setFont(font);

        RenderingHints rh = new RenderingHints(
                RenderingHints.KEY_ANTIALIASING,
                RenderingHints.VALUE_ANTIALIAS_ON);

        rh.put(RenderingHints.KEY_RENDERING,
                RenderingHints.VALUE_RENDER_QUALITY);

        g2d.setRenderingHints(rh);

        GradientPaint gp = new GradientPaint(0, 0,
                Color.red, 0, height / 2, Color.black, true);

        g2d.setPaint(gp);
        g2d.fillRect(0, 0, width, height);

        g2d.setColor(new Color(255, 153, 0));

        Random r = new Random();
        int index = Math.abs(r.nextInt()) % 5;

        String captcha = String.copyValueOf(data[index]);
        request.getSession().setAttribute("captcha", captcha);

        int x = 0;
        int y = 0;

        for (int i = 0; i < data[index].length; i++) {
            x += 10 + (Math.abs(r.nextInt()) % 15);
            y = 20 + Math.abs(r.nextInt()) % 20;
            g2d.drawChars(data[index], i, 1, x, y);
        }

        g2d.dispose();

        response.setContentType("image/png");
        OutputStream os = response.getOutputStream();
        ImageIO.write(bufferedImage, "png", os);
        os.close();
    }


    protected void doGet(HttpServletRequest request,
                         HttpServletResponse response)
            throws ServletException, IOException {
        String captchaContent = generateCaptchaString();
        response.setContentType("image/jpg");
        ServletOutputStream out = response.getOutputStream();
        ImageIO.write(createCaptchaImage(captchaContent), "jpeg", out);
        out.close();
    }


    protected void doPost(HttpServletRequest request,
                          HttpServletResponse response)
            throws ServletException, IOException {
        String success = request.getParameter("success");
        System.out.println(success);
    }
}
