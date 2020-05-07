package com.example.demo;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DatabaseController {

    //returns first 100 players it finds
    public List<Player> getPlayers() {
        List<Player> players = new ArrayList<>();

        ResultSet rset = null;
        try {
            rset = Database.getInstance().getStmt().executeQuery("Select * from players");
        } catch (SQLException e) {
            e.printStackTrace();
        }
        try{
            while(rset.next())
                players.add(new Player(rset.getInt("id"), rset.getString("name")));
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return players;
    }


    public boolean addPlayer(Player player) {

        int affectedRows = -1;//might be useful later
        try {
            affectedRows = Database.getInstance().getStmt().executeUpdate("INSERT INTO players(name) values ('"+player.getName()+"') ");
        } catch (SQLException e) {
            e.printStackTrace();
        }
        if(affectedRows > 0)
            return true;
        return false;
    }

    public boolean modifyName(String newName, String oldName) {
        int affectedRows = -1;//might be useful later
        try {
            affectedRows = Database.getInstance().getStmt().executeUpdate("UPDATE players SET name = '" + newName + "' WHERE name = '" + oldName + "' ");
        } catch (SQLException e) {
            e.printStackTrace();
        }
        if(affectedRows > 0)
            return true;
        return false;
    }
    public boolean deletePlayer(Player player) {
        int affectedRows = -1;//might be useful later
        try {
            affectedRows = Database.getInstance().getStmt().executeUpdate("DELETE FROM players WHERE name = '" + player.getName() + "' ");
        } catch (SQLException e) {
            e.printStackTrace();
        }
        if(affectedRows > 0)
            return true;
        return false;
    }
}
