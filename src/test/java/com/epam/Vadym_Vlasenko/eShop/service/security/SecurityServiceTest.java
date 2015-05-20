package com.epam.Vadym_Vlasenko.eShop.service.security;

import com.epam.Vadym_Vlasenko.eShop.entity.Role;
import com.epam.Vadym_Vlasenko.eShop.service.exception.ShopException;
import com.epam.Vadym_Vlasenko.eShop.service.security_service.SecurityService;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import static org.junit.Assert.*;

/**
 * Created by Vadym_Vlasenko on 20.05.2015.
 */
public class SecurityServiceTest {

    private static final String SECURITY_FILE_NAME = "src/main/webapp/WEB-INF/securityForTest.xml";
    private static final String SECURITY_FILE_NAME_FOR_FAIL = "WEB-INF/securityForTest.xml";
    private static final String URL_PATTERN = "/ordersHistory";
    private static final String URL_FOR_TEST = "/admin";
    private static final String CLIENT_ROLE = "client";

    private SecurityService service;
    private Role role;
    private Map<String, List<Role>> mapWithRole;

    @Before
    public void init() {
        service = new SecurityService(SECURITY_FILE_NAME);
        role = new Role();
        role.setRole(CLIENT_ROLE);
        mapWithRole = service.getMapFromXml();
    }

    @Test(expected = ShopException.class)
    public void getMapFromXmlTestException() {
        service = new SecurityService(SECURITY_FILE_NAME_FOR_FAIL);
        service.getMapFromXml();
    }

    @Test
    public void getMapFromXmlTest() {
        List<Role> roles = mapWithRole.get(URL_PATTERN);
        assertNotNull(mapWithRole);
        assertTrue(mapWithRole.containsKey(URL_PATTERN));
        assertNotNull(roles);
        assertEquals(role, roles.get(0));
    }

    @Test
    public void isSecureUrlTest() {
        assertTrue(service.isSecureUrl(URL_PATTERN,mapWithRole));
    }


}
