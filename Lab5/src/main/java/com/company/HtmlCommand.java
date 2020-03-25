package com.company;

import java.io.FileDescriptor;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintStream;

public class HtmlCommand implements Command{
    Catalog catalog;
    String savePath;
    public HtmlCommand(Catalog catalog, String savePath) {
        this.catalog = catalog;
        this.savePath = savePath;
    }

    @Override
    public void executeSelf() {
        PrintStream fileStream = null;
        try {
            fileStream = new PrintStream(savePath);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        System.setOut(fileStream);


        System.out.println("<html>\n<head></head>\n<body>\n");
        System.out.println("<h1>" + catalog.getName() + "</h1>");
        System.out.println("<h1>" + catalog.getPath() + "</h1>");
        for(var doc:catalog.getDocuments()){
            System.out.println("<ul><li> ID: " + doc.getId() + "</li>");
            System.out.println("<li> Location: " + doc.getLocation() + "</li>");
            System.out.println("<li> Name: " + doc.getName() + "</li>");
            for(var tag:doc.getTags().entrySet()){
                System.out.println("<li>" + tag.getKey() + ": " + tag.getValue() + "</li>");
            }
            System.out.println("</ul>");
        }

        System.out.println("</body>\n</html>");
        System.setOut(new PrintStream(new FileOutputStream(FileDescriptor.out)));
    }
}
