package org.sentras;

public class WorkWithJson {


    public void run (String json) {
        System.out.println("JSON: " + json + "\n\n");

        // Parse the JSON string into a JsonObject
        String[] lines = json.split(",");
        for (String line : lines) {
            String[] keyValue =
                    line
                            .replace("{", "").replace("}", "")
                            .replace("\"", "").split(":");
            if (keyValue.length == 2) {
                System.out.println(" " + keyValue[0].trim() + ": " + keyValue[1].trim());
            }
        }

    }

}
