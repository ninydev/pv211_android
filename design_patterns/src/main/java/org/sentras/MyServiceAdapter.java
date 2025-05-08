package org.sentras;

public class MyServiceAdapter implements  MyServiceInterface {

    private final MyOldService myOldService;
    private final XmlToJsonAdapter adapter;

    public MyServiceAdapter(MyOldService myOldService, XmlToJsonAdapter adapter) {
        this.myOldService = myOldService;
        this.adapter = adapter;
    }

    public int doSomething(String data) {
        // ArrayAdapter adapter
        // getView || getDropdownView

        String json = adapter.XmlStringTojsonString(data);
        return myOldService.doSomething(json);
    }

}
