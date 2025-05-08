package org.sentras;

import java.io.IOException;

public class Main {

    public static void myOldMethod(String data, MyServiceInterface service) {
        int size = service.doSomething(data);
        System.out.println("size: " + size);
    }


    public static void main(String[] args) throws IOException {

        String data;

//        data = new String(java.nio.file.Files.readAllBytes(
//                    java.nio.file.Paths.get("src/main/java/org/sentras/users.json")));
        data = new String(java.nio.file.Files.readAllBytes(
                java.nio.file.Paths.get("src/main/java/org/sentras/users.xml")));
        // MyOldService myOldService = new MyOldService();

        MyServiceAdapter myOldService = new MyServiceAdapter(new MyOldService(), new XmlToJsonAdapter());

        // Я не могу вот тут ничего менять - мне нужно передавать сервис и данные для обработки
        myOldMethod(data, myOldService);
    }
}


//        XmlToJsonAdapter xmlToJsonAdapter = new XmlToJsonAdapter();
//
//        WorkWithJson workWithJson = new WorkWithJson();
//        try {
//            // Було
////            String json = new String(java.nio.file.Files.readAllBytes(
////                    java.nio.file.Paths.get("src/main/java/org/sentras/users.json")));
//            // Стало
//            String json = xmlToJsonAdapter.run();
//
//            workWithJson.run(json);
//        } catch (Exception e) {
//            e.printStackTrace();
//        }