package org.sentras;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;


public class XmlToJsonAdapter {


public String XmlStringTojsonString(String xml) {
    try {
        // Парсинг XML строки
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();
        Document document = builder.parse(new java.io.ByteArrayInputStream(xml.getBytes()));
        document.getDocumentElement().normalize();

        // Создание JSON массива
        JsonArray usersArray = new JsonArray();
        NodeList userList = document.getElementsByTagName("user");

        for (int i = 0; i < userList.getLength(); i++) {
            Node userNode = userList.item(i);
            if (userNode.getNodeType() == Node.ELEMENT_NODE) {
                Element userElement = (Element) userNode;

                // Создание JSON объекта для каждого пользователя
                JsonObject userJson = new JsonObject();
                userJson.addProperty("id", userElement.getElementsByTagName("id").item(0).getTextContent());
                userJson.addProperty("email", userElement.getElementsByTagName("email").item(0).getTextContent());
                userJson.addProperty("name", userElement.getElementsByTagName("name").item(0).getTextContent());

                usersArray.add(userJson);
            }
        }

        // Возврат JSON строки
        return usersArray.toString();
    } catch (Exception e) {
        e.printStackTrace();
        return null;
    }
}




public String readfromFile() {
    try {
        // Чтение XML файла
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();
        Document document = builder.parse("src/main/java/org/sentras/users.xml");
        document.getDocumentElement().normalize();

        // Создание JSON массива
        JsonArray usersArray = new JsonArray();
        NodeList userList = document.getElementsByTagName("user");

        for (int i = 0; i < userList.getLength(); i++) {
            Node userNode = userList.item(i);
            if (userNode.getNodeType() == Node.ELEMENT_NODE) {
                Element userElement = (Element) userNode;

                // Создание JSON объекта для каждого пользователя
                JsonObject userJson = new JsonObject();
                userJson.addProperty("id", userElement.getElementsByTagName("id").item(0).getTextContent());
                userJson.addProperty("email", userElement.getElementsByTagName("email").item(0).getTextContent());
                userJson.addProperty("name", userElement.getElementsByTagName("name").item(0).getTextContent());

                usersArray.add(userJson);
            }
        }

        // Возврат JSON строки
        return usersArray.toString();
    } catch (Exception e) {
        e.printStackTrace();
        return null;
    }
}
}
