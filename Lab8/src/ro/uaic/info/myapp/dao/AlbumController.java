package ro.uaic.info.myapp.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

public class AlbumController {
    public AlbumController() {
    }

    /**create entry with executeUpdate
     *
     * @param name the name of the artist to be inserted
     * @param artistId the artistId of the album artist
     * @param releaseYear the release year of the album
     * returns affectedRows. Might be useful later
     */
    public void create(String name, int artistId, int releaseYear) {
        int affectedRows = -1;
        try {
            java.sql.Statement stmt = Database.getInstance().getStmt();
            affectedRows = stmt.executeUpdate("INSERT INTO albums (name, artist_id, release_year) values ('" + name + "', '" + artistId + "', '" + releaseYear + "')");
        } catch (SQLException e) {
            e.printStackTrace();
        }
        //System.out.println(affectedRows);
    }
    /** finds entry with given artistId
     *
     * @param artistId the artistId of the creator of the album
     * @return ResultSet corresponding to the artistId (might return more rows)
     */
    public ResultSet findByArtist(int artistId){
        ResultSet rset = null;
        try {
            rset = Database.getInstance().getStmt().executeQuery("Select * from  albums where artist_id = '" + artistId + "'");
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return rset;
    }
}
