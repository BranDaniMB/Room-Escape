/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package objects;

import builderteam.InvalidDataException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import listManager.ListRiddle;

/**
 *
 * @author Pedro Rodriguez
 */
public class RoomRiddle implements Cloneable{

    private ArrayList<Riddle> listRiddle;
    private String roomId;

    public RoomRiddle(ArrayList<Riddle> listRiddle, String roomId) {
        this.listRiddle = listRiddle;
        this.roomId = roomId;
    }
    
    public void addRiddleGame(Riddle riddle) {

        if (riddle!=null) {

            listRiddle.add(riddle);
        }else{
            try {
                throw new InvalidDataException("The riddle must be different from null.");
            } catch (InvalidDataException ex) {
                Logger.getLogger(RoomRiddle.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    public boolean removeRiddleGame(Riddle riddle) {
        return listRiddle.remove(riddle);
    }

    public String showRiddleGame() {
        return listRiddle.toString();
    }

    public ArrayList<Riddle> copy() {

        ArrayList<Riddle> aux = new ArrayList<>();
        for (int i = 0; i < listRiddle.size(); i++) {
            aux.add(listRiddle.get(i));
        }
        return aux;
    }
    
}
