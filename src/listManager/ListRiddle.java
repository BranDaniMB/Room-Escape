/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package listManager;

import objects.Riddle;
import java.util.ArrayList;

/**
 *
 * @author Pedro Rodriguez
 */
public class ListRiddle implements Cloneable {

    private ArrayList<Riddle> listRiddle;

    public ListRiddle() {

        listRiddle = new ArrayList<>();
    }
    
    public void addRiddle (Riddle riddle){    
        listRiddle.add(riddle);
    }
    
    public boolean removeRiddle (Riddle riddle){
        return listRiddle.remove(riddle);
    }

    public ArrayList<Riddle> copyListRiddle() throws CloneNotSupportedException {

        ArrayList<Riddle> copyList = new ArrayList<>();
        
         for (int i = 0; i < listRiddle.size(); i++) {       
            copyList.add((Riddle) listRiddle.get(i).clone());
        }
        return copyList;
    }

    public Riddle assignRiddle() {

        int riddleRemove = (int) ((Math.random() * listRiddle.size()) + 0);
        Riddle riddle = listRiddle.get(riddleRemove);
        
        removeRiddle(riddle);
        return riddle;
    }
    @Override
    public String toString() {
        return "ManagerRiddle{" + "listRiddle=" + listRiddle + '}';
    }   
}
