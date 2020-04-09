package ro.uaic.info.myapp.app;

import ro.uaic.info.myapp.dao.AlbumController;
import ro.uaic.info.myapp.dao.ArtistController;

import java.sql.ResultSet;
import java.sql.SQLException;

public class Test {
    public Test() {
        ArtistController artistController = new ArtistController();
        artistController.create("Robby", "Miraku");//add artists
        artistController.create("Morty", "Baruba");
        artistController.create("Rafaelo", "Venezuela");
        ResultSet artistResult = artistController.findByName("Morty");//artists with this name
        int idHelper = 0;
        try {
            /**for each artist with that name, get the country*/
            while(artistResult.next()) {
                System.out.println("Artistul Morty s-a nascut in :" + artistResult.getString("country"));
                idHelper = artistResult.getInt("id");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }


        AlbumController albumController = new AlbumController();
        albumController.create("Makeba", idHelper-1, 1999);//add albums
        albumController.create("Back to school", idHelper, 2000);
        albumController.create("Soundify", idHelper, 2089);
        ResultSet albumResult = albumController.findByArtist(idHelper);//find albums with that artist_id
        try {
            /**for each album with that artist_id, get the name*/
            System.out.printf("Artistul cu id = " + idHelper + " are albumele:");
            while(albumResult.next())
                System.out.printf("%s",albumResult.getString("name") + ", ");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
