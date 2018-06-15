/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package listManager;

import java.util.ArrayList;
import objects.RoomRiddle;

/**
 *
 * @author Pedro Rodriguez
 */
public class ListRiddle {
    
    
    private ArrayList<RoomRiddle> listRiddle;

    private ListRiddle() {

        listRiddle = new ArrayList<>();
    }
    
    
    public void addRiddle (RoomRiddle riddle){    
        listRiddle.add(riddle);
    }
    
    public boolean removeRiddle (RoomRiddle riddle){
        return listRiddle.remove(riddle);
    }

    public RoomRiddle assignRiddle() {

        int riddleRemove = (int) ((Math.random() * listRiddle.size()) + 0);
        RoomRiddle riddle = listRiddle.get(riddleRemove);
        
        removeRiddle(riddle);
        return riddle;
    }
    @Override
    public String toString() {
        return "ManagerRiddle{" + "listRiddle=" + listRiddle + '}';
    } 
    public static ListRiddle getInstance() {
        return listRiddleHolder.INSTANCE;
    }
    
    private static class listRiddleHolder {

        private static final ListRiddle INSTANCE = new ListRiddle();
    }
}
