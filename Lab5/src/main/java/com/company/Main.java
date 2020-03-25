package com.company;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
        static Catalog  catalog = null;
        public static void main(String[] args) throws
        java.io.IOException {

            String commandLine;
            BufferedReader console = new BufferedReader(new InputStreamReader(System.in));

            while (true) {
                //read the command
                System.out.print("shell>");
                commandLine = console.readLine();

                //if just a return, loop
                if (commandLine.equals("")){
                    continue;
                }

                //clear screen
                if (commandLine.equals("clear")) {
                    for (int cls = 0; cls < 100; cls++ ){
                        System.out.println("");
                    }
                    continue;
                }
                if (commandLine.equals("exit")) {
                    System.out.println("Exiting");
                    System.exit(0);

                }

                //help command
                if (commandLine.equals("help")) {
                    System.out.println();
                    System.out.println();
                    System.out.println("Written by: Stafie Stefan");
                    System.out.println("Lab5 Java");
                    System.out.println("Commands to use:");
                    System.out.println("--------------------");
                    System.out.println("create catalog {name} {path}");
                    System.out.println("add doc {id} {name} {path}");
                    System.out.println("add tag {name} {value} to {id}");
                    System.out.println("load {path}");
                    System.out.println("list {id}");
                    System.out.println("report html");
                    System.out.println("view");
                    System.out.println("clear");
                    System.out.println("save");
                    System.out.println("help");
                    System.out.println("---------------------");
                    System.out.println();
                }

                //if it actually receives a command

                if(commandLine.startsWith("add doc ")) {
                    if(catalog==null){
                        System.out.println("You have to load the catalog first");
                    } else {
                        String[] argumente = commandLine.split(" ");
                        if (argumente.length != 5) {
                            System.out.println("Write \"help\" for help");
                        } else {
                            Document document = new Document(argumente[2], argumente[3], argumente[4]);
                            catalog.add(document);
                        }

                    }
                    continue;
                }

                if(commandLine.equals("save")) {
                    if(catalog==null){
                        System.out.println("You have to load the catalog first");
                    } else {
                        CatalogUtil use = new CatalogUtil();
                        try{use.save(catalog);}
                        catch(IOException e){
                            System.out.println("Cannot find file path");
                        }
                    }
                    continue;
                }

                if(commandLine.startsWith("create catalog ")) {
                    String[] argumente = commandLine.split(" ");
                    if (argumente.length != 4) {
                        System.out.println("Write \"help\" for help");
                    } else {
                       catalog = new Catalog(argumente[2], argumente[3]);
                    }
                    continue;
                }

                if(commandLine.startsWith("add tag ")) {
                    if(catalog==null){
                        System.out.println("You have to load the catalog first");
                    } else {
                        String[] argumente = commandLine.split(" ");
                        if (argumente.length != 6) {
                            System.out.println("Write \"help\" for help");
                        } else {
                            Document document = catalog.findById(argumente[5]);
                            if(document == null) {
                                System.out.println("Document not found");
                            } else {
                                document.addTag(argumente[2],argumente[3]);
                            }

                        }
                    }
                    continue;
                }



                if(commandLine.startsWith("load ")) {
                    String[] argumente = commandLine.split(" ");
                    if (argumente.length != 2){
                        System.out.println("Write \"help\" for help");
                        continue;
                    }
                    LoadCommand x = new LoadCommand(catalog, argumente[1]);
                    x.executeSelf();
                    catalog = x.getCatalog();
                    continue;
                }

                if (commandLine.equals("view")) {
                    if(catalog != null && catalog.getPath() !=null){
                        new ViewCommand(catalog.getPath()).executeSelf();
                    } else {
                        System.out.println("You have to load catalog first");
                    }
                    continue;
                }
                if (commandLine.startsWith("add ")) {
                    if(catalog != null){
                        new HtmlCommand(catalog,"index.html").executeSelf();
                    } else {
                        System.out.println("You have to load catalog first");
                    }
                    continue;
                }
                if (commandLine.equals("report html")) {
                    if(catalog != null){
                        new HtmlCommand(catalog,"index.html").executeSelf();
                    } else {
                        System.out.println("You have to load catalog first");
                    }
                    continue;
                }

                if (commandLine.startsWith("list")) {
                    if (catalog == null) {
                        System.out.println("you have to load catalog first");
                    } else {
                        String[] argumente = commandLine.split(" ");
                        if (argumente.length != 2) {
                            System.out.println("Write \"help\" for help");
                        } else {
                            new ListCommand(catalog, argumente[1]).executeSelf();
                        }
                    }
                    continue;
                }
                //in case everything fails, goes to help
                System.out.println("Write \"help\" for help");
            }
        }
    }
