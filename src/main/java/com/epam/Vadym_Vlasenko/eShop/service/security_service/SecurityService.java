package com.epam.Vadym_Vlasenko.eShop.service.security_service;

import com.epam.Vadym_Vlasenko.eShop.entity.Role;
import com.epam.Vadym_Vlasenko.eShop.entity.User;
import com.epam.Vadym_Vlasenko.eShop.service.xml_parser.XmlParser;
import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by swift-seeker-89717 on 21.04.2015.
 */
public class SecurityService {

    private String fileName;
    private XmlParser xmlParser;

    public SecurityService(String fileName) {
        this.fileName = fileName;
        this.xmlParser = new XmlParser();
    }

    public Map<String, Role> getMapFromXml() {
        Map<String, Role> roleMap = null;
        try {
            roleMap = xmlParser.parseXml(fileName);
        } catch (ParserConfigurationException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (SAXException e) {
            e.printStackTrace();
        }
        return roleMap;
    }

    public boolean securityUrl(String url, User user) {
        Map<String, Role> roleMap = null;
        try {
            roleMap = xmlParser.parseXml(fileName);
        } catch (ParserConfigurationException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (SAXException e) {
            e.printStackTrace();
        }
        Role role = user.getRole();
        return checkUrlWithRole(url, roleMap, role);
    }

    public boolean isSecureUrl(String url, Map<String, Role> roleMap) {
        System.out.println(roleMap);
        for (Map.Entry entry : roleMap.entrySet()) {
            Pattern pattern = Pattern.compile(String.valueOf(entry.getKey()));
            Matcher matcher = pattern.matcher(url);
            if (matcher.matches()) {
                System.out.println(entry.getKey() + " " + url);
                return true;
            }
        }
        return false;
    }

    public boolean checkUrlWithRole(String url, Map<String, Role> roleMap, Role role) {
        System.out.println(roleMap);
        for (Map.Entry entry : roleMap.entrySet()) {
            Pattern pattern = Pattern.compile(String.valueOf(entry.getKey()));
            Matcher matcher = pattern.matcher(url);
            Role roleFromMap = (Role) entry.getValue();
            String roleValueFromMap = roleFromMap.getRole();
            String roleValueParam = role.getRole();
            if (matcher.matches()) {
                System.out.println(url + " " + roleValueFromMap + " " + roleValueParam);
                if (roleValueParam.equals(roleValueFromMap)) {
                    return true;
                } else {
                    return false;
                }
            }
        }
        return false;
    }

}
