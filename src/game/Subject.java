package game;

import gui.rooms.RoomsInterface;

/**
 *
 * @author Jermy
 */
interface Subject {

    void addObserver(RoomsInterface e);

    RoomsInterface removeObserver(int index);
}
