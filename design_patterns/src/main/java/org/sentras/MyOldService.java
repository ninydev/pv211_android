package org.sentras;

public class MyOldService implements MyServiceInterface {

    @Override
    public int doSomething(String json) {
        // Парсинг JSON строки в JsonArray
        com.google.gson.JsonParser parser = new com.google.gson.JsonParser();
        com.google.gson.JsonArray jsonArray = parser.parse(json).getAsJsonArray();

        // Вывод сущностей на экран
        for (com.google.gson.JsonElement element : jsonArray) {
            System.out.println(element.toString());
        }

        // Возврат количества сущностей
        return jsonArray.size();
    }
}
