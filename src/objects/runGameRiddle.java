/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package objects;

import java.util.ArrayList;
import listManager.ListRiddle;

/**
 *
 * @author Pedro Rodriguez
 */
public class runGameRiddle implements Cloneable{

    private ArrayList<Riddle> listRiddle;

    public runGameRiddle() {
        listRiddle = new ArrayList<>();
    }

    public void addRiddleGame(Riddle riddle) {
        listRiddle.add(riddle);
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
