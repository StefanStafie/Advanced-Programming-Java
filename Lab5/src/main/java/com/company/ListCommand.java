package com.company;

public class ListCommand implements Command{
    Catalog catalog = new Catalog();
    String id;
    public ListCommand(Catalog catalog, String id) {
        this.catalog = catalog;
        this.id = id;
    }

    @Override
    public void executeSelf() {
        Document doc = catalog.findById(id);
        if(doc!= null)
            System.out.println(doc.toString());
        else
            System.out.println("Nu a gasit \"" + id + "\"");
    }
}
