package ro.uaic.info.myapp.app;

import ro.uaic.info.myapp.dao.AlbumController;
import ro.uaic.info.myapp.dao.ArtistController;


import java.util.List;

public class Test {
    public Test() {
        ArtistController artistController = new ArtistController();
        artistController.create("Robby", "Miraku");//add artists
        artistController.create("Morty", "Baruba");
        artistController.create("Rafaelo", "Venezuela");
        List id = artistController.findByName("Morty");//artists with this name
        System.out.println(id);

        AlbumController albumController = new AlbumController();
        albumController.create("Makeba",(int) id.get(0), 1999);//add albums
        albumController.create("Back to school", (int) id.get(0), 2000);
        albumController.create("Soundify", (int) id.get(0), 2089);
        List albumResult = albumController.findByArtist((int) id.get(0));//find albums with that artist_id
        System.out.println(albumResult);
    }
}
