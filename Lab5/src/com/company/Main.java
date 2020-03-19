package com.company;


import java.io.IOException;

public class Main {

    public static void main(String[] args) {

            Main app = new Main();
            app.testCreateSave();
            app.testLoadView();
        }

        private void testCreateSave() {
            Catalog catalog =
                    new Catalog("Java Resources", "d:/catalog.ser");
            Document doc = new Document("java1", "Java Course 1",
                    "https://profs.info.uaic.ro/~acf/java/slides/en/intro_slide_en.pdf");

            doc.addTag("type", "Slides");
            catalog.add(doc);

            Document doc2 = new Document("java2", "Java Course 1",
                    "d:/catalog.ser");
            catalog.add(doc2);
            try {
                CatalogUtil.save(catalog);
            } catch (IOException e) {
                e.printStackTrace();
            }

        }

        private void testLoadView() {
            Catalog catalog = null;
            try {
                catalog = CatalogUtil.load("d:/catalog.ser");
            } catch (InvalidCatalogException e) {
                e.printStackTrace();
            }
            Document doc = catalog.findById("java1");
            CatalogUtil.view(doc);

        }
    }