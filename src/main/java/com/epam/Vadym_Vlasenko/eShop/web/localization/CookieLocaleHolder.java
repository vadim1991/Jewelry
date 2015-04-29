package com.epam.Vadym_Vlasenko.eShop.web.localization;


import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Locale;


/**
 * Created by swift-seeker-89717 on 29.04.2015.
 */
public class CookieLocaleHolder implements LocaleHolder {

    private static final String LOCALE = "locale";

    @Override
    public void setLocale(HttpServletRequest request, HttpServletResponse response, Locale locale) {
        response.addCookie(new Cookie(LOCALE, locale.toString()));
        request.setAttribute(LOCALE, locale);
    }

    @Override
    public Locale getLocale(HttpServletRequest request) {
        for (Cookie cookie : request.getCookies()) {
            if (cookie.getName().equals(LOCALE)) {
                return new Locale(cookie.getValue());
            }
        }
        return null;
    }
}
