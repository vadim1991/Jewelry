package com.epam.Vadym_Vlasenko.eShop.web.localization;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;
import javax.servlet.http.HttpServletResponse;
import java.util.Enumeration;
import java.util.List;
import java.util.Locale;
import java.util.NoSuchElementException;

/**
 * Created by swift-seeker-89717 on 29.04.2015.
 */
public class LocalizationRequestWrapper extends HttpServletRequestWrapper {

    private static final String LOCALES = "locales";
    private static final String DEFAULT_LOCALE = "defaultLocale";
    private static final String LOCALE_HOLDER = "localeHolder";
    private static final String LANG = "lang";

    private Locale locale;
    private Locale defaultLocale;
    private List<Locale> locales;
    private LocaleHolder localeHolder;
    private HttpServletResponse response;

    public LocalizationRequestWrapper(HttpServletRequest request) {
        super(request);
        this.locale = setLocale(request);
    }

    @Override
    public Locale getLocale() {
        return locale;
    }

    @Override
    public Enumeration<Locale> getLocales() {
        return new Enumeration<Locale>() {
            private boolean next = true;

            @Override
            public boolean hasMoreElements() {
                return next;
            }

            @Override
            public Locale nextElement() {
                if (!next) {
                    throw new NoSuchElementException();
                } else {
                    next = false;
                    return locale;
                }
            }
        };
    }

    private Locale setLocale(HttpServletRequest request) {
        initParameters(request);
        if (locale != null) {
            return checkLocaleParameter(request);
        } else {
            Enumeration<Locale> localeValues = request.getLocales();
            if (localeValues != null) {
                return checkBrowserLocaleParameters(localeValues);
            }
            if (locale == null) {
                locale = defaultLocale;
            }
            return locale;
        }
    }

    private void initParameters(HttpServletRequest request) {
        localeHolder = (LocaleHolder) request.getServletContext().getAttribute(LOCALE_HOLDER);
        defaultLocale = (Locale) request.getServletContext().getAttribute(DEFAULT_LOCALE);
        locales = (List<Locale>) request.getServletContext().getAttribute(LOCALES);
        locale = localeHolder.getLocale(request);
    }

    private Locale checkLocaleParameter(HttpServletRequest request) {
        String lang = request.getParameter(LANG);
        if (locale.toString().equals(lang)) {
            return locale;
        } else {
            if (lang != null) {
                locale = new Locale(lang);
            }
            return locale;
        }
    }

    private Locale checkBrowserLocaleParameters(Enumeration<Locale> localeValues) {
        while (localeValues.hasMoreElements()) {
            Locale nextLocale = localeValues.nextElement();
            for (Locale loc : locales) {
                if (loc.equals(nextLocale)) {
                    locale = nextLocale;
                    return locale;
                }
            }
        }
        return null;
    }

}
