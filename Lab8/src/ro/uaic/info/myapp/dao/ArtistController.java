package ro.uaic.info.myapp.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

public class ArtistController {
    public ArtistController() {
    }

    /**create entry with executeUpdate
     *
     * @param name the name of the artist to be inserted
     * @param country the country of the artist to be inserted
     * returns affectedRows. Might be useful later
     */
    public void create(String name, String country) {
        int affectedRows = -1;
        try {
            java.sql.Statement stmt = Database.getInstance().getStmt();
            affectedRows = stmt.executeUpdate("INSERT INTO artists (name, country) values ('" + name + "', '" + country + "')");
        } catch (SQLException e) {
            e.printStackTrace();
        }
        //System.out.println(affectedRows);
    }

    /** finds entry with given name
     *
     * @param name the name of the entry to be found
     * @return ResultSet corresponding to the name (might return more rows)
     */
    public ResultSet findByName(String name){
        ResultSet rset = null;
        try {
            rset = Database.getInstance().getStmt().executeQuery("Select * from artists where name = '" + name + "'");
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return rset;
    }
}
