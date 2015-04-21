package com.epam.Vadym_Vlasenko.eShop.service.xml_parser;

import com.epam.Vadym_Vlasenko.eShop.entity.Role;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by swift-seeker-89717 on 21.04.2015.
 */
public class XmlParser {

    private static final String NODE_LIST = "constraint";
    private static final String URL_PATTERN = "url-pattern";
    private static final String ROLE = "role";

    private String fileName;

    public XmlParser(String fileName) {
        this.fileName = fileName;
    }

    public Map<String, Role> parseXml() throws ParserConfigurationException, IOException, SAXException {
        Map<String, Role> roleMap = new HashMap<String, Role>();
        File file = new File(fileName);
        DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder documentBuilder = documentBuilderFactory.newDocumentBuilder();
        Document document = documentBuilder.parse(file);

        NodeList nodeList = document.getElementsByTagName(NODE_LIST);
        for (int i = 0; i < nodeList.getLength(); i++) {
            Node node = nodeList.item(i);

            if (node.getNodeType() == Node.ELEMENT_NODE) {
                Element element = (Element) node;
                Role role = new Role();
                role.setRole(element.getAttribute(ROLE));
                roleMap.put(element.getAttribute(URL_PATTERN), role);
            }
        }
        return roleMap;
    }

}
