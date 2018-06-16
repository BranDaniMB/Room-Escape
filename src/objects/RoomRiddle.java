/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package objects;

import builderteam.InvalidDataException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import listManager.ListRoomRiddle;

/**
 *
 * @author Pedro Rodriguez
 */
public class RoomRiddle implements Cloneable, Serializable {

    private ArrayList<Riddle> listRiddle;
    private String roomId;

    public RoomRiddle(ArrayList<Riddle> listRiddle, String roomId) {
        this.listRiddle = listRiddle;
        this.roomId = roomId;
    }

    public void addRiddleGame(Riddle riddle) {

        if (riddle != null) {

            listRiddle.add(riddle);
        } else {
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

    public ArrayList<Riddle> copy() throws CloneNotSupportedException {

        ArrayList<Riddle> aux = new ArrayList<>();
        for (int i = 0; i < listRiddle.size(); i++) {
            aux.add((Riddle) listRiddle.get(i).clone());
        }
        return aux;
    }

    public ArrayList<Riddle> getListRiddle() {
        return listRiddle;
    }

    public void setListRiddle(ArrayList<Riddle> listRiddle) {
        this.listRiddle = listRiddle;
    }

    public String getRoomId() {
        return roomId;
    }

    public void setRoomId(String roomId) {
        this.roomId = roomId;
    }

    @Override
    public Object clone() throws CloneNotSupportedException {
        return new RoomRiddle(copy(), roomId.toString());
    }

}
