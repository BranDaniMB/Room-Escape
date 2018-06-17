/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui.rooms;

/**
 *
 * @author Jermy
 */
public interface RoomInterface {

    void update(String msg);

    void updatePadlock(int padlock);

    void unlockTrackLocked(int padlock);
    
    void showMessage(String msg);
}
