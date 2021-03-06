package Controller.Utility;

import Model.Entity.Entity;
import Model.Entity.EntityType;
import Model.Entity.Equipment;
import Model.Entity.Inventory;
import Model.Map.AreaEffect.AreaEffect;
import Model.Map.Location;
import Model.Map.Map;
import Model.Map.Terrain.Glacier;
import Model.Map.Terrain.Terrain;
import Model.Map.World;
import View.AreaView.MapView;
import org.junit.jupiter.api.Test;

import java.io.FileNotFoundException;
import java.util.Scanner;

import static Model.Entity.EntityType.ICE;
import static Model.Entity.EntityType.WATER;
import static org.junit.jupiter.api.Assertions.*;

class GameSaverTest {
//
//
//    @Test
//    void saveMapTest() throws FileNotFoundException {
//        MapBuilder mb = new MapBuilder();
//        Map m = mb.buildMap("0001");
//        World.getWorld().changeCurrentMapTo(m);
//        Entity entity = new Entity(m.getDefaultLocation());
//        String saveFileLocation = "./resources/saves/";
//
//        assertEquals(Integer.toString(m.getRows()), "5", "Rows are correct");
//        assertEquals(Integer.toString(m.getCols()), "5", "Columns are correct");
//
//        GameSaver gs = new GameSaver();
//
//        gs.SaveMap(saveFileLocation, entity, World.getWorld(), m);
//    }
//
//    @Test
//    void saveEntity() throws FileNotFoundException {
//        MapBuilder mb = new MapBuilder();
//        Map m = mb.buildMap("0001");
//        World.getWorld().changeCurrentMapTo(m);
//
//        EntityBuilder eb = new EntityBuilder();
//        Entity entity = eb.buildEntity("0001");
//        Inventory inventory = entity.getInventory();
//        Equipment equipment = inventory.getEquipment();
//        String saveFileLocation = "./resources/saves/";
//
//        GameSaver gs = new GameSaver();
//
//        gs.SaveEntity(saveFileLocation, entity, inventory, equipment);
//    }

    @Test
    void saveGame() throws FileNotFoundException {
        MapBuilder mb = new MapBuilder();

        Map m1 = mb.buildMap("resources/maps", "0001");
        MapView mv = new MapView();
        World.getWorld().addMap("0001", m1, mv);
        World.getWorld().changeCurrentMapTo(m1, false);

        Map m2 = mb.buildMap("resources/maps", "0002");
        World.getWorld().addMap("0002", m2, mv);

        Map m3 = mb.buildMap("resources/maps", "0003");
        World.getWorld().addMap("0003", m3, mv);

        EntityBuilder eb = new EntityBuilder();
        Entity entity = eb.buildEntity("resources/entities", "0001");
        Inventory inventory = entity.getInventory();
        Equipment equipment = inventory.getEquipment();

        GameSaver gs = new GameSaver();

        gs.SaveGame(entity);

//        gs.SaveMap("0003", entity);

//        gs.SaveMap(saveFileLocation, entity, World.getWorld(), m);
//
//        gs.SaveEntity(saveFileLocation, entity, inventory, equipment);

    }

}