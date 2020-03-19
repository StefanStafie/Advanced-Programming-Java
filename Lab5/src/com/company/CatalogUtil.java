package com.company;

import java.awt.*;
import java.io.*;
import java.net.URI;
import java.net.URISyntaxException;

public class CatalogUtil {
    public static void save(Catalog catalog)
            throws IOException {
        try (var oos = new ObjectOutputStream(
                new FileOutputStream(catalog.getPath()))) {
            oos.writeObject(catalog);
        }
        catch (IOException e){
            e.printStackTrace();
        }
    }
    public static Catalog load(String path)
            throws InvalidCatalogException {
        try (var ois = new ObjectInputStream(new FileInputStream(path))) {
            return (Catalog) ois.readObject();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }
    public static void view(Document doc) {
        Desktop desktop = Desktop.getDesktop();
        try {
            desktop.browse(new URI(doc.getLocation()));
            //desktop.edit(new File(doc.getLocation()));
        } catch (IOException e) {
            e.printStackTrace();
        } catch (URISyntaxException e) {
            e.printStackTrace();
        }
    }
}