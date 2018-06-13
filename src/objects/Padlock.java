/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package objects;

/**
 *
 * @author Jermy
 */
public class Padlock {
    
    private boolean open;
    private Riddle riddle;
    
    public Padlock(Riddle riddle) {
        this.open = false;
        this.riddle = riddle;
    }
    
    public Padlock() {
        
    }
    
    public boolean isOpen() {
        return open;
    }
    
    public void setOpen(boolean open) {
        this.open = open;
    }
    
    public Riddle getRiddle() {
        return riddle;
    }
    
    public void setRiddle(Riddle riddle) {
        this.riddle = riddle;
    }
    
    public boolean tryOpen(String txt) {
        if (txt.equals(riddle.getAnswer())) {
            open = true;
            return true;
        }
        return false;
    }
}
