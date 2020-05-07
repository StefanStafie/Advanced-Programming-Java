package com.example.demo;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class Rest {
    DatabaseController databaseController = new DatabaseController();

    @GetMapping("/rest")
    public List<Player> getPlayerList() {
        return databaseController.getPlayers();
    }

    @PostMapping("/rest")
    public boolean addPLayer(@RequestParam(value = "name", defaultValue = "unknown") String name) {
        return databaseController.addPlayer(new Player(0, name));
    }

    @PutMapping("/rest")
    public boolean modifyPlayerName(@RequestParam(value = "oldName", defaultValue = "unknown") String oldName, @RequestParam(value = "newName", defaultValue = "unknown") String newName) {
        if(oldName.equals("unknown") || newName.equals(("unknown")))
            return false;
        return databaseController.modifyName(newName, oldName);
    }
    @DeleteMapping("/rest")
    public boolean deletePlayer(@RequestParam(value = "name", defaultValue = "unknown") String name) {
        return databaseController.deletePlayer(new Player(0, name));
    }
}
