package com.epam.Vadym_Vlasenko.eShop.web.filters;

import com.epam.Vadym_Vlasenko.eShop.web.localization.LocaleHolder;
import com.epam.Vadym_Vlasenko.eShop.web.localization.LocalizationRequestWrapper;
import org.apache.log4j.Logger;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

/**
 * Created by swift-seeker-89717 on 29.04.2015.
 */
@WebFilter(urlPatterns = "/*",initParams = {@WebInitParam(name = "locales", value = "en ru"),@WebInitParam(name = "defaultLocale",value = "ru")})
public class LocalizationFilter implements Filter {

    private static final Logger logger = Logger.getLogger(LocalizationFilter.class);
    private static final String LOCALE_HOLDER = "localeHolder";
    private static final String LOCALES = "locales";
    private static final String DEFAULT_LOCALE = "defaultLocale";
    private Locale defaultLocale;
    private List<Locale> locales;

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        logger.info("Localization filter starts");
        String localeValues = filterConfig.getInitParameter(LOCALES);
        if (localeValues == null || localeValues.isEmpty()) {
            logger.warn("default locale parameters will be used");
        } else {
            String defaultLocaleValue = filterConfig.getInitParameter(DEFAULT_LOCALE);
            if (defaultLocaleValue != null) {
                defaultLocale = new Locale(defaultLocaleValue);
            }
            locales = new ArrayList<>();
            for (String localeName : localeValues.split(" ")) {
                locales.add(new Locale(localeName));
            }
        }
        filterConfig.getServletContext().setAttribute(LOCALES, locales);
        filterConfig.getServletContext().setAttribute(DEFAULT_LOCALE, defaultLocale);
        logger.info("Localization filter finished");
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest httpServletRequest = (HttpServletRequest) request;
        HttpServletResponse httpServletResponse = (HttpServletResponse) response;
        HttpServletRequest localizationRequest = new LocalizationRequestWrapper(httpServletRequest);

        LocaleHolder localeHolder = (LocaleHolder) request.getServletContext().getAttribute(LOCALE_HOLDER);
        Locale locale = localizationRequest.getLocale();
        localeHolder.setLocale(httpServletRequest, httpServletResponse, locale);
        chain.doFilter(localizationRequest, response);
    }

    @Override
    public void destroy() {

    }

}
