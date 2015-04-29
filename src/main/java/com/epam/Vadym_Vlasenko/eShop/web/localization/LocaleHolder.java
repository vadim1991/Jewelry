package com.epam.Vadym_Vlasenko.eShop.web.localization;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Locale;

/**
 * Created by swift-seeker-89717 on 29.04.2015.
 */
public interface LocaleHolder {
    public void setLocale(HttpServletRequest request, HttpServletResponse response, Locale locale);

    public Locale getLocale(HttpServletRequest request);
}
