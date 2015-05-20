package com.epam.Vadym_Vlasenko.eShop.web.servlets;

import com.epam.Vadym_Vlasenko.eShop.service.captcha.ICaptchaHandler;
import com.epam.Vadym_Vlasenko.eShop.web.Constants;

import javax.imageio.ImageIO;
import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by swift-seeker-89717 on 08.04.2015.
 */
@WebServlet("/captcha")
public class CaptchaServlet extends HttpServlet {

    private ICaptchaHandler captchaHandler;

    private static final String CONTENT_TYPE = "image/jpg";
    private static final String IMAGE_TYPE = "jpeg";

    @Override
    public void init() throws ServletException {
        captchaHandler = (ICaptchaHandler) getServletContext().getAttribute(Constants.CAPTCHA_HANDLER);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String captchaContent = captchaHandler.generateCaptchaString();
        System.out.println(captchaContent);
        captchaHandler.saveCaptchaParameters(req, resp, captchaContent);
        resp.setContentType(CONTENT_TYPE);
        ServletOutputStream outputStream = resp.getOutputStream();
        ImageIO.write(captchaHandler.createCaptchaImage(captchaContent), IMAGE_TYPE, outputStream);
        outputStream.close();
    }
}
