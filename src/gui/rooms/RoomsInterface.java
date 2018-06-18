
package gui.rooms;

/**
 *
 * @author Jermy
 */
public interface RoomsInterface {

    void update(String msg);

    void updatePadlock(int padlock);

    void unlockTrackLocked(int padlock);

    void showMessageWin(String msg);
    
    String getTime();
}
