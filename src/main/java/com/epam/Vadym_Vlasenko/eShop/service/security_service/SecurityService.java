package com.epam.Vadym_Vlasenko.eShop.service.security_service;

import com.epam.Vadym_Vlasenko.eShop.entity.Role;
import com.epam.Vadym_Vlasenko.eShop.entity.User;
import com.epam.Vadym_Vlasenko.eShop.service.xml_parser.XmlParser;
import org.apache.log4j.Logger;
import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by swift-seeker-89717 on 21.04.2015.
 */
public class SecurityService {

    private static final Logger LOG = Logger.getLogger(SecurityService.class);

    private String fileName;
    private XmlParser xmlParser;

    public SecurityService(String fileName) {
        this.fileName = fileName;
        this.xmlParser = new XmlParser();
    }

    public Map<String, List<Role>> getMapFromXml() {
        Map<String, List<Role>> roleMap = null;
        try {
            roleMap = xmlParser.parseXml(fileName);
        } catch (ParserConfigurationException e) {
            LOG.error(e);
        } catch (IOException e) {
            LOG.error(e);
        } catch (SAXException e) {
            LOG.error(e);
        }
        return roleMap;
    }

    public boolean securityUrl(String url, User user) {
        Map<String, List<Role>> roleMap = null;
        try {
            roleMap = xmlParser.parseXml(fileName);
        } catch (ParserConfigurationException e) {
            LOG.error(e);
        } catch (IOException e) {
            LOG.error(e);
        } catch (SAXException e) {
            LOG.error(e);
        }
        Role role = user.getRole();
        return checkUrlWithRole(url, roleMap, role);
    }

    public boolean isSecureUrl(String url, Map<String, List<Role>> roleMap) {
        for (Map.Entry entry : roleMap.entrySet()) {
            Pattern pattern = Pattern.compile(String.valueOf(entry.getKey()));
            Matcher matcher = pattern.matcher(url);
            if (matcher.matches()) {
                return true;
            }
        }
        return false;
    }

    public boolean checkUrlWithRole(String url, Map<String, List<Role>> roleMap, Role role) {
        for (Map.Entry entry : roleMap.entrySet()) {
            Pattern pattern = Pattern.compile(String.valueOf(entry.getKey()));
            Matcher matcher = pattern.matcher(url);
            String roleValueParam = role.getRole();
            if (matcher.matches()) {
                List<Role> roleList = (List<Role>) entry.getValue();
                for (Role roleFromList : roleList) {
                    String roleValueFromMap = roleFromList.getRole();
                    if (roleValueParam.equals(roleValueFromMap)) {
                        return true;
                    } else {
                        return false;
                    }
                }
            }
        }
        return false;
    }

}
