package com.company;

public class LoadCommand implements Command {
    Catalog catalog = new Catalog();
    String id;

    public Catalog getCatalog() {
        return catalog;
    }

    public LoadCommand(Catalog catalog, String id) {
        this.catalog = catalog;
        this.id = id;
    }

    @Override
    public void executeSelf() {
        catalog = new Catalog();
        try {
            catalog = CatalogUtil.load(id);
        } catch (InvalidCatalogException e) {
            e.printStackTrace();
        }

    }
}
