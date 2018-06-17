/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package objects;

import builderteam.InvalidDataException;
import gui.rooms.Rooms;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Pedro Rodriguez
 */
public class RoomRiddle implements Cloneable, Serializable {

    private ArrayList<Riddle> listRiddle;
    private String roomInterface;

    public RoomRiddle(ArrayList<Riddle> listRiddle, String roomInterface) {
        this.listRiddle = listRiddle;
        this.roomInterface = roomInterface;
    }

    public RoomRiddle(String roomInterface) {
        this.listRiddle = new ArrayList<>();
        this.roomInterface = roomInterface;
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

    public String getRoomInterface() {
        return roomInterface;
    }

    public void setRoomInterface(String roomInterface) {
        this.roomInterface = roomInterface;
    }

    @Override
    public Object clone() throws CloneNotSupportedException {
        return new RoomRiddle(copy(), roomInterface);
    }

    @Override
    public String toString() {
        return "RoomRiddle{" + "listRiddle=" + listRiddle + ", roomInterface=" + roomInterface + '}';
    }
    
}
