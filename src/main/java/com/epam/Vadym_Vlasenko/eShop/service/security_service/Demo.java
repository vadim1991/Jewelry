package com.epam.Vadym_Vlasenko.eShop.service.security_service;

import com.epam.Vadym_Vlasenko.eShop.entity.Role;
import com.epam.Vadym_Vlasenko.eShop.entity.User;

/**
 * Created by swift-seeker-89717 on 21.04.2015.
 */
public class Demo {

    public static void main(String[] args) {
        SecurityService securityService = new SecurityService("src\\\\main\\\\resources\\\\security.xml");
        User user = new User();
        Role role = new Role();
        role.setRole("client");
        user.setRole(role);
        System.out.println(securityService.securityUrl("/", user));
    }

}
