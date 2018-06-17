/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package listManager;

import gui.rooms.Rooms;
import java.io.Serializable;
import java.util.Map;
import java.util.TreeMap;

/**
 *
 * @author Jermy
 */
public class ListRoomsInterface implements Serializable{

    private TreeMap<String, Rooms> roomsList;

    private ListRoomsInterface() {
        roomsList = new TreeMap<>();
    }

    public static ListRoomsInterface getInstance() {
        return ListRoomsInterfaceHolder.INSTANCE;
    }

    private static class ListRoomsInterfaceHolder {

        private static final ListRoomsInterface INSTANCE = new ListRoomsInterface();
    }

    public TreeMap<String, Rooms> getRoomsList() {
        return roomsList;
    }

    public void setRoomsList(TreeMap<String, Rooms> roomsList) {
        this.roomsList = roomsList;
    }

    @Override
    public String toString() {
        return "ListRoomsInterface{" + "roomsList=" + roomsList + '}';
    }

    public int size() {
        return roomsList.size();
    }

    public void putAll(Map<? extends String, ? extends Rooms> map) {
        roomsList.putAll(map);
    }

    public Rooms put(String key, Rooms value) {
        return roomsList.put(key, value);
    }

    public Rooms remove(Object key) {
        return roomsList.remove(key);
    }
    
}
