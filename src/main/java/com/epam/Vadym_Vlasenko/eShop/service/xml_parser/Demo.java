package com.epam.Vadym_Vlasenko.eShop.service.xml_parser;

import com.epam.Vadym_Vlasenko.eShop.entity.Role;
import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by swift-seeker-89717 on 21.04.2015.
 */
public class Demo {

    public static void main(String[] args) {
        XmlParser xmlParser = new XmlParser();
        try {
            Map<String, Role> roleMap = xmlParser.parseXml("src\\main\\resources\\security.xml");
            System.out.println(roleMap);
        } catch (ParserConfigurationException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (SAXException e) {
            e.printStackTrace();
        }
        Pattern pattern = Pattern.compile("/user.*.do");
        Matcher matcher = pattern.matcher("/useegistration.do");
        System.out.println(matcher.matches());
    }

}
