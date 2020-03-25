package com.company;


import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import java.awt.*;
import java.io.*;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;


public class CatalogUtil {
    public static void save(Catalog catalog)
            throws IOException {
        PrintStream fileStream = new PrintStream(catalog.getPath());
        System.setOut(fileStream);

        JsonObject catalogJson = new JsonObject();
        catalogJson.addProperty("name", catalog.getName());
        catalogJson.addProperty("path", catalog.getPath());

        JsonArray documenteJson = new JsonArray();
        List<Document> documente = catalog.getDocuments();
        for(var doc:documente) {
            JsonObject documentJson = new JsonObject();
            documentJson.addProperty("id", doc.getId());
            documentJson.addProperty("name", doc.getName());
            documentJson.addProperty("location", doc.getLocation());
            Map<String, Object> tags = doc.getTags();
            for(var tag: tags.entrySet()) {
                documentJson.addProperty(tag.getKey().toString(), tag.getValue().toString());
            }
            documenteJson.add(documentJson);
        }
        catalogJson.add("Documente", documenteJson);
        System.out.println(catalogJson);
        System.setOut(new PrintStream(new FileOutputStream(FileDescriptor.out)));
    }


    public static Catalog load(String path)
            throws InvalidCatalogException {
        var records = new String();
        try ( BufferedReader reader = new BufferedReader(new FileReader(path))) {
            String line;
            while ((line = reader.readLine()) != null) {
                records += line;
            }
        } catch (FileNotFoundException e) {
            System.out.println(e);
            return null;
        } catch (IOException e) {
            System.out.println(e);
            return null;
        }
        String jsonString = records;
        JsonParser jsonParser = new JsonParser();
        JsonObject objectFromString = jsonParser.parse(jsonString).getAsJsonObject();
        //catalog
        Catalog catalog = new Catalog();
        catalog.setName(objectFromString.get("name").getAsString());
        catalog.setPath(objectFromString.get("path").getAsString());
        JsonArray jsonArray = objectFromString.get("Documente").getAsJsonArray();
        //documente
        List<Document> documente = new ArrayList<>();
        for(var x : jsonArray){
            Document doc = new Document();
            JsonObject jsonDoc = x.getAsJsonObject();
            doc.setId(jsonDoc.get("id").getAsString());
            doc.setName(jsonDoc.get("name").getAsString());
            doc.setLocation(jsonDoc.get("location").getAsString());

            var tags = doc.getTags().entrySet();
            for(var tag:tags){
                doc.addTag(tag.getKey(), tag.getValue());
            }
            catalog.add(doc);
        }
        return catalog;
    }
    public static void view(Document doc) {
        Desktop desktop = Desktop.getDesktop();
        try {
            desktop.browse(new URI(doc.getLocation()));
        } catch (IOException e) {
            System.out.println(e);;
        } catch (URISyntaxException e) {
            System.out.println(e);;
        }
    }
}